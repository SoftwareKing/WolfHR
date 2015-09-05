package com.wolf.hr.struts2.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.IncomeAndPayment;
import com.wolf.hr.domain.SalaryInfo;
import com.wolf.hr.domain.SalaryType;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.AddWorkingService;
import com.wolf.hr.service.AttendanceService;
import com.wolf.hr.service.IncomeAndPaymentService;
import com.wolf.hr.service.SalaryInfoService;
import com.wolf.hr.service.SalaryTypeService;
import com.wolf.hr.service.UserService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;

@Controller("salaryInfoAction")
@Scope("prototype")
public class SalaryInfoAction extends BaseAction<SalaryInfo> {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "salaryTypeService")
	private SalaryTypeService salaryTypeService;
	@Resource(name = "salaryInfoService")
	private SalaryInfoService salaryInfoService;
	@Resource(name = "addWorkingService")
	private AddWorkingService addWorkingService;
	@Resource(name = "attendanceService")
	private AttendanceService attendanceService;
	@Resource(name = "incomeAndPaymentService")
	private IncomeAndPaymentService incomeAndPaymentService;

	private String address;

	private Long ipids[];

	private String year;
	private String month;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long[] getIpids() {
		return ipids;
	}

	public void setIpids(Long[] ipids) {
		this.ipids = ipids;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAllSalaryInfos() {

		Collection<SalaryInfo> salaryInfolist = this.salaryInfoService
				.getAllSalaryInfos();
		ActionContext.getContext().put("salaryInfolist", salaryInfolist);
		return listAction;
	}

	public String auditSalary() { // 输入核算信息。
		String name = null;
		try {
			if (this.address != null) { //
				name = new String(address.getBytes("iso-8859-1"), "UTF-8");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("address:" + name);
		Collection<User> users = userService.getAllUser();
		ActionContext.getContext().put("users", users);
		Collection<IncomeAndPayment> ipsAdress = incomeAndPaymentService
				.getAllIncomeAndPaymentsByAdress();
		ActionContext.getContext().put("ipsAdress", ipsAdress);
		Collection<IncomeAndPayment> ips = incomeAndPaymentService
				.getAllIncomeAndPayments(name);
		ActionContext.getContext().put("ips", ips);
		Collection<SalaryType> types = salaryTypeService.getAllSalaryTypes();
		ActionContext.getContext().put("types", types);
		return addUI;
	}

	public String addSalaryInfo() { // 实现薪资套账。。。
		SalaryInfo salaryInfo = new SalaryInfo();
		BeanUtils.copyProperties(this.getModel(), salaryInfo);
		Set<IncomeAndPayment> ips = incomeAndPaymentService
				.getIncomeAndPaymentsByIds(this.ipids);
		User user = userService.getUserById(salaryInfo.getUser().getUid());
		SalaryType salaryType = salaryTypeService.getSalaryTypeById(salaryInfo
				.getSalaryType().getId());
		salaryInfo.setSalaryType(salaryType);
		salaryInfo.setTime(DateFormat.toStringWork(new Date()));
		salaryInfo.setIps(ips);
		salaryInfo.setUser(user);
		salaryInfo.setWorkerCategory(salaryType.getCategory());
		Double actualSalary = 0.0;
		if (salaryInfo.getSalaryType() != null) {
			actualSalary = salaryInfo.getSalaryType().getBaseSalary()
					+ salaryInfo.getSalaryType().getPostSalary();
			Double adworkHoursMoney = addWorkingService.getAllHours(salaryInfo
					.getTime(), user.getUid())
					* salaryInfo.getSalaryType().getAddWorkMoney();

			salaryInfo.setAddWorkSalary(adworkHoursMoney);
			Double leaveHoursMoney = attendanceService.getLeaveHours(salaryInfo
					.getTime(), user.getUid())
					* salaryInfo.getSalaryType().getLeaveMoney();
			salaryInfo.setLeaveSalary(leaveHoursMoney);
			Double lateHoursMoney = attendanceService.getLateHours(salaryInfo
					.getTime(), user.getUid())
					* salaryInfo.getSalaryType().getLateMoney();
			salaryInfo.setLateSalary(lateHoursMoney);
			Double absentHoursMoney = attendanceService.getAbsentHours(
					salaryInfo.getTime(), user.getUid())
					* salaryInfo.getSalaryType().getAbsentMoney();
			salaryInfo.setAbsentSalary(absentHoursMoney);
			actualSalary = actualSalary + adworkHoursMoney - leaveHoursMoney
					- lateHoursMoney - absentHoursMoney;
			for (IncomeAndPayment incomeAndPayment : ips) {
				if (incomeAndPayment.getState() == 0) {
					actualSalary = actualSalary
							- incomeAndPayment.getActivatyMoney();
				} else if (incomeAndPayment.getState() == 1) {
					actualSalary = actualSalary
							+ incomeAndPayment.getActivatyMoney();
				}
			}
		}
		salaryInfo.setActualSalary(actualSalary);
		salaryInfoService.saveSalaryInfo(salaryInfo);
		return null;
	}

	public String salaryByLastMonth() {// 查询上月所有，财务部有此权限。
		Collection<SalaryInfo> salaryInfos = this.salaryInfoService
				.getAllByLastMonth(DateFormat.toStringWork(new Date()));
		ActionContext.getContext().put("salaryInfos", salaryInfos);
		setAtt(DateFormat.toStringWork(new Date()));

		return "actionList";
	}

	public String salaryByMonth() {// 用户按年月份查询。
		String date;
		if (this.year != null & this.month != null) {
			date = this.year + "-" + month;
			Collection<SalaryInfo> salaryInfos = salaryInfoService.getSalaryInfoByUserByMonth(date);
			ActionContext.getContext().put("salaryInfos", salaryInfos);
			setAtt(DateFormat.toStringMonth(new Date()));
		} else {
			Collection<SalaryInfo> salaryInfos = this.salaryInfoService
				.getAllByUser();
			ActionContext.getContext().put("salaryInfos", salaryInfos);
			setAtt(DateFormat.toStringWork(new Date()));
		}

		return "actionDate";
	}

	public String salaryByYear() {// 用户按年份查询。
		String date;
		if (this.year != null) {
			date = this.year;
			Collection<SalaryInfo> salaryInfos = salaryInfoService.getSalaryInfoByUserByYear(date);
			ActionContext.getContext().put("salaryInfos", salaryInfos);
			setAtt(DateFormat.toStringMonth(new Date()));
		} else {
			Collection<SalaryInfo> salaryInfos = this.salaryInfoService
				.getAllByUser();
			ActionContext.getContext().put("salaryInfos", salaryInfos);
			setAtt(DateFormat.toStringWork(new Date()));
		}

		return "actionDate";
	}

	public String showStand() { // 查看本月薪资标准
		SalaryInfo salaryInfo = salaryInfoService
				.getSalaryInfoByUser(DateFormat.toStringWork(new Date()));
		ActionContext.getContext().put("salaryInfo", salaryInfo);
		setAtt(DateFormat.toStringMonth(new Date()));
		return "action";
	}

	public void setAtt(String time) {

		time = time.replace("-", "年") + "月";
		ActionContext.getContext().put("time", time);
		Collection<IncomeAndPayment> types = incomeAndPaymentService
				.getAllIncomeAndPayments();
		List<IncomeAndPayment> listName = new ArrayList<IncomeAndPayment>();
		Set<String> category = new HashSet<String>();
		for (IncomeAndPayment incomeAndPayment : types) {
			category.add(incomeAndPayment.getActivatyName());
		}
		for (String string : category) {
			IncomeAndPayment ic = new IncomeAndPayment();
			ic.setActivatyName(string);
			listName.add(ic);
		}
		ActionContext.getContext().put("category", listName); // 显示所有福利扣缴
	}
}

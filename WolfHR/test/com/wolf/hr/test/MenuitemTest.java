package com.wolf.hr.test;

import java.util.Collection;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wolf.hr.domain.Menuitem;


public class MenuitemTest {
	@Test
	public void addMenuItem(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Menuitem Menuitemitem1 = new Menuitem();
		Menuitemitem1.setMid(1L);
		Menuitemitem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		Menuitemitem1.setName("人力资源自动化");
		Menuitemitem1.setPid(0L);
		//Menuitemitem1.setChecked(false);
		Menuitemitem1.setIsParent(true);
		
		Menuitem Menuitem2 = new Menuitem();
		Menuitem2.setMid(2L);
		Menuitem2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menuitem2.setName("个人办公");
		//Menuitem2.setChecked(false);
		Menuitem2.setPid(1L);
		Menuitem2.setIsParent(true);
		
		//考勤管理
		Menuitem Menuitem21 = new Menuitem();
		Menuitem21.setMid(21L);
		Menuitem21.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem21.setName("个人考勤");
		//Menuitem21.setChecked(false);
		Menuitem21.setPid(2L);
		Menuitem21.setIsParent(true);
		
		//考勤管理--日常考勤
		Menuitem Menuitem211 = new Menuitem();
		Menuitem211.setMid(211L);
		Menuitem211.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem211.setName("请假登记");
		//Menuitem21.setChecked(false);
		Menuitem211.setPid(21L);
		Menuitem211.setIsParent(false);
		
		//考勤管理--加班考勤
		Menuitem Menuitem212 = new Menuitem();
		Menuitem212.setMid(212L);
		Menuitem212.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem212.setName("请假历史");
		//Menuitem21.setChecked(false);
		Menuitem212.setPid(21L);
		Menuitem212.setIsParent(false);
		
		//考勤管理--请(休)假考勤
		Menuitem Menuitem213 = new Menuitem();
		Menuitem213.setMid(213L);
		Menuitem213.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem213.setName("加班登记");
		//Menuitem21.setChecked(false);
		Menuitem213.setPid(21L);
		Menuitem213.setIsParent(false);
		
		//考勤管理--请(休)假考勤
		Menuitem Menuitem214 = new Menuitem();
		Menuitem214.setMid(214L);
		Menuitem214.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem214.setName("加班历史");
		//Menuitem21.setChecked(false);
		Menuitem214.setPid(21L);
		Menuitem214.setIsParent(false);
		
		//考勤管理--请(休)假考勤
		Menuitem Menuitem215 = new Menuitem();
		Menuitem215.setMid(215L);
		Menuitem215.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem215.setName("违纪详情");
		//Menuitem21.setChecked(false);
		Menuitem215.setPid(21L);
		Menuitem215.setIsParent(false);
		

		Menuitem Menuitem22 = new Menuitem();
		Menuitem22.setMid(22L);
		Menuitem22.setIsParent(true);
		//Menuitem33.setChecked(false);
		Menuitem22.setPid(2L);
		Menuitem22.setName("我的消息");
		Menuitem22.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		Menuitem Menuitem221 = new Menuitem();
		Menuitem221.setMid(221L);
		Menuitem221.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem221.setPid(22L);
		Menuitem221.setName("发送短消息");
		Menuitem221.setIcon("css/images/MenuIcon/FUNC241000.gif");

		Menuitem Menuitem222 = new Menuitem();
		Menuitem222.setMid(222L);
		Menuitem222.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem222.setPid(22L);
		Menuitem222.setName("已发送");
		Menuitem222.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		Menuitem Menuitem223 = new Menuitem();
		Menuitem223.setMid(223L);
		Menuitem223.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem223.setPid(22L);
		Menuitem223.setName("已接收");
		Menuitem223.setIcon("css/images/MenuIcon/FUNC241000.gif");
		

		Menuitem Menuitem224 = new Menuitem();
		Menuitem224.setMid(224L);
		Menuitem224.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem224.setPid(22L);
		Menuitem224.setName("草稿箱");
		Menuitem224.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		
		Menuitem Menuitem23 = new Menuitem();
		Menuitem23.setMid(23L);
		Menuitem23.setIsParent(true);
		//Menuitem33.setChecked(false);
		Menuitem23.setPid(2L);
		Menuitem23.setName("我的邮件");
		Menuitem23.setIcon("css/images/MenuIcon/eml.gif");
		
		
		Menuitem Menuitem231 = new Menuitem();
		Menuitem231.setMid(231L);
		Menuitem231.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem231.setPid(23L);
		Menuitem231.setName("发送邮件");
		Menuitem231.setIcon("css/images/MenuIcon/eml.gif");

		Menuitem Menuitem232 = new Menuitem();
		Menuitem232.setMid(232L);
		Menuitem232.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem232.setPid(23L);
		Menuitem232.setName("已发送");
		Menuitem232.setIcon("css/images/MenuIcon/eml.gif");
		
		Menuitem Menuitem233 = new Menuitem();
		Menuitem233.setMid(233L);
		Menuitem233.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem233.setPid(23L);
		Menuitem233.setName("已接收");
		Menuitem233.setIcon("css/images/MenuIcon/eml.gif");
		

		Menuitem Menuitem234 = new Menuitem();
		Menuitem234.setMid(234L);
		Menuitem234.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem234.setPid(23L);
		Menuitem234.setName("草稿箱");
		Menuitem234.setIcon("css/images/MenuIcon/eml.gif");
		
		
		Menuitem Menuitem24 = new Menuitem();
		Menuitem24.setMid(24L);
		Menuitem24.setIsParent(false);
		//Menuitem33.setChecked(false);
		Menuitem24.setPid(2L);
		Menuitem24.setName("发起申请");
		Menuitem24.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		Menuitem Menuitem25 = new Menuitem();
		Menuitem25.setMid(25L);
		Menuitem25.setIsParent(false);
		//Menuitem34.setChecked(false);
		Menuitem25.setPid(2L);
		Menuitem25.setName("审批申请");
		Menuitem25.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
		Menuitem Menuitem26 = new Menuitem();
		Menuitem26.setMid(26L);
		Menuitem26.setIsParent(false);
		//Menuitem35.setChecked(false);
		Menuitem26.setPid(2L);
		Menuitem26.setName("状态查询");
		Menuitem26.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
/*********************************************************************************/	
		/*
		 * 审批流转
		 */
		Menuitem Menuitem3 = new Menuitem();
		Menuitem3.setMid(3L);
		///Menuitem3.setChecked(false);
		Menuitem3.setIsParent(true);
		Menuitem3.setPid(1L);
		Menuitem3.setName("审批流转");
		Menuitem3.setIcon("css/images/MenuIcon/FUNC20057.gif");
		
		Menuitem Menuitem31 = new Menuitem();
		Menuitem31.setMid(31L);
		//Menuitem31.setChecked(false);
		Menuitem31.setIsParent(false);
		Menuitem31.setPid(3L);
		Menuitem31.setName("审批流程管理");
		Menuitem31.setIcon("css/images/MenuIcon/manager.gif");
		
		Menuitem Menuitem32 = new Menuitem();
		Menuitem32.setMid(32L);
		//Menuitem32.setChecked(false);
		Menuitem32.setIsParent(false);
		Menuitem32.setPid(3L);
		Menuitem32.setName("表单模板管理");
		Menuitem32.setIcon("css/images/MenuIcon/formmodel.gif");
		
/*******************************************************************************/	
		//个人设置
		/**************************************************************************/
		/*
		 * 个人设置
		 * 		个人信息
		 * 		密码修改
		 */
		Menuitem Menuitem4 = new Menuitem();
		Menuitem4.setMid(4L);
		Menuitem4.setIsParent(true);
		//Menuitem9.setChecked(false);
		Menuitem4.setPid(1L);
		Menuitem4.setName("个人设置");
		Menuitem4.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Menuitem Menuitem41 = new Menuitem();
		Menuitem41.setMid(41L);
		Menuitem41.setIsParent(false);
		//Menuitem91.setChecked(false);
		Menuitem41.setPid(4L);
		Menuitem41.setName("个人信息");
		Menuitem41.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Menuitem Menuitem42 = new Menuitem();
		Menuitem42.setMid(42L);
		Menuitem42.setIsParent(false);
		//Menuitem92.setChecked(false);
		Menuitem42.setPid(4L);
		Menuitem42.setName("密码修改");
		Menuitem42.setIcon("css/images/MenuIcon/FUNC241000.gif");
		

/*******************************************************************************/
		/*
		 * 入职管理
		 */
		Menuitem Menuitem5 = new Menuitem();
		Menuitem5.setMid(5L);
		Menuitem5.setIsParent(true);
		//Menuitem5.setChecked(false);
		Menuitem5.setPid(1L);
		Menuitem5.setName("入职管理");
		Menuitem5.setIcon("css/images/MenuIcon/manager.gif");
		
		Menuitem Menuitem51 = new Menuitem();
		Menuitem51.setMid(51L);
		Menuitem51.setIsParent(false);
		//Menuitem51.setChecked(false);
		Menuitem51.setPid(5L);
		Menuitem51.setName("入职信息");
		Menuitem51.setIcon("css/images/MenuIcon/FUNC20070.gif");
		
		Menuitem Menuitem52 = new Menuitem();
		Menuitem52.setMid(52L);
		Menuitem52.setIsParent(false);
		//Menuitem52.setChecked(false);
		Menuitem52.setPid(5L);
		Menuitem52.setName("综合查询");
		Menuitem52.setIcon("css/images/MenuIcon/FUNC20064.gif");
		
		
/**************************************************************************************/	
		//考勤管理
		
		/*
		 * 入职管理
		 */
		Menuitem Menuitem6 = new Menuitem();
		Menuitem6.setMid(6L);
		Menuitem6.setIsParent(true);
		//Menuitem5.setChecked(false);
		Menuitem6.setPid(1L);
		Menuitem6.setName("考勤管理");
		Menuitem6.setIcon("css/images/MenuIcon/FUNC20054.gif");
		
		Menuitem Menuitem61 = new Menuitem();
		Menuitem61.setMid(61L);
		Menuitem61.setIsParent(false);
		//Menuitem51.setChecked(false);
		Menuitem61.setPid(6L);
		Menuitem61.setName("违纪统计");
		Menuitem61.setIcon("css/images/MenuIcon/FUNC20054.gif");
		
		Menuitem Menuitem62 = new Menuitem();
		Menuitem62.setMid(62L);
		Menuitem62.setIsParent(false);
		//Menuitem52.setChecked(false);
		Menuitem62.setPid(6L);
		Menuitem62.setName("加班审核");
		Menuitem62.setIcon("css/images/MenuIcon/FUNC20054.gif");
		
		Menuitem Menuitem63 = new Menuitem();
		Menuitem63.setMid(63L);
		Menuitem63.setIsParent(false);
		//Menuitem52.setChecked(false);
		Menuitem63.setPid(6L);
		Menuitem63.setName("请假审核");
		Menuitem63.setIcon("css/images/MenuIcon/FUNC20054.gif");
		
		
/**************************************************************************************/
		/*
		 * 人力资源管理
		 * 	档案管理
		 * 	培训记录
		 * 	奖金记录
		 * 	职位变更
		 * 	人事合同
		 * 	薪酬制度
		 */
		Menuitem Menuitem7 = new Menuitem();
		Menuitem7.setMid(7L);
		Menuitem7.setIsParent(true);
		//Menuitem6.setChecked(false);
		Menuitem7.setPid(1L);
		Menuitem7.setName("绩效管理");
		Menuitem7.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Menuitem Menuitem71 = new Menuitem();
		Menuitem71.setMid(71L);
		Menuitem71.setIsParent(false);
		//Menuitem61.setChecked(false);
		Menuitem71.setPid(7L);
		Menuitem71.setName("导入绩效");
		Menuitem71.setIcon("css/images/MenuIcon/FUNC20076.gif");
		
		Menuitem Menuitem72 = new Menuitem();
		Menuitem72.setMid(72L);
		Menuitem72.setIsParent(false);
		//Menuitem62.setChecked(false);
		Menuitem72.setPid(7L);
		Menuitem72.setName("绩效查询");
		Menuitem72.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menuitem Menuitem73 = new Menuitem();
		Menuitem73.setMid(73L);
		Menuitem73.setIsParent(false);
		//Menuitem63.setChecked(false);
		Menuitem73.setPid(7L);
		Menuitem73.setName("绩效考核");
		Menuitem73.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menuitem Menuitem74 = new Menuitem();
		Menuitem74.setMid(74L);
		Menuitem74.setIsParent(false);
		//Menuitem63.setChecked(false);
		Menuitem74.setPid(7L);
		Menuitem74.setName("我的绩效");
		Menuitem74.setIcon("css/images/MenuIcon/FUNC20064.gif");
		
/*****************************************************************************************/
		/*
		 * 薪资管理
		 */
		Menuitem Menuitem8 = new Menuitem();
		Menuitem8.setMid(8L);
		Menuitem8.setIsParent(true);
		//Menuitem7.setChecked(false);
		Menuitem8.setPid(1L);
		Menuitem8.setName("薪资管理");
		Menuitem8.setIcon("css/images/MenuIcon/FUNC20001.gif");

		//薪资管理---薪资设置
		Menuitem Menuitem81 = new Menuitem();
		Menuitem81.setMid(81L);
		Menuitem81.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem81.setPid(8L);
		Menuitem81.setName("薪资设置");
		Menuitem81.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menuitem Menuitem811 = new Menuitem();
		Menuitem811.setMid(811L);
		Menuitem811.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem811.setPid(81L);
		Menuitem811.setName("薪资标准");
		Menuitem811.setIcon("css/images/MenuIcon/FUNC55000.gif");
         
		Menuitem Menuitem812 = new Menuitem();
		Menuitem812.setMid(812L);
		Menuitem812.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem812.setPid(81L);
		Menuitem812.setName("津贴设置");
		Menuitem812.setIcon("css/images/MenuIcon/FUNC55000.gif");

        
		Menuitem Menuitem813 = new Menuitem();
		Menuitem813.setMid(813L);
		Menuitem813.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem813.setPid(81L);
		Menuitem813.setName("薪资合算");
		Menuitem813.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		//薪资管理---薪资查询
		Menuitem Menuitem82 = new Menuitem();
		Menuitem82.setMid(82L);
		Menuitem82.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem82.setPid(8L);
		Menuitem82.setName("薪资计算");
		Menuitem82.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menuitem Menuitem821 = new Menuitem();
		Menuitem821.setMid(821L);
		Menuitem821.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem821.setPid(82L);
		Menuitem821.setName("本月薪资");
		Menuitem821.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Menuitem Menuitem822 = new Menuitem();
		Menuitem822.setMid(822L);
		Menuitem822.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem822.setPid(82L);
		Menuitem822.setName("上月薪资");
		Menuitem822.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		
		Menuitem Menuitem823 = new Menuitem();
		Menuitem823.setMid(823L);
		Menuitem823.setIsParent(false);
		//Menuitem7.setChecked(false);
		Menuitem823.setPid(82L);
		Menuitem823.setName("历史薪资");
		Menuitem823.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		
/*******************************************************************/
		/*
		 * 离职管理
		 */
		Menuitem Menuitem9 = new Menuitem();
		Menuitem9.setMid(9L);
		Menuitem9.setIsParent(true);
		//Menuitem8.setChecked(false);
		Menuitem9.setPid(1L);
		Menuitem9.setName("离职管理");
		Menuitem9.setIcon("css/images/MenuIcon/FUNC20076.gif");
		
		Menuitem Menuitem91 = new Menuitem();
		Menuitem91.setMid(91L);
		Menuitem91.setIsParent(false);
		//Menuitem81.setChecked(false);
		Menuitem91.setPid(9L);
		Menuitem91.setName("离职维护");
		Menuitem91.setIcon("css/images/MenuIcon/FUNC220000.gif");
		
		Menuitem Menuitem92 = new Menuitem();
		Menuitem92.setMid(92L);
		Menuitem92.setIsParent(false);
		//Menuitem82.setChecked(false);
		Menuitem92.setPid(9L);
		Menuitem92.setName("原因分析");
		Menuitem92.setIcon("css/images/MenuIcon/search.gif");
		

/***********************************************************************************/
		/*
		 * 系统管理
		 * 	岗位管理
		 * 	部门管理
		 * 	用户管理
		 */
		Menuitem Menuitem10 = new Menuitem();
		Menuitem10.setMid(10L);
		Menuitem10.setIsParent(true);
		//Menuitem10.setChecked(false);
		Menuitem10.setPid(1L);
		Menuitem10.setName("系统管理");
		Menuitem10.setIcon("css/images/MenuIcon/system.gif");
		
		Menuitem Menuitem101 = new Menuitem();
		Menuitem101.setMid(101L);
		Menuitem101.setIsParent(false);
		//Menuitem101.setChecked(false);
		Menuitem101.setPid(10L);
		Menuitem101.setName("岗位管理");
		Menuitem101.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Menuitem Menuitem102 = new Menuitem();
		Menuitem102.setMid(102L);
		Menuitem102.setIsParent(false);
		//Menuitem102.setChecked(false);
		Menuitem102.setPid(10L);
		Menuitem102.setName("部门管理");
		Menuitem102.setIcon("css/images/MenuIcon/department.gif");
		
		Menuitem Menuitem103 = new Menuitem();
		Menuitem103.setMid(103L);
		Menuitem103.setIsParent(false);
		//Menuitem103.setChecked(false);
		Menuitem103.setPid(10L);
		Menuitem103.setName("用户管理");
		Menuitem103.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Menuitem Menuitem104 = new Menuitem();
		Menuitem104.setMid(104L);
		Menuitem104.setIsParent(false);
		//Menuitem103.setChecked(false);
		Menuitem104.setPid(10L);
		Menuitem104.setName("用户组管理");
		Menuitem104.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Menuitem Menuitem105 = new Menuitem();
		Menuitem105.setMid(105L);
		Menuitem105.setIsParent(false);
		//Menuitem103.setChecked(false);
		Menuitem105.setPid(10L);
		Menuitem105.setName("菜单项管理");
		Menuitem105.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Menuitem Menuitem106 = new Menuitem();
		Menuitem106.setMid(106L);
		Menuitem106.setIsParent(false);
		//Menuitem103.setChecked(false);
		Menuitem106.setPid(10L);
		Menuitem106.setName("邮件管理");
		Menuitem106.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
/**********************************************************************/
		
		/*
		session.save(Menuitemitem1);
		
		session.save(Menuitem2);
		session.save(Menuitem21);
		session.save(Menuitem211);
		session.save(Menuitem212);
		session.save(Menuitem213);
		session.save(Menuitem214);
		session.save(Menuitem213);
		
		session.save(Menuitem22);
		session.save(Menuitem221);
		session.save(Menuitem222);
		session.save(Menuitem223);
		session.save(Menuitem224);
		
		session.save(Menuitem23);
		session.save(Menuitem231);
		session.save(Menuitem232);
		session.save(Menuitem233);
		session.save(Menuitem234);
		
		session.save(Menuitem24);
		session.save(Menuitem25);
		session.save(Menuitem26);
		
		
		session.save(Menuitem3);
		session.save(Menuitem31);
		session.save(Menuitem32);
		
		
		session.save(Menuitem4);
		session.save(Menuitem41);
		session.save(Menuitem42);
		
		session.save(Menuitem5);
		session.save(Menuitem51);
		session.save(Menuitem52);
		
		
       
	
		
		session.save(Menuitem6);
		
		session.save(Menuitem61);
		session.save(Menuitem62);
		session.save(Menuitem63);
		
		
		
		session.save(Menuitem7);
		session.save(Menuitem71);
		session.save(Menuitem72);
		session.save(Menuitem73);
		session.save(Menuitem7);
		*/
		//session.save(Menuitem8);
		/*session.save(Menuitem81);
		session.save(Menuitem811);
		session.save(Menuitem812);
		session.save(Menuitem813);*/
		session.save(Menuitem82);
		session.save(Menuitem821);
		session.save(Menuitem822);
		session.save(Menuitem823);
	
		/*session.save(Menuitem9);
		session.save(Menuitem91);
		session.save(Menuitem92);
		
		
		
		session.save(Menuitem10);
		session.save(Menuitem101);
		session.save(Menuitem102);
		session.save(Menuitem103);
		session.save(Menuitem104);
		session.save(Menuitem105);
		session.save(Menuitem106);*/
		transaction.commit();
		session.close();
	}
}

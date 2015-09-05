package com.wolf.hr.domain;

import java.io.Serializable;
import java.util.Set;



public class User implements Serializable{
	private Long uid;//员工基本信息ID,不含任何业务逻辑
	private String Jobnumber;//员工工号
	private String username;//员工姓名
	
	private String password;//密码
	
	private String idcard;//身份证号
	private String birthday;//出生日期
	private String jiguan;//籍贯
	private String hukou;//户口所在地
	private String hunyin;//婚姻状况
	private String xuexing;//学型
	
	private String gradue;//毕业时间
	private String rusidate;//如司日期
	private String xuewei;//学位
	private String waiyu;//外语语种
	private String major;//专业
	private String secondwaiyu;//第二外语
	
	private String techang;//特长
	private String phone;//电话
	private String jinjiren;//紧急联系人
	private String zhuanzhengriqi;//转正日期
	private String zhichen;//职称
	
	private String mingzu;//名族
	private String sex;//性别
	private String englishname;//英文名
	private String juzhudizhi;//居住地址
	private String zhengzhimianmao;//政治面貌
	private String xueli;//学历
	private String firstworktime;//初次工作时间
	private String gradueschool;//毕业院校
	private String waiyujibie;//外语级别
	private String secondwaiyujibie;//第二外语级别
	private String likes;//爱好
	private String email;//邮箱
	private String jinjirenphone;//紧急联系人电话
	private String employstate;//员工状态
	
	private String zhengshu;//证书
	private String gongzuolvli;//工作履历
	
	private String jianliurl;//简历文件
	
	private String photourl;//照片
	
	
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getJobnumber() {
		return Jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		Jobnumber = jobnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getHukou() {
		return hukou;
	}

	public void setHukou(String hukou) {
		this.hukou = hukou;
	}

	public String getHunyin() {
		return hunyin;
	}

	public void setHunyin(String hunyin) {
		this.hunyin = hunyin;
	}

	public String getXuexing() {
		return xuexing;
	}

	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}

	public String getGradue() {
		return gradue;
	}

	public void setGradue(String gradue) {
		this.gradue = gradue;
	}

	public String getRusidate() {
		return rusidate;
	}

	public void setRusidate(String rusidate) {
		this.rusidate = rusidate;
	}

	public String getXuewei() {
		return xuewei;
	}

	public void setXuewei(String xuewei) {
		this.xuewei = xuewei;
	}

	public String getWaiyu() {
		return waiyu;
	}

	public void setWaiyu(String waiyu) {
		this.waiyu = waiyu;
	}

	public String getSecondwaiyu() {
		return secondwaiyu;
	}

	public void setSecondwaiyu(String secondwaiyu) {
		this.secondwaiyu = secondwaiyu;
	}

	public String getTechang() {
		return techang;
	}

	public void setTechang(String techang) {
		this.techang = techang;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJinjiren() {
		return jinjiren;
	}

	public void setJinjiren(String jinjiren) {
		this.jinjiren = jinjiren;
	}

	public String getZhuanzhengriqi() {
		return zhuanzhengriqi;
	}

	public void setZhuanzhengriqi(String zhuanzhengriqi) {
		this.zhuanzhengriqi = zhuanzhengriqi;
	}

	public String getZhichen() {
		return zhichen;
	}

	public void setZhichen(String zhichen) {
		this.zhichen = zhichen;
	}

	public String getMingzu() {
		return mingzu;
	}

	public void setMingzu(String mingzu) {
		this.mingzu = mingzu;
	}

	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getJuzhudizhi() {
		return juzhudizhi;
	}

	public void setJuzhudizhi(String juzhudizhi) {
		this.juzhudizhi = juzhudizhi;
	}

	public String getZhengzhimianmao() {
		return zhengzhimianmao;
	}

	public void setZhengzhimianmao(String zhengzhimianmao) {
		this.zhengzhimianmao = zhengzhimianmao;
	}

	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getFirstworktime() {
		return firstworktime;
	}

	public void setFirstworktime(String firstworktime) {
		this.firstworktime = firstworktime;
	}

	public String getGradueschool() {
		return gradueschool;
	}

	public void setGradueschool(String gradueschool) {
		this.gradueschool = gradueschool;
	}

	public String getWaiyujibie() {
		return waiyujibie;
	}

	public void setWaiyujibie(String waiyujibie) {
		this.waiyujibie = waiyujibie;
	}

	public String getSecondwaiyujibie() {
		return secondwaiyujibie;
	}

	public void setSecondwaiyujibie(String secondwaiyujibie) {
		this.secondwaiyujibie = secondwaiyujibie;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJinjirenphone() {
		return jinjirenphone;
	}

	public void setJinjirenphone(String jinjirenphone) {
		this.jinjirenphone = jinjirenphone;
	}

	public String getEmploystate() {
		return employstate;
	}

	public void setEmploystate(String employstate) {
		this.employstate = employstate;
	}

	public String getZhengshu() {
		return zhengshu;
	}

	public void setZhengshu(String zhengshu) {
		this.zhengshu = zhengshu;
	}

	public String getGongzuolvli() {
		return gongzuolvli;
	}

	public void setGongzuolvli(String gongzuolvli) {
		this.gongzuolvli = gongzuolvli;
	}

	
	public String getJianliurl() {
		return jianliurl;
	}

	public void setJianliurl(String jianliurl) {
		this.jianliurl = jianliurl;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}


	/***************用户-UserEdu--一对多************************/
	private Set<UserEdu> useredu;
	
	

	public Set<UserEdu> getUseredu() {
		return useredu;
	}

	public void setUseredu(Set<UserEdu> useredu) {
		this.useredu = useredu;
	}

	/***************用户-UserManger-一对一************************/
	
      private UserManger usermanger;
      public UserManger getUsermanger() {
  		return usermanger;
  	}

  	public void setUsermanger(UserManger usermanger) {
  		this.usermanger = usermanger;
  	}

	/***************用户-UserWork--一对多************************/
	
      private Set<UserWork> userwork;

	 

	public Set<UserWork> getUserwork() {
		return userwork;
	}

	public void setUserwork(Set<UserWork> userwork) {
		this.userwork = userwork;
	}

	/***************部门************************/
	private Department department;
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	/***************岗位************************/
	private Set<Post> posts;
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	/***************用户组************************/
	private Set<UserGroup> usergroups;

	public Set<UserGroup> getUsergroups() {
		return usergroups;
	}

	public void setUsergroups(Set<UserGroup> usergroups) {
		this.usergroups = usergroups;
	}
	
	private Set<Menuitem> menuitems;
	public Set<Menuitem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(Set<Menuitem> menuitems) {
		this.menuitems = menuitems;
	}
	
	
	/***************消息************************/
	private Set<Message> sendMessages  ;
	private Set<Message> receiveMessages ;
	
	public Set<Message> getSendMessages() {
		return sendMessages;
	}
	public void setSendMessages(Set<Message> sendMessages) {
		this.sendMessages = sendMessages;
	}
	public Set<Message> getReceiveMessages() {
		return receiveMessages;
	}
	public void setReceiveMessages(Set<Message> receiveMessages) {
		this.receiveMessages = receiveMessages;
	}
	/***************邮件************************/
	private Set<Mail> sendMail  ;
	private Set<Mail> receiveMail ;



	public Set<Mail> getSendMail() {
		return sendMail;
	}

	public void setSendMail(Set<Mail> sendMail) {
		this.sendMail = sendMail;
	}

	public Set<Mail> getReceiveMail() {
		return receiveMail;
	}

	public void setReceiveMail(Set<Mail> receiveMail) {
		this.receiveMail = receiveMail;
	}
	
	/***************加班************************/
	private Set<AddWorking> addWorks ;



	public Set<AddWorking> getAddWorks() {
		return addWorks;
	}

	public void setAddWorks(Set<AddWorking> addWorks) {
		this.addWorks = addWorks;
	}
	
	private Set<Leave> leaves ;//请假 

	private Set<Attendance> attendances ;// 日常 考勤 
	
	private Set<Attendance> allAtts ;//考勤部 查询 所有 员工 

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}

	public Set<Attendance> getAllAtts() {
		return allAtts;
	}

	public void setAllAtts(Set<Attendance> allAtts) {
		this.allAtts = allAtts;
	}
	
	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}
	
	/********工资 ***************/
	private Set<SalaryInfo> salaryInfos;

	public Set<SalaryInfo> getSalaryInfos() {
		return salaryInfos;
	}

	public void setSalaryInfos(Set<SalaryInfo> salaryInfos) {
		this.salaryInfos = salaryInfos;
	}
	
}



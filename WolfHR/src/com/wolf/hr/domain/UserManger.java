package com.wolf.hr.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Set;



public class UserManger implements Serializable{
	
	private Long umid;
	private String yiliaobaoxian;//医疗保险号
	private String danganhao;//档案号
	private String dangansuozaidi;//档案所在地
    private String gongzuoxingzhi;//工作性质
    private String gongjijinhao;//公积金号
    private String shebaobianhao;//社保编号
    private String bianzhi;//编制
    private String bankID;//银行账号
    private String kaoqinbanci;//考勤班次
    
    
	public Long getUmid() {
		return umid;
	}
	public void setUmid(Long umid) {
		this.umid = umid;
	}
	public String getYiliaobaoxian() {
		return yiliaobaoxian;
	}
	public void setYiliaobaoxian(String yiliaobaoxian) {
		this.yiliaobaoxian = yiliaobaoxian;
	}
	public String getDanganhao() {
		return danganhao;
	}
	public void setDanganhao(String danganhao) {
		this.danganhao = danganhao;
	}
	public String getDangansuozaidi() {
		return dangansuozaidi;
	}
	public void setDangansuozaidi(String dangansuozaidi) {
		this.dangansuozaidi = dangansuozaidi;
	}
	public String getGongzuoxingzhi() {
		return gongzuoxingzhi;
	}
	public void setGongzuoxingzhi(String gongzuoxingzhi) {
		this.gongzuoxingzhi = gongzuoxingzhi;
	}
	public String getGongjijinhao() {
		return gongjijinhao;
	}
	public void setGongjijinhao(String gongjijinhao) {
		this.gongjijinhao = gongjijinhao;
	}
	public String getShebaobianhao() {
		return shebaobianhao;
	}
	public void setShebaobianhao(String shebaobianhao) {
		this.shebaobianhao = shebaobianhao;
	}
	public String getBianzhi() {
		return bianzhi;
	}
	public void setBianzhi(String bianzhi) {
		this.bianzhi = bianzhi;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getKaoqinbanci() {
		return kaoqinbanci;
	}
	public void setKaoqinbanci(String kaoqinbanci) {
		this.kaoqinbanci = kaoqinbanci;
	}
    
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	


}
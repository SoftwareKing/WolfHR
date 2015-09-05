<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/WEB-INF/jsp/user/usercommon.jsp"></jsp:include>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
 <body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">
 <div>
     <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/user/title_arrow.gif" height="13" border="0" width="13" /> 查看个人档案<input value="systemadmin" name="userAccount" type="hidden" />
        </div>

        <div id="Title_End"></div>

       
      </div>
     </div>   
    <center>
      <div class="ItemBlock_Title1">
        <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" />&nbsp;基本信息
      </div>

      <div class="ItemBlockBorder" style="width:95%;">
        <div class="ItemBlock">
          <center>
            <center>
              <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                  <tr>
                    <td>
                      <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                          <tr>
                            <td width="50"></td>

                            <td width="100"></td>

                            <td width="150"></td>

                            <td width="50"></td>

                            <td height="27" width="100"></td>

                            <td width="150"></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>工号</td>

                            <td><s:property value="#personal.Jobnumber"/></td>

                            <td height="27" width="50"></td>

                            <td>员工姓名</td>

                            <td><s:property value="#personal.username"/></td>

                            <td rowspan="4">
                              <table cellpadding="0" cellspacing="0" height="120" border="0" width="120">
                                <tbody>
                                  <tr height="5">
                                    <td class="Navigation_bg_img1" width="5"></td>

                                    <td class="Navigation_bg_img2"></td>

                                    <td class="Navigation_bg_img3" width="6"></td>
                                  </tr>

                                  <tr>
                                    <td class="Navigation_bg_img4"></td>

                                    <td class="Category_bg" align="center" valign="middle"><img src="" height="100" border="0" width="100" /></td>

                                    <td class="Navigation_bg_img6"></td>
                                  </tr>

                                  <tr height="6">
                                    <td class="Navigation_bg_img8"></td>

                                    <td class="Navigation_bg_img10"></td>

                                    <td class="Navigation_bg_img9"></td>
                                  </tr>
                                </tbody>
                              </table>
                            </td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>身份证号码</td>

                            <td><s:property value="#personal.idcard"/></td>

                            <td height="27" width="50"></td>

                            <td>民族</td>

                            <td><s:property value="#personal.mingzu"/></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>出生日期</td>

                            <td><s:property value="#personal.birthday"/></td>

                            <td height="27" width="50"></td>

                            <td>性别</td>

                            <td width="150"><s:property value="#personal.sex"/></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>籍贯</td>

                            <td> <s:property value="#personal.jiguan"/></td>

                            <td height="27" width="50"></td>

                            <td>英文名</td>

                            <td><s:property value="#personal.englishname"/></td>
                          </tr>

                          <tr>
                            <td></td>

                            <td>户口所在地</td>

                            <td><s:property value="#personal.hukou"/></td>

                            <td></td>

                            <td>居住地址</td>

                            <td height="27"><s:property value="#personal.juzhudizhi"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>婚姻状态</td>

                            <td><s:property value="#personal.hunyin"/></td>

                            <td height="27" width="50"></td>

                            <td>政治面貌</td>

                            <td><s:property value="#personal.zhengzhimianmao"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>血型</td>

                            <td><s:property value="#personal.xuexing"/></td>

                            <td height="27" width="50"></td>

                            <td>学历</td>

                            <td><s:property value="#personal.xueli"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>毕业时间</td>

                            <td><s:property value="#personal.gradue"/></td>

                            <td height="27" width="50"></td>

                            <td>初次工作时间</td>

                            <td><s:property value="#personal.firstworktime"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>入职日期</td>

                            <td><s:property value="#personal.rusidate"/></td>

                            <td height="27" width="50"></td>

                            <td>毕业院校</td>

                            <td><s:property value="#personal.gradueschool"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td></td>

                            <td height="27">学位</td>

                            <td><s:property value="#personal.xuewei"/></td>

                            <td></td>

                            <td>专业</td>

                            <td><s:property value="#personal.major"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>外语语种</td>

                            <td><s:property value="#personal.waiyu"/></td>

                            <td height="27" width="50"></td>

                            <td>外语级别</td>

                            <td><s:property value="#personal.waiyujibie"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>第二外语</td>

                            <td><s:property value="#personal.secondwaiyu"/></td>

                            <td height="27" width="50"></td>

                            <td>第二外语级别</td>

                            <td><s:property value="#personal.secondwaiyujibie"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27"></td>

                            <td>特长</td>

                            <td><s:property value="#personal.techang"/></td>

                            <td></td>

                            <td>爱好</td>

                            <td><s:property value="#personal.likes"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>电话</td>

                            <td><s:property value="#personal.phone"/></td>

                            <td height="27" width="50"></td>

                            <td>邮箱</td>

                            <td><s:property value="#personal.email"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27"></td>

                            <td>紧急联系人</td>

                            <td><s:property value="#personal.jinjiren"/></td>

                            <td></td>

                            <td>联系人电话</td>

                            <td><s:property value="#personal.jinjirenphone"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>转正日期</td>

                            <td><s:property value="#personal.zhuanzhengriqi"/></td>

                            <td height="27" width="50"></td>

                            <td>员工状态</td>

                            <td><s:property value="#personal.employstate"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>部门</td>

                            <td><s:property value="#personal.department.dname"/></td>

                            <td height="27" width="50"></td>

                            <td>岗位</td>

                            <td><s:property value="#personal.post.pname"/></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27" width="50"></td>

                            <td>职称</td>

                            <td><s:property value="#personal.zhichen"/></td>

                            <td height="27" width="50"></td>

                            <td></td>

                            <td></td>

                            <td></td>
                          </tr>

                          <tr>
                            <td height="27"></td>

                            <td height="70">职业资格证书</td>

                            <td colspan="4"><s:property value="#personal.zhengshu"/></td>

                            <td>
                            
                           
                            
                            </td>
                          </tr>

                          <tr>
                            <td height="27"></td>

                            <td height="70">工作履历</td>

                            <td colspan="6"><s:property value="#personal.gongzuolvli"/></td>
                            <td colspan="6"></td>
                          </tr>

                          <tr>
                            <td height="27"></td>

                            <td>简历附件</td>

                            <td><s:property value="#personal.jianli"/></td>

                            <td height="27" width="50"></td>

                            <td></td>

                            <td width="150"></td>

                            <td></td>
                          </tr>
                        </tbody>
                      </table>
                    </td>

                    <td align="right" valign="top"></td>

                    <td width="10"></td>
                  </tr>
                </tbody>
              </table>
            </center>
          </center>
        </div>
      </div>
    </center><br />

    <center>
      <div class="ItemBlock_Title1">
        <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" />&nbsp;管理信息
      </div>

      <div class="ItemBlockBorder" style="width:95%;">
        <div class="ItemBlock">
          <center>
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
              <tbody>
                <tr>
                  <td height="27" width="50"></td>

                  <td width="140">医疗保险号</td>

                  <td width="200"><s:property value="#personal.usermanger.yiliaobaoxian"/> </td>

                  <td height="27" width="50"></td>

                  <td width="140">编制</td>

                  <td><s:property value="#personal.usermanger.bianzhi"/></td>
                   
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>档案号</td>

                  <td><s:property value="#personal.usermanger.danganhao"/></td>

                  <td height="27" width="50"></td>

                  <td width="73">银行账号 </td>

                  <td><s:property value="#personal.usermanger.bankID"/></td>
                   
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>档案所在地</td>

                  <td><s:property value="#personal.usermanger.dangansuozaidi"/> </td>

                  <td height="27" width="50"></td>
                  

                  <td>考勤班次</td>

                  <td><s:property value="#personal.usermanger.kaoqinbanci"/></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td></td>

                  <td> </td>

                  <td></td>

                  <td></td>

                  <td></td>
                </tr>
                 <tr style="display:none">
                  <td></td>

                  <td></td>

                  <td></td>

                  <td></td>

                  <td></td>

                  <td></td>
                </tr>
              </tbody>
            </table>
          </center>
        </div>
      </div>
    </center><br />

  <center>
      <center>
        <div class="ItemBlock_Title1">
          <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" /> 教育经历浏览
        </div>

        <div class="ItemBlockBorder" style="width:95%;">
          <div class="ItemBlock">
            <table class="TableStyle" cellpadding="0" cellspacing="0" border="0" width="92%">
              <tbody>
                <tr id="TableTitle" align="center" valign="middle">
                  <td width="80">学历</td>

                  <td width="200">学校</td>

                  <td width="150">专业</td>

                  <td width="130">开始时间</td>

                  <td width="130">结束时间</td>

                  <td>备注</td>
                </tr>
              </tbody>

            <tbody id="TableData" class="dataContainer" >
              <s:iterator value="#personal.useredu" var="edu">
	            <tr class="TableDetail1 template">
	                <td align=center> <s:property value="#edu.xueli"/></td>
	               
	                <td align=center><s:property value="#edu.school"/></td>
	                <td align=center>
						<s:property value="#edu.major"/>
						
					</td>
					<td align=center>
					<s:property value="#edu.starttime"/>
				    </td>
	                <td align=center>
						
							<s:property value="#edu.endtime"/>
						
					</td>
					<td align=center>
						
							<s:property value="#edu.description"/>
					
					</td>
	              
	            </tr>
            </s:iterator>
              
              </tbody>
              
            </table>
          </div>
        </div>
      </center>
    </center><br/>
    <center>
      <center>
        <div class="ItemBlock_Title">
          <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" /> 工作经历浏览
        </div>
        
        

        <div class="ItemBlockBorder" style="width:95%;">
          <div class="ItemBlock">
          <table class="TableStyle" cellpadding="0" cellspacing="0" border="0" width="92%">
             <tbody>
                <tr id="TableTitle" align="center" valign="middle">
                  
                  <td width="80">公司名称</td>

                  <td width="200">负责工作</td>

                  <td width="130">开始时间</td>

                  <td width="130">结束时间</td>

                  <td width="200">主要业绩</td>

                  <td width="200">备注</td>

                 </tr>
              </tbody>
            
             <tbody id="TableData" class="dataContainer" >
              <s:iterator value="#personal.userwork " var="work">
	            <tr class="TableDetail1 template">
	                <td align=center> <s:property value="#work.companyname"/></td>
	               
	                <td align=center><s:property value="#work.majorwork"/></td>
	                <td align=center>
						<s:property value="#work.starttime"/>
						
					</td>
					<td align=center>
					<s:property value="#work.endtime"/>
				    </td>
	                <td align=center>
						
							<s:property value="#work.yeji"/>
						
					</td>
					
					
					<td align=center>
						
							<s:property value="#work.description"/>
						
					</td>
					
	            </tr>
            </s:iterator>
              
              </tbody>
            </table>
          </div>
        </div>
      </center>
    </center><br/>

 </div>
 </body>

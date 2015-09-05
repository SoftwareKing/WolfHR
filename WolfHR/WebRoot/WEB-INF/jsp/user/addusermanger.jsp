<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/user/usercommon.jsp"></jsp:include>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
  <title>HR</title>
</head>

<body>
  <s:form action="usermangerAction_add.action">
     <s:hidden name="uid"></s:hidden>
    <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/user/title_arrow.gif" border="0" height="13" width="13" /> 新增员工档案<input name="userAccount" type="hidden" />
        </div>

        <div id="Title_End"></div>

       
      </div>
    </div>

    <div id="QueryArea">
      <div style="height: 25px">
        <center>
          <table cellpadding="3" cellspacing="1" border="0" height="22">
            <tbody>
              <tr width="230" class="Pannel_font" align="center" valign="bottom">
             <td class="Pannel_no_select" width="77"><a onclick="submitButton('EDUCATION');" href="usereduAction_getAllUserEdu.action">教育背景</a></td>

              <td class="Pannel_select" width="77"><a onclick="submitButton('BASE');" href="usermangerAction_addUI.action">管理信息</a></td>
              
             <td class="Pannel_no_select" width="77"><a onclick="submitButton('EDUCATION');" href="usereduAction_getAllUserEdu.action">教育背景</a></td>

              <td class="Pannel_no_select" width="77"><a onclick="submitButton('WORKHISTORY');" href="userworkAction_getAllUserWork.action">工作经历</a></td>
            </tr>
            </tbody>
          </table>
        </center>
      </div>
    </div>

    <center>
      <div class="ItemBlock_Title1">
        <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" />&nbsp;管理信息
      </div>

      <div class="ItemBlockBorder" style="width:95%;">
        <div class="ItemBlock">
          <center>
            <table cellpadding="0" cellspacing="0" border="0" width="90%">
              <tbody>
              <tr>
                  <td height="27" width="30"></td>
                   <td>所属用户</td>
                    	<!-- 
                    		list 数据的来源
                    		listValue 显示的文本内容
                    		listKey   option的属性value的值
                    	 -->
                    	
                    <td>
                     <s:select list="#userList" listKey="uid" listValue="username" headerKey="" headerValue="请选择员工" name="uid" ></s:select>
                    </td>
                </tr>
                <tr>
                  <td height="27"></td>

                  <td width="100">医疗保险号</td>

                  <td><input onfocus="this.select();" class="InputStyle" name="yiliaobaoxian" type="text" /></td>

                  <td height="27" width="50"></td>

                  <td width="73">公积金号</td>

                  <td width="150"><input onfocus="this.select();" class="InputStyle" name="gongjijinhao" type="text" /></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>档案号</td>

                  <td><input onfocus="this.select();" class="InputStyle" name="danganhao" type="text" /></td>

                  <td height="27" width="10"></td>

                  <td width="73">社保编号</td>

                  <td><input onfocus="this.select();" class="InputStyle" name="shebaobianhao" type="text" /></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>档案所在地</td>

                  <td><input onfocus="this.select();" class="InputStyle" name="dangansuozaidi" type="text" /></td>

                  <td height="27" width="10"></td>

                  <td>编制</td>

                  <td><select class="SelectStyle" name="bianzhi">
                    <option value="WONoSelectionString">
                      请选择
                    </option>

                    <option value="0">
                      工人
                    </option>

                    <option selected="selected" value="1">
                      干部
                    </option>
                  </select></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>考勤班次</td>

                  <td><select name="kaoqinbanci">
                    <option  value="默认班次">
                                                                默认班次
                    </option>
                  </select></td>

                  <td></td>

                  <td>银行账号</td>

                  <td><input onfocus="this.select();" class="InputStyle" name="bankID" type="text" /></td>
                   
                   <td></td>
                
                </tr>
                 <tr>
                  <td height="27"></td>

                  <td>工作性质</td>

                  <td>
                    <table cellpadding="0" cellspacing="0" border="0">
                      <tbody>
                        <tr>
                          <td><input value="一线员工" name="gongzuoxingzhi" checked="checked" type="radio" /></td>

                          <td>一线员工</td>

                          <td><input value="辅助员工" name="gongzuoxingzhi" type="radio" /></td>

                          <td>辅助员工</td>
                        </tr>
                      </tbody>
                    </table>
                  </td>

                  <td height="27" width="10"></td>

                  <td width="73"></td>

                  <td></td>
                </tr>

                <tr style="display:none">
                  <td></td>

                  <td></td>

                  <td></td>

                  <td></td>

                  <td></td>

                  <td>
                   
                  
                  </td>
                </tr>
              </tbody>
            </table>
          </center>
         &nbsp; &nbsp;&nbsp;  &nbsp; &nbsp; 注：一个员工只有一个管理信息，请不要重复操作！
        </div>
                
      </div>
    </center>
    <div id="InputDetailBar">
          <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
          <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
    </div>
  </s:form>
</body>
</html>

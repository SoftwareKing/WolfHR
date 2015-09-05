<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/WEB-INF/jsp/user/usercommon.jsp"></jsp:include>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
  <title>HR</title>
</head>

<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">

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
              <td class="Pannel_no_select" width="76"><a onclick="submitButton('BASE');" href="userAction_addUUI.action">基本信息</a></td>

              <td class="Pannel_no_select" width="77"><a onclick="submitButton('BASE');" href="usermangerAction_addUI.action">管理信息</a></td>

              <td class="Pannel_select" width="77"><a onclick="submitButton('EDUCATION');" href="usereduAction_getAllUserEdu.action">教育背景</a></td>

              <td class="Pannel_no_select" width="77"><a onclick="submitButton('WORKHISTORY');" href="userworkAction_getAllUserWork.action">工作经历</a></td>
            </tr>
            </tbody>
          </table>
        </center>
      </div>
    </div>

    <center>
      <center>
      <s:form action="usereduAction_update.action">
      <s:hidden name="ueid"></s:hidden>
        <div class="ItemBlock_Title1">
          <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" />&nbsp;教育经历
        </div>

        <div class="ItemBlockBorder" style="width:95%;">
          <div class="ItemBlock">
            <table cellpadding="0" cellspacing="0" border="0" width="90%">
              <tbody>
                <tr>
                  <td height="27" width="30"></td>

                  <td>学历</td>

                  <td>
                 
                  <s:textfield name="xueli" cssClass="InputStyle"></s:textfield>
                  </td>

                  <td align="center" width="40"><font color="#FF0000">*</font></td>

                  
                </tr>

                <tr>
                  <td height="27" width="50"></td>

                  <td width="100">学校</td>

                  <td>
                 
                  <s:textfield name="school" cssClass="InputStyle"></s:textfield>
                  </td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>专业</td>

                  <td>
                 
                  <s:textfield name="major" cssClass="InputStyle"></s:textfield>
                  </td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>开始时间</td>

                  <td>
                     <s:textfield  size="10"  value="1970-01-01" name="starttime" type="text" > </s:textfield>
                     
                  </td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>结束时间</td>

                  <td>
                    <s:textfield size="10"   name="endtime" type="text" ></s:textfield> 
                    
                  </td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="80"></td>

                  <td>备注</td>

                  <td>
                  <s:textarea cssClass="InputAreaStyle" style="width:100%;height:80%" name="description">
                   </s:textarea></td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td></td>

                  <td></td>

                  <td></td>

                  <td>
                  
                   <div id="InputDetailBar">
                     <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
                      <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
       </s:form>
       </center>
      </center>
  
</body>
</html>

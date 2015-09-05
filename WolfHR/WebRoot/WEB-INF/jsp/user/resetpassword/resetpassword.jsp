<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/user/usercommon.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>密码修改</title>
    <script language="javascript" src="${pageContext.request.contextPath}/css/user/password.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" type="text/css">
  </head>
  
 <body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">
 <s:form action="userAction_resetpsw.action">
    <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/user/title_arrow.gif" border="0" height="13" width="13" /> 密码修改
        </div>

        <div id="Title_End"></div>

        
      </div>

      
    </div>

    <div id="MainArea">
    

      <center>
        <div class="ItemBlock_Title1"></div>

        <div class="ItemBlockBorder">
          <div class="ItemBlock">
            <br />

            <table cellpadding="0" cellspacing="0" border="0">
              <tbody>
                  <tr height="27">
                  <td align="right"><img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" /></td>

                  <td valign="middle">&nbsp;请填写新密码</td>

                  <td><input onkeyup="pwStrength(this.value);" onblur="pwStrength(this.value);" class="InputStyle" id="newPwd" name="newPwd" type="password" /></td>

                  <td width="10"></td>

                  <td style="DISPLAY: block" id="passwdBarDiv" nowrap="nowrap" valign="middle" width="180">
                    <table cellpadding="0" cellspacing="0" border="0">
                      <tbody>
                        <tr>
                          <td nowrap="nowrap" valign="top" width="0"><font face="Arial, sans-serif" size="-1">密码强度</font></td>

                          <td nowrap="nowrap" valign="top"><font color="#808080" face="Arial, sans-serif" size="-1"><b><span id="passwdRating"></span></b></font></td>
                        </tr>

                        <tr>
                          <td colspan="2">
                            <table id="passwdBar" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" border="0" width="160">
                              <tbody>
                                <tr>
                                  <td style="WIDTH: 0px; BACKGROUND: #ffcc33" id="posBar" bgcolor="#E0E0E0" height="4" width="0%"></td>

                                  <td style="width: 160px;" id="negBar" bgcolor="#E0E0E0" height="4" width="100%"></td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>

                <tr height="27">
                  <td align="right"><img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" /></td>

                  <td valign="middle">&nbsp;再次输入新密码</td>

                  <td><input class="InputStyle" name="password" type="password" /></td>

                  <td colspan="2"></td>
                </tr>

                <tr height="20">
                  <td></td>

                  <td colspan="4">(为增加密码强度，建议您把密码长度设为6位以上,混合使用大小写字母、数字和特殊符号)</td>
                </tr>
               
              </tbody>
              
            </table>
          </div>
        </div>
      </center>
      
    </div>
    <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
            
    </div>
  </s:form>
</body>
</html>


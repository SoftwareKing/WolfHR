<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>站内邮件管理</title>
  
</head>

<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">
  <form>
   <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/message/title_arrow.gif" border="0" height="13" width="13" /> 站内邮件管理
        </div>

        <div id="Title_End"></div>

       
      </div>
    </div>

    <div id="MainArea">
      <table class="TableStyle" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
          <tr id="TableTitle" align="center" valign="middle">
           
            
            <td width="35">标题 &nbsp;</td>

            <td width="25">发送人</td>

            <td width="50">发送时间 </td>

            <td width="45">操 作 </td>
          </tr>
        </tbody>

        <tbody id="TableData">
          <s:iterator value="#mailList">
							<tr onclick="content_onclick('d0');" class="TableDetail2" id="d0">
							
							
							<td  align="CENTER">
								<s:a href="mailAction_seeMail.action?id=%{id}" 	class="Wait"><s:property value="title"/> </s:a>
							</td>
							<td  align="CENTER">
								<s:property value="sender.username"/>
							</td>
							<td  align="CENTER">
								<s:property value="showTime"/>
							</td>
							
							<td align="center">
								<s:a href="mailAction_deleteMail.action?id=%{id}">删除 </s:a> 
							</td>
						</tr>
						</s:iterator>
        </tbody>
      </table>
    </div>
    
  </form>
 <!--分页信息 -->

<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>收件箱</title>
  
</head>

<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">
  <form>
   <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/message/title_arrow.gif" border="0" height="13" width="13" /> 已接收邮件
        </div>

        <div id="Title_End"></div>

       
      </div>
    </div>

    <div id="MainArea">
      <table class="TableStyle" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
          <tr id="TableTitle" align="center" valign="middle">
            <td style="border-left: 0px solid #000;" width="26"><input name="selectAll" onclick="checkAll();" type="checkbox" /></td>

            <td width="25"><img src="${pageContext.request.contextPath}/css/message/priority.gif" /></td>

            <td width="35"><img src="${pageContext.request.contextPath}/css/message/attachmenttitle.gif" border="0" /></td>

            <td>标题 &nbsp;</td>

            <td width="180">发送人</td>

            <td width="180">发送时间 &nbsp;</td>

            <td width="180">操 作 &nbsp;</td>
          </tr>
        </tbody>

        <tbody id="TableData">
          <s:iterator value="#inboxList">
							<tr onclick="content_onclick('d0');" class="TableDetail2" id="d0">
							<td style="padding: 0px;" align="CENTER">
								<input onclick="window.event.cancelBubble=true" value="d0"
									name="checkBox" type="checkbox">
							</td>
							<td align="CENTER">
								&nbsp;
							</td>
							<td align="CENTER">
								&nbsp;
							</td>
							<td>
								<s:a href="mailAction_seeMail.action?id=%{id}" 	class="Wait"><s:property value="title"/> </s:a>
							</td>
							<td>
								<s:property value="sender.username"/>
							</td>
							<td>
								<s:property value="showTime"/>
							</td>
							
							<td align="center">
								<s:a href="mailAction_deleteFrominbox.action?id=%{id}">删除 </s:a> 
								<s:a href="mailAction_reSendMail.action?id=%{id}">回复</s:a>
							</td>
						</tr>
						</s:iterator>
        </tbody>
      </table>
    </div>
    
  </form>
 
</body>
</html>

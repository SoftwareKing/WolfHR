<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/message/messagecommon.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>   
</head>
<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">

		<table cellpadding="0" cellspacing="0" border="0" height="95%" width="100%">
			<tbody><tr>
				<td id="Title_bar">
					<div id="Title_bar_Head">
						<div id="Title_Head"></div>
						<div id="Title">
							<img src="css/message/title_arrow.gif" border="0" height="13" width="13">
							查看邮件
						</div>
						<div id="Title_End"></div>
						<div id="Title_bar_bg"></div>
					</div>
					<div id="Title_bar_Tail">
						<div id="Title_FuncBar">
							<ul>
								<li class="line"></li>
									<li class="line"></li>
								
							</ul>
						</div>
					</div>
				</td>
			</tr>
			<tr height="120">
				<td id="MsgInfo">
                    <table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tbody><tr>
							<td>
								<ul>
									<li class="MsgTitle">
									<font color="red">
										<s:property value="#mail.title" />
									</font></li>
									<li class="MsgInfoMiddle">发送时间：
										<s:property value="#mail.showTime" /></li>
									<li class="MsgInfoMiddle">发送者：
										<s:property value="#mail.sender.username" /></li>
									<li class="MsgReceiver">接收者：
											<s:property value="#mail.receiver.username" />
										</li>
									<li class="MsgReceiver">提取文件：
											<s:property value="#mail.fileSend" />
											<s:a href="download_DownFile.action?id=%{id}" >下载文件</s:a>
										</li>
									<li class="MsgReceiver">邮件内容：
											<s:property value="#mail.content" />
										</li>
								</ul>
							</td>
							
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td id="MsgContent" valign="top">
                    
 
			<div style="height: 343px;" class="Msg_read_memo_bg" id="msgFrame">
				<div align="center">
					<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
				</div>
			</div>
		                   
                   </td>
			</tr>
		</tbody></table>
</body></html>
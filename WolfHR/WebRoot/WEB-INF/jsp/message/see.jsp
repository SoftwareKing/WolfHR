<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/message/messagecommon.jsp"%>

<html>
 <head>
 
 </head>
   

<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">

		<table cellpadding="0" cellspacing="0" border="0" height="95%" width="100%">
			<tbody>
			<tr heigth="45">
				<td id="Title_bar">
					<div id="Title_bar_Head">
						<div id="Title_Head"></div>
						<div id="Title">
							<img src="css/message/title_arrow.gif" border="0" height="13" width="13">
							消息阅读
						</div>
						<div id="Title_End"></div>
					
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
                    <a name="downloadLnk">
                    </a>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tbody><tr>
							<td>
								<ul>
									<li class="MsgTitle">
									<font color="red">
										<s:property value="#message.title" />
									</font></li>
									<li class="MsgInfoMiddle">发送时间：
										<s:property value="#message.showTime" /></li>
									<li class="MsgInfoMiddle">发送者：
										<s:property value="#message.sender.username" /></li>
									<li class="MsgReceiver">接收者：
											<s:property value="#message.receiver.username" />
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
				<table cellpadding="0" cellspacing="0" border="0" height="100%" width="100%">
					<tbody><tr>
						<td width="6"></td>
						<td class="writeMsgTD1" valign="TOP">
							<div class="scrollStyle" id="msgFrame">
								<table cellpadding="0" cellspacing="0" border="0" height="100%" width="100%">
									<tbody>
									<tr>
										<td class="ItemTitleFont" valign="TOP">
											<div style="height:78px">
										      <s:property value="#message.content" />
											</div>
										</td>
									</tr>
									
								</tbody>
							</table>
							</div>
						</td>
					</tr>
				</tbody></table>
			</div>
		                   
                  </td>
			</tr>
		</tbody>
	</table>
</body>
</html>
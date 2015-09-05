<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>人力资源管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/blue/top.css" />
	<script language="javascript" src="${pageContext.request.contextPath}/js/top.js"></script>
</head>

<body class="PageBody" style="margin: 0" onload="init();" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
  
	<div id="Head1">
		<div id="Logo">
			<a id="msgLink" href="javascript:void(0)"></a>
			<!--
			<font color="#0000CC" style="color:#F1F9FE; font-size:28px; font-family:Arial Black, Arial">人力资源管理系统</font>  
			 
			-->
          
			<img border="0"  style="width:180px;height:60px; "src="${pageContext.request.contextPath}/css/blue/images/mylogo.png" />
        </div>
		
		<div id="Head1Right">
			<div id="Head1Right_UserName">
                <img border="0" width="13" height="14" src="css/images/top/user.gif" /> 您好，<b>${user.username }</b>
			</div>
			
			<div id="Head1Right_UserSetup">
            	<a target="right" href="userAction_resetpswUI.action">
					<img border="0" width="13" height="14" src="css/images/top/user_setup.gif" /> 个人设置
				</a>
			</div>
			
			
		</div>
		
		 <div id="Head1Right_Button">
		   <!--为了避免不同浏览器下的布局变化，所以加了table  -->
            <table>
            <tr>
            <td>
             <a target="right" href="${pageContext.request.contextPath}/forwardAction_right.action">
				<img width="65" height="20" alt="显示桌面" src="css/blue/images/top/desktop.gif" />
			  </a>
            
            </td>
			  <td>
		         <a target="_parent" href="loginAction_Loginout.action">
				<img width="78" height="20" alt="退出系统" src="css/blue/images/top/logout.gif" onclick="return window.confirm('您确定要退出吗?')"/>
			   </a>
			   
			  </td>
			
			</tr>
		 </table>
        </div>
       </div>
    
    <div id="Head2">
        <div id="Head2_Awoke">
            <ul id="AwokeNum">
                <li><a target="right" href="messageAction_inboxList.action">
						<img border="0" width="11" height="13" src="css/images/top/msg.gif" /> 消息
						<span id="msg"></span>
					</a>
				</li>
                <li class="Line"></li>
                <li><a target="right" href="mailAction_inboxList.action">
						<img border="0" width="16" height="11" src="css/images/top/mail.gif" /> 邮件
						<span id="mail"></span>
					</a>
				</li>
                <li class="Line"></li>
				  <!-- 是否有待审批文档的提示1，数量 -->
                <li>
                <a href="${pageContext.request.contextPath}/workFlowAction_myTaskList.action" target="right">
                		<img border="0" width="12" height="14" src="css/images/top/wait.gif" /> 
                		待审批事项
                	</a>
                </li>
				  
                <!-- 是否有待审批文档的提示2，提示审批 -->
                <li id="messageArea"></li>
               
            </ul>
           
        </div>
        
		<div id="Head2_FunctionList">
			<marquee style="WIDTH: 100%;" onMouseOver="this.stop()" onMouseOut="this.start()" 
				scrollamount=1 scrolldelay=30 direction=left>
			  <!--为了避免不同浏览器下的布局变化，所以加了table  -->
			   <table>
			     <tr>
			        <td><b>您好，当前时间为： </b></td>
			        <td><b id="Head1Right_Time"></b></td>
			     </tr>
			   </table>
			</marquee>
		</div>
	</div>

</body>
</html>

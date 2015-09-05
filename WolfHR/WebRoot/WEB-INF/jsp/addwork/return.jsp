<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
	<title>跳转页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 操作成功
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
        <div class="ItemBlock_Title1">
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td> 
                    	
                    	<font color="red" size="14">操作成功！</font>
                    </td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
             <a href="addWorkingAction_getAllAddWorking.action"> <font color="green" size="10">查看上月加班记录</font> </a>
            <a href="addWorkingAction_getAllNowAddWorking.action"><font color="blue" size="10">查看本月加班记录</font></a>
        </div>
</div>
</body>
</html>

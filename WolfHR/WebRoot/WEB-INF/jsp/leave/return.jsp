<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
	<title>请假登记</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>请假登记
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
                    <tr>
                    <td> 
                    	
                    	<font color="red" size="6">您好，恭喜您请假登记成功，请等待审核！</font>
                    </td>
                    </tr>
                </table>
               
            </div>
             
        </div>
        
        <!-- 表单操作 -->
           <div id="InputDetailBar" class="ItemBlock">
              <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                    <td> 
                    	
                    	<a href="leaveAction_getAllLeaves.action"> <font color="green" size="6">查看所有的请假记录</font> </a>
                    </td>
                    <td>
                     <a href="leaveAction_getAllNowLeaves.action"><font color="blue" size="6">查看本月请假记录</font></a>
                    </td>
                    
                    </tr>
                </table>
                </div>
</div>
</body>
</html>

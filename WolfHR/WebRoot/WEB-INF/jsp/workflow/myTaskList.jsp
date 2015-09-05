<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>待我审批</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body> 

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 待我审批
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--
<div id="QueryArea">
	<div style="height: 30px">
		<form action="#">
		<table border=0 cellspacing=3 cellpadding=5>
			<tr>
				<td>按条件查询：</td>
				<td><select name="arg1" class="SelectStyle">
						<option value="">查看全部模板</option>
						<option value="0">领款单</option>
						<option value="10">工作报告</option>
						<option value="13">设备采购单</option>
						<option value="21">员工请假单</option>
						<option value="22">加班申请</option>
					</select>
				</td>
				<td><a href=""><input type="IMAGE" src="${pageContext.request.contextPath}/css/blue/images/button/query.PNG"/></a></td>
			</tr>
		</table>
	
		</form>
	</div>
</div>
-->
<form>
	<input type="hidden" name="pageNum" value="1" />
</form>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td width="250">标题</td>
				<td width="115">申请人</td>
				<td width="115">申请日期</td>
				<td>相关操作</td>
			</tr>
		</thead>		
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="formList">
       		<s:iterator value="#taskViewList">
			<tr class="TableDetail1 template">
				<td><s:property value="form.title"/></td>
				<td><s:property value="form.applicator"/></td>
				<td><s:property value="form.applicatetime"/></td>
				<td><s:a action="workFlowAction_approveUI?fid=%{form.fid}&&taskId=%{task.id}">审批处理</s:a>
					<!-- <a href="showForm.html">查看申请信息</a> -->
					<s:a action="workFlowAction_approvedHistory?fid=%{form.fid}">查看流转记录</s:a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail"><div id="TableTail_inside"></div></div>
</div>
</body>
</html>

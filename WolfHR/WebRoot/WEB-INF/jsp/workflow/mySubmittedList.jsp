<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>我的申请查询</title>
 <%@ include file="/WEB-INF/jsp/common/common.jsp"%>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 我的申请查询
        </div>
        <div id="Title_End"></div>
    </div>
</div>


<div id="QueryArea">
	<div style="height: 30px">
		
		<s:form action="workFlowAction_mySubmittedList">
		  <s:hidden name="fid"></s:hidden>
			<table border=0 cellspacing=3 cellpadding=5>
				<tr>
					<td>按条件查询：</td>
					<td>
						<s:select name="formTemplateId" cssClass="SelectStyle" 
							list="#formTemplateList" listKey="fid" listValue="name"
							headerKey="" headerValue="查看全部模板">
						</s:select>
					</td>
					<td>
						<s:select name="status" cssClass="SelectStyle" 
							list="{'审批中', '未通过', '已通过'}"
							headerKey="" headerValue="查看全部状态">
						</s:select>
					</td>
					<td><a href=""><input type="image" src="${pageContext.request.contextPath}/css/blue/images/button/query.PNG"/></a></td>
				</tr>
			</table>
		</s:form>
		
	</div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td width="250px">标题</td>
				<td width="115px">申请人</td>
				<td width="115px">申请日期</td>
				<td width="115px">当前状态</td>
				<td>相关操作</td>
			</tr>
		</thead>	
				
		<!--显示数据列表：正在审批或审批完成的表单显示示例-->
        <tbody id="TableData" class="dataContainer" datakey="formList">
			<!-- 正在审批或审批完成的表单显示示例 -->
			
		<s:iterator value="recordList">
			<tr class="TableDetail1 template">
				<td>${title}</td>
				<td>${applicator}&nbsp;</td>
				<td>${applicatetime}&nbsp;</td>
				<td>${state}&nbsp;</td>
				<td>
					<s:a action="workFlowAction_approvedHistory?fid=%{fid}">查看流转记录</s:a>
				</td>
			</tr>
		</s:iterator>	
			
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail"><div id="TableTail_inside"></div></div>
</div>


<!--分页信息 -->

<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>

<div class="Description">
	说明：<br />
	1，排序是：按申请时间降序排列（最后的申请在最前面）。<br>
</div>

</body>
</html>
	
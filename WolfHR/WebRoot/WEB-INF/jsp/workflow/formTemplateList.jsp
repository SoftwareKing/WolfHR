<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>表单模板列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 模板管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="250px">模板名称</td>
				<td width="250px">所用流程</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="documentTemplateList">
        	<s:iterator value="#ftList">
				<tr class="TableDetail1 template">
						<td><s:property value="name"/></td>
						<td><s:property value="processKey"/></td>
						<td>
						     
							<s:a action="formTemplateAction_delete?ftid=%{ftid}" onclick="return window.confirm('您确认要删除此表单模板吗?')">删除</s:a>
							<s:a action="formTemplateAction_updateUI?ftid=%{ftid}" onclick="return window.confirm('您确认要修改此表单模板吗?')">修改</s:a>
							
							<s:a action="formTemplateAction_download?ftid=%{ftid}">下载</s:a>
						</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
			<a href="formTemplateAction_addUI.action"><img src="${pageContext.request.contextPath}/css/blue/images/button/addNew.PNG" /></a>
        </div>
    </div>
</div>
</body>
</html>

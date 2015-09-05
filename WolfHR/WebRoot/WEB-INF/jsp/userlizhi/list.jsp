<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>离职管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 离职管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="QueryArea">
	<div style="height: 30px">
		
		<s:form action="userlizhiAction_QueryUserLizhi">
		  <s:hidden name="lzid"></s:hidden>
			<table border=0 cellspacing=3 cellpadding=5>
				<tr>
					<td>按工号查询：</td>
					<td>
						<s:textfield name="jobnumbers" cssClass="InputStyle"></s:textfield>
					</td>
					<td>
					<a href="">
					<input type="image" src="${pageContext.request.contextPath}/css/blue/images/button/query.PNG"/>
					</a>
					</td>
				</tr>
			</table>
		</s:form>
		
	</div>
</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="100px">工号</td>
				<td width="100px">姓名</td>
				<td width="100px">部门</td>
				<td width="100px">岗位</td>
				<td width="100px">离职时间</td>
				<td width="150px">离职性质</td>
				<td width="150px">离职原因</td>
				<td width="150px">备注</td>
				<td width="150px">相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userlizhiList">
        	<!-- 
        		iterator说明
        		  *  当前正在迭代的元素在栈顶
        		  *  如果value属性不写，则默认迭代栈顶的元素
        		  *  value值如果为top,则也是迭代栈顶的元素
        	 -->
              <s:iterator value="#userlizhiList">
				<tr class="TableDetail1 template">
					<td align="center"><s:property value="Jobnumber"/></td>
					<td align="center"><s:property value="username"/></td>
					<td align="center"><s:property value="department"/></td>
					<td align="center"><s:property value="post"/></td>
					<td align="center"><s:property value="time"/></td>
					<td align="center"><s:property value="lizhixingzhi"/></td>
					<td align="center"><s:property value="reason"/></td>
					<td align="center"><s:property value="description" escape="false"/></td>
					<td align="center">
						<!-- 
							在struts2的标签中只能用ognl表达式，不能用el表达式
							在html标签中，只能用el表达式，不能用ognl表达式
						 -->
						<s:a action="userlizhiAction_deleteUserLizhi?lzid=%{lzid}">删除</s:a>
						<s:a action="userlizhiAction_updateUI?lzid=%{lzid}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="userlizhiAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
    </div>
</div>
<!--分页信息 -->

<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
</body>
</html>

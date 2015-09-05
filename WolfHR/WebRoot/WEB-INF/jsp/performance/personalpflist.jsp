<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>我的绩效</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>我的绩效
        </div>
        <div id="Title_End"></div>
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
				<td width="100px">任务描述</td>
				<td width="150px">进度(%)</td>
				<td width="150px">开始时间</td>
				<td width="150px">计划结束时间</td>
				<td width="150px">完成时间</td>
				<td width="150px">备注</td>
				
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="performancelist">
        	<!-- 
        		iterator说明
        		  *  当前正在迭代的元素在栈顶
        		  *  如果value属性不写，则默认迭代栈顶的元素
        		  *  value值如果为top,则也是迭代栈顶的元素
        	 -->
              <s:iterator value="#performancelist">
				<tr class="TableDetail1 template">
				    <td align="center"><s:property value="Jobnumber"/></td>
					<td align="center"><s:property value="username"/></td>
					<td align="center"><s:property value="department"/></td>
					<td align="center"><s:property value="post"/></td>
					<td align="center"><s:property value="taskdescription"/></td>
					<td align="center"><s:property value="baifenbi"/></td>
					<td align="center"><s:property value="starttime"/></td>
					
					<td align="center"><s:property value="planendtime"/></td>
					<td align="center"><s:property value="completetime"/></td>
					<td align="center"><s:property value="description" escape="false"/></td>
					
				</tr>
			</s:iterator>
			</tbody>
    </table>
</div>
</body>
</html>

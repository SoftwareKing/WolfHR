<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
	<title>薪资标准设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/salary.js"></script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 薪资标准设置
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
   <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="120px">员工类别</td>
				<td width="120px">基本薪资<font color="red">(元)</font></td>
				<td width="120px">岗位薪资<font color="red">(元)</font></td>
				<td width="120px">加班薪资<font color="red">(元/小时)</font></td>
				<td width="120px">旷工扣缴<font color="red">(元/小时)</font></td>
				<td width="120px">迟到扣缴<font color="red">(元/小时)</font></td>
				<td width="120px">早退扣缴<font color="red">(元/小时)</font></td>
				<td width="150px">相关操作</td>
            </tr>
        </thead>
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="salaryTypelist">
        	<!-- 
        		iterator说明
        		  *  当前正在迭代的元素在栈顶
        		  *  如果value属性不写，则默认迭代栈顶的元素
        		  *  value值如果为top,则也是迭代栈顶的元素
        	 -->
        	
        	<s:iterator value="#salaryTypelist">
				<tr class="TableDetail1 template">
					<td align="center"><s:property value="category"/></td>
					<td align="center"><s:property value="baseSalary"/></td>
					<td align="center"><s:property value="postSalary"/></td>
					<td align="center"><s:property value="addWorkMoney"/></td>
					<td align="center"><s:property value="absentMoney"/></td>
					<td align="center"><s:property value="lateMoney"/></td>
					<td align="center"><s:property value="leaveMoney"/></td>
					<td align="center">
						<!-- 
							在struts2的标签中只能用ognl表达式，不能用el表达式
							在html标签中，只能用el表达式，不能用ognl表达式
						 -->
						<s:a href="salaryTypeAction_deleteSalaryType.action?id=%{id}">删除</s:a>
						<s:a href="salaryTypeAction_updateUI.action?id=%{id}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
    </table>
        
      
        
     <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="salaryTypeAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
    </div>
 
</div>

</body>
</html>


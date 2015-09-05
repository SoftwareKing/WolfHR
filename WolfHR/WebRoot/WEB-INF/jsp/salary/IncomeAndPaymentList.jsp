<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>津贴扣缴设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>津贴扣缴设置
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
            	<td width="120px">收支类别</td>
				<td width="120px">贴扣名称</td>
				<td width="120px">贴扣地区</td>
				<td width="120px">薪资<font color="red">(元)</font></td>
				<td width="150px">相关操作</td>
            </tr>
        </thead>
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="incomeandpaymentList">
        	<!-- 
        		iterator说明
        		  *  当前正在迭代的元素在栈顶
        		  *  如果value属性不写，则默认迭代栈顶的元素
        		  *  value值如果为top,则也是迭代栈顶的元素
        	 -->
        	
        	<s:iterator value="#incomeandpaymentList">
				<tr class="TableDetail1 template">
					<td align="center">
					<c:choose>
					<c:when test="${state=='1'}">津贴</c:when>
					<c:when test="${state=='0'}">扣缴</c:when>
					</c:choose>
					
					</td>
					<td align="center"><s:property value="activatyName"/></td>
					<td align="center"><s:property value="address"/></td>
					<td align="center"><s:property value="activatyMoney"/></td>
					<td align="center">
						<!-- 
							在struts2的标签中只能用ognl表达式，不能用el表达式
							在html标签中，只能用el表达式，不能用ognl表达式
						 -->
						<s:a href="incomeAndPaymentAction_deleteIncomeAndPayment.action?id=%{id}">删除</s:a>
						<s:a href="incomeAndPaymentAction_updateUI.action?id=%{id}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
    </table>
        
      
        
     <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="incomeAndPaymentAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
    </div>
 
</div>

</body>
</html>


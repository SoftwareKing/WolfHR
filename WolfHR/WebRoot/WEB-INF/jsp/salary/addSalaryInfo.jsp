<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>薪资信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/user_add.js">
</script>
		<script type="text/javascript">

function checkips() {
	var address = document.getElementById("address").value;
	var str = "${pageContext.request.contextPath}/salaryInfoAction_auditSalary.action?address="
			+ address;
	location.href = str;

}
</script>
	</head>
	<body>

		<!-- 标题显示 -->
		<div id="Title_bar">
			<div id="Title_bar_Head">
				<div id="Title_Head"></div>
				<div id="Title">
					<!--页面标题-->
					<img border="0" width="13" height="13"
						src="${pageContext.request.contextPath}/css/images/title_arrow.gif" />
					薪资设置
				</div>
				<div id="Title_End"></div>
			</div>
		</div>

		<!--显示表单内容-->
		<div id=MainArea>
			<s:form action="salaryInfoAction_addSalaryInfo.action">

				<div class="ItemBlock_Title1">
					<!-- 信息说明 -->
					<div class="ItemBlock_Title1">
						<img border="0" width="4" height="7"
							src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />
						津贴扣缴设置
					</div>
				</div>

				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td>
									津扣地区
								</td>
								<td>
									<s:select list="#ipsAdress" listKey="address"
										listValue="address" headerValue="请选择地区" cssClass="SelectStyle"
										name="address" id="address" onchange="checkips();"></s:select>
								</td>
							</tr>
							<tr>
								<td width="100">
									津贴扣缴
								</td>

								<td>
									<s:select list="#ips" name="ipids" listKey="id"
										listValue="activatyName" cssClass="SelectStyle"
										multiple="true" size="10"></s:select>
									`按住Ctrl键可以多选或取消选择
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="ItemBlock_Title1">
					<!-- 信息说明 -->
					<div class="ItemBlock_Title1">
						<img border="0" width="4" height="7"
							src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />
						薪资信息
					</div>
				</div>

				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td width="100">
									人员信息
								</td>
								<!-- 
                    		list 数据的来源
                    		listValue 显示的文本内容
                    		listKey   option的属性value的值
                    	 -->

								<td>
									<s:select list="#users" listKey="uid" listValue="username"
										headerKey="" headerValue="请选择人员" name="user.uid"
										cssClass="SelectStyle"></s:select>
								</td>
							</tr>
							<tr>
								<td>
									工作类型
								</td>
								<td>
									<s:select list="#types" listKey="id" listValue="category"
										headerValue="请选择工种" cssClass="SelectStyle" name="salaryType.id"></s:select>
								</td>
							</tr>
						</table>
					</div>
				</div>



				<!-- 表单操作 -->
				<div id="InputDetailBar">
					<input type="image"
						src="${pageContext.request.contextPath}/css/images/save.png" />
					<a href="javascript:history.go(-1);"><img
							src="${pageContext.request.contextPath}/css/images/goBack.png" />
					</a>
				</div>
			</s:form>
		</div>
	</body>
</html>

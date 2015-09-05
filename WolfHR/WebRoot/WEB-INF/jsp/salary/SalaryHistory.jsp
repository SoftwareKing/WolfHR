<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>薪资历史查询</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/blue/pageCommon.css"
			type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/user_add.js">
</script>
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/findSalaryByDate.js">
</script>
		<script type="text/javascript">

function checkips() {
	var address = document.getElementById("address").value;
	alert(address);
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
					薪资历史查询
				</div>
				<div id="Title_End"></div>
			</div>
		</div>

		<!--显示表单内容-->
		<div id="QueryArea">
			<div style="height: 30px">

				<s:form name="form">
					<table border=0 cellspacing=3 cellpadding=5>
						<tr>
							<td>
								按年查询：
							</td>
							<td>
								<s:textfield name="year" cssClass="InputStyle" id="year"></s:textfield>
							</td>
							<td>
								按月查询：
							</td>
							<td>
								<s:select name="month" cssClass="SelectStyle"
									list="{'01','02','03','04','05','06','07','08','09','10','11','12'}"
									headerKey="" headerValue="查看全部" id="month">
								</s:select>
							</td>
							<td>
								<a href=""> <input onclick="return checkMonth();"
										type="image"
										src="${pageContext.request.contextPath}/css/blue/images/button/query.PNG" />
								</a>
							</td>
						</tr>
					</table>
				</s:form>

			</div>
		</div>
		<div id="MainArea">
			
				<table class="TableStyle" cellpadding="0" cellspacing="0" border="0"
					width="100%">
					<tbody>
						<tr id="TableTitle" align="center" valign="middle">
							<td>
								工作类型
							</td>
							<td>
								基本工资
							</td>
							<td>
								岗位工资
							</td>
							<td>
								加班工资
							</td>
							<td>
								迟到扣除
							</td>
							<td>
								旷工扣除
							</td>
							<td>
								早退扣除
							</td>

							<s:iterator value="#category" id="ca">
								<td>
									<s:property value="#ca.activatyName" />
								</td>
							</s:iterator>
							<td>
								实发工资
							</td>
						</tr>
					</tbody>
					<tbody id="TableData">

						<s:iterator value="#salaryInfos" var="si">
							<tr class="TableDetail1 template">
								<td align="center">
									<s:property value="workerCategory" />
								</td>
								<td align="center">
									<s:property value="salaryType.baseSalary" />
								</td>
								<td align="center">
									<s:property value="salaryType.postSalary" />
								</td>
								<td align="center">
									<s:property value="addWorkSalary" />
								</td>
								<td align="center">
									<s:property value="lateSalary" />
								</td>
								<td align="center">
									<s:property value="absentSalary" />
								</td>
								<td align="center">
									<s:property value="leaveSalary" />
								</td>
								<s:iterator value="#category" id="ca">
									<s:set name="flag" value="0" />
									<s:iterator value="#si.ips" id="ip">
										<s:if test="%{#ip.activatyName  == #ca.activatyName  }">
											<s:set name="flag" value="1" />
											<td align="center">
												<font color="blue"><s:property
														value="#ip.activatyMoney" /> </font>
											</td>
										</s:if>
									</s:iterator>
									<s:if test="%{#flag==0}">
										<td align="center">
											0.0
										</td>
									</s:if>
								</s:iterator>
								<td align="center">
									<font color="red"><s:property value="actualSalary" /> </font>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>


			<div id="TableTail">
				<div id="TableTail_inside">
					<table cellpadding="0" cellspacing="0" border="0" height="100%">
						<tbody>
							<tr valign="bottom">
								<td colspan="3">
									统计月份：
									<s:property value="#time" />
									&nbsp;&nbsp;&nbsp;
									<font color="red">(*注：薪资基本信息参考上月基本信息，谨作参考，详细请参考薪资月末薪资详情)</font>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>

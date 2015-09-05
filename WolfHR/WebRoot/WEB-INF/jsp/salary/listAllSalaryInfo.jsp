<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" type="text/css">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>工资管理</title>

	</head>
	<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0"
		marginwidth="0">

			<div id="Title_bar">
				<div id="Title_bar_Head">
					<div id="Title_Head"></div>

					<div id="Title">
						<img src="css/work/title_arrow.gif" border="0" height="13"
							width="13">
						工资管理
					</div>

					
				</div>

				<div id="Title_bar_Tail">
					<div id="Title_FuncBar">
						<ul>
							<li class="title">
								<div onclick="javascript:history.go(-1);" class="Btn">
									返回
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div id="MainArea">



				<table class="TableStyle" cellpadding="0" cellspacing="0" border="0"
					width="100%">
					<tbody>
						<tr id="TableTitle" align="center" valign="middle">
						    <td>
						                 员工姓名
						    </td>
						    <td >
								工作类型
							</td>
							<td >
								基本工资
							</td>
							<td >
								岗位工资
							</td>
							<td >
								加班工资
							</td>
							<td >
								迟到扣除
							</td>
							<td>
								旷工扣除
							</td>
							<td>
								早退扣除
							</td>
							
							<s:iterator value="#category" id="ca">
								<td><s:property value="#ca.activatyName"/> </td>
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
									<s:property value="user.username" />
								</td>
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
								</td >
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
											<font color="blue"><s:property value="#ip.activatyMoney"/></font>	
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
											<font color="red"><s:property value="actualSalary"/></font>	
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
									<td colspan="3">统计月份：<s:property value="#time"/> </td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	</body>
</html>
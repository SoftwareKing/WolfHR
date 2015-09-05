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
						当月薪资信息
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
								基本工资(<font color="red">元</font>)
							</td>
							<td >
								岗位工资(<font color="red">元</font>)
							</td>
							<td >
								加班工资(<font color="red">元/小时</font>)
							</td>
							<td >
								早退扣罚(<font color="red">元/小时</font>)
							</td>
							<td >
								迟到扣罚(<font color="red">元/小时</font>)
							</td>
							<td >
								旷工扣罚(<font color="red">元/小时</font>)
							</td>
							<s:iterator value="#category" id="ca">
								<td><s:property value="#ca.activatyName"/>(<font color="red">元</font>) </td>
							</s:iterator>
							<td>
								实发工资
							</td>
						</tr>
					</tbody>
					<tbody id="TableData">

							<tr class="TableDetail1 template">
							    <td align="center">
									<s:property value="#salaryInfo.user.username" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.workerCategory" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.salaryType.baseSalary" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.salaryType.postSalary" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.salaryType.addWorkMoney" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.salaryType.leaveMoney" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.salaryType.lateMoney" />
								</td>
								<td align="center">
									<s:property value="#salaryInfo.salaryType.absentMoney" />
								</td>
								<s:iterator value="#category" id="ca">
									<s:set name="flag" value="0" />
									<s:iterator value="#salaryInfo.ips" id="ip">	
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
											<font color="red">核算中。。</font>	
									</td>
							</tr>
					</tbody>
				</table>


				<div id="TableTail">
					<div id="TableTail_inside">
						<table cellpadding="0" cellspacing="0" border="0" height="100%">
							<tbody>
								<tr valign="bottom">
									<td colspan="3">统计月份：<s:property value="#time"/>&nbsp;&nbsp;&nbsp;<font color="red">(*注：薪资基本信息参考上月基本信息，谨作参考，详细请参考薪资月末薪资详情)</font> </td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	</body>
</html>
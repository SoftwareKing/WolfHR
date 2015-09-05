<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>违纪列表</title>
		<meta content="MSHTML 6.00.2800.1276" name="GENERATOR">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<meta http-equiv="Content-Style-Type" content="text/css">
		<meta http-equiv="Pragma" content="no-cache">
		<meta name="viewport" content="width=device-width,minimum-scale=1.0">
      <script language="javascript" src="${pageContext.request.contextPath}/css/work/sb.js"></script>

       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" type="text/css">
		<link href="css/work/mainWin_002.css" type="text/css" media="screen"
			rel="stylesheet">
		<link href="css/work/query.css" type="text/css" media="screen"
			rel="stylesheet">
		<link href="css/work/mainWin.css" type="text/css" media="screen"
			rel="stylesheet">


	</head>
	<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0"
		marginwidth="0">

			<div id="Title_bar">
				<div id="Title_bar_Head">
					<div id="Title_Head"></div>

					<div id="Title">
						<img src="css/work/title_arrow.gif" border="0" height="13"
							width="13">
						违纪详情
					</div>

					<div id="Title_End"></div>

					<div id="Title_bar_bg"></div>
				</div>

				<div id="Title_bar_Tail">
					<div id="Title_FuncBar">
						<ul>
						<li class="line"></li>
							<li class="title">

								<div onclick="javascript:history.go(-1);" class="Btn">
									返回
								</div>

							</li>
							<li class="line"></li>
							<li class="title">
								<form name="form"></form>
								<div onclick="sub();" class="Btn">
									提出异议
								</div>

							</li>
						    <li class="line"></li>
							<li class="title">

							<a href="attendanceAction_listByLate.action">我的迟到记录</a>

							</li>
							<li class="line"></li>
							<li class="title">

								<a href="attendanceAction_listByLeave.action">我的早退记录</a>
									

							</li>
							<li class="line"></li>
							<li class="title">

								<a href="attendanceAction_listByAbsent.action">我的旷工记录</a>

							</li>
							<li class="line"></li>
						</ul>
					</div>
				</div>
			</div>

			<div id="MainArea">



				<table class="TableStyle" cellpadding="0" cellspacing="0" border="0"
					width="100%">
					<tbody>
						<tr id="TableTitle" align="center" valign="middle">
							
							<td >
								考勤日期
							</td>
							<td >
								考勤时间
							</td>
							<td >
								违纪情况
							</td>
							<td >
								具体时长<font color="red">(小时)</font>
							</td>
							<td>
								登记人员
							</td>
							
						</tr>

					</tbody>
					<tbody id="TableData">

						<s:iterator value="#attendances">
							<tr class="TableDetail1 template">
								
								<td align="center">
									<s:property value="startDate" />
								</td>
								<td align="center">
									<s:property value="time" />
								</td>
								<td align="center">
									<c:choose>
										<c:when test="${attType=='leave'}">
											早            退
										</c:when>
										<c:when test="${attType=='late'}">
											迟            到
										</c:when>
										<c:otherwise>
										<font color="red">	旷            工</font>
										</c:otherwise>
									</c:choose>
								</td>
								<td align="center">
									<s:property value="attHours" />
								</td >
								<td align="center"> 
									<s:property value="attUser.username" />
								</td>
								
							</tr>
						</s:iterator>
					</tbody>
				</table>

    </div>
	</body>
</html>
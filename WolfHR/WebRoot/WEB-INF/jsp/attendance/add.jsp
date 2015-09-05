<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ include file="/WEB-INF/jsp/common/date.jsp"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html>
	<head>
		<title>加班</title>
		<jsp:include page="/WEB-INF/jsp/addwork/commonwork.jsp"></jsp:include>
	</head>
	<body>
		
		
 <form method="post"  action="attendanceAction_addAttendance.action">
			<div id="Title_bar">
				<div id="Title_bar_Head">
					<div id="Title_Head"></div>

					<div id="Title">
						<img src="css/work/title_arrow.gif" border="0" height="13"
							width="13">
						日常考勤
					</div>

					
				</div>



			</div>

			<div id="MainArea">
				<input name="functionName" type="hidden">
				<center>
					<div class="ItemBlock_Title1"></div>

					<div class="ItemBlockBorder" style="width: 95%;">
						<div class="ItemBlock">
							<table cellpadding="0" cellspacing="0" border="0" width="70%">
								<tbody>
									<tr height="30">
										<td align="center" width="30">
											<img src="css/work/item_point.gif" border="0">
										</td>
										<td>
											<b>人员选择</b>
										</td>
										<td>
											<table cellpadding="0" cellspacing="0" border="0"
												width="100%">
												<tbody>
													<tr height="1">
														<td class="spilt_line1_head" width="70%">
															<img src="css/work/blank.gif" border="0" height="1"
																width="1">
														</td>
														<td class="spilt_line1_detail">
															<img src="css/work/blank.gif" border="0" height="1"
																width="1">
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
							<table cellpadding="0" cellspacing="0" border="0">
								<tbody>
									<tr>
										<td height="37" width="80"></td>
										<td>
											人员姓名：
										</td>
										<td width="10"></td>
										<td width="120">
											<select class="SelectStyle" name="user.uid"
												id="showNamereceive">
												<s:iterator value="#userList">

															<option value="<s:property value='uid' />">
												<s:property value="username" />

												</s:iterator>

											</select>

										</td>
										<td width="20"></td>
										<td>
											人员
										</td>
										<td width="10"></td>
										<td width="120">

										</td>
										<td></td>
									</tr>
								</tbody>
							</table>
							<p></p>
							<table cellpadding="0" cellspacing="0" border="0" width="70%">
								<tbody>
									<tr height="30">
										<td align="center" width="30">
											<img src="css/work/item_point.gif" border="0">
										</td>
										<td>
											<b>加班时间</b>
										</td>
										<td>
											<table cellpadding="0" cellspacing="0" border="0"
												width="100%">
												<tbody>
													<tr height="1">
														<td class="spilt_line1_head" width="70%">
															<img src="css/work/blank.gif" border="0" height="1"
																width="1">
														</td>
														<td class="spilt_line1_detail">
															<img src="css/work/blank.gif" border="0" height="1"
																width="1">
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
							<table cellpadding="0" cellspacing="0" border="0" width="70%">
								<tbody>
									<tr>
										<td height="37" width="80"></td>
										<td colspan="15">
											<table cellpadding="0" cellspacing="0" border="0">
												<tbody>
													<tr>
														<td height="30"></td>
														<td colspan="2" style="display: none">
															<input onclick="submitButton('MORE');" name="more"
																value="0.11.0.13.25" type="checkbox">
															&nbsp;&nbsp;
														</td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
													</tr>
													<tr>
														<td height="30"></td>
														<td>
															违纪日期
														</td>
														<td>
															
														<input size="10" type="text" id="date-input" name="startDate"/> 
															

														</td>
														<td>
															<select class="SelectStyle" name="time"
																	id="showNamereceive">
																<option value="上午">上  午</option>
																<option value="下午">下  午</option>
																</select>
														</td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
													</tr>
													<tr>
														<td height="37" width="50"></td>
														<td width="73">
															考勤月份
														</td>
														<td width="120">
															<select class="SelectStyle" name="month"
																id="showNamereceive">
																<option value="01">1月</option>
																<option value="02">2月</option>
																<option value="03">3月</option>
																<option value="04">4月</option>
																<option value="05">5月</option>
																<option value="06">6月</option>
																<option value="07">7月</option>
																<option value="08">8月</option>
																<option value="09">9月</option>
																<option value="10">10月</option>
																<option value="11">11月</option>
																<option value="12">12月</option>
															</select>
														</td>
														<td>
															
															<script language="javascript">
															var upImg = "<img border=0 src=/htoa/image/time_up.gif>";
															var downImg = "<img border=0 src=/htoa/image/time_down.gif>";
															var saveImg = "<img border=0 src=/htoa/image/time_save.gif>";
															var cancelImg = "<img border=0 src=/htoa/image/time_cancel.gif>";
															</script>
														</td>
														<td width="10"></td>
														<td></td>
														<td width="10"></td>
														<td></td>
														<td width="10"></td>
														<td></td>
													</tr>
													<tr>
														<td height="37"></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
													</tr>
													<tr>
														<td height="60"></td>
														<td colspan="9">
															<font color="#ff0000">* 如只补录一项时间，只需选中该项多选框</font>
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
									<tr>
										<td height="37"></td>
										<td>
											合计
										</td>
										<td></td>
										<td colspan="13">
											<input class="InputStyle" id="hours" style=""
												name="attHours" type="text">
											&nbsp;&nbsp;小时
										</td>
									</tr>
								</tbody>
							</table>
							<p></p>
							<table cellpadding="0" cellspacing="0" border="0" width="70%">
								<tbody>
									<tr height="30">
										<td align="center" width="30">
											<img src="css/work/item_point.gif" border="0">
										</td>
										<td>
											<b>违纪详情</b>
										</td>
										<td>
											<table cellpadding="0" cellspacing="0" border="0"
												width="100%">
												<tbody>
													<tr height="1">
														<td class="spilt_line1_head" width="70%">
															<img src="css/work/blank.gif" border="0" height="1"
																width="1">
														</td>
														<td class="spilt_line1_detail">
															<img src="css/work/blank.gif" border="0" height="1"
																width="1">
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
							<table cellpadding="0" cellspacing="0" border="0" width="60%">
								<tbody>
									<tr>
										<td width="80">
											
										</td>
										<td height="100">
											
											<input type="radio" value="leave" name="attType">早&nbsp;&nbsp;&nbsp; 退<br/>
											<input type="radio" value="late" name="attType">迟&nbsp;&nbsp;&nbsp; 到<br/>
											<input type="radio" value="absent" name="attType">旷&nbsp;&nbsp;&nbsp; 工<br/>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</center>
			</div>
			<br/><br/><br/>
			<div id="InputDetailBar" align="center">
			    <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>&nbsp;&nbsp;
				 <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
		   </div>
		</form>
	</body>
</html>
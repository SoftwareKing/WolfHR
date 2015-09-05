<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/date.jsp"%>
<html>
	<head>
		<title>加班</title>
		<jsp:include page="commonwork.jsp"></jsp:include>
		
       
</head>
<body >
		<div id="Calendar" scrolling="no"
			style="border: 0px solid #EEEEEE; position: absolute; width: 150; height: 137; z-index: 200; filter: 'progid:DXImageTransform.Microsoft.Shadow(direction=135,color=#AAAAAA,strength=4)'; display: none"></div>

		
		<div id="Clock" scrolling="no"
			style="color: #2b333c; font-size: 14px; padding: 10px; border: 1px solid #EEEEEE; position: absolute; background: #FFFFFF; width: 150; z-index: 200; filter: 'progid:DXImageTransform.Microsoft.Shadow(direction=135,color=#AAAAAA,strength=1)'; display: none"></div>

		
     <s:form action="addWorkingAction_saveAddWorking.action">
			
			<div id="Title_bar">
				<div id="Title_bar_Head">
					<div id="Title_Head"></div>

					<div id="Title">
						<img src="css/work/title_arrow.gif" border="0" height="13"
							width="13">
						加班登记
					</div>

					<div id="Title_End"></div>
					
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
											
										</td>
										<td width="10"></td>
										<td width="120">
											
										</td>
										<td width="20"></td>
										<td>
											${user.username }
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
															加班日期
														</td>
														<td>
															
													    <input size="10" type="text" id="date-input" name="startDate"/>

														</td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
													</tr>
													<tr>
														<td height="37" width="50"></td>
														<td width="73">
															开始时间
														</td>
														<td width="120">
													
															<input size="6" onblur="TimeOnBlur(this);"
																onfocus="textOnSelect(this);" class="inputdate"
																value="18:00" name="startTime" type="text">
															<img onclick="OpenTime(getElementById('startTime'));"
																style="cursor: pointer; margin-bottom: -5px;"
																src="css/work/time_icon.gif" border="0">
														</td>
														<td>
															结束时间
															<script language="javascript">
																var upImg = "<img border=0 src=/htoa/image/time_up.gif>";
																var downImg = "<img border=0 src=/htoa/image/time_down.gif>";
																var saveImg = "<img border=0 src=/htoa/image/time_save.gif>";
																var cancelImg = "<img border=0 src=/htoa/image/time_cancel.gif>";
																</script>
															<input size="6" onblur="TimeOnBlur(this);"
																onfocus="textOnSelect(this);" class="inputdate"
																value="21:00" name="endTime" type="text">
															<img onclick="OpenTime(getElementById('endTime'));"
																style="cursor: pointer; margin-bottom: -5px;"
																src="css/work/time_icon.gif" border="0">
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
											<input class="InputStyle" id="countHour"
												style="" name="hours" type="text" onclick="countValue()">
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
											<b>工作内容</b>
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
										<td width="80">&nbsp;</td>
										<td height="100">
											<textarea class="InputAreaStyle" name="content"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</center>
			</div>
			<div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
		</s:form>
	</body>
</html>
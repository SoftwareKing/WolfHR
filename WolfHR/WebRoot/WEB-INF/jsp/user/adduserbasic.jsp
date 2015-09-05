<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/date.jsp"%>
<html>
	<head>
   </head>

<body>
  
    
    
    
   <div id="Title_bar">
			<div id="Title_bar_Head">
				<div id="Title_Head"></div>

				<div id="Title">
					<img
						src="${pageContext.request.contextPath}/css/user/title_arrow.gif"
						border="0" height="13" width="13" />
					新增员工档案
					<input name="userAccount" type="hidden" />
				</div>

				<div id="Title_End"></div>



			</div>

		</div>


		<div id="QueryArea">
			<div style="height: 25px">
				<center>
					<table cellpadding="3" cellspacing="1" border="0" height="22">
						<tbody>
							<tr width="230" class="Pannel_font" align="center"
								valign="bottom">
								<td class="Pannel_select" width="76">
									<a onclick="submitButton('BASE');"
										href="userAction_addUUI.action">基本信息</a>
								</td>

								<td class="Pannel_no_select" width="77">
									<a onclick="submitButton('BASE');"
										href="usermangerAction_addUI.action">管理信息</a>
								</td>

								<td class="Pannel_no_select" width="77">
									<a onclick="submitButton('EDUCATION');"
										href="usereduAction_getAllUserEdu.action">教育背景</a>
								</td>

								<td class="Pannel_no_select" width="77">
									<a onclick="submitButton('WORKHISTORY');"
										href="userworkAction_getAllUserWork.action">工作经历</a>
								</td>
							</tr>

						</tbody>
					</table>
				</center>
			</div>
		</div>
		<a name="downloadLnk" href="#"></a>
		<input name="functionName" type="hidden" />

		<center>
			<div class="ItemBlock_Title1">
				<img
					src="${pageContext.request.contextPath}/css/user/item_point.gif"
					border="0" />
				&nbsp;基本信息
			</div>
			<s:form action="userAction_add2.action" enctype="multipart/form-data">

				<div class="ItemBlockBorder" style="width: 95%;">
					<div class="ItemBlock">
						<center>
							<center>
								<table cellpadding="0" cellspacing="0" border="0" width="100%">
									<tbody>
										<tr>
											<td>
												<table cellpadding="0" cellspacing="0" border="0">
													<tbody>
														<tr>
															<td></td>

															<td width="100"></td>

															<td width="180"></td>

															<td></td>

															<td width="100"></td>

															<td width="180"></td>

															<td></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td></td>

															<td height="27" width="50"></td>

															<td></td>

															<td></td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																工号
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="Jobnumber" type="text" />
															</td>

															<td height="27" width="50">
																<font color="#FF0000">&nbsp;*</font>
															</td>

															<td>
																员工姓名
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="username" type="text" />
															</td>

															<td height="27" width="50">
																<font color="#FF0000">&nbsp;*</font>
															</td>

															<td rowspan="4">
																<table cellpadding="0" cellspacing="0" border="0"
																	height="120" width="120">
																	<tbody>
																		<tr height="5">
																			<td class="Navigation_bg_img1" width="5"></td>

																			<td class="Navigation_bg_img2"></td>

																			<td class="Navigation_bg_img3" width="6"></td>
																		</tr>

																		<tr>
																			<td class="Navigation_bg_img4"></td>

																			<td class="Category_bg" align="center"
																				valign="middle">
																				<img
																					src="${pageContext.request.contextPath}/css/user/default_person.gif"
																					border="0" height="100" width="100" />


																			</td>

																			<td class="Navigation_bg_img6"></td>
																		</tr>

																		<tr height="6">
																			<td class="Navigation_bg_img8"></td>

																			<td class="Navigation_bg_img10" align="center">

																				<s:file name="photo" cssClass="InputStyle">照片上传</s:file>
																			</td>

																			<td class="Navigation_bg_img9"></td>
																		</tr>
																	</tbody>
																</table>
															</td>
														</tr>

														<tr>
															<td></td>

															<td>
																身份证号码
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="idcard" type="text" />
															</td>

															<td></td>

															<td>
																民族
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="mingzu" type="text" />
															</td>

															<td height="27"></td>
														</tr>

														<tr>
															<td></td>

															<td>
																出生日期
															</td>

															<td>
															<input size="10" type="text" id="date-input" name="birthday"/> 
																
															</td>

															<td></td>

															<td>
																性别
															</td>

															<td>
																<select class="SelectStyle" name="sex">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option selected="selected" value="男">
																		男
																	</option>

																	<option value="女">
																		女
																	</option>
																</select>
															</td>

															<td height="27"></td>
														</tr>

														<tr>
															<td></td>

															<td>
																籍贯
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="jiguan" type="text" />
															</td>

															<td></td>

															<td>
																英文名
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="englishname" type="text" />
															</td>

															<td height="27"></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																户口所在地
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="hukou" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td>
																居住地址
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="juzhudizhi" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																婚姻状态
															</td>

															<td>
																<select class="SelectStyle" name="hunyin">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option selected="selected" value="未婚">
																		未婚
																	</option>

																	<option value=" 已婚">
																		已婚
																	</option>

																	<option value="离异">
																		离异
																	</option>

																	<option value="丧偶">
																		丧偶
																	</option>
																</select>
															</td>

															<td height="27" width="50"></td>

															<td>
																政治面貌
															</td>

															<td>
																<select class="SelectStyle" name="zhengzhimianmao">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option value="一般人员">
																		一般人员
																	</option>

																	<option selected="selected" value="群众">
																		群众
																	</option>

																	<option value="党员">
																		党员
																	</option>

																	<option value="团员">
																		团员
																	</option>

																	<option value=" 民主党派">
																		民主党派
																	</option>
																</select>
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																血型
															</td>

															<td>
																<table cellpadding="0" cellspacing="0" border="0">
																	<tbody>
																		<tr>
																			<td>
																				<input value="A型" name="xuexing" checked="checked"
																					type="radio" />
																			</td>

																			<td>
																				A型
																			</td>

																			<td>
																				<input value="B型" name="xuexing" type="radio" />
																			</td>

																			<td>
																				B型
																			</td>

																			<td>
																				<input value="O型" name="xuexing" type="radio" />
																			</td>

																			<td>
																				O型
																			</td>

																			<td>
																				<input value="AB型" name="xuexing" type="radio" />
																			</td>

																			<td>
																				AB型
																			</td>
																		</tr>
																	</tbody>
																</table>
															</td>

															<td height="27" width="50"></td>

															<td>
																学历
															</td>

															<td>
																<select class="SelectStyle" name="xueli">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option value="初中">
																		初中
																	</option>

																	<option value="高中">
																		高中
																	</option>

																	<option value="大专">
																		大专
																	</option>

																	<option value="本科">
																		本科
																	</option>

																	<option value="研究生">
																		研究生
																	</option>

																	<option value="博士">
																		博士
																	</option>

																	<option value="博士后">
																		博士后
																	</option>
																</select>
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																毕业时间
															</td>

															<td>
																
																	
														    <input size="10" type="text" id="demo2" name="gradue"/>

															</td>

															<td height="27" width="50"></td>

															<td>
																初次工作时间
															</td>

															<td>
																
																 <input size="10" type="text" id="demo3" name="firstworktime"/>
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																入职日期
															</td>

															<td>
															<input size="10" type="text" id="demo4" name="rusidate"/>
																
															</td>

															<td height="27" width="50"></td>

															<td>
																毕业院校
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="gradueschool" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																学位
															</td>

															<td>
																<select class="SelectStyle" name="xuewei">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option value="无学位">
																		无学位
																	</option>

																	<option value="学士">
																		学士
																	</option>

																	<option value="硕士">
																		硕士
																	</option>

																	<option value="博士">
																		博士
																	</option>
																</select>
															</td>

															<td height="27" width="50"></td>

															<td>
																专业
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="major" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td></td>

															<td>
																外语语种
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="waiyu" type="text" />
															</td>

															<td></td>

															<td>
																外语级别
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="waiyujibie" type="text" />
															</td>

															<td height="27"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																第二外语
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="secondwaiyu" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td>
																第二外语级别
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="secondwaiyujibie" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																特长
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="techang" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td>
																爱好
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="likes" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																电话
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="phone" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td>
																邮箱
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="email" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																紧急联系人
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="jinjiren" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td>
																联系人电话
															</td>

															<td>
																<input onfocus="this.select();" class="InputStyle"
																	name="jinjirenphone" type="text" />
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																转正日期
															</td>

															<td>
															<input size="10" type="text" id="demo5" name="zhuanzhengriqi"/>
																

                              </script>
															</td>

															<td height="27" width="50"></td>

															<td>
																员工状态
															</td>

															<td>
																<select class="SelectStyle" name="employstate">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option value="临时合同工">
																		临时合同工
																	</option>

																	<option value="正式员工">
																		正式员工
																	</option>

																	<option value="试用期员工">
																		试用期员工
																	</option>
																</select>
															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																部门
															</td>
															<td>
																<s:select list="#departmentList" listKey="did"
																	listValue="dname" headerKey="" headerValue="请选择部门"
																	name="did"></s:select>
															</td>

															<td height="27" width="50"></td>

															<td>
																岗位
															</td>

															<td>
																<s:select list="#postList" name="pids" listKey="pid"
																	listValue="pname" cssClass="SelectStyle"
																	headerValue="请选择岗位"></s:select>

															</td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td width="50"></td>

															<td>
																职称
															</td>

															<td>
																<select class="SelectStyle" name="zhichen">
																	<option value="WONoSelectionString">
																		请选择
																	</option>

																	<option selected="selected" value="0">
																		无职称
																	</option>

																	<option value="技工">
																		技工
																	</option>

																	<option value="工程师">
																		工程师
																	</option>

																	<option value="高级工程师">
																		高级工程师
																	</option>
																</select>
															</td>

															<td height="27" width="50"></td>

															<td></td>

															<td></td>

															<td height="27" width="50"></td>

															<td></td>
														</tr>

														<tr>
															<td height="150"></td>

															<td height="70" valign="middle">
																职业资格证书
															</td>

															<td colspan="4">
																<textarea class="InputAreaStyle"
																	style="width: 100%; height: 80%" name="zhengshu">
</textarea>
															</td>

															<td></td>

															<td></td>
														</tr>

														<tr>
															<td height="27"></td>

															<td height="70" valign="middle">
																工作履历
															</td>

															<td colspan="4">
																<textarea class="InputAreaStyle"
																	style="width: 100%; height: 80%" name="gongzuolvli">
</textarea>
															</td>

															<td></td>

															<td></td>
														</tr>

														<tr>
															<td height="27"></td>

															<td>
																简历附件
															</td>

															<td colspan="4">
																<s:file name="jianli" cssClass="InputStyle"></s:file>

															</td>

															<td></td>

															<td></td>
														</tr>
													</tbody>
												</table>
											</td>

											<td align="right" valign="top"></td>

											<td width="10">
												&lt;
											</td>
										</tr>
									</tbody>
								</table>
								<!-- 表单操作 -->
								<div id="InputDetailBar">
									<input type="image"
										src="${pageContext.request.contextPath}/css/images/save.png" />
									<a href="javascript:history.go(-1);"><img
											src="${pageContext.request.contextPath}/css/images/goBack.png" />
									</a>
								</div>
							</center>
						</center>
					</div>

				</div>
			</s:form>
		</center>



	</body>
</html>
   



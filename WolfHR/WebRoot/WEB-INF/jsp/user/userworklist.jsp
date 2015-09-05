<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/user/usercommon.jsp"></jsp:include>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>HR</title>
</head>

<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">
  <div id="Calendar" scrolling="no" style="border:0px solid #EEEEEE ;position: absolute; width: 150; height: 137; z-index: 200; filter :'progid:DXImageTransform.Microsoft.Shadow(direction=135,color=#AAAAAA,strength=4)' ;display: none"></div>
 <form>
    <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/user/title_arrow.gif" border="0" height="13" width="13" /> 新增员工档案<input name="userAccount" type="hidden" />
        </div>

        <div id="Title_End"></div>
     </div>
</div>
<div id="QueryArea">
      <div style="height: 25px">
        <center>
          <table cellpadding="3" cellspacing="1" border="0" height="22">
            <tbody>
              <tr width="230" class="Pannel_font" align="center" valign="bottom">
              <td class="Pannel_no_select" width="76"><a onclick="submitButton('BASE');" href="userAction_addUUI.action">基本信息</a></td>

             <td class="Pannel_no_select" width="77"><a onclick="submitButton('BASE');" href="usermangerAction_addUI.action">管理信息</a></td>

              <td class="Pannel_no_select" width="77"><a onclick="submitButton('EDUCATION');" href="usereduAction_getAllUserEdu.action">教育背景</a></td>

              <td class="Pannel_select" width="77"><a onclick="submitButton('WORKHISTORY');" href="userworkAction_getAllUserWork.action">工作经历</a></td>
            </tr>
            </tbody>
          </table>
        </center>
      </div>
    </div>
   <center>
      <center>
        <div class="ItemBlock_Title1">
          <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" />&nbsp;工作经历管理
        </div>
        <div class="ItemBlockBorder">
          <div class="ItemBlock">
            <div class="FontBeforeLine" style="width:85%"></div>
            <table class="TableStyle" cellpadding="0" cellspacing="0" border="0" width="92%">
              <tbody>
                <tr id="TableTitle" align="center" valign="middle">
                <td width="100">工号</td>
                  <td width="100">姓名</td>
                  <td width="150">公司名称</td>

                  <td width="150">负责工作</td>

                  <td width="120">开始时间</td>

                  <td width="120">结束时间</td>

                  <td width="200">主要业绩</td>

                  <td width="200">备注</td>

                  <td width="100">操作</td>
                  
                </tr>
              </tbody>

              <tbody id="TableData" class="dataContainer" datakey="#user">
              <s:iterator value="#user" var="u">
                  <s:iterator value="#u.userwork">
	            <tr class="TableDetail1 template">
	            <td align=center> <s:property value="users.Jobnumber"/></td>
	               <td align=center> <s:property value="users.username"/></td>
	                <td align=center> <s:property value="companyname"/></td>
	               
	                <td align=center><s:property value="majorwork"/></td>
	                <td align=center>
						<s:property value="starttime"/>
						
					</td>
					<td align=center>
					<s:property value="endtime"/>
				    </td>
	                <td align=center>
						
							<s:property value="yeji"/>
						
					</td>
					
					
					<td align=center>
						
							<s:property value="description"/>
						
					</td>
					<td align=center>
	                	<s:a action="userworkAction_deleteUserWork?uwid=%{uwid}">删除</s:a>
	                    <s:a action="userworkAction_updateUI?uwid=%{uwid}">修改</s:a>
						
	                </td>
	            </tr>
	            </s:iterator>
            </s:iterator>
              
              </tbody>
            </table>
            
          
             <div id="TableTail_inside">
            <a href="userworkAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
           
           </div>
          </div>
        </div>
      </center>
    </center>
  </form>
</body>
</html>

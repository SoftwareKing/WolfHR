<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html>
<head>
	<title>绩效数据导入</title>
   
    <meta http-equiv="Content-Type" content="application/x-msdownload"/>
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>导入绩效数据
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
 <s:form action="performanceAction_importdata.action"  enctype="multipart/form-data">
 
 <center>
        <div class="ItemBlock_Title1"></div>

        <div class="ItemBlockBorder">
          <div class="ItemBlock">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
              <tbody>
                <tr height="6">
                  <td></td>
                </tr>
              </tbody>
            </table>

            <table cellpadding="0" cellspacing="0" align="center" border="0" width="98%">
              <tbody>
                <tr height="5">
                  <td class="Navigation_bg_img1" width="5"></td>

                  <td class="Navigation_bg_img2"></td>

                  <td class="Navigation_bg_img3" width="6"></td>
                </tr>

                <tr>
                  <td class="Navigation_bg_img4"></td>

                  <td class="Category_bg" valign="top">
                    <table cellpadding="0" cellspacing="0" border="0" width="80%">
                      <tbody>
                        <tr height="1">
                          <td colspan="5"></td>
                        </tr>

                        <tr height="5">
                          <td colspan="5"></td>
                        </tr>

                        <tr height="25">
                          <td align="right" width="200">导入来源文件&nbsp;</td>

                          <td width="320">
                          
                        
                            <s:file name="resource" cssClass="InputStyle" size="31"></s:file>
                          
                          
                          </td>

                          <td width="10"></td>

                          <td>
                          </td>
                        </tr>

                        <tr height="10">
                          <td colspan="5"></td>
                        </tr>
                      </tbody>
                    </table>
                  </td>

                  <td class="Navigation_bg_img6"></td>
                </tr>

                <tr height="6">
                  <td class="Navigation_bg_img8"></td>

                  <td class="Navigation_bg_img10"></td>

                  <td class="Navigation_bg_img9"></td>
                </tr>
              </tbody>
            </table>

            <table cellpadding="0" cellspacing="0" align="center" border="0" width="98%">
              <tbody>
                <tr height="5">
                  <td class="Navigation_bg_img1" width="5"></td>

                  <td class="Navigation_bg_img2"></td>

                  <td class="Navigation_bg_img3" width="6"></td>
                </tr>

                <tr>
                  <td class="Navigation_bg_img4"></td>

                  <td class="Category_bg" valign="top">
                    <table cellpadding="0" cellspacing="0" border="0" width="80%">
                      <tbody>
                        <tr height="25">
                          <td align="right" width="120"></td>

                          <td width="400">亲,请参照模板进行导入操作，为确保数据准确，请尽可能联系我们。&nbsp;</td>

                          <td>
                          
                          <a href="${pageContext.request.contextPath}/modeldata/员工绩效考评数据.xls"> <font color="#0000FF">下载模板(请右键另存，否则出错！)</font></a>
                          
                          </td>
                         
                        </tr>
                         
                        <tr height="5">
                          <td colspan="4"></td>
                        </tr>

                        <tr height="10">
                          <td colspan="4"></td>
                        </tr>
                      </tbody>
                    </table>
                  </td>

                  <td class="Navigation_bg_img6"></td>
                </tr>

                <tr height="6">
                  <td class="Navigation_bg_img8"></td>

                  <td class="Navigation_bg_img10"></td>

                  <td class="Navigation_bg_img9"></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </center>
       <!-- 表单操作 -->
        <div id="InputDetailBar">
             <input type="image" src="${pageContext.request.contextPath}/css/images/import.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
       </s:form>
   </div>
       

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/message/messagecommon.jsp"%>

<html>
<head>
  <title>发送消息</title>
  
  <script type="text/javascript">
//<![CDATA[

   function send(){
      form.action="mailAction_saveSendMail.action";
      form.submit();
    }
   function savecaogao(){
   form.action="mailAction_saveDraftMail.action";
    form.submit();
  }

  //]]>
  </script>
</head>

<body topmargin="0" leftmargin="0" onload="onLoad()" class="Msg_body" marginheight="0" marginwidth="0">
  

  <form name="form">
   <div id="Title_bar">
      <div id="Title_bar_Head">
        <div id="Title_Head"></div>

        <div id="Title">
          <img src="${pageContext.request.contextPath}/css/message/title_arrow.gif" border="0" height="13" width="13" /> 发送邮件
        </div>

        <div id="Title_End"></div>

       
      </div>

      <div id="Title_bar_Tail">
        <div id="Title_FuncBar">
          <ul>
            <li class="title">
              <div onclick="send();" class="Btn">
                                                  发送
              </div>
            </li>

            <li class="title">
              <div onclick="savecaogao();" class="Btn">
                                             保存到草稿箱 
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <table id="MainArea2" style="float: left; height: auto">
      <tbody>
        <tr height="20px">
          <td></td>
        </tr>

        <tr>
          <td>
            <center>
              <table style="padding: 3px" class="msgBorder" cellpadding="0" cellspacing="0" border="0" height="450px" width="95%">
                <tbody>
                  <tr>
                    <td>
                      <table style="background-color: #ffffff" cellpadding="0" cellspacing="0" border="0" height="100%" width="100%">
                        <tbody>
                          <tr>
                            <td class="Msg_read_title_bg"></td>

                            <td class="Msg_read_title_bg" height="90">
                              <table cellpadding="0" cellspacing="0" border="0" height="27">
                                <tbody>
                                  <tr class="ItemTitleFont">
                                    <td>邮件级别：</td>

                                    <td width=""><select class="SelectStyle" name="priority">
                                      <option value="0">
                                        重要
                                      </option>

                                      <option selected="selected" value="1">
                                        普通
                                      </option>
                                    </select></td>

                                    <td>&nbsp; &nbsp; <input value="1" name="" type="checkbox" /> 收到后给我一个回执</td>
                                  </tr>
                                </tbody>
                              </table>

                              <table cellpadding="0" cellspacing="0" border="0" height="27" width="70%">
                                <tbody>
                                  <tr>
																			<td width="60">
																				接收人
																			</td>
																			<td>
																					<input type="hidden" name="receiver.uid" value="<s:property value="#user.uid"/>">
																				<s:property value="#user.username"/>
																			</td>
                                    <td align="right" width="10"></td>

                                    <td align="right" width="80">
                                      
                                    </td>
                                  </tr>
                                </tbody>
                              </table>
                               <table cellpadding="0" cellspacing="0" border="0" width="69%">
                                <tbody>
                                  <tr class="ItemTitleFont">
                                    <td width="60">标题</td>

                                    <td height="27"><input onfocus="this.select();" class="InputStyle" value="无标题" name="title" type="text" /></td>

                                    <td height="27" width="9"></td>
                                  </tr>
                                </tbody>
                              </table>
                            </td>

                            <td class="Msg_read_title_bg"></td>
                          </tr>

                          <tr>
                            <td colspan="3" class="Msg_spilt_line1" height="1"></td>
                          </tr>

                          <tr>
                            <td colspan="3" class="Msg_spilt_line2" height="1"></td>
                          </tr>

                          <tr>
                            <td colspan="3" height="5"></td>
                          </tr>

                          <tr>
                            <td width="30"></td>

                            <td>
                              <table cellpadding="0" cellspacing="0" border="0" height="100%" width="100%">
                                <tbody>
                                  <tr height="23">
                                    <td width="60"></td>

                                    <td width="800">
                                      <div style="float: left; margin-bottom: -3px;">
                                        <a target="actSwfUploadOpenWin1" onclick="window.open('/OAapp/WebObjects/OAapp.woa/wo/com.oa8000.proj.oasp31.Oasp3101/rZMbNNVbIyDG4P6Do9tMfg/9.0.11.0.5.33.0.0.1.1.0','actSwfUploadOpenWin1','dependent, toolbar=no,location=no,status=no,menubar=no,resizable=yes,scrollbars=auto,width=600,height=480,left=378.0,top=109.0'); return false" href="http://127.0.0.1/OAapp/WebObjects/OAapp.woa/wo/com.oa8000.proj.oasp31.Oasp3101/rZMbNNVbIyDG4P6Do9tMfg/9.0.11.0.5.33.0.0.1.1.0"><img src="css/message/upload.gif" border="0" /></a>
                                      </div>&nbsp; <select id="attachmentList" style="padding-left: 5px; display: none;" name="FileList">
                                        <option selected="selected" value="WONoSelectionString">
                                          已添加文件
                                        </option>
                                      </select>
                                    </td>

                                    <td></td>
                                  </tr>

                                  <tr>
                                    <td height="4"></td>

                                    <td></td>
                                  </tr>

                                  <tr class="ItemTitleFont">
                                    <td class="ItemTitleFont" valign="top" width="60">内容</td>

                                    <td>
                                    <textarea class="InputAreaStyle" name="content">
</textarea></td>

                                    <td></td>
                                  </tr>

                                  <tr class="ItemTitleFont">
                                    <td height="8"></td>

                                   
                                  </tr>

                                  <tr>
                                    <td height="20" width="60"></td>

                                    <td width="200"><span style="color: gray"><input disabled="disabled" value="1" name="" type="checkbox" />发送手机短信给离线用户</span></td>

                                    <td></td>
                                  </tr>
                                </tbody>
                              </table>
                            </td>

                            <td width="20"></td>
                          </tr>
                        </tbody>
                      </table>
                    </td>
                  </tr>
                </tbody>
              </table>
            </center>
          </td>
        </tr>
      </tbody>
    </table>

    <div id="InputDetailBar">
      <input type="image" src="${pageContext.request.contextPath}/css/message/send.png" onclick="send()" />
    </div>
  </form>
</body>
</html>

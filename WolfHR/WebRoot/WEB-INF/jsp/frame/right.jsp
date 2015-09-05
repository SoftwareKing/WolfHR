<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Right</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
  <script language="javascript" src="css/right/desktopTitle.js" type="text/javascript">
</script>
 <script language="javascript" src="css/right/desktopMove.js" type="text/javascript">
</script>

  <script language="javascript" src="css/right/pageCommon.js" type="text/javascript">
</script>
  <script language="javascript" src="css/right/pictureNews.js" type="text/javascript">
</script>
  <link href="css/right/desktop.css" type="text/css" media="screen" rel="stylesheet" />
  <link href="css/right/mode.css" type="text/css" media="screen" rel="stylesheet" />
</head>
<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0" style="background-color: #D1E2F0;">
 <div style="height:370px;" id="Content">
      <div style="width:50%; float:left;" id="sub">
         <div class="DesktopBlock" >
          <div id="Block">
            <div id="BlockHead" class="BlockDetailByAdage">
              <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                <tbody>
                  <tr align="left" class="BlockDetailByAdage">
                    <td width="25"><img src="css/right/FUNC00019.gif" border="0" height="15" width="15" /></td>

                    <td>待我审批</td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="最小化" id="FUNC00019Min" src="css/right/min.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="refreshMode('FUNC00019');" alt="刷新" src="css/right/refresh.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="关闭" src="css/right/close.gif" border="0" height="11" width="11" /></td>

                    <td width="5"></td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div style="padding: 0px;"  class="BlockMemo">
              <div id="BlockDetail" class="BlockDetailByAdage">
                 <!--显示数据列表-->
                <table>
                <tbody id="TableData" class="dataContainer" datakey="formList">
       		     <s:iterator value="#taskViewList">
			       <tr height="3">
				     <td><font style="font-size:12PX;color:#005892;"><s:property value="form.title"/></font></td>
				     <td><font style="font-size:12PX;color:#005892;"><s:property value="form.applicator"/></font></td>
				     <td>
				      <s:a action="workFlowAction_approveUI?fid=%{form.fid}&&taskId=%{task.id}"><font style="font-size:12PX">审批处理</font></s:a>
				      <s:a action="workFlowAction_approvedHistory?fid=%{form.fid}"><font style="font-size:12PX">查看流转记录</font></s:a>
				     </td>
			      </tr>
			   </s:iterator>
            </tbody>
           </table>
           </div>
          <div id="BlockFoot">
              
              <div class="BlockDetailByAdage">
                  <img src="css/right/more.gif" border="0" height="8" width="9" /> <a href="workFlowAction_myTaskList.action" onclick="actMoreBtn('Oasp3103', '短消息');">更多...</a>
                </div>
              </div>
            </div>
            
          </div>
        </div>


           <div class="DesktopBlock" >
          <div id="Block">
            <div id="BlockHead">
              <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                <tbody>
                  <tr align="left" class="BlockDetailByAdage">
                    <td width="25"><img src="css/right/FUNC00019.gif" border="0" height="15" width="15" /></td>

                    <td>邮件</td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="最小化" id="FUNC00019Min" src="css/right/min.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="refreshMode('FUNC00019');" alt="刷新" src="css/right/refresh.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="关闭" src="css/right/close.gif" border="0" height="11" width="11" /></td>

                    <td width="5"></td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div style="padding: 0px;"  class="BlockMemo">
              <div id="BlockDetail" class="BlockDetailByAdage">
               <table>
               <tbody id="TableData">
                 <s:iterator value="#maillist">
							<tr class="DetailLine" onclick="content_onclick('d0');" class="TableDetail2" id="d0">
							<td align="left">
								<img src="css/right/list.gif" border="0" height="8" width="8" /><s:a href="mailAction_seeMail.action?id=%{id}"><font style="font-size:13PX;"><s:property value="title"/></font> </s:a>
							</td>
							<td align="left">
							</td>
							<td align="left">
								<font style="font-size:12PX"><s:property value="sender.username"/></font>	
							</td>
							<td align="left">
								<font style="font-size: 12PX"><s:property value="showTime"/></font>	
							</td>
							
							
							<td align="center">
								<s:a href="mailAction_deleteFrominbox.action?id=%{id}"><font style="font-size: 12PX">删除 </font> </s:a> 
								<s:a href="mailAction_reSendMail.action?id=%{id}"><font style="font-size: 12PX">回复</font></s:a>
							</td>
						</tr>
						</s:iterator>
               </tbody>
               </table> 
              </div>
               <div id="BlockFoot">
                <div class="BlockDetailByAdage">
                  <img src="css/right/more.gif" border="0" height="8" width="9" /> <a target="right" href="mailAction_inboxList.action" onclick="actMoreBtn('Oasp2803', '公告');">更多...</a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div  class="DesktopBlock">
          <div id="Block">
            <div id="BlockHead">
              <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                <tbody>
                  <tr align="left" class="BlockDetailByAdage">
                    <td width="25"><img src="css/right/FUNC00001.gif" border="0" height="15" width="15" /></td>

                    <td>短消息</td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="最小化" id="FUNC00001Min" src="css/right/min.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="refreshMode('FUNC00001');" alt="刷新" src="css/right/refresh.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="关闭" src="css/right/close.gif" border="0" height="11" width="11" /></td>

                    <td width="5"></td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div style="padding: 0px;" class="BlockMemo" >
              <div id="BlockDetail" class="BlockDetailByAdage">
              <table>
            
               <tbody id="TableData">
                  <s:iterator value="#messagelist">
							<tr class="DetailLine" onclick="content_onclick('d0');" class="TableDetail2" id="d0">
							
							<td width="50" class="DetailLineInfo">
							<img src="css/right/list.gif" border="0" height="8" width="8" /> 
							<s:a href="messageAction_seeMessage.action?id=%{id}">
							 &nbsp;&nbsp;&nbsp;<s:property value="title"/> </s:a>
							</td>
							
							<td>
								<s:property value="sender.username"/>
							</td>
							<td>
								<s:property value="showTime"/>
							</td>
							
							<td align="center">
								<s:a href="messageAction_deleteFrominbox.action?id=%{id}">删除 </s:a> 
								<s:a href="messageAction_reSendMessage.action?id=%{id}">回复</s:a>
							</td>
							
						</tr>
						</s:iterator>
             </tbody>
             </table>
              </div>

              <div id="BlockFoot">
                <div class="BlockDetailByAdage">
                  <img src="css/right/more.gif" border="0" height="8" width="9" /> <a target="right" href="messageAction_inboxList.action" onclick="actMoreBtn('Oasp3103', '短消息');">更多...</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      

      <div style="width:50%; float:right;" id="right">
        <div class="DesktopBlock" id="FUNC00004">
          <div id="Block" >
            <div id="BlockHead">
              <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                <tbody>
                  <tr align="left" class="BlockDetailByAdage">
                    <td width="25"><img src="css/right/FUNC00004.gif" border="0" height="15" width="15" /></td>
                   <td>公司格言</td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="最小化" id="FUNC00007Min" src="css/right/min.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="refreshMode('FUNC00007');" alt="刷新" src="css/right/refresh.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="关闭" src="css/right/close.gif" border="0" height="11" width="11" /></td>

                    <td width="5"></td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div style="height: auto; padding: 0px;"  class="BlockMemo" >
              <table style=" height:175px;" border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody>
                  <tr height="3">
                    <td colspan="5"></td>
                  </tr>

                  <tr height="5">
                    <td width="3px"></td>

                    <td class="AdageTopLeft" width="5"></td>

                    <td class="BlockDetailByAdage"></td>

                    <td class="AdageTopRight" width="5"></td>

                    <td width="3"></td>
                  </tr>

                  <tr>
                    <td width="3px"></td>

                    <td class="BlockDetailByAdage"></td>

                    <td class="BlockDetailByAdage" align="left">
                      <strong><font color="#005892" size="4">企业理念：以人为本，以信为金。</font></strong>

                      <p><strong><font color="#005892" face="楷体_GB2312" size="4">企业精神：创新，负责，守信，努力。</font></strong></p>

                      <p><strong><font color="#005892" face="楷体_GB2312" size="4">企业目标：为员工、顾客、股东、公众创造美好生活。</font></strong></p>
                    </td>

                    <td class="BlockDetailByAdage"></td>

                    <td width="3px"></td>
                  </tr>

                  <tr height="5">
                    <td width="3px"></td>

                    <td class="AdageBottomLeft" width="5"></td>

                    <td class="BlockDetailByAdage"></td>

                    <td class="AdageBottomRight" width="5"></td>

                    <td width="3"></td>
                  </tr>

                  <tr>
                    <td colspan="5" height="3"></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>



        <div  class="DesktopBlock" >
          <div id="Block">
            <div id="BlockHead">
               <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                <tbody>
                  <tr align="left" class="BlockDetailByAdage">
                    <td width="25"><img src="css/right/FUNC00006.gif" border="0" height="15" width="15" /></td>

                    <td>常用网址</td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="最小化" id="FUNC00006Min" src="css/right/min.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="refreshMode('FUNC00006');" alt="刷新" src="css/right/refresh.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="关闭" src="css/right/close.gif" border="0" height="11" width="11" /></td>

                    <td width="5"></td>
                  </tr>
                </tbody>
              </table>

            </div>
          
            
          <div style="padding: 0px;" class="BlockMemo" >
              <div id="BlockDetail" class="BlockDetailByAdage">
                <ul>
                  <li class="DetailLine">
                    <div class="DetailLineInfo">
                      <img src="css/right/list.gif" border="0" height="8" width="8" /> <a target="_blank" href="http://www.baidu.com/">百度</a>
                    </div>
                  </li>

                  <li class="DetailLine">
                    <div class="DetailLineInfo">
                      <img src="css/right/list.gif" border="0" height="8" width="8" /> <a target="_blank" href="http://www.ifeng.com/">凤凰网</a>
                    </div>
                  </li>
                  
                   <li class="DetailLine">
                    <div class="DetailLineInfo">
                      <img src="css/right/list.gif" border="0" height="8" width="8" /> <a target="_blank" href="http://www.qqhru.edu.cn/">齐齐哈尔大学</a>
                    </div>
                  </li>
                  
                   <li class="DetailLine">
                    <div class="DetailLineInfo">
                      <img src="css/right/list.gif" border="0" height="8" width="8" /> <a target="_blank" href="http://jkxy.qqhru.edu.cn/">齐齐哈尔大学计控学院</a>
                    </div>
                  </li>
                  
                </ul>
              </div>
              </div>
            

   
 
</div>

<!-- ********************************************************************* -->
  

 <div  class="DesktopBlock">
          <div id="Block">
            <div id="BlockHead">
              <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                <tbody>
                  <tr align="left" class="BlockDetailByAdage">
                    <td width="25"><img src="css/right/FUNC00001.gif" border="0" height="15" width="15" /></td>

                    <td>短消息</td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="最小化" id="FUNC00001Min" src="css/right/min.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="refreshMode('FUNC00001');" alt="刷新" src="css/right/refresh.gif" border="0" height="11" width="11" /></td>

                    <td width="14"><img onclick="alert('桌面不允许用户自行关闭或最小化。');" alt="关闭" src="css/right/close.gif" border="0" height="11" width="11" /></td>

                    <td width="5"></td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div style="padding: 0px;" class="BlockMemo" >
              <div id="BlockDetail" class="BlockDetailByAdage">
              <table>
            
               <tbody id="TableData">
               
               </tbody>
             </table>
              </div>

              <div id="BlockFoot">
                <div class="BlockDetailByAdage">
                  <img src="css/right/more.gif" border="0" height="8" width="9" /> <a target="right" href="messageAction_inboxList.action" onclick="actMoreBtn('Oasp3103', '短消息');">更多...</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
</div>
</body>
</html>

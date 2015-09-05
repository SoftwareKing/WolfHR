<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/WEB-INF/jsp/user/usercommon.jsp"></jsp:include>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html >
<head>
  <title>HR</title>
  <style type="text/css">
/*<![CDATA[*/
  .date-picker-wp {
  display: none;
  position: absolute;
  background: #f1f1f1;
  left: 40px;
  top: 40px;
  border-top: 4px solid #3879d9;
  }
  .date-picker-wp table {
  border: 1px solid #ddd;
  }
  .date-picker-wp td {
  background: #fafafa;
  width: 22px;
  height: 18px;
  border: 1px solid #ccc;
  font-size: 12px;
  text-align: center;
  }
  .date-picker-wp td.noborder {
  border: none;
  background: none;
  }
  .date-picker-wp td a {
  color: #1c93c4;
  text-decoration: none;
  }
  .strong {font-weight: bold}
  .hand {cursor: pointer; color: #3879d9}
  /*]]>*/
  </style>
  <script type="text/javascript">
//<![CDATA[
  var DatePicker = function () {
  var $ = function (i) {return document.getElementById(i)},
  addEvent = function (o, e, f) {o.addEventListener ? o.addEventListener(e, f, false) : o.attachEvent('on'+e, function(){f.call(o)})},
  getPos = function (el) {
  for (var pos = {x:0, y:0}; el; el = el.offsetParent) {
  pos.x += el.offsetLeft;
  pos.y += el.offsetTop;
  }
  return pos;
  }
  var init = function (n, config) {
  window[n] = this;
  Date.prototype._fd = function () {var d = new Date(this); d.setDate(1); return d.getDay()};
  Date.prototype._fc = function () {var d1 = new Date(this), d2 = new Date(this); d1.setDate(1); d2.setDate(1); d2.setMonth(d2.getMonth()+1); return (d2-d1)/86400000;};
  this.n = n;
  this.config = config;
  this.D = new Date;
  this.el = $(config.inputId);
  this.el.title = this.n+'DatePicker';
  this.update();
  this.bind();
  }
  init.prototype = {
  update : function (y, m) {
  var con = [], week = ['Su','Mo','Tu','We','Th','Fr','Sa'], D = this.D, _this = this;
  fn = function (a, b) {return '<td title="'+_this.n+'DatePicker" class="noborder hand" onclick="'+_this.n+'.update('+a+')">'+b+'<\/td>'},
  _html = '<table cellpadding=0 cellspacing=2>';
  y && D.setYear(D.getFullYear() + y);
  m && D.setMonth(D.getMonth() + m);
  var year = D.getFullYear(), month = D.getMonth() + 1, date = D.getDate();
  for (var i=0; i<week.length; i++) con.push('<td title="'+this.n+'DatePicker" class="noborder">'+week[i]+'<\/td>');
  for (var i=0; i<D._fd(); i++ ) con.push('<td title="'+this.n+'DatePicker" class="noborder"> <\/td>');
  for (var i=0; i<D._fc(); i++ ) con.push('<td class="hand" onclick="'+this.n+'.fillInput('+year+', '+month+', '+(i+1)+')">'+(i+1)+'<\/td>');
  var toend = con.length%7;
  if (toend != 0) for (var i=0; i<7-toend; i++) con.push('<td class="noborder"> <\/td>');
  _html += '<tr>'+fn("-1, null", "<<")+fn("null, -1", "<")+'<td title="'+this.n+'DatePicker" colspan=3 class="strong">'+year+'/'+month+'/'+date+'<\/td>'+fn("null, 1", ">")+fn("1, null", ">>")+'<\/tr>';
  for (var i=0; i<con.length; i++) _html += (i==0 ? '<tr>' : i%7==0 ? '<\/tr><tr>' : '') + con[i] + (i == con.length-1 ? '<\/tr>' : '');
  !!this.box ? this.box.innerHTML = _html : this.createBox(_html);
  },
  fillInput : function (y, m, d) {
  var s = this.config.seprator || '/';
  this.el.value = y + s + m + s + d;
  this.box.style.display = 'none';
  },
  show : function () {
  var s = this.box.style, is = this.mask.style;
  s['left'] = is['left'] = getPos(this.el).x + 'px';
  s['top'] = is['top'] = getPos(this.el).y + this.el.offsetHeight + 'px';
  s['display'] = is['display'] = 'block';
  is['width'] = this.box.offsetWidth - 2 + 'px';
  is['height'] = this.box.offsetHeight - 2 + 'px';
  },
  hide : function () {
  this.box.style.display = 'none';
  this.mask.style.display = 'none';
  },
  bind : function () {
  var _this = this;
  addEvent(document, 'click', function (e) {
  e = e || window.event;
  var t = e.target || e.srcElement;
  if (t.title != _this.n+'DatePicker') {_this.hide()} else {_this.show()}
  })
  },
  createBox : function (html) {
  var box = this.box = document.createElement('div'), mask = this.mask = document.createElement('iframe');
  box.className = this.config.className || 'datepicker';
  mask.src = 'javascript:false';
  mask.frameBorder = 0;
  box.style.cssText = 'position:absolute;display:none;z-index:9999';
  mask.style.cssText = 'position:absolute;display:none;z-index:9998';
  box.title = this.n+'DatePicker';
  box.innerHTML = html;
  document.body.appendChild(box);
  document.body.appendChild(mask);
  return box;
  }
  }
  return init;
  }();
  onload = function () {
  
  new DatePicker('_DatePicker_demo', {
  inputId: 'starttime',
  className: 'date-picker-wp',
  seprator: '-'
  });
  
  new DatePicker('_demo2', {inputId: 'demo2', className: 'date-picker-wp', seprator: '-'});
  new DatePicker('_demo3', {inputId: 'demo3', className: 'date-picker-wp', seprator: '-'});
  new DatePicker('_demo4', {inputId: 'demo4', className: 'date-picker-wp', seprator: '-'});
  new DatePicker('_demo5', {inputId: 'demo5', className: 'date-picker-wp', seprator: '-'})
    
  
  }
  //]]>
  </script>
</head>

<body topmargin="0" leftmargin="0" onload="onLoad()" marginheight="0" marginwidth="0">
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
      <s:form action="userworkAction_update.action">
      <s:hidden name="uwid"></s:hidden>
        <div class="ItemBlock_Title1">
          <img src="${pageContext.request.contextPath}/css/user/item_point.gif" border="0" />&nbsp;工作经历
        </div>

        <div class="ItemBlockBorder" style="width:95%;">
          <div class="ItemBlock">
            <table cellpadding="0" cellspacing="0" border="0" width="90%">
              <tbody>
                <tr>
                  <td height="27" width="30"></td>

                  <td>公司名称</td>

                  <td>
                 
                  <s:textfield name="companyname" cssClass="InputStyle"></s:textfield>
                  </td>

                  <td align="center" width="40"><font color="#FF0000">*</font></td>

                  
                </tr>

                <tr>
                  <td height="27" width="50"></td>

                  <td width="100">负责工作</td>

                  <td>
                 
                  <s:textfield name="majorwork" cssClass="InputStyle"></s:textfield>
                  </td>

                  <td></td>

                  <td></td>
                </tr>
                 <tr>
                  <td height="27"></td>

                  <td>开始时间</td>

                  <td>
                   <s:textfield  size="10" id="starttime" name="starttime" type="text" > </s:textfield>
                     
                  </td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td>结束时间</td>

                  <td>
                    <s:textfield size="10"  cssClass="inputdate" name="endtime" type="text" ></s:textfield> 
                         
                    
                  </td>

                  <td></td>

                  <td></td>
                </tr>
                
                <tr>
                  <td height="27"></td>

                  <td>主要业绩</td>

                  <td>
                 
                  <s:textfield name="yeji" cssClass="InputStyle"></s:textfield>
                  </td>

                  <td></td>

                  <td></td>
                </tr>
                <tr>
                  <td height="80"></td>

                  <td>备注</td>

                  <td>
                  <s:textarea cssClass="InputAreaStyle" style="width:100%;height:80%" name="description">
                   </s:textarea></td>

                  <td></td>

                  <td></td>
                </tr>

                <tr>
                  <td height="27"></td>

                  <td></td>

                  <td></td>

                  <td></td>

                  <td>
                  
                   <div id="InputDetailBar">
                     <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
                      <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
       </s:form>
       </center>
      </center>
  </body>
</html>

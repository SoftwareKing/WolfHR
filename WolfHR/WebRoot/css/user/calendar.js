var num1 = "一";
var num2 = "二";
var num3 = "三";
var num4 = "四";
var num5 = "五";
var num6 = "六";
var num7 = "日";
var toThisDay = "今日:";
var year = "年";
var month = "月";
var dateErr = "日期输入错误\n正确的格式为(YYYY-MM-DD)";
var guanbi = "关闭";
var lastyear = "前一年";
var nextyear = "后一年";
var lastmonth = "上个月";
var nextmonth = "下个月";

function formatMonth(monthValue) {
//	var months = new Array("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月");
	var months = new Array("壹月", "贰月", "叁月", "肆月", "伍月", "陆月", "柒月", "捌月", "玖月", "拾月", "拾壹月", "拾贰月");
	return months[monthValue - 1];
}

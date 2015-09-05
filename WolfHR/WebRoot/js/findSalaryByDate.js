function checkMonth(){
    var month = document.getElementById("month").value;
    if (month == "") {
        if (checkYear()) {
            form.action = "salaryInfoAction_salaryByYear.action"; //按年查询；
            form.submit();
        } else {
			return false ;
		}
    }
    else {
        if (checkYear()) {
            form.action = "salaryInfoAction_salaryByMonth.action"; //按年月查询；
            form.submit();
        } else {
			return false ;
		}
    }
}

function checkYear(){
    var year = document.getElementById("year").value;
    if (year == "") {
        alert("年份不能为空!");
        return false;
    }
    else 
        if (isNaN(year)) {
            alert("输入错误！");
            return false;
        }
        else {
            return true;
        }
}

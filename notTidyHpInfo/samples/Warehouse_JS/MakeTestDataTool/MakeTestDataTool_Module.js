// テスト用メソッド
function OnButtonClick() {
  target = document.getElementById("output");
  target.innerHTML = "Penguin";
}

// Excel起動メソッド
  function withExcel(visible, func) {
    target = document.getElementById("output");
	target.innerHTML = "withExcel";
	//wshshell=new ActiveXObject("WScript.Shell") 
	//wshshell.run("excel test.xls") 
	
 　　　var excel = new ActiveXObject("Excel.Application");
 　　　excel.Visible = visible;
 　　　excel.DisplayAlerts = false;
　　　try {
//　　　　　//func(excel);
　　　} finally {
	　excel.Quit();
　　　}
}

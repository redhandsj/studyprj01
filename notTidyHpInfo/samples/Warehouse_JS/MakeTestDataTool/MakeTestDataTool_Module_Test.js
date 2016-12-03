//wshshell=new ActiveXObject("WScript.Shell") 
//wshshell.run("excel test.xls") 
var excel = new ActiveXObject("Excel.Application");
excel.Visible = true;
excel.DisplayAlerts = false;
try {
//　　　　　//func(excel);
} finally {
  excel.Quit();
}

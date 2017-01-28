//カレンダー
//
//<script type="text/javascript" src="calendar2.js"></script>
//↑HTMLに上記タグを埋め込み、同じディレクトリに
//このファイルを設置すると、カレンダーが表示されます。

//日付と時間の設定
now = new Date();
year = now.getYear();
if (year < 1900) year += 1900;
mon = now.getMonth()+1;
day = now.getDate();
you = now.getDay();

//CSS
css_text = "";

//今日の日付
today = year + "/" + mon + "/" + day;

//曜日の選択肢
youbi = new Array("日","月","火","水","木","金","土");
youbi_color = new Array("ff0000","000000","000000","000000","000000","000000","0000ff");

//表示位置指定
document.write("<span id='c_view'></span>");

output_calendar(year,mon);

function output_calendar(ly,lm) {
	//表示用の日付
	cy = ly;
	cm = lm;

	var cal = "";

	//1日
	var fday = new Date(cy+"/"+cm+"/1");
	var fyou = fday.getDay();

	//末日
	var lday = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if ((cy%4 == 0 && cy%100 != 0) || (cy%400 == 0)) {lday[1]++;} //閏年

	//カレンダー表示
	cal += "<table border='1'>";
	cal += "<tr><th colspan='7'>";
	//前年ボタン
	//cal += "<input type='button' value='《' onClick='change_month(-12)'>";
	//前月ボタン
	cal += "<input type='button' value='←' onClick='change_month(-1)'>";
	cal += "<input type='button' value='" + cy+"年"+cm+"月' onClick='change_month(0)'>";
	//来月ボタン
	cal += "<input type='button' value='→' onClick='change_month(1)'>";
	//来年ボタン
	//cal += "<input type='button' value='》' onClick='change_month(12)'>";
	cal += "</th></tr>";
	cal += "<tr>";
	for (m = 0; m < 7; m++){
		cal += "<th><span class='youbi" + m + "'>" + youbi[m] + "</span></th>";
		if (youbi_color[m] != "") {
			css_text += ".youbi" + m + "{color: #" + youbi_color[m] + ";}\n";
		}
	}
	cal += "</tr>";
	for (n = 0; n < 6; n++) {
		cal += "<tr>";
		for (m = 0; m < 7; m++){
			var d = (n*7+m+1-fyou);
			var c_today = cy + "/" + cm + "/" + d;

			if (today == c_today) {cal += "<td align='right' bgcolor='#ffaaaa'>";}
			else {cal += "<td align='right'>";}
			if (d > 0 && d <= lday[cm-1]) {cal += "<span class='youbi" + m + "'>" + d + "</span>";}
			else {cal += "&nbsp;";}
			cal += "</td>";
		}
		cal += "</tr>";
		if (d >= lday[cm-1]) break;
	}
	cal += "</table>";

	//CSS出力
	cal += "<style type='text/css'>" + css_text + "</style>";

	document.getElementById("c_view").innerHTML = cal;
}

function change_month(ch) {

	if (ch == 0) {
		cy = year;
		cm = mon;
	} else if (ch > 0) {
		cy = cy + Math.floor(ch/12);
		cm = cm + ch % 12;
	} else {
		ch = Math.abs(ch);
		cy = cy - Math.floor(ch/12);
		cm = cm - ch % 12;
	}

	if (cm > 12) {cy += 1; cm -= 12;}
	if (cm < 1) {cy -= 1; cm += 12;}

	if (cy < 0) {cy = 1; cm = 1;}

	output_calendar(cy,cm);
}

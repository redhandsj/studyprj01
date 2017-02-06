/**
 * JSONからページを設定
 */
window.onload = function() {
	/* ちしき*/
	var aps = JSON.stringify(ap, function(key, value) {
		if (key === '') return value;
		var nav_dtl = document.getElementById("ap_dtl");
		var content_dtl = document.getElementById("content_ap_dtl");
		JsonToMenu(nav_dtl,content_dtl,key,value);
	});
	/* のうはう */
	var khs = JSON.stringify(kh, function(key, value) {
		if (key === '') return value;
		var nav_dtl = document.getElementById("kh_dtl");
		var content_dtl = document.getElementById("content_kh_dtl");
		JsonToMenu(nav_dtl,content_dtl,key,value);
	});
	/* 辞書 */
	var khs = JSON.stringify(dc, function(key, value) {
		if (key === '') return value;
		var nav_dtl = document.getElementById("dc_dtl");
		var content_dtl = document.getElementById("content_dc_dtl");
		JsonToMenu(nav_dtl,content_dtl,key,value);
	});
	/* ★新着情報リスト作成 */
	var khs = JSON.stringify(newlist, function(key, value) {
		if (key === '') return value;
		var nav_dtl = document.getElementById("new_list");
		makeNewList(nav_dtl,key,value);
	});

	// デフォルトはホーム
	var page = 'home';
	if(location.hash) {
		// URL#※ここにページが指定している場合、採用
		page = location.hash.substring(1);
		// セッションに値がない場合はホームを表示
	}
	ChangeTab(page,'1000');
}

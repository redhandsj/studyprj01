/**
 * タブ入れ替え
 */
function ChangeTab(tabname,z) {
	// 全部消す
	//document.getElementById('home').style.display = 'none';
	// 該当が存在しない場合は、HOMEを表示
	var content_dtl = document.getElementById('content_dtl');
	content_dtl.setAttribute('src', "../html/home/home.html");
	content_dtl.height = "2000px";
	// デフォルトの置きかえページ
	//var replace_page = "../html/home/home.html";
	// パン屑のデフォルトを設定
	document.getElementById('breadScraps').innerHTML = 'HOME';
	// 辞書
	var aps = JSON.stringify(ap, function(key, value) {
		if (key === '') return value;
		replace_page = ChangeTabSub(key,value,tabname,content_dtl);
	});
	if(replace_page==null){
		// 取れてなければ
		// ノウハウ
		var khs = JSON.stringify(kh, function(key, value) {
			if (key === '') return value;
			replace_page = ChangeTabSub(key,value,tabname,content_dtl);
		});
	}
	if(replace_page==null){
		// 取れてなければ
		// 辞書
		var khs = JSON.stringify(dc, function(key, value) {
			if (key === '') return value;
			replace_page = ChangeTabSub(key,value,tabname,content_dtl);
		});
	}
	if(replace_page==null){
		// 取れてなければ
		// サイトマップ
		if(tabname==='sitemap'){
			replace_page = "../html/home/sitemap.html";
		}
	}
	if(replace_page==null){
		// ここまでとれてなかったらデフォルトを格納
		replace_page = "../html/home/home.html";
	}

	// 指定箇所のみ表示
	content_dtl.contentWindow.location.replace(replace_page);
	// 最前面にする
	content_dtl.style.position = "relative";
	content_dtl.style.zIndex = z;

	//position: relative;
	//z-index: 9999;

	// URLに「#」をつける
	location.hash=tabname;

	// パネルボタンのhrefを書き換えて、URLが変わらないようにする
	var panel_btn = document.getElementById('panel-btn');
	panel_btn.hash = tabname;

	// 隠しメニューの初期化
	$( "[id^=animate-block]" ).hide();
	//alert("ssssssssssss");

	// クリックイベント
	//var clickMe = document.getElementById("panel-btn");
	//if( /*@cc_on ! @*/ false )
	//{
	//  // IEの場合
	//  clickMe.fireEvent("onclick"); //これでclickイベントが発火する
	//}
	//else
	//{
	//  // それ以外の場合
	//  var event = document.createEvent( "MouseEvents" ); // イベントオブジェクトを作成
	//  event.initEvent("click", false, true); // イベントの内容を設定
	//  clickMe.dispatchEvent(event); // イベントを発火させる
	//}

	//if((window.sessionStorage !== null)) {
	//    // セッションストレージが使える
	//	window.sessionStorage.setItem(['nowpage'],[tabname]);
	//} else {
	//    // 使えない。。。
	//}

	// セッションに現在のタブを格納

	// タブ入れ替え時にメニューは閉じる
	//if(body.hasClass('open')){
    //    body.toggleClass('open');
    //    menu.animate({'left' : -menuWidth }, 300);
    //    body.animate({'left' : 0 }, 300);
 	// }
}
function ChangeTabSub(key,value,tabname,content_dtl) {
	var folder = null;
	for(k1 in value){
		// オブジェクトではない場合はフォルダ名だけ取得する
		if(!(value[k1] instanceof Object)){
			folder = value[k1];
			continue;
		}
		for(k2 in value[k1]){
			// オブジェクトではない場合は無視する
			if(!(value[k1][k2] instanceof Object)) continue;
			for(k3 in value[k1][k2]){
				// オブジェクトではない場合は無視する
				if(!(value[k1][k2][k3] instanceof Object)) continue;
				if(value[k1][k2][k3].ex){
					// 存在する場合のみ非表示
					//document.getElementById(value[k1][k2][k3].id).style.display = 'none';
					if(value[k1][k2][k3].id===tabname){
						// 表示しようとしているもののパン屑表示を作成
						var pan = value.category + ' > ' + value[k1].title + ' > ' + value[k1][k2].title + ' > ' + value[k1][k2][k3].title;
						document.getElementById('breadScraps').innerHTML = pan;
						// 表示するものをiframeにセット
						content_dtl.setAttribute('src', folder + value[k1][k2][k3].id + ".html");
						content_dtl.height = value[k1][k2][k3].ht;
						//replace_page = folder + value[k1][k2][k3].id + ".html";
						//content_dtl.contentWindow.location.replace(folder + value[k1][k2][k3].id + ".html");
						return (folder + value[k1][k2][k3].id + ".html");
					}
				}
			}
		}
	}
	// なければnullを返す
	return null;
};


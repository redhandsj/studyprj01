/**
 * フレーム内からのタブ入れ替え
 */
function ChangeTabInFrame(tabname) {
	// 全部消す
	// 該当が存在しない場合は、HOMEを表示
	// デフォルトの置きかえページ
	var replace_page = "../html/home/home.html";
	// パン屑のデフォルトを設定
	//window.parent.document.getElementById('breadScraps').innerHTML = 'HOME';
	// 知識
	var aps = JSON.stringify(ap, function(key, value) {
		if (key === '') return value;
		replace_page = ChangeTabInFrameSub(key,value,tabname);
	});
	if(replace_page==null){
		// 取れてなければ
		// ノウハウ
		var khs = JSON.stringify(kh, function(key, value) {
			if (key === '') return value;
			replace_page = ChangeTabInFrameSub(key,value,tabname);
		});
	}
	if(replace_page==null){
		// 取れてなければ
		// 辞書
		var khs = JSON.stringify(dc, function(key, value) {
			if (key === '') return value;
			replace_page = ChangeTabInFrameSub(key,value,tabname);
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

	// 外のURLを更新する
	//alert("../" + replace_page);
	//location.href=replace_page;
	location.href= ("../" + replace_page);

	// URLに「#」をつける
	//alert(tabname);
	//top.location.hash=tabname;
}
function ChangeTabInFrameSub(key,value,tabname) {
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
					//window.parent.document.getElementById(value[k1][k2][k3].id).style.display = 'none';
					if(value[k1][k2][k3].id===tabname){
						return (folder + value[k1][k2][k3].id + ".html");
					}
				}
			}
		}
	}
	// なければnullを返す
	return null;
};

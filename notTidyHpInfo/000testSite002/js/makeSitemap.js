/**
 * サイトマップを作成
 */
window.onload = function() {
	/* ちしき*/
	var aps = JSON.stringify(ap, function(key, value) {
		if (key === '') return value;
		var map_dtl = document.getElementById("sitemap01");
		makeSitemap(map_dtl,key,value);
	});
	/* のうはう*/
	var aps = JSON.stringify(kh, function(key, value) {
		if (key === '') return value;
		var map_dtl = document.getElementById("sitemap02");
		makeSitemap(map_dtl,key,value);
	});
	/* 辞書*/
	var aps = JSON.stringify(dc, function(key, value) {
		if (key === '') return value;
		var map_dtl = document.getElementById("sitemap03");
		makeSitemap(map_dtl,key,value);
	});
}
/**
 * サイトマップを作成
 */
function makeSitemap(map_dtl,key,value) {
	// head
	var folder = null;
	for(k1 in value){
		// オブジェクトではない場合はフォルダ名だけ取得する
		if(!(value[k1] instanceof Object)){
			folder = value[k1];
			continue;
		}

		// div要素
		var e2 = document.createElement('li');
		e2.innerHTML = value[k1].title;  // ★

		// ul要素作成
		var e3 = document.createElement('ul');

		// ２階層目
		for(k2 in value[k1]){
			// オブジェクトではない場合は無視する
			if(!(value[k1][k2] instanceof Object)) continue;
			// li要素作成
			var e11 = document.createElement('li');
			e11.innerHTML = value[k1][k2].title; // ★

			// ul要素作成
			var e13 = document.createElement('ul');

			// ３階層目
			for(k3 in value[k1][k2]){
				// オブジェクトではない場合は無視する
				if(!(value[k1][k2][k3] instanceof Object)) continue;
				// li要素作成
				var e111 = document.createElement('li');

				// リンク or 文字列要素作成
				var e112 = null;
				if(value[k1][k2][k3].ex){
					e112 = document.createElement('a');
					e112.href = '#' + value[k1][k2][k3].id;
					e112.setAttribute('onclick', "ChangeTabInFrame('" + value[k1][k2][k3].id + "'); return false;");
				}else{
					e112 = document.createElement('a');
				}
				e112.innerHTML = value[k1][k2][k3].title;  // ★
				// 要素追加( <ul><li><a>...</a></li></ul> )
				e111.appendChild(e112);
				// 要素追加( <ul><li><a>...</a></li></ul> )
				e13.appendChild(e111);
			}
			// 要素追加( <ul><li><a>...</a></li></ul> )
			e11.appendChild(e13);
			// 要素追加( <ul><li><a>...</a></li></ul> )
			e3.appendChild(e11);
		}
		// 要素追加( <li><ul><li><a>...</a></li></ul></li> )
		e2.appendChild(e3);
		// 作成した要素を追加
		map_dtl.appendChild(e2);
	}
}

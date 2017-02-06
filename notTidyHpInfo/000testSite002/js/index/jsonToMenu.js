/**
 * JSONからメニューを作成
 */
function JsonToMenu(menu_dtl,content_dtl,key,value) {

	// head
	var folder = null;
	for(k1 in value){
		// オブジェクトではない場合はフォルダ名だけ取得する
		if(!(value[k1] instanceof Object)){
			folder = value[k1];
			continue;
		}

		// リンク要素作成
		var e1 = document.createElement('a');
		e1.href = '#';
		e1.innerHTML = value[k1].title;  // ★
		// div要素
		var e2 = document.createElement('li');
		e2.appendChild(e1);

		// ul要素作成
		var e3 = document.createElement('ul');

		// ２階層目
		for(k2 in value[k1]){
			// オブジェクトではない場合は無視する
			if(!(value[k1][k2] instanceof Object)) continue;
			// li要素作成
			var e11 = document.createElement('li');
			// A要素作成
			var e12 = document.createElement('a');
			e12.href = '#';
			e12.innerHTML = value[k1][k2].title; // ★

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
					e112.setAttribute('onclick', "ChangeTab('" + value[k1][k2][k3].id + "','998'); return false;");
				}else{
					e112 = document.createElement('a');
				}
				e112.innerHTML = value[k1][k2][k3].title;  // ★
				// 要素追加( <ul><li><a>...</a></li></ul> )
				e111.appendChild(e112);
				// 要素追加( <ul><li><a>...</a></li></ul> )
				e13.appendChild(e111);
/*
				// フレーム作成
				// リンク要素作成
				if(value[k1][k2][k3].ex){
					// カテゴリdiv作成（フレーム用）
					var e1111 = document.createElement('div');
					e1111.id = value[k1][k2][k3].id;

					var e1112 = document.createElement('iframe');
					e1112.setAttribute('src', folder + value[k1][k2][k3].id + ".html");
					e1112.name = value[k1][k2][k3].id;
					e1112.height = value[k1][k2][k3].ht;
					// 要素追加( <div><iframe>...</iframe></div> )
					e1111.appendChild(e1112);
					// 要素追加( <content_dtl><div><iframe>...</iframe></div></content_dtl> )
					content_dtl.appendChild(e1111);
				}
*/
			}
			// 要素追加( <ul><li><a>...</a></li></ul> )
			e11.appendChild(e12);
			// 要素追加( <ul><li><a>...</a></li></ul> )
			e11.appendChild(e13);
			// 要素追加( <ul><li><a>...</a></li></ul> )
			e3.appendChild(e11);
		}
		// 要素追加( <li><ul><li><a>...</a></li></ul></li> )
		e2.appendChild(e3);
		// 作成した要素を追加
		menu_dtl.appendChild(e2);
	}
}

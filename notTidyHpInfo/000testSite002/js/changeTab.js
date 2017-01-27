/**
 * タブ入れ替え
 */
function ChangeTab(tabname) {
	// 全部消す
	document.getElementById('c000tab000').style.display = 'none';
	// ちしき
	var aps = JSON.stringify(ap, function(key, value) {
		if (key === '') return value;
		ChangeTabSub(key,value,tabname);
	});
	// のうはう
	var khs = JSON.stringify(kh, function(key, value) {
		if (key === '') return value;
		ChangeTabSub(key,value,tabname);
	});
	// 指定箇所のみ表示
	document.getElementById(tabname).style.display = 'block';

	// セッションに現在のタブを格納
	window.sessionStorage.setItem(['nowpage'],[tabname]);

	// タブ入れ替え時にメニューは閉じる
	//if(body.hasClass('open')){
    //    body.toggleClass('open');
    //    menu.animate({'left' : -menuWidth }, 300);
    //    body.animate({'left' : 0 }, 300);
 	// }
}
function ChangeTabSub(key,value,tabname) {
	for(k1 in value){
		for(k2 in value[k1]){
			// オブジェクトではない場合は無視する
			if(!(value[k1][k2] instanceof Object)) continue;
			for(k3 in value[k1][k2]){
				// オブジェクトではない場合は無視する
				if(!(value[k1][k2][k3] instanceof Object)) continue;
				if(value[k1][k2][k3].ex){
					// 存在する場合のみ非表示
					document.getElementById(value[k1][k2][k3].id).style.display = 'none';
					if(value[k1][k2][k3].id===tabname){
						// 表示しようとしているもののパン屑表示を作成
						var pan = value.category + ' > ' + value[k1].title + ' > ' + value[k1][k2].title + ' > ' + value[k1][k2][k3].title;
						document.getElementById('breadScraps').innerHTML = pan;
					}

				}
			}
		}
	}
};


/**
 * タブ入れ替え
 */
function ChangeTab(tabname) {
	var mydata = JSON.stringify(idx, function(key, value) {
		if (key === '') return value;
		// 全部消す
		document.getElementById('c000tab000').style.display = 'none';
		for(k1 in value){
			for(k2 in value[k1]){
				// オブジェクトではない場合は無視する
				if(!(value[k1][k2] instanceof Object)) continue;
				for(k3 in value[k1][k2]){
					// オブジェクトではない場合は無視する
					if(!(value[k1][k2][k3] instanceof Object)) continue;
					document.getElementById('c' + k1 + 'tab' + k3).style.display = 'none';
				}
			}
		}
		// 指定箇所のみ表示
		document.getElementById(tabname).style.display = 'block';
	});
}

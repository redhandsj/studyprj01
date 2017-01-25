/**
 * タブ入れ替え
 */
function ChangeTab(tabname) {
	// 全部消す
	document.getElementById('c000tab000').style.display = 'none';
	// ちしき
	var aps = JSON.stringify(ap, function(key, value) {
		if (key === '') return value;
		ChangeTabSub(key,value);
	});
	// のうはう
	var khs = JSON.stringify(kh, function(key, value) {
		if (key === '') return value;
		ChangeTabSub(key,value);
	});
	// 指定箇所のみ表示
	document.getElementById(tabname).style.display = 'block';
}
function ChangeTabSub(key,value) {
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
				}
			}
		}
	}
};


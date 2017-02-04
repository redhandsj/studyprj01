/**
 * 用語のリンクを作成
 */
//var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
//alert(doc.body.innerHTML);
//var doc = document;
//alert(document.getElementById('toc'));
window.onload = function()
{
	//alert(document.body.innerHTML);
    // 知識
    var aps = JSON.stringify(ap, function(key, value) {
    	if (key === '') return value;
    	document.body.innerHTML = makeFrameLinksSub(key,value,document.body.innerHTML);
    });
}
function makeFrameLinksSub(key,value,html) {
	var wkHtml = html;
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
					// 全置換
					var before = value[k1][k2][k3].title ;
					var regExp = new RegExp( before, "g" ) ;
					wkHtml = wkHtml.replace( regExp , "<a href='#" + value[k1][k2][k3].id + "' onclick =\"ChangeTabInFrame('" + value[k1][k2][k3].id + "'); return false;\">" + before + "</a>" ) ;
				}
			}
		}
	}
	// 加工後を返す
	return wkHtml;
};



/**
 * 新着情報メニューを作成
 */
function makeNewList(menu_dtl,key,value) {

	// head
	var folder = null;

	// ul要素作成
	var e1 = document.createElement('ul');

	for(k1 in value){
		// オブジェクトではない場合は無視する
		if(!(value[k1] instanceof Object)) continue;

		// li要素作成
		var e11 = document.createElement('li');
		// 日付作成
		var e12 = document.createElement('span');
		e12.className = 'date';
		e12.innerHTML = value[k1].date; // ★
		// br要素作成
		var e13 = document.createElement('br');
		// A要素作成
		var e14 = document.createElement('a');
		if(value[k1].ex){
			// リンク作成する
			e14.href = '#' + value[k1].id;
			e14.setAttribute('onclick', "ChangeTab('" + value[k1].id + "','998'); return false;");
			e14.innerHTML = value[k1].title; // ★
		}else{
			// リンクがない場合はふつうの太字
			// A要素作成
			var e111 = document.createElement('b');
			e111.innerHTML = value[k1].title; // ★
			e14.appendChild(e111);
		}

		// リスト１つ分作成
		e11.appendChild(e12);
		e11.appendChild(e13);
		e11.appendChild(e14);
		// リスト追加
		e1.appendChild(e11);
	}
	// 作成した要素を追加
	menu_dtl.appendChild(e1);

}

<?php
// オブジェクト指向ではないスクリプト
//! @param  $kaiinType 会員種別
//! @param  $kingaku   購入金額
//! @return            請求金額 -1 : エラー
function procKeisan($kaiinType, $kingaku){
	$kei = -1;
	if($kaiinType === 'S'){
		$kei = (int)($kingaku * 0.9);
	} else if($kaiinType === 'A'){
		$kei = (int)($kingaku * 0.95) + 300;
	}
	return $kei;
}

if(($fd = @fopen('data.csv','r')) !== FALSE){
	while(($dt = fgetcsv($fd,32,",")) !== FALSE){
		$kaiinType = $dt[1];
		$kingaku = $dt[2];
		$kei = procKeisan($kaiinType, $kingaku);
		if($kei >= 0){
			echo $dt[0], 'さんへの請求額は、', $kei,"円です。\n";
		}
	}
	fclose($fd);
}

?>
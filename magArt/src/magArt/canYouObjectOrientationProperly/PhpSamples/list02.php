<?php
class Kaiin { // 会員種別クラス
	protected $kingaku = 0;
	protected $waribiki = 0;
	protected $soryo = 0;

	//! @param $kingaku 購入金額
	function __construct($kingaku){
		$this->kingaku = $kingaku;
	}

	public function procKeisan(){
		return (int)($this->kingaku * $this->waribiki) + $this->soryo;
	}
}

class KaiinS extends Kaiin { // 会員種別 Sクラス
	protected $waribiki = 0.9;
	protected $soryo = 0;
}

class KaiinA extends Kaiin { // 会員種別 Aクラス
	protected $waribiki = 0.95;
	protected $soryo = 300;
}

class User { // ユーザ管理クラス
	protected $name = '';
	protected $kaiin = NULL;

	//! @param $name 会員名
	//! @param $kaiin 会員種別
	//! @param $kingaku 購入金額
	function __construct($name, $kaiin, $kingaku){
		$class = 'kaiin'.$kaiin;
		if(class_exists($class)){
			$this->kaiin = new $class($kingaku);
		}
		$this->name = $name;
	}

	function getKingaku(){
		if(!isset($this->kaiin)){
			return;
		}
		$kingaku = $this->kaiin->procKeisan();
		echo $this->name , 'さんへの請求額は、' , $kingaku , ' 円です。' , "\n";
	}
}

// クラスを使用した処理
if(($fd = @fopen('data.csv','r')) !== FALSE){
	while(($dt = fgetcsv($fd,32,",")) !== FALSE){
		$user = new User($dt[0], $dt[1], $dt[2]);
		$user->getKingaku();
	}
	fclose($fd);
}

?>
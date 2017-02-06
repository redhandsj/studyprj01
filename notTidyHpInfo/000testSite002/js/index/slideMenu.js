/**
 * スライドメニュー
 */
$(function(){
  var menu = $('#slide_menu'), // スライドインするメニューを指定
       /*menuBtn = $('#button'), // メニューボタンを指定*/
       body = $(document.body),
       menuWidth = menu.outerWidth();
  // メニューボタンをクリックした時の動き
  //menuBtn.on('click', function(){
  $('#panel-btn').click(function(){
	// body に open クラスを付与する
    body.toggleClass('open');
    if(body.hasClass('open')){
      // open クラスが body についていたらメニューをスライドインする
      body.animate({'left' : menuWidth }, 300);
      menu.animate({'left' : 0 }, 300);
      $('#content_dtl').css({ position:'relative',zIndex:998 })
    }else {
      // open クラスが body についていなかったらスライドアウトする
      menu.animate({'left' : -menuWidth }, 300);
      body.animate({'left' : 0 }, 300);
      $('#content_dtl').css({ position:'relative',zIndex:1000 })
    }
  });

  // 画面のどこかをクリックしたら、開いていた場合のみ閉じる
  // ※ スマホのhoverが動かないので一旦やめる
  /*$("#content").click(function(e) {
	 //alert(e.target.id);
     //if(e.target.id==="panel-btn" || e.target.id==="dropmenu"
	 //   	 || e.target.id==="slide_menu" || e.target.id==="menuString"){
     if(e.target.id==="panel-btn"){
		 // パネルボタンとメニューは無視
		 return;
	 }
	 // パネルボタン以外のクリックでメニューを閉じる
    if(body.hasClass('open')){
       body.toggleClass('open');
       menu.animate({'left' : -menuWidth }, 300);
       body.animate({'left' : 0 }, 300);
	 }
  });*/
});
/**
 * サイドメニューの強制スクロール
 */
$(window).on("scroll", function(){
    $("#slide_menu").css("top", -$(window).scrollTop());
});


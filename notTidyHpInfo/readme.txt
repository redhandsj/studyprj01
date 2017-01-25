//=====================================================================================================================
//　全体readme
//=====================================================================================================================
★ 全体にシンプル構成

//=====================================================================================================================
// 課題
//=====================================================================================================================
★ git-hub
 - (〇)基本公開設定
   - http://blogger.weblix.net/2014/01/github-pages-create-web-site.html
 - publicのみ公開のディレクトリ構成と設定
   - (〇)docsフォルダ作成
   - (〇)SettingsタブのGitHub PagesセクションのSource
 - 独自ドメイン調査
   - git-hub単独ではないので保留
     - http://himaratsu.hatenablog.com/entry/github/hosting
     - http://qiita.com/tiwu_official/items/d7fb6c493ed5eb9ee4fc

★ メニュー
 - (〇)スマホの場合は縦に並ぶ
 - (〇)スマホの場合は↓に伸びる
 - (〇)jsonからサイドメニュー作成
 - (〇)Jsonにフォルダ位置・ファイル名を書いてそれを参照するようにする。
 - ナビの上にメニューをJPGかなんかで表示


 - アコーディオンメニュー（検討）
   - http://weboook.blog22.fc2.com/blog-entry-361.html

★ サイト内検索
 - google機能

★ アクセスカウンタ
 - 公式
   - https://rcmdnk.com/blog/2014/02/20/computer-github/#公式に解析ツールが追加されていた

★ アフィリエイト
 - adsence機能


★ デザイン
 - 全体デザイン（黒を基調）
 - アイコン作成

★ 表示系
 - (〇)複数項目閉じ
   → 対応済み

 - フッタの表示

 - 項目の矢印
   - (〇)まず簡単な矢印（固定）のみで。。。
     - http://weblovelog.com/web/2181

   - 画像を使わずcssだけで、開閉するリストによくある矢印を作る
     - http://qiita.com/terrym/items/aaf07df0221bfbaea1b3

 - カレンダー
   - (△)埋め込みカレンダー
     - http://www.shurey.com/js/calendar/index.html

 - 画像
   -(〇)【CSS】img画像の縦横比は元のまま、表示させたいボックスサイズの大きい方に合わせて縮小して表示させる。ついでに上下左右中央寄せで。
     - http://bashalog.c-brains.jp/15/08/17-100000.php

 - 新着表示
 - RSS

 - 携帯を横画面にした場合のメニューの表示

 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 - 再読み込み時の元画面の表示
   - セッションを使ってみる
     - http://portaltan.hatenablog.com/entry/2015/08/05/100655
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

★ 外部連携
 - Twitter
   - この変の情報があるが難しそうなので保留
     - http://lealog.hateblo.jp/entry/2012/01/27/184153

★ ゲーム開発
 - スクラッチ開発
   - http://qiita.com/zukkun/items/4ea9542a6dde45c6a9fd
 - スクラッチ開発
   - http://www.slideshare.net/KazukiMiyanishi/java-scripthtml5
 - JavaScript によるゲームプログラミング
   - http://www.sist.ac.jp/~suganuma/game/JavaScript/



//=====================================================================================================================
// 作成中ページのしおり
//=====================================================================================================================
★　khc001tab001.html 【DB】【MySQL】rootパスワードを忘れた場合
 - https://liginc.co.jp/web/programming/mysql/87393

★　khc001tab002.html 【DB】【MySQL】権限の追加と確認
 - http://qiita.com/pinohara/items/481c95dc4c8c2568bf8d




//=====================================================================================================================
// 未整頓情報
//=====================================================================================================================

★ 【mysql】rootパスワードを忘れた場合の対処法
 - https://liginc.co.jp/web/programming/mysql/87393

★ preタグコメント分の一覧
http://ubuntu.jump-up.info/jquery/jquery/syntaxhighlighter.html


★ 雑多情報蓄積
file:///G:/works/repos/git/github/redhandsj/studyprj01/notTidyHpInfo/html/subpages001/readme.html


★本番
https://github.com/redhandsj/redhandsj.github.io.git

★本番のアクセス
https://redhandsj.github.io/


★ 使用ライブラリ
/notTidyHpInfo/libs/syntaxhighlighter_3.0.83

★プロジェクト管理における課題管理の位置づけ
http://www.linzylinzy.com/issue_management.html



★要件定義ラボ
http://xn--zdkza790s3glz27b6lm.com/


★eclipse ワークスペース 復旧方法

* Eclipseを起動した時に、
 「workspace in use or cannot be created choose a different one」というダイアログが表示されて、
  Workspaceを違うところにさせられるエラーがでる

 ※ まずは、別でEclipseを立ち上げていると、この現象があるので、そのことを確認する。
　　⇒確認して、別でEclipseを立ち上げていたら、それを閉じる。
　　⇒確認して、別でEclipseが立ち上げていなかったら、下記を試してみるといいかも。


解決方法

1. 「(自分の設定したパス)\workspace\.metadata」下まで移動する
2. 「.lock」というファイルがあるので、削除

//=====================================================================================================================
// <END>
//=====================================================================================================================

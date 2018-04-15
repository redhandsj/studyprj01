/**
 *
 */
package rgsJavap2.chap18;

import java.time.Instant;
import java.util.Date;

/**
 * List18　第18章　設計の原則とデザインパターン
 */
public class List18Service {
	//=======================================================================
	/**
	 * List18_01
	 */
	private void list18_01(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Account a = new Account("ミナト");
	}
	//=======================================================================
	/**
	 * List18_Visitor
	 */
	private void list18_Visitor(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		//窓口の中村くんを作る
		Librarian nakamura = new Librarian();
		//中村くんに昆虫図鑑の場所を聞く
		String location = nakamura.searchBook("昆虫図鑑");
		if(location.equals("貸出中です")){
			System.out.println("貸出中かよ…");
		}else if(location.equals("その本は所蔵していません")){
			System.out.println("なんだ、ないのか");
		}else{
			System.out.println("サンキュ！");
		}

	}
	//=======================================================================
	/**
	 * List18_03
	 */
	private void list18_03(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		SingletonFlower sf = SingletonFlower.getInstance();
	}
	//=======================================================================
	/**
	 * List18_05
	 */
	@SuppressWarnings("resource")
	private void list18_05(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		System.out.println("オセロゲームを開始します。");
		int[][] board = new int[8][8];

		OthelloAI ai = null;
		System.out.println("コンピュータの強さを選んでください(1=弱い, 2=強い, 3=その他)");
		int cpuno = new java.util.Scanner(System.in).nextInt();
		if (cpuno == 1) {
			ai = new WeakOthelloAI();
		} else if (cpuno == 2) {
			ai = new StrongOthelloAI();
		} else {
			/*
			 * System.out.println("人工知能クラスのFQCNを入力してください");
			 * System.out.println("（[ただし人工知能クラスはクラスパスに配備されている必要があります）"); String
			 * fqcn = new java.util.Scanner(System.in).nextLine(); Class<?>
			 * clazz = Class.forName(fqcn); ai = (OthelloAI)
			 * clazz.newInstance();
			 */
		}

		while (true) {
			System.out.println("あなたの番: 打つ場所を決めてください.");
			/* : */
			System.out.println("わたしの番: 打つ場所を決めます.");
			int[] nextStone = ai.decide(board);
			/* : */
		}
	}

	//=======================================================================
	/**
	 * List18_07 TemplateMethod を用いたパターン
	 */
	private void list18_07(){
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println("-----"+ste[1].getMethodName()+"------");

		Hero h = new Hero("ああああ");
		h.introduce();
	}

	//=======================================================================
	/**
	 * 各処理
	 */
	void procs(){
		// 18.4 クラス関係に関する原則
		this.list18_01();
		// 18.6 Facade 内部を隠してシンプルに
		this.list18_Visitor();
		// 18.7 Singleton 唯一無二の存在
		this.list18_03();
		// 18.8 Strategy プラグインの切替
		//this.list18_05();
		// 18.9 TemplateMethod 大まかなシナリオ
		this.list18_07();

	}
}

/**
 * List18_01
 */
class Account{
	/**
	 * 口座
	 * @param owner 預金者
	 */
	public Account(final String owner){
		System.out.println(owner);
	}
}
/**
 * List 18-3 １つだけしかインスタンスを作成できない花
 * <ul>
 * <li>final 継承による生成を防止
 * <li>clone() をオーバーライドしない
 * <li>シリアライズにしない
 * </ul>
 */
final class SingletonFlower {
	/**
	 * 唯一のインスタンス保存用
	 */
	private static SingletonFlower theInstance;
	/**
	 * newできないコンストラクタ
	 */
	private SingletonFlower() {}
	/**
	 * インスタンス取得
	 * @return 唯一のインスタンス
	 */
	public static SingletonFlower getInstance() {
		// nullの場合（初回１回のみ）インスタンス作成
		if(theInstance == null) {
			theInstance = new SingletonFlower();
		}
		return theInstance;
	}
}
/**
 * List18-04 オセロゲームの人工知能関連クラス
 */
interface OthelloAI {
	/**
	 * 現在の盤の状態から、次に打つ場所を決める処理.
	 * @param board
	 *            現在の盤状態(8x8のint配列)。0=石なし、1=白、-1=黒。
	 * @return 次に石を打つべきx座標とy座標を格納した要素数2の配列。
	 */
	public int[] decide(int[][] board);
}
class StrongOthelloAI implements OthelloAI {
	public int[] decide(int[][] board) {
		/* … 盤の状態を詳しく分析して次の手を決める処理 … */
		return null;
	}
}
class WeakOthelloAI implements OthelloAI {
	public int[] decide(int[][] board) {
		/* … 打てる場所を全て洗い出し、ランダムで選ぶ処理 … */
		return null;
	}
}
/**
 * キャラクタ
 */
abstract class Character {
	/**
	 * 名前
	 */
	protected String name;
	/**
	 * 変更できない大きな処理の流れ
	 */
	final void introduce() {         /* (1)のメソッド */
		System.out.println("私の名前は、" + this.name + "です。");
		doIntroduce();                      /* (2)を呼び出し */
		System.out.println("よろしくお願いします。");
	}
	/**
	 * 各クラスで特有の動作を定義
	 */
	protected abstract void doIntroduce();  /* (2)のメソッド */
}
/**
 * ヒーロー
 */
class Hero extends Character {
	/**
	 *コンストラクタ
	 * @param name 名前
	 */
	Hero(final String name){
		this.name = name;
	}
	/**
	 * 特有の動作を定義
	 */
	protected void doIntroduce(){
		System.out.println("私はヒーローです");
	}
}

/**
 * 所蔵本リスト
 */
class BookList {
	public String searchBook(String bookName) {
		String location = null;
		//本の名前から探す。あればその場所を、なければnullを返す
		return location;
	}
}
/**
 * 貸出帳
 */
class LendingList {
	public boolean check(String bookName) {
		//貸出帳をチェックする
		//貸出中ならtrue、そうでなければfalseを返す
		return true;
	}
}
/**
 * 図書委員の中村くん
 */
class Librarian {
	public String searchBook(String bookName) {
		//本を探す
		BookList bookList = new BookList();
		String location = bookList.searchBook(bookName);
		//本の場所がnullではない(所蔵してる)とき
		if (location != null) {
			//貸出中かチェックする
			LendingList lendingList = new LendingList();
			if (lendingList.check(bookName)) {
				//貸出中のとき
				return "貸出中です";
			} else {
				//貸出中ではないとき
				return location;
			}
			//所蔵してないとき
		} else {
			return "その本は所蔵していません";
		}
	}
}

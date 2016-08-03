/**
 *
 */
package blogs.theDifferenceBetweenFactoryMethodAndAbstractFactory.staticFactory;

/**
 * static ファクトリーメソッド適用
 */
public class Main {
	/**
	 * 作成タイプ
	 */
	enum Type { FIRST, SECOND };

	/**
	 *　メイン
	 * @param args コマンドライン
	 */
	public static void main(String[] args) {
		Type type;
		Alphabet alphabet;

		type = Type.FIRST;
		alphabet = factoryMethod (type);
		alphabet.whoAreYou ();

		type = Type.SECOND;
		alphabet = factoryMethod (type);
		alphabet.whoAreYou ();
	}

	/**
	 * Factoryメソッド
	 * @param type 作成タイプ
	 * @return 作成オブジェクト
	 */
	static Alphabet factoryMethod (Type type) {
		if (type == Type.FIRST) {
			return new A ();
		} else {
			return new B ();
		}
	}
}

/**
 * 親クラス
 */
abstract class  Alphabet {
    abstract void whoAreYou ();
}

/**
 * A
 */
class A extends  Alphabet {
    void whoAreYou () { System.out.println ("I'm A");}
}

/**
 * B
 */
class B extends  Alphabet {
    void whoAreYou () { System.out.println ("I'm B");}
}

/**
 *
 */
package blogs.theDifferenceBetweenFactoryMethodAndAbstractFactory.noFactory;

/**
 * ファクトリーなしパターン
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
		if (type == Type.FIRST) {
			alphabet = new A ();
		} else {
			alphabet = new B ();
		}
		alphabet.whoAreYou ();

		type = Type.SECOND;
		if (type == Type.FIRST) {
			alphabet = new A ();
		} else {
			alphabet = new B ();
		}
		alphabet.whoAreYou ();
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

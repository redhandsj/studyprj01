package blogs.theDifferenceBetweenFactoryMethodAndAbstractFactory.factoryMethod;

/**
 * ファクトリーメソッド パターン適用
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
		Creator creator;
		Alphabet alphabet;

		creator = new CreatorA ();
		alphabet = creator.factoryMethod ();
		alphabet.whoAreYou ();

		creator = new CreatorB ();
		alphabet = creator.factoryMethod ();
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
 * 作成クラス
 */
abstract class Creator {
    abstract Alphabet factoryMethod ();
}

/**
 * 作成(A)クラス
 */
class CreatorA extends Creator {
    Alphabet factoryMethod () {
        return new A ();
    }
}

/**
 * 作成(B)クラス
 */
class CreatorB extends Creator {
    Alphabet factoryMethod () {
        return new B ();
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

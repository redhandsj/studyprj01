/**
 *
 */
package blogs.theDifferenceBetweenFactoryMethodAndAbstractFactory.abstractFactory;

/**
 * Abstract Factory パターン適用
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
		Number number;

		creator = new FirstCreator ();
		alphabet = creator.alphabetFactoryMethod ();
		number = creator.numberFactoryMethod ();
		alphabet.whoAreYou ();
		number.whoAreYou ();

		creator = new SecondCreator ();
		alphabet = creator.alphabetFactoryMethod ();
		number = creator.numberFactoryMethod ();
		alphabet.whoAreYou ();
		number.whoAreYou ();
	}
}

/**
 * 作成(共通)クラス
 */
abstract class Creator {
    abstract Alphabet alphabetFactoryMethod ();
    abstract Number numberFactoryMethod ();
}

/**
 * 作成(タイプ１)クラス
 */
class FirstCreator extends Creator {
    Alphabet alphabetFactoryMethod () {
        return new A ();
    }
    Number numberFactoryMethod () {
        return new One ();
    }
}

/**
 * 作成(タイプ２)クラス
 */
class SecondCreator extends Creator {
    Alphabet alphabetFactoryMethod () {
        return new B ();
    }
    Number numberFactoryMethod () {
        return new Twe ();
    }
}

/**
 * アルファベットクラス
 */
abstract class  Alphabet {
    abstract void whoAreYou ();
}

/**
 * アルファベット(A)
 */
class A extends  Alphabet {
    void whoAreYou () { System.out.println ("I'm A");}
}

/**
 * アルファベット(B)
 */
class B extends  Alphabet {
    void whoAreYou () { System.out.println ("I'm B");}
}

/**
 * 数値クラス
 */
abstract class Number {
    abstract void whoAreYou ();
}

/**
 * 数値（１）クラス
 */
class One extends Number {
    void whoAreYou () { System.out.println ("I'm 1");}
}

/**
 * 数値（２）クラス
 */
class Twe extends Number {
    void whoAreYou () { System.out.println ("I'm 2");}
}

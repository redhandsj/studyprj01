public class Outer {
    int outerMember;                // 非finalメンバ
    void outerMethod() {
        int a = 10;                 // 非finalローカル変数
        class Inner {               /* ここでInnerを定義 */
            public void innerMethod() {
                System.out.println("innerMethodです");
                System.out.println(outerMember);
            }                       /* ローカルクラスの内部からouterMemberは利用できるが */
        }                           /* 変数aは利用できない */
        Inner ic = new Inner();     /* 同じメソッド内ですぐに利用 */
        ic.innerMethod();
    }
}
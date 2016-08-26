public class King {
	void talk(Hero h) {
		System.out.println("王様：ようこそ我が国へ、勇者" + h.name + "よ。");
		System.out.println("王様：長旅疲れたであろう、そこで横になって休むがよい");
		h.die(); 		// ここが不具合の原因。勇者が死ぬ！
	}
}

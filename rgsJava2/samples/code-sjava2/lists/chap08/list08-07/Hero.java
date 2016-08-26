public class Hero {
	String name;
	int hp;
	
	void sleep() {
		this.hp = 100;	/* ←自分自身のhpフィールド*/
		System.out.println(this.name + "は、眠って回復した");
	}						/* ↑自分自身のnameフィールド */
}

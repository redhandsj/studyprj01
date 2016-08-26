public class Character {
	String name;
	int hp;
	
	public void run(){
		System.out.println(this.name + "は逃げ出した");
	}
	
	public void attack(Matango m){
		System.out.println(this.name + "の攻撃！");
		System.out.println("敵に？？ポイントのダメージをあたえた！");
		m.hp -= ??;			/* ここを記述しようとして手が止まる */
	}
}

public class SuperHero extends Hero {		/* 「基本的にはHeroと同じ」と宣言 */
	private boolean flying;
	public void fly(){				/* flyを追加 */
		this.flying = true;
		System.out.println("飛び上がった！");
	}

	public void land(){				/* landを追加 */
		this.flying = false;
		System.out.println("着地した！");
	}
}

public class Hero {
	String name;
	int hp;
	public boolean equals(Object o) {
		if(this == o) { return true; } //等値なら間違いなく等価
		if(o instanceof Hero){	
			Hero h = (Hero)o;	
			if(this.name.equals(h.name)) {
				return true;  //名前が等しければ等価
			}
		}
		return false;
	}

}

public class Main {
  public static void main(String[] args) {
    System.out.println("あなたの運勢を占います");
    int fortune = new java.util.Random().nextInt(5) + 1;    // 1〜5の乱数発生
    switch(fortune) {
     case 1:
     case 2:    // fortuneが1か2なら…
       System.out.println("いいね！");
       break;
     case 3:    // fortuneが3なら…
       System.out.println("普通です");
       break;
     case 4:
     case 5:    // fortuneが4か5なら…
       System.out.println("うーん…");
    }
  }
}

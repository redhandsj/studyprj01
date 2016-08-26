public class Main {
  public static void main(String[] args) {
    boolean tenki = true;    // ここでtrueかfalseを代入
    if(tenki == true) {      // 内容が2行なので波カッコ省略不可能
      System.out.println("洗濯をします");
      System.out.println("散歩にいきます");
    } else                   // 1行しかないので波カッコは省略可能
      System.out.println("DVDを見ます");
  }
}

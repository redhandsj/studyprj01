public class Main {
  public static void main(String[] args) {
    int[] score = { 20, 30, 40, 50, 80 };
    for(int value : score) {      // ループが1周するたびに次の要素がvalueに入る
      System.out.println(value);  // valueをそのまま使える
    }
  }
}

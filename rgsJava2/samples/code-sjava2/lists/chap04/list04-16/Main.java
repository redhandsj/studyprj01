public class Main {
  public static void main(String[] args) {
    int[][] scores = { { 10, 20, 30 }, { 30, 40, 50 } };  // このような初期化が可能
    System.out.println(scores.length);                    // 2が出力される 
    System.out.println(scores[0].length);                 // 3が出力される 
  }
}

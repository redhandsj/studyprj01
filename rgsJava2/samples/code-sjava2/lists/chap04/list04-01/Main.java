public class Main {
  public static void main(String[] args) {
    int sansu = 20;     // 算数は20点
    int kokugo = 30;    // 国語は30点
    int rika = 40;      // 理科は40点
    int eigo = 50;      // 英語は50点
    int syakai = 80;    // 社会は80点

    int sum = sansu + kokugo + rika + syakai + eigo;  // 合計の算出
    int avg = sum / 5;  // 平均の算出

    System.out.println("合計点:" + sum);    // 合計と平均の表示
    System.out.println("平均点:" + avg);
  }
}

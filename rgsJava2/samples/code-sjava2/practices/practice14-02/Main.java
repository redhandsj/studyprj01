public class Main {
	public static void main(String[] args) {
		Account a1 = new Account();
		a1.accountNumber="4649"; a1.balance = 1592;
		Account a2 = new Account();
		a2.accountNumber="  4649"; a1.balance = 8214;
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println("上記2つの口座が等価であるか:" + (a1.equals(a2)));
	}
}

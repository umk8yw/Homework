package tests;

public class StringUtil {
	public static String lowcase(String s) {
		return s.toLowerCase();
	}

	public static void main(String[] args) {
		String q = "world is not ENOUGH";
		String qq = lowcase(q);
		String qqq = q.substring(q.indexOf("ENOUGH"));
		qqq.concat(" is not enough");
		System.out.println(q);
		System.out.println(qq);
		System.out.println(qqq);
	}
}
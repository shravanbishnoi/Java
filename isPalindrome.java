public class isPalindrome {
	public static void main(String[] args) {
		String str = "Shravan";
		check s1 = new check();
		System.out.println(s1.ispalindrome(str));
	}
}
// class containing ispalindrome method
class check {
	public boolean ispalindrome(String s){
		if (s.length()<=1) {
			return true;
		}
		// reversing the string
		String n="";
		for (int i=s.length()-1; i>=0; i--) {
			n = n + s.charAt(i);
		}
		if (s.equals(n)){
			return true;
		}
		else{
			return false;
		}
	}
}
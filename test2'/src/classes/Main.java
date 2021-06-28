package classes;

class Number {
	int n1 = 1, n2 = 2;
	int sum;
	
	public int sums() {
		return sum = n1 + n2;
	}
}

class Main {
	public static void main (String [] arguments) {
		  Number n = new Number();
		  n.sums();
		  System.out.println(n.sum);
	 }

	private static int add(int n1, int n2) {
		  int sum = n1 + n2;
		  
		  return sum;
	  }
	}
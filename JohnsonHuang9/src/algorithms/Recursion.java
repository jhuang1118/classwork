package algorithms;

public class Recursion {
	 public static void main(String[] args){
		 int value = 6;
		 /*System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");*/
		 //System.out.println(fibonacci(value));
		 hanoi(4,"A", "B", "C");
	 }

	public static int countPrimeFactors(int value, int testPrime) {
		if(value == testPrime) {
			return 1;
		}
		else if(value % testPrime == 0) {
			value = value / testPrime;
			return 1 + countPrimeFactors(value, testPrime);
		}else {
			return countPrimeFactors(value, testPrime + 1);
		}
		
	}

	public static int factorial(int value) {
		if(value == 0) {
			return 1;
		} else return value * (factorial(value - 1));
	}
	
	public static int fibonacci(int term) {
		if(term <= 2) {
			return 1;
		} else return fibonacci(term-1) + fibonacci(term-2);
	}
	public static void hanoi(int n, String start, String help, String end) {
		if(n == 1) {
			System.out.print(start + " --> " + end + "\n");
		}
		else {
			hanoi(n - 1, start, end, help);
			System.out.print(start + " --> " + end + "\n");
			hanoi(n - 1, help, start, end);
		}
	}
}

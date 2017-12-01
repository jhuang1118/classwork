package algorithms;

public class Recursion {
	 public static void main(String[] args){
		 int value = 6;
		 System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
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
}

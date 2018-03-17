public class Fibonacci {

   public static void main(String[] args) { 
      int num = 11;
      System.out.println("Val 11 returns fib value of: " + fibonacii(num));
   }

   public static int fibonacii(int n) {
      if (n <= 0) { 
         return 0;
      } else if (n==1) {
         return 1;
      } else {
         return fibonacii(n-1) + fibonacii(n-2);
      }
   }
}

    /* package Recursion;
    */
    public class Factorial {
    
        public static int factorial(int n){

            int fact = n;
            if(n > 1){

            fact = fact * factorial(n - 1);

            return fact;
        }

            return fact;
    }
        
        public static void main(String[] args) {
            
            System.out.println(factorial(4));;
        }
    }

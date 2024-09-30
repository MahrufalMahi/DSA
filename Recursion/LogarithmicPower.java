    public class LogarithmicPower {
        
        public static int logarithmicPow(int x, int n){

            if(n == 0){

                return 1;
            }
            int result = logarithmicPow(x, n/2) * logarithmicPow(x, n/2);

            if(n % 2 == 1){

                result *= x;
            }

            return result;
        }

        public static void main(String[] args) {
            
            System.out.println(logarithmicPow(5, 3));
        }
    }

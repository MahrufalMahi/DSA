/* package Recursion;
 */
public class XPowerN {

    public static int power(int x, int n){

        int res = x;
        if(n <= 1){

            return res;

        }

        res = res * power(x,n-1);

        return res;
    }

    public static void main(String[] args) {
        
        System.out.println(power(5, 3));
    }
    
}

/* package Recursion;
 */
public class PrintDecreasingIncreasing {
    
    public static void pdi(int n){
 
        if(n < 1){
            return;
        }
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        pdi(4);
    }
}

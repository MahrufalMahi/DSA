/* package Recursion;
 */
public class PrintDecreasing {
    
    public static void printDecreasing(int n){

        if(n < 1){ 
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void main(String[] args) {
        
        printDecreasing(10);
    }
}

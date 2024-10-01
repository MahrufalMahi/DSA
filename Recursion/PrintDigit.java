public class PrintDigit {
    
    public static String[] arr = {"zero","one", "two","three","four","five","six","seven", "eight","nine"};

    public static void printDig(int n){

        if(n == 0){
       
            
            return;
        }

        printDig(n / 10);
        System.out.println(arr[n%10]);


    }

    public static void main(String[] args) {
        
        printDig(4580);
    }
}

public class FibonacciSeries {
    
public static int printNth(int n){


    if(n == 1){
        return 0;
    }
    if(n == 2){
        return 1;
    }

    return printNth(n - 1) + printNth(n - 2);

   
}

public static void main(String[] args) {
    
    for(int i = 1; i <= 8; i++){

        System.out.println(printNth(i));
    }
}
}

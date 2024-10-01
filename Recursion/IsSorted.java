public class IsSorted {
    
    public static boolean isSorted(int arr[], int i){

        if(i >= arr.length - 1){
            return true;

        }
        if(arr[i] < arr[i - 1]){
 
            return false;
        }

        return isSorted(arr, i+1);
        
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 3, 2, 4, 5};

        // Test cases
        System.out.println("Array 1 is sorted: " + isSorted(arr1, 1));  // true
        System.out.println("Array 2 is sorted: " + isSorted(arr2, 1));  // false
        System.out.println("Array 3 is sorted: " + isSorted(arr3, 1));  // false
    }

}

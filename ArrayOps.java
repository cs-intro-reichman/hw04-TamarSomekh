public class ArrayOps {
    public static void main(String[] args) {
        System.out.println(findMissingInt(new int[] {2,3,1}));
        System.out.println(secondMaxValue(new int[] {2,8,3,7,8}));
        System.out.println(containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3}));
        System.out.println(isSorted(new int[] {1, -2, 3}));
    }
    
    public static int findMissingInt (int [] array) {
        int missing = 0;
        int bigSum = 0;
        for(int i = 0; i <= array.length; i++){
            bigSum = bigSum +i;
        }
        
        int sum = sum(array);
        
        missing = bigSum - sum;
        return missing;
    }

    public static int secondMaxValue(int [] array) {
        //finding the max value
        int max = maxVal(array);
     
        //removing the max value from array
        int[] newArr = new int[array.length - 1];
        int index = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != max){
                newArr[index] = array[i];
                index++;
            }else{
               maxCount++;
            }
        }

        //finding the second max value
        int secondMax;
        if (maxCount != 1) {
            secondMax = max;
        }else{
            secondMax = maxVal(newArr);
        }
    
        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        //going through the arrays 
        //and using the function contains to check if the values are the same
        boolean areSame1 = true;
        for (int i = 0; i < array1.length; i++){
            if (contains(array2, array1[i]) == true) {
                areSame1 = true;
            }else{
                areSame1 = false;
                break;
            }
        }

        boolean areSame2 = true;
        for (int i = 0; i < array2.length; i++){
            if (contains(array1, array2[i]) == true) {
                areSame2 = true;
            }else{
                areSame2 = false;
                break;
            }
        }
        
        if (areSame1 == areSame2) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean isSorted(int [] array) {
        boolean goingUp = true;
        for (int i = 0; i < array.length; i++){
            if (i == array.length - 1) {
                goingUp = true;
            }else{
                if (array[i] <= array[i+1]) {
                    goingUp = true;
                }else{
                    goingUp = false;
                    break;
                }
            }  
        }

        boolean goingDown = true;
        for(int i = 0; i < array.length; i++){
            if (i == array.length -1) {
                goingDown = true;
            }else{
                if (array[i] >= array[i+1] ) {
                    goingDown = true;
                }else{
                    goingDown = false;
                    break;
                }
            }
        }
        
        if (goingDown == true || goingUp == true) {
            return true;
        }else{
            return false;
        }  
    }


    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }


    public static boolean contains(int[] array, int value){
        //a function that checks if an array contains a value
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    //function that finds maximum value in an array
    public static int maxVal(int[] array){
        int max = array[0];
         for(int i = 0; i < array.length; i++){
            if ((array[i] > max)) {
                max = array[i];
            }
        }
        return max; 
    }
    //function that finds minimum value in an array
    public static int minVal(int[] array){
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if ((array[i] < min)) {
                min = array[i];
            }
        }
        return min;
    }
}

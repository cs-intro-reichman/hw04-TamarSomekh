public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //System.out.println(capVowelsLowRest("vowels are fun"));
        //System.out.println(lowerCase("TAMAR"));
        //System.out.println(UpperThenLower("TAmarSOmekh"));
        System.out.println(camelCase("     Tamar        Somekh hamuda       VEMETUKA wow"));
        allIndexOf("Hello world",'l');
    }

    public static String capVowelsLowRest (String string) {
        String ans = "";
        char ch = ' ';

        for(int i = 0; i < string.length(); i++){
            ch = string.charAt(i);
            //checking if ch is a spacer
            if (ch == 32) {
                ans = ans + (char)(ch);
            //checking if ch is a vowel
            }else if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
                //checking if its uppercase
                if (ch <= 'A' && ch >= 'Z') {
                    ans = ans + (char)(ch);
                //if not uppercase - changing it
                }else{
                    ans = ans + (char)(ch - 32);
                }
            }else{
                //if the regular letter is uppercase - lower it
                if (ch <= 'A' && ch >= 'Z') {
                    ans = ans + (char)(ch + 32);
                }else{
                    ans = ans + (char)(ch);
                }
            }
        }
        return ans;
    }

    public static String camelCase (String string) {
        String ans = "";
        
        
        //finding index of first space
        int firstSpace = string.indexOf(' ');
        
        //cleaning up spaces in begining
        while (firstSpace == 0) {
            string = string.substring(1);
            firstSpace = string.indexOf(' ');
        }
        
        //if the sentence is one word
        //change it to lowercase and stop
        if (firstSpace == -1) {
            ans = lowerCase(string);
        
        //changing the first word and saving it in ans
        }else{
            //adding the first word to ans
            String firstWord = string.substring(0, (firstSpace));
            firstWord = lowerCase(firstWord);
            ans = ans + firstWord;
            
            String restOfSen = string.substring(firstSpace + 1);
            String currentWord = "";
            
            firstSpace = restOfSen.indexOf(' ');
            boolean moreWords = true;
            //a loop that will go through the rest of the sentence    
            while (moreWords == true){
                //erasing spaces between words
                if (firstSpace == 0) {
                    restOfSen = restOfSen.substring(1);
                }else{
                    //defining the next word
                    if (firstSpace != -1) {
                        currentWord = restOfSen.substring(0, (firstSpace));
                    //defining what happens in the last word
                    }else{
                        currentWord = restOfSen;
                        moreWords = false;
                    }
                    //fixing the letters and adding to ans
                    currentWord = UpperThenLower(currentWord);
                    ans = ans + currentWord;
                    restOfSen = restOfSen.substring(firstSpace + 1); 
                    
                }
                firstSpace = restOfSen.indexOf(' ');
                
            }
        }
        return ans;

    }

    public static int[] allIndexOf (String string, char chr) {
        int arraySize = 0;
        for(int i = 0; i < string.length(); i++){
            if (string.charAt(i) == chr) {
                arraySize++;
            }
        }
        int arrayIndex = 0;
        String str = "output: {";
        int[] arr = new int[arraySize];
        for(int j = 0; j < string.length(); j++){
            if (string.charAt(j) == chr) {
                arr[arrayIndex] = j;
                if (arrayIndex != 0){
                    str = str + ", " ;
                }
                str = str + j;
                arrayIndex++;
            }
        }
        str = str + "}";
        System.out.println(str);
        return arr;
    }

    public static String lowerCase(String s) {
        
        String ans = "" ;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            //checking if ch is a letter
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                //if the letter is uppercase
                //changing it to lowercase
                if (ch >= 'A' && ch <= 'Z') {
                    ans = ans + (char) (s.charAt(i) + 32); 
                }
                else{
                    ans = ans + ch;
                }
                
            // if ch isnt a letter, add it to the string    
            } else {
                ans = ans + ch;
            }
            
            i++;
        }

        return ans;
    }

    public static String UpperThenLower (String s){
        String ans = "" ;
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z' ) {
            ans = ans + (char) (s.charAt(0) - 32);
        }else{
            ans = ans + (char) (s.charAt(0));
        }
        
        int i = 1;
        while (i < s.length()) {
            char ch = s.charAt(i);
            //checking if ch is a letter
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                //if the letter is uppercase
                //changing it to lowercase
                if (ch >= 'A' && ch <= 'Z') {
                    ans = ans + (char) (s.charAt(i) + 32); 
                }
                else{
                    ans = ans + ch;
                }
                
            // if ch isnt a letter, add it to the string    
            } else {
                ans = ans + ch;
            }
            
            i++;
        }

        return ans;
    }
}

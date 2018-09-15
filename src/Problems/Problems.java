package Problems;

import java.util.HashMap;

public class Problems {

    public static String reverseString(String input)
    {
        /*char[] array = input.toCharArray();
        StringBuilder builder = new StringBuilder();

        for(int i=array.length-1;i>=0;i--){
            builder.append(array[i]);
        }

        return builder.toString();
        */

        char[] arr = input.toCharArray();
        String reversed = "";

        for( char a : arr){
            reversed = a + reversed;
        }

        return reversed;
    }

    public static boolean isPalindromeSolutionOne(String input){
        return reverseString(input).equals(input);
    }

    public static boolean isPalindromeSolutionTwo(String input){
        String reversedInput = reverseString(input);
        int inputLength = input.length();
        int counter = 0;
        boolean result = true;
        while(counter < inputLength){

            if( reversedInput.charAt(counter) != input.charAt(counter) ){
                result = false;
            }
            counter++;
        }

        return result;
    }

    public static boolean isPalindromeSolutionThree(String input){
        int length = input.length();

        for(int i=0;i<length;i++){
            if(input.charAt(i) != input.charAt(length-1-i)){
                return false;
            }
        }

        return true;
    }

    public static int reverseIntSolutionOne(int input){

        int result = 0;
        while(input / 10 != 0 || input % 10 != 0){
            int a = input % 10 ;
            input /= 10;
            result = (10*result) + a;
        }

        return result;
    }

    public static int reverseIntSolutionTwo(int input)
    {
        String reverse = reverseString("" + input);
        reverse = reverse.replace("-","");
        return Integer.parseInt(reverse) * ( input > 0 ? 1 : -1 );
    }



    public static char maxChars(String input){

        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = input.toCharArray();
        int maxCounter = -99999;
        char result = ' ';
        for(char item  : arr){
            if(map.containsKey(item))
            {
                map.put(item,map.get(item) +1);
                if(map.get(item) > maxCounter)
                {
                    maxCounter = map.get(item);
                    result = item;
                }
            }else{
                map.put(item,1);
            }
        }

        return result;

    }

    public static void fizzbuzzProblem(int val)
    {
        final int fizz = 3;
        final int buzz = 5;
        final int fizzbuzz = 15;

        for(int i=1;i<=val;i++){

            if( i % fizzbuzz == 0)
            {
                System.out.println("fizzbuzz");
            }else if( i % buzz == 0){
                System.out.println("buzz");
            }else if( i % fizz == 0){
                System.out.println("fizz");
            }else{
                System.out.println(i);
            }
        }
    }

    public static void arrayChunkProblem(int[] arr,int dividerSize){

        int chunkSize =  (arr.length / dividerSize) + ( arr.length % dividerSize == 0 ?  0 : 1);
        int counterRow = 0;
        String[] chucksValues = new String[chunkSize];
        for(int i=0;i<arr.length;i++){
            if( i % dividerSize == 0 && i != 0){
                chucksValues[counterRow] = chucksValues[counterRow].replace("null","").trim();
                counterRow++;
            }
            chucksValues[counterRow] += arr[i] + " ";
        }
        chucksValues[counterRow] = chucksValues[counterRow].replace("null","").trim();
        String [][] matrix = new String[chunkSize][];
        for(int i=0;i<chunkSize;i++)
        {
            matrix[i] = new String[ chucksValues[i].trim().split(" ").length];
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j < matrix[i].length;j++)
            {
                matrix[i][j] = chucksValues[i].split(" ")[j];
            }
        }

        for(int i=0;i<matrix.length;i++)
        {
            System.out.print("[");
            for(int j=0;j < matrix[i].length;j++)
            {
                if(j == matrix[i].length -1){
                    System.out.print(matrix[i][j]);
                    continue;
                }
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print("]");
            System.out.println();
        }

    }

}

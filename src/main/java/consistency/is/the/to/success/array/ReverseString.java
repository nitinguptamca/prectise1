package consistency.is.the.to.success.array;

import consistency.is.the.to.success.ds.generalTree.GeneraliseTree;

import java.util.Arrays;

public class ReverseString {
  static   String input ="abc*%de$#zx%&";
  static   char[] charArray=input.toCharArray();
    public static void main(String[] args) {
       int i=0 , k= charArray.length-1;
       while (i<=k){
           if(isSpecialCharacter(charArray[i])) i++;
           else if(isSpecialCharacter(charArray[k])) k--;
           else{
               swap( i ,k);
               i++;
               k--;
           }
       }
        System.out.println(Arrays.toString(charArray));
    }

    private static void swap(int i, int k) {
        char temp =charArray[i];
        charArray[i] =charArray[k];
        charArray[k]=temp;
    }

    public static boolean isSpecialCharacter(char ch){
        if(!Character.isAlphabetic(ch)) return true;
        else return false;
    }
}

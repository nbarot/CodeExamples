package interviewcoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nirav_000 on 4/1/2016.
 */
public class StringPermutations {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine() ;
//        List<String> perm = new ArrayList<>(0);
//        char temp ;
//        char[] charArray = str.toCharArray();
//        char[] copyArray = new char[str.length()];
//        for(int i = 0 ; i < str.length() ; i++){
//            copyArray[i] = charArray[str.length() - 1] ;
//            charArray[0] = ;
//            charArray[str.length() - 1] = temp ;
//        }
//
//        if(str.length() >= 2){
//            perm = generatePermutations(str);
//        }
//        else {
//            perm.add(str);
//        }
//
//        System.out.println(perm);
//    }
//
//    private static List<String> generatePermutations(String str) {
//        char[] charArray = str.toCharArray();
//        List<String> tempPermuList = new ArrayList<>();
//        if(str.length() == 2) {
//            tempPermuList = getPermutations(str) ;
//        }
//        List<String> finalList = new ArrayList<>();
//
//        for(int i = 2 ; i < str.length() ; i++){
//           for(String s : tempPermuList){
//               StringBuilder sb = new StringBuilder();
//               sb.append(str.substring(0,str.length() - i));
//               sb.append(s);
//               finalList.add(sb.toString());
//           }
//        }
//
//       return finalList;
//    }
//
//    private static List<String> getPermutations(String str) {
//        List<String> permutationList = new ArrayList<>();
//        char[] charArray = str.toCharArray();
//        permutationList.add(str);
//        char temp = charArray[0];
//        charArray[0] = charArray[1];
//        charArray[1] = temp;
//        permutationList.add(String.copyValueOf(charArray));
//
//        return permutationList;
//    }
}

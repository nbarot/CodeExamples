package interviewcoding;

import java.util.Scanner;

/**
 * Created by nirav_000 on 4/10/2016.
 */
public class BuildSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        buildSubsequences(inputString);
    }

    static void buildSubsequences(String s) {
        String[] strArray = new String[100000];
        int k = 0;
        for(int i = 0 ; i < s.length() ; i++){
            strArray[k++] = String.valueOf(s.charAt(i));
            String str = s.substring(i);
            for(int j = 0 ; j < str.length() ; j++){
                strArray[k++] = str.replace(String.valueOf(str.charAt(j)),"");
            }
        }

        for(int x = 0 ; x < strArray.length ; x++){

            if(strArray[x] == null)
                break;

            System.out.println(strArray[x]);
        }

    }

    private static String getSubstring(String s, int j) {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0 ; i < s.length() ; i++){
            if(i == j){
                continue;
            }
            else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }


}

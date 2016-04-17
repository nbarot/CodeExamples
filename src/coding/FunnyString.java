package interviewcoding;

import java.util.Scanner;

/**
 * Created by nirav_000 on 2/21/2016.
 */
public class FunnyString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int samples = sc.nextInt();
        sc.nextLine();
        for(int i = 1 ; i <= samples ; i++){
            isFunnyString(sc.nextLine());
        }
    }

    private static void isFunnyString(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        boolean funny = true ;

        for(int i = 1 ; i < str.length()-1 ; i++){
            System.out.println("str.charAt(i) : " + str.charAt(i) + " str.charAt(i-1) : " + str.charAt(i-1) + " str.charAt(i) - str.charAt(i-1) : " + (str.charAt(i) - str.charAt(i-1)));
            System.out.println("reverse.charAt(i) : " + reverse.charAt(i) + " reverse.charAt(i-1) : " + reverse.charAt(i-1) + " (reverse.charAt(i) - reverse.charAt(i-1) : " + (reverse.charAt(i) - reverse.charAt(i-1)) );
            if(Math.abs(str.charAt(i) - str.charAt(i - 1)) == Math.abs(reverse.charAt(i) - reverse.charAt(i-1))){
                continue;
            }
            else {
                funny = false;
                break;
            }

        }
        System.out.println(funny ? "Funny" : "Not Funny");
    }
}

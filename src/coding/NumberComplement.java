package interviewcoding;

import java.util.Scanner;

/**
 * Created by nirav_000 on 4/10/2016.
 */
public class NumberComplement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getIntegerComplement(n));
    }

    static int getIntegerComplement(int n) {

        String decToBinary = getBinary(n);

        String binaryComplement = getBinaryComplement(decToBinary);

        return getBinaryComplementToDecimal(binaryComplement);
    }

    private static int getBinaryComplementToDecimal(String binaryComplement) {

        int decimal = 0;
        int power = 0;
        int binaryInt = binaryComplement.equals("") ? 0 : Integer.parseInt(binaryComplement);
        while(true){
            if(binaryInt == 0){
                break;
            } else {
                int tmp = binaryInt%10;
                decimal += tmp*Math.pow(2, power);
                binaryInt = binaryInt/10;
                power++;
            }
        }
        System.out.println(decimal);
        return decimal;
    }

    private static String getBinaryComplement(String decToBinary) {
        StringBuilder binaryComeplement = new StringBuilder("");
        for(int i = decToBinary.length()-1 ; i >= 0  ; i--){
            if(decToBinary.charAt(i) == '1'){
                binaryComeplement.append("0");
            }
            else
            {
                binaryComeplement.append("1");
            }
        }
        System.out.println(binaryComeplement);
        return binaryComeplement.toString();
    }

    private static String getBinary(int n) {

        StringBuilder binary = new StringBuilder("");

        if(n == 0){
            binary.append("0");
        }

        while(n > 0){
            int rem = n % 2 ;
            binary.append(rem);
            n = n / 2 ;
        }
        System.out.println(binary);

        return binary.toString() ;
    }

}

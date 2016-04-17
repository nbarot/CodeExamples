package interviewcoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by nirav_000 on 2/15/2016.
 */
public class NumberToWord {

    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//
//        for (int i = number; i > 1; i--) {
//            int j = 1;
//
//            for (j = 1; j < i; j++) {
//                System.out.print(" ");
//            }
//           for(int k = j ; k <= number ; k++){
//               System.out.print("#");
//           }
//            System.out.println("\n");
//        }


        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= count; i++) {
            String A = scanner.nextLine();
            String B = scanner.nextLine();
            isCommonSubString(A, B) ;
        }
    }

    private static void isCommonSubString(String A, String B) {
        char[] arrayA = A.toCharArray();
        String flag = "NO" ;
        for (char c : arrayA) {
            if(A.indexOf(c) > -1 && B.indexOf(c) > -1) {
                flag = "YES";
                break;
            }
        }
        System.out.println(flag);


//        Scanner s = new Scanner(System.in);
//        List<Integer> list1 = readNumbersFromCommandLine(s);
//        List<Integer> list2 = readNumbersFromCommandLine(s);
//        long start = System.currentTimeMillis();
//        Map<Integer,Integer> mapOccList1 = createMap(list1);
//        Map<Integer,Integer> mapOccList2 = createMap(list2);
//
//        printMissingNumber(mapOccList1, mapOccList2);
//        System.out.println("Alt #1 took "+(System.currentTimeMillis()-start)+" ms");
    }

    private static Map<Integer, Integer> createMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : list){
            int count = 1;
            if(map.containsKey(i)){
                count = map.get(i);
                count++;
                map.put(i,count);
            }
            else {
                map.put(i, count);
            }
        }
        return map;
    }

    private static void printMissingNumber(Map<Integer,Integer> mapOccList1, Map<Integer,Integer> mapOccList2) {

        Set<Integer> missingNumberSet = new TreeSet<>();
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(mapOccList2.entrySet());
        for(Map.Entry<Integer,Integer> entry : list){

            int val1 = mapOccList1.get(entry.getKey());
            int val2 = entry.getValue();

            if(val1 == val2){
                continue;
            }
            else {
                missingNumberSet.add(entry.getKey());
            }

        }

        Iterator<Integer> iterator = missingNumberSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }

    public static List<Integer> readNumbersFromCommandLine(Scanner s) {

        List<Integer> numbers = new ArrayList<>();
        try {
            int count = s.nextInt();
            s.nextLine(); // throw away the newline.
            int i = 0;
            for (String numStr : s.nextLine().split("\\s")) {
                numbers.add(Integer.parseInt(numStr));
                i++;
            }
            if (i != count) {
                System.out.println("You didn't provide enough numbers");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return numbers;
    }
}
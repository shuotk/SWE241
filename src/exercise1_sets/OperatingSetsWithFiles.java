package exercise1_sets;

import exercise1_sets.BinaryTreeSet;
import exercise1_sets.HashTableSet;
import exercise1_sets.LinkedListSet;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OperatingSetsWithFiles {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/exercise1_sets/pride-and-prejudice.txt"));
        Scanner sc2 = new Scanner(new File("src/exercise1_sets/words-shuffled.txt"));
        PrintWriter llsOut = new PrintWriter("src/exercise1_sets/lls.txt");
        PrintWriter btsOut = new PrintWriter("src/exercise1_sets/bts.txt");
        PrintWriter htsOut = new PrintWriter("src/exercise1_sets/hts.txt");

        LinkedListSet linkedListSet = new LinkedListSet();
        BinaryTreeSet binaryTreeSet = new BinaryTreeSet();
        HashTableSet hashTableSets = new HashTableSet();

        try {
            while (sc.hasNextLine()) {
                String nextLine = removeSpChar(sc.nextLine());
                String[] words = nextLine.split("\\s+");
                for (String each : words) {
                    //System.out.println(each);
                    if(!each.isEmpty()) {
                        long time = llsAdd(linkedListSet, each);
                        if(time != -1) llsOut.println(time);
                        time = btsAdd(binaryTreeSet, each);
                        if(time != -1) btsOut.println(time);
                        time = htsAdd(hashTableSets, each);
                        if(time != -1) htsOut.println(time);
                    }
                }
            }
            int count_lls = 0;
            int count_bts = 0;
            int count_hts = 0;
            while (sc2.hasNextLine()){
                String next = sc2.nextLine();
                if(!linkedListSet.contains(next)){
                    count_lls++;
                }
                if(!binaryTreeSet.contains(next)){
                    count_bts++;
                }
                if(!hashTableSets.contains(next)){
                    count_hts++;
                }
            }
            System.out.println("Words in sets:\nlls:" + linkedListSet.size() + "\nbts: " + binaryTreeSet.size() + "\nhts: " + hashTableSets.size());
            System.out.println("Words do not exists in sets:\nlls: " + count_lls + "\nbts: " + count_bts + "\nhts: " + count_hts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
            llsOut.close();
            btsOut.close();
            htsOut.close();
        }
    }

    private static long llsAdd(LinkedListSet lls, String input){
        long st = System.nanoTime();
        if(lls.add(input)){
            return System.nanoTime() - st;
        } else return -1;
    }

    private static long btsAdd(BinaryTreeSet bts, String input){
        long st = System.nanoTime();
        if(bts.add(input)){
            return System.nanoTime() - st;
        } else return -1;
    }

    private static long htsAdd(HashTableSet hts, String input){
        long st = System.nanoTime();
        if(hts.add(input)){
            return System.nanoTime() - st;
        } else return -1;
    }

    private static String removeSpChar(String input){
        String result = input.replaceAll("[^\\w\\d ]", " ");
        return result;
    }
}

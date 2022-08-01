package homework18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> hs = new HashSet<>();
        Set<Integer> lhs = new LinkedHashSet<>();
        Set<Integer> ts = new TreeSet<>();
        int number = 10;
        System.out.print("Rnd:[");
        for (int i = 0; i < number; i++) {
            Integer randomNumber = (int) (Math.random() * 100);
            hs.add(randomNumber);
            lhs.add(randomNumber);
            ts.add(randomNumber);
            System.out.print(randomNumber + ", ");

        }
        System.out.println("]");
        printRND(hs,lhs,ts);
        removeEvenFromLHS(lhs);
        printRND(hs,lhs,ts);
        ts.removeAll(lhs);
        printRND(hs,lhs,ts);

        lhs.retainAll(ts);
        System.out.println(" ");
        printRND(hs,lhs,ts);
        lhs.addAll(hs);
        System.out.println(" ");
        printRND(hs,lhs,ts);

    }

    public static void printRND(Set<Integer> hs,Set<Integer> lhs,Set<Integer> ts) {
        System.out.println("HS: "+hs);
        System.out.println("LHS:"+lhs);
        System.out.println("TS: "+ts);
    }

    public static void removeEvenFromLHS(Set<Integer> lhs){
        Iterator<Integer> iterator = lhs.iterator();
            while (iterator.hasNext()){
                if(iterator.next() %2 == 0){
                    iterator.remove();
                }
            }

    }
}

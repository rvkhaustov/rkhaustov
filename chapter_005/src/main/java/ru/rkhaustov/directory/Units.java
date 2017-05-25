package ru.rkhaustov.directory;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by rvkha_000 on 25.05.2017.
 */
public class Units {

    /**
     * @param lists units
     * @return sort ASC
     */
    public Set<String> sortASC(Collection<String> lists) {
        Set<String> sets = new TreeSet<>(lists);
        return  addUnits(lists, sets);
    }

    /**
     * @param lists units
     * @return sort DESC
     */
    public Set<String> sortDESC(Collection<String> lists) {
        Set<String> sets = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareTo(o1, o2);
            }
        });
        sets.addAll(lists);
        return  addUnits(lists, sets);
    }

    /**
     * @param lists units
     * @param sets collection set
     * @return add unit
     */
    public Set<String> addUnits(Collection<String> lists, Set<String> sets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String list : lists) {
            for (String unit : list.split("\\\\")) {
                stringBuilder.append(unit);
                sets.add(stringBuilder.toString());
                stringBuilder.append("\\");
            }
            stringBuilder.delete(0, stringBuilder.length());
        }
        return sets;
    }

    /**
     * @param o1 first unit
     * @param o2 seconf unit
     * @return -1 o1 > o2 ; 1 o1 < o2 ; 0 o1 == o2
     */
    public int compareTo(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        int lim = Math.min(len1, len2);
        char[] v1 = o1.toCharArray();
        char[] v2 = o2.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c2 - c1;
            }
            k++;
        }
        return len1 - len2;
    }
//    public static void main(String[] args) {
//
//        List<String> lists = new ArrayList<>();
//        lists.addAll(Arrays.asList("K1\\SK1",
//                "K1\\SK2",
//                "K1\\SK1\\SSK1",
//                "K1\\SK1\\SSK2",
//                "K2",
//                "K2\\SK1\\SSK1",
//                "K2\\SK1\\SSK2"
//        ));
//        List<String> expected = new ArrayList<>();
//        expected.addAll(Arrays.asList(
//                "K2",
//                "K2\\SK1",
//                "K2\\SK1\\SSK2",
//                "K2\\SK2\\SSK1",
//                "K1",
//                "K1\\SK2",
//                "K1\\SK1",
//                "K1\\SK1\\SSK2",
//                "K1\\SK1\\SSK1"
//
//        ));
//        System.out.println(new Units().sortDESC(lists));
//        System.out.println(expected);
//
////        char c = '1';
////        System.out.println((int)c);
//        System.out.println(new Units().sortASC(lists));
//
////        Set<String> sets = new TreeSet<>(lists);
////        StringBuilder stringBuilder = new StringBuilder();
////        for(String list : lists) {
////            for(String unit : list.split("\\\\")) {
////                stringBuilder.append(unit);
////                sets.add(stringBuilder.toString());
////                stringBuilder.append("\\");
////            }
////            System.out.println(stringBuilder);
////            stringBuilder.delete(0,stringBuilder.length());
////        }
//
//
//
//
//    }


}

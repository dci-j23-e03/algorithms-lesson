import java.util.*;

public class MemoryAlgorithms {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(1000);
        for (int i = 1; i <= 1000; i++) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>(list1);

        long start = System.currentTimeMillis();
        List<Boolean> result1 = compareLists1(list1, list2);
        long end = System.currentTimeMillis();
//        System.out.println(result1);
        System.out.println("Algorithm 1: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        List<Boolean> result2 = compareLists2(list1, list2);
        end = System.currentTimeMillis();
//        System.out.println(result2);
        System.out.println("Algorithm 2: " + (end - start) + " ms");
    }

    static List<Boolean> compareLists1(List<Integer> list1, List<Integer> list2) {
        int n = list1.size();
        int m = list2.size();
        Map<Integer, Map<Integer, Integer>> a = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> b = new HashMap<>();
            for (int j = 0; j < m; j++) {
                b.put(list2.get(j), list1.get(i));  // list1 element as key, list2 element as value
            }
            a.put(list1.get(i), b);
        }
        List<Boolean> c = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> aItem : a.entrySet()) {
            List<Boolean> d = new ArrayList<>();
            for (Map.Entry<Integer, Integer> bItem : aItem.getValue().entrySet()) {
                d.add(bItem.getKey().equals(bItem.getValue()));
            }
            c.addAll(d);
        }
        return c;
    }

    static List<Boolean> compareLists2(List<Integer> list1, List<Integer> list2) {
        List<Boolean> a = new ArrayList<>();
        for (Integer i : list1) {
            for (Integer j : list2) {
                a.add(Objects.equals(i, j));
            }
        }
        return a;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> inputList = new ArrayList<>(100000);
        for (int i = 1; i <= 100000; i++) {
            inputList.add(i);
        }

        long start = System.currentTimeMillis();
        List<Integer> result1 = prefixAverages1(inputList);
        long end = System.currentTimeMillis();
        System.out.println("Algorithm 1: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        List<Integer> result2 = prefixAverages2(inputList);
        end = System.currentTimeMillis();
        System.out.println("Algorithm 2: " + (end - start) + " ms");

//        System.out.println(result1.equals(result2));
//        printList(result1);
//        printList(result2);
    }

    static void printList(List<Integer> list) {
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static List<Integer> prefixAverages2(List<Integer> list) {
        List<Integer> a = new ArrayList<>();
        int n = list.size();
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += list.get(i);
            a.add(s / (i + 1));
        }
        return a;
    }

    static List<Integer> prefixAverages1(List<Integer> list) {
        List<Integer> a = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < i + 1; j++) {
                s += list.get(j);
            }
            a.add(s / (i + 1));
        }
        return a;
    }
}
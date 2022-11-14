package GenericLab4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(13, 42, 73, 69, -66);
        //List<Integer> integers = new ArrayList<>();

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));
    }
}

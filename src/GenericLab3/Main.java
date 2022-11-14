package GenericLab3;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a", "z");
        System.out.println(scale.getHeavier());

        Scale<Integer> scale2 = new Scale<>(55, 12);
        System.out.println(scale2.getHeavier());
    }
}

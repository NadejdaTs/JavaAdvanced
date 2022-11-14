package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] command = sc.nextLine().split(", ");

        Map<String, LinkedHashMap<String, Double>> products = new TreeMap<>();
        while(!command[0].equals("Revision")){
            String shop = command[0];
            String product = command[1];
            double price = Double.parseDouble(command[2]);

            if(!products.containsKey(shop)){
                products.put(shop, new LinkedHashMap<>());
            }
            products.get(shop).put(product, price);

            command = sc.nextLine().split(", ");
        }

        products.entrySet().stream()
                .forEach((pair) -> {
                    System.out.printf("%s->%n", pair.getKey());
                    pair.getValue().entrySet().stream()
                            .forEach((e) -> {
                                System.out.printf("Product: %s, Price: %.1f%n", e.getKey(), e.getValue());
                            });
                });
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/*  Переносим в отдельный класс (Data)
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
*/

/*  Пока перенесем в Purchase
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : Data.products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end");
*/
        var purchase = new Purchase();
        purchase.printShowCase();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);
        }
/* Тоже пихнем в Purchase
        long sum = purchase.sum(Data.products);
        System.out.println("ИТОГО: " + sum);
*/
        purchase.printPurchases();
    }
}

import java.util.HashMap;
import java.util.Map;

public class Purchase {
    // Внутренние переменные были протектед - неправильно же?
    // Да и вообще не особо они и нужны
/*
    private String title;
    private int count;
*/
    // Вот тут точно нарушение - константа цифрой
    // protected Purchase[] purchases = new Purchase[4];

    // Да и вообще, раз начали через  МАПы делать, то и будем через МАПы
    private final Map<String, Integer> products;
    private final Map<String, Integer> purchases = new HashMap<>();



/* Не вижу смысла в данном конструкторе
    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }
*/

    /**
     * В конструкторе задается источник данный на этапе кодирования<br>
     * Конструктор инициализирует локальную копию ассортимента
     */
    public Purchase() {
        // Dependency Inversion Principle - в принципе сюда подходит
        // описываем интерфейс, скрывая реализацию (может там вообще SQL)
        DataBase dataBase = Data.getInstance();
        products = dataBase.getProducts();
    }

    public void addPurchase(String title, int count) {
        // Тут как всегда - добавляем или апдейтим энтри продаж
        purchases.put(title, purchases.getOrDefault(title, 0) + count);
/* Может тут и не было особых нарушений, но мы же решили работать через МАПы
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
*/
    }

    public void printPurchases() {
/*
        System.out.println("КОРЗИНА:");
        long sum = purchase.sum(Data.products);
        System.out.println("ИТОГО: " + sum);
*/
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Map.Entry<String, Integer> entryMap : purchases.entrySet()) {
            System.out.println("\t" + entryMap.getKey() + " " + entryMap.getValue()
                    + " шт. в сумме " + (entryMap.getValue() * products.get(entryMap.getKey()) + " руб."));
            sum += (long) entryMap.getValue() * products.get(entryMap.getKey());
        }
        System.out.println("ИТОГО: " + sum);
    }

/*
    private long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
*/
    // Перенесено из мейн - печатаем заставку и ассортимент
    public void printShowCase() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end");
    }
}

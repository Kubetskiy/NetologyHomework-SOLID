import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Data implements DataBase {
    public static final Data INSTANCE = new Data();

    private static final Map<String, Integer> products = Map.ofEntries(
            entry("Хлеб", 56),
            entry("Масло", 153),
            entry("Колбаса", 211),
            entry("Пирожок", 45)
    );

    @Override
    public Map<String, Integer> getProducts() {
        return new HashMap<>(products);
    }

    // Экземпляров нам не надо
    private Data() {
    }

    // Внешний "конструктор"
    public static Data getInstance() {
        return INSTANCE;
    }
}

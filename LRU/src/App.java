public class App {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.put(0, "A");
        cache.put(1, "B");
        cache.put(2, "C");
        cache.put(3, "D");
        cache.show();
        System.out.println();
        System.out.println(cache.get(0) + "\n");
        cache.show();
        System.out.println();
        System.out.println(cache.get(1) + "\n");
        cache.show();
        System.out.println();
        cache.put(4, "E");
        cache.show();
        System.out.println();

    }
}

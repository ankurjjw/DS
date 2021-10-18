public class App {
    public static void main(String[] args) {
        Cache<Integer, Integer> c = new Cache<Integer, Integer>();
        c.put(1,100);
        c.put(3, 300);
        c.put(5, 500);
        c.put(6, 600);
        c.put(4, 400);
        c.show();
        c.put(7, 700);
        c.show();
        c.put(5,250);
        c.show();


    }
}

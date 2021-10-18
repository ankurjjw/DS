public class App {
    public static void main(String[] args) {
        BST bs = new BST();

        bs.insert(10);
        bs.insert(5);
        bs.insert(16);
        bs.insert(-3);
        bs.insert(15);
        bs.insert(19);
        bs.insert(13);
        bs.insert(-1);
        bs.insert(7);
        bs.insert(17);
        bs.insert(20);


        bs.BFT();
        System.out.println("***************************************************");
        bs.inorder();
        System.out.println("***************************************************");
        System.out.println("successor: " + bs.findSuccessor(5).getKey());
        System.out.println("predecessor: " + bs.findPredecessor(5).getKey());
        System.out.println("successor: " + bs.findSuccessor(15).getKey());
        System.out.println("predecessor: " + bs.findPredecessor(-1).getKey());
        System.out.println("Max: " + bs.getMax());
        System.out.println("Min: " + bs.getMin());
        System.out.println("***************************************************");
        bs.remove(16);
        bs.BFT();



    }
}

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BSTIterative<Integer> bst = new BSTIterative<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(14);
        bst.insert(16);
        bst.insert(-1);
        bst.insert(7);
        bst.levelOrderTraversal();
    }
}

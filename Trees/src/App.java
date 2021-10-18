public class App {
    public static void main(String[] args) {
        BSTIterative<Integer> bst = new BSTIterative<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(14);
        bst.insert(16);
        bst.insert(-1);
        bst.insert(7);
//        bst.traversal();
        System.out.println(bst.levelOrderTraversal());
//        System.out.println(bst.preOrder());
//        System.out.println(bst.preOrderUsingStack());
//        System.out.println(bst.inOrderUsingStack());
//        System.out.println(bst.postOrder());
//        System.out.println(bst.postOrderUsingStack());







//        bst.findSuccessor(10);
//        bst.findSuccessor(14);
//        bst.findSuccessor(-1);
//        bst.findPredecessor(7);
//        bst.findPredecessor(14);
//        bst.insert(13);
//        bst.levelOrderTraversal();
//        bst.traversal();
//        bst.remove(15);
//        bst.levelOrderTraversal();
//        bst.traversal();










//        BinarySearchTree<Integer> bst2 = new BinarySearchTree();
//        bst2.insert(10);
//        bst2.insert(5);
//        bst2.insert(15);
//        bst2.insert(14);
//        bst2.insert(16);
//        bst2.insert(-1);
//        bst2.traversal();
//        System.out.println();

//        System.out.println(compareTrees(bst.getRoot(), bst2.getRoot()));

//        System.out.println("Your min is - " + bst.getMin());
//        System.out.println("Your max is - " + bst.getMax());
//        bst.remove(-1);
//        bst.traversal();
//        System.out.println();
//        bst.insert(-1);
//        bst.traversal();
//        System.out.println();
//        bst.remove(10);
//        bst.traversal();
//        System.out.println();

    }

    private static Boolean compareTrees(Node<Integer> node1, Node<Integer> node2) {

//        System.out.println("1st " + node1.getData() + " " + node2.getData() + " " + (node1.getData() == node2.getData()));

//        System.out.println(node1 + " " + node2);
        if(node1 ==null && node2 ==null){
            System.out.println("both trees are null :");
            return true;
        }
        System.out.println("1st " + node1.getData() + " " + node2.getData());

        if((node1 != null && node2 != null) && (node1.getData() == node2.getData())){
            System.out.println("2nd " + node1.getData() + " " + node2.getData() + " " + (node1.getData() == node2.getData()));
            return compareTrees(node1.getLeftChild(), node2.getLeftChild()) && compareTrees(node1.getRightChild(), node2.getRightChild());
        } else{
            System.out.println("returning false " + node1.getData() + " " + node2.getData());
            return false;
        }

//        return ((node1.getData() == node2.getData())  &&(node1!=null && node2 !=null) &&
//                compareTrees(node1.getLeftChild(), node2.getLeftChild()) && compareTrees(node1.getRightChild(), node2.getRightChild()));


    }
}

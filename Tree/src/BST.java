import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void BFT(){
        if(root == null){
            System.out.println("No node in this tree");
            return;
        }

        Node current = root;
        Queue<Node> q = new LinkedList<>();
        q.add(current);

        while (!q.isEmpty()){
            Node temp = q.poll();
            System.out.println(temp.getKey());
            if(temp.getLeft()!=null) q.add(temp.getLeft());
            if(temp.getRight()!=null) q.add(temp.getRight());
        }
    }

    public Node search(int key) {
        if (key == root.key) return root;
        Node current = root;
        while (current!= null) {
            if (key < current.getKey()) {
                current = current.left;
            } else if (key > current.getKey()) {
                current = current.right;
            } else break;
        }
        return current;
    }

    public void insert(int key){
        Node newNode = new Node(key);
        Node previous = null;

        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while(current!=null){
            if (key < current.getKey()) {
                previous = current;
                current = current.left;
            } else if (key > current.getKey()) {
                previous = current;
                current = current.right;
            } else break;
        }
        if(key<previous.getKey()){
            previous.setLeft(newNode);
        } else{
            previous.setRight(newNode);
        }

    }

    public void inorder() {
        Node current = root;
        inorderHelper(current);
    }

    private void inorderHelper(Node current) {
        if(current==null) return;
        inorderHelper(current.getLeft());
        System.out.println(current.key);
        inorderHelper(current.getRight());
    }

    public Node findPredecessor(int i){
        if(root == null) return null;

        Node current = root;
        Node previous = null;
        while(current!=null){
            if(i<current.key){
                current=current.left;
            } else if(i>current.key){
                previous=current;
                current=current.right;
            }else{
                break;
            }
        }

        if(current.right==null){
            return previous;
        }else{
            current=current.getLeft();
            while(current.getRight()!=null){
                current=current.getRight();
            }
            return current;
        }
    }

    public Node findSuccessor(int i) {
        if(root == null) return null;

        Node current = root;
        Node previous = null;

        while(current!=null){
            if(i<current.key){
                previous=current;
                current=current.getLeft();
            }else if(i>current.key){
                current=current.getRight();
            } else{
                break;
            }
        }
        if(current.getRight()!=null){
            current=current.getRight();
            while(current.getLeft()!=null){
                current=current.getLeft();
            }
            return current;
        }else{
            return previous;
        }

    }

    public void remove(int i){
        if(root == null) System.out.println("Empty tree!!!");

        Node current = root;
        Node previous = null;

        while(current!=null){
            if(i<current.key){
                previous=current;
                current=current.left;
            }else if(i>current.key){
                previous=current;
                current=current.right;
            }else{break;}
        }
        //no child
        if(current.right==null && current.left==null){
            if(previous.right==current){
                previous.right=null;
            }else{
                previous.left=null;
            }
            current=null;
        } //one child
        else if(current.right!=null && current.left==null){
            System.out.println("previous" + previous.key);
            if(previous.right==current){
                previous.right=current.right;
            }else{
                previous.left=current.right;
            }
            current=null;
        } else if(current.left!=null && current.right==null){
            System.out.println("previous" + previous.key + current.left.key);
            if(previous.right==current){
                previous.right=current.left;
            }else{
                previous.left=current.left;
            }
            current=null;
        } //two child
        else{
            //find successor
            previous = null;
            Node successor = current.right;
            while(successor.left!=null){
                previous = successor;
                successor=successor.left;
            }
            current.key = successor.key;
            if(previous!=null) {
                previous.left=successor.right;
                successor.right = null;
            } else{
                current.right = null;
            }

        }

    }

    public int getMin(){
        Node current = root;
        while(current.left!=null){
            current=current.left;
        }
        return current.key;
    }

    public int getMax(){
        Node current = root;
        while(current.right!=null){
            current=current.right;
        }
        return current.key;
    }
}

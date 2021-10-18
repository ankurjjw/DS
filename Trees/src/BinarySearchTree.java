public class BinarySearchTree <T extends Comparable<T>> implements Tree<T>{
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public void insert(T data) {
        if(root == null){
            Node newNode = new Node(data, null);

            root= newNode;
        } else{
            insert(data, root);
        }

    }

    private void insert(T data, Node<T> node) {
        if(node.getData().compareTo(data)>0){
            if(node.getLeftChild()!=null) {
                insert(data, node.getLeftChild());
            }else{
                node.setLeftChild(new Node<>(data, node));
            }
        }else{
            if(node.getRightChild()!=null) {
                insert(data, node.getRightChild());
            }else{
                node.setRightChild(new Node<>(data, node));
            }
        }
    }

    @Override
    public void remove(T data) {
        if(root == null){
            return;
        }
        System.out.println("Calling remove() recursively");
        remove(data, root);

    }

    private void remove(T data, Node<T> node) {

        if(node.getData().compareTo(data) < 0){
            remove(data, node.getRightChild());
        } else if(node.getData().compareTo(data) > 0){
            remove(data, node.getLeftChild());
        }else{
            //CASE 1 - leaf node
            if(node.getRightChild()==null && node.getLeftChild()==null){
                System.out.println("Inside Case 1");
                System.out.println(node.getData());
                //if this is the root node with no offspring
                if(node.getParentNode() == null){
                    root = null;
                }
                Node<T> parent = node.getParentNode();
                if(parent.getLeftChild() == node){
                    parent.setLeftChild(null);
                } else{
                    parent.setRightChild(null);
                }
                node = null;
            }else if(node.getRightChild()==null && node.getLeftChild()!=null){
                System.out.println("Inside Case 2");

                Node<T> parent = node.getParentNode();
                if(parent!=null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getLeftChild());
                    node.getLeftChild().setParentNode(parent);
                }else if(parent!=null && parent.getRightChild() == node){
                    parent.setRightChild(node.getLeftChild());
                    node.getLeftChild().setParentNode(parent);
                }else{
                    root = node.getLeftChild();
                    root.setLeftChild(null);
                }

            }else if(node.getRightChild()!=null && node.getLeftChild()==null){
                System.out.println("Inside Case 3");

                Node<T> parent = node.getParentNode();
                if(parent!=null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getRightChild());
                    node.getRightChild().setParentNode(parent);
                }else if(parent!=null && parent.getRightChild() == node){
                    parent.setRightChild(node.getRightChild());
                    node.getRightChild().setParentNode(parent);
                }else{
                    root = node.getRightChild();
                    root.setRightChild(null);
                }

            }else{//node has two child
                System.out.println("Inside Case 4");
                Node<T> successorNode = findSuccessor(node);
                System.out.println("Got the successor - " + node.getData());

                T temp = node.getData();
                node.setData(successorNode.getData());
                successorNode.setData(temp);
                remove(data, successorNode);

            }
        }
    }

    private Node<T> findSuccessor(Node<T> node) {
        if(node.getRightChild()!= null){
            return findSuccessor(node.getRightChild());
        }
        System.out.println("found successor: " + node.getData());
        return node;
    }

    @Override
    public void traversal() {
        Node node = root;

        if(root == null){
            return;
        }else{
            traversal(node);
        }



    }

    private void traversal(Node node) {
        if(node.getLeftChild() != null){
            System.out.println("1st " + node.getData());

            traversal(node.getLeftChild());
        }
        System.out.println("In between " + node.getData());

//        System.out.print(node.getData() + "->");

        if(node.getRightChild() != null){
            System.out.println("2nd " + node.getData());

            traversal(node.getRightChild());
        }
    }

    @Override
    public T getMin() {
        Node<T> node = root;

        if(root == null){
            return null;
        }else{
            return getMin(node);
        }
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild() != null){
            return getMin(node.getLeftChild());
        } else{
            return node.getData();
        }
    }

    @Override
    public T getMax() {
        if(root == null){
            return null;
        }else{
            return getMax(root);
        }
    }

    private T getMax(Node<T> node) {
        if(node.getRightChild()!= null){
            return getMax(node.getRightChild());
        } else{
            return node.getData();
        }
    }
}

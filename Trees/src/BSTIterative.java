import java.util.*;

public class BSTIterative <T extends Comparable<T>> implements Tree<T>{
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public void insert(T data) {
        if (root == null) {
            Node<T> newNode = new Node<T>(data,null);
            root = newNode;
        }else{
            Node <T> currentNode = root;
            while(currentNode != null){
                if(currentNode.getData().compareTo(data)>0){
                    if(currentNode.getLeftChild()!=null){
                        currentNode = currentNode.getLeftChild();
                    }else{
                        currentNode.setLeftChild(new Node<>(data,currentNode));
                    }
                } else if(currentNode.getData().compareTo(data)<0){
                    if(currentNode.getRightChild()!=null){
                        currentNode = currentNode.getRightChild();
                    }else{
                        currentNode.setRightChild(new Node<>(data,currentNode));
                    }
                } else{
                    return;
                }
            }

        }
    }

    @Override
    public void remove(T data) {
        Node<T> currentNode = root;
        if(currentNode==null) return;

        while(currentNode!=null){
            if(currentNode.getData().compareTo(data)>0){
                currentNode = currentNode.getLeftChild();
            }else if(currentNode.getData().compareTo(data)<0){
                currentNode = currentNode.getRightChild();
            }else if(currentNode.getData().compareTo(data) == 0){

                if(currentNode.getRightChild()==null && currentNode.getLeftChild()==null){ //case 1 - no child
                    if(currentNode.getParentNode()==null){//when current node is the root node
                        root = null;
                    }else if(currentNode.getParentNode().getData().compareTo(data)>0){
                        currentNode.getParentNode().setLeftChild(null);
                    }else{
                        currentNode.getParentNode().setRightChild(null);
                    }
                    currentNode = null;
                }else if((currentNode.getRightChild()!=null && currentNode.getLeftChild()==null)){//case 2 - one right child
                    if(currentNode.getParentNode()==null) {
                        root = currentNode.getRightChild();
                    }else if(currentNode.getParentNode().getData().compareTo(data)>0){
                            currentNode.getParentNode().setLeftChild(currentNode.getRightChild());
                    }else{
                            currentNode.getParentNode().setRightChild(currentNode.getRightChild());
                    }
                    currentNode=null;
                }else if(currentNode.getRightChild()==null && currentNode.getLeftChild()!=null){//case 2 - one left child
                    if(currentNode.getParentNode()==null) {
                        root = currentNode.getLeftChild();
                    }else if(currentNode.getParentNode().getData().compareTo(data)>0){
                        currentNode.getParentNode().setLeftChild(currentNode.getLeftChild());
                    }else{
                        currentNode.getParentNode().setRightChild(currentNode.getLeftChild());
                    }
                    currentNode=null;
                }else if((currentNode.getLeftChild()!=null) && (currentNode.getRightChild()!=null)){//case 3 - two children
                    //swap current node with a successor node
                    Node<T> successorNode = findSuccessor(currentNode.getData());
                    T temp = currentNode.getData();
                    currentNode.setData(successorNode.getData());
                    successorNode.setData(temp);
                    //deleting the successor node after a swap
                    if(successorNode.getParentNode().getRightChild() == successorNode){//"==" for object comparision
                        successorNode.getParentNode().setRightChild(successorNode.getRightChild());
                    }else if(successorNode.getParentNode().getLeftChild() == successorNode){
                        successorNode.getParentNode().setRightChild(successorNode.getRightChild());
                    }
                    successorNode=null; //garbage collectible
                }
            }
        }
    }

    public Node<T> findSuccessor(T data){
        Node<T> previous = null;
        Node<T> currentNode = root;
        while(currentNode!=null){
            if(currentNode.getData().compareTo(data)>0){
                previous = currentNode;

                currentNode = currentNode.getLeftChild();
            }else if(currentNode.getData().compareTo(data)<0){
                currentNode = currentNode.getRightChild();

            } else if(currentNode.getData().compareTo(data)==0){
               break;
            }
        }

        if(currentNode.getRightChild()!=null){
            currentNode = currentNode.getRightChild();

            while ((currentNode.getLeftChild()!=null)){
                currentNode = currentNode.getLeftChild();
            }

        } else{
            currentNode = previous;
        }
        return currentNode;
    }

    public Node<T> findPredecessor(T data){
        Node<T> previous = null;
        Node<T> currentNode = root;
        while(currentNode!=null){
            if(currentNode.getData().compareTo(data)>0){

                currentNode = currentNode.getLeftChild();
            }else if(currentNode.getData().compareTo(data)<0){
                previous = currentNode;

                currentNode = currentNode.getRightChild();

            } else if(currentNode.getData().compareTo(data)==0){
                break;
            }
        }

        if(currentNode.getLeftChild()!=null){
            currentNode = currentNode.getLeftChild();

            while ((currentNode.getRightChild()!=null)){
                currentNode = currentNode.getRightChild();
            }

        } else{
            currentNode = previous;
        }
        return currentNode;
    }

    @Override
    public void traversal() {
        System.out.println("****************** In-Order ************************");

        traversal(root);
    }

    private void traversal(Node<T> root) {
        if(root==null){
            return;
        }

        traversal(root.getLeftChild());
        System.out.println(root.getData());
        traversal(root.getRightChild());
    }

    public List<Integer> preOrder(){

        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(Node<T> root, List result){
        if(root == null){
            return;
        }
        result.add(root.getData());
        preOrder(root.getLeftChild(), result);
        preOrder(root.getRightChild(), result);
    }

    public List<Integer> postOrder(){

        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(Node<T> root, List result){
        if(root == null){
            return;
        }
        postOrder(root.getLeftChild(), result);
        postOrder(root.getRightChild(), result);
        result.add(root.getData());

    }

    public List<Integer> preOrderUsingStack(){

        List<Integer> result = new ArrayList<>();
        Stack<Node> tempStack = new Stack<Node>();

        tempStack.add(root);

        while(!tempStack.isEmpty()){
            Node tempNode = tempStack.pop();
            result.add((Integer) tempNode.getData());

            if(tempNode.getRightChild()!=null){
                tempStack.add(tempNode.getRightChild());
            }
            if(tempNode.getLeftChild()!=null){
                tempStack.add(tempNode.getLeftChild());
            }
        }


        return result;
    }

    public List<Integer> inOrderUsingStack() {

        List<Integer> result = new ArrayList<>();
        Stack<Node> tempStack = new Stack<Node>();
        Node tempNode;
        Node node = root;
        if (node == null) {
            return null;
        }
        while (true) {
            if (node != null) {
                tempStack.push(node);
                node = node.getLeftChild();
            } else {
                if (tempStack.isEmpty()) {
                    break;
                }
                node = tempStack.pop();
                result.add((int) node.getData());
                node = node.getRightChild();
            }
        }
        return result;
    }

        public List<Integer> postOrderUsingStack(){

            List<Integer> result = new ArrayList<>();
            Stack<Node> tempStack = new Stack<Node>();
            Node top;
            Node tempNode;
            Node node = root;
            if(node == null){
                return null;
            }

            while(node!=null || !tempStack.isEmpty()){
                if(node.getLeftChild()!=null){
                    tempStack.push(node);
                    node = node.getLeftChild();

                }
                if(node.getRightChild()!=null){
                    tempStack.push(node);
                    node = node.getLeftChild();

                }
                top = tempStack.peek();
                if(node == null || top.getParentNode().getRightChild()== top){

                    if(top.getLeftChild()==null && top.getRightChild()==null){
                        tempNode = tempStack.pop();
                        result.add((int)tempNode.getData());
                        node = tempNode.getRightChild();
                    } else if(top.getRightChild()!=null){
                        tempStack.push(top.getRightChild());
                        node = top.getRightChild();
                    }
                    else if(top.getParentNode().getLeftChild()== top){


                    }else if(top.getParentNode().getRightChild()== top){
                        tempNode = tempStack.pop();
                        result.add((int)tempNode.getData());
                        node = tempStack.pop();
                    }
                }
            }

        return result;
    }



    public List<List<Integer>> levelOrderTraversal() {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> levelQueue = new LinkedList<>();

        if(root == null){
            return null;
        }

        // TreeNode node = root;
        levelQueue.add(root);

        while(!levelQueue.isEmpty()){
            int qCount = levelQueue.size();
            List<Integer> tempArray = new ArrayList<Integer>();
            for(int i =0;i<qCount;i++){
                Node node = levelQueue.poll();

                tempArray.add((Integer) node.getData());
                if(node.getLeftChild()!=null){
                    levelQueue.add(node.getLeftChild());
                }
                if(node.getRightChild()!=null){
                    levelQueue.add(node.getRightChild());
                }

            }

            result.add(new ArrayList<>(tempArray));


        }

        return result;

        }

    public void levelOrderTraversalZigZag(){

    }

    @Override
    public T getMin() {
        return null;
    }

    @Override
    public T getMax() {
        return null;
    }
}

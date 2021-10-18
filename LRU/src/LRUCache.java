import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int currentSize = 0;
    private DoublyLinkedList linkedList;
    private Map<Integer, Node> nodeMap;

    public LRUCache() {
        this.linkedList = new DoublyLinkedList();
        this.nodeMap = new HashMap<>();
    }

    public void put(int id, String data){
        if(nodeMap.containsKey(id)){
            Node currentNode = nodeMap.get(id);
            currentNode.setData(data);
            update(currentNode);
            return;
        }
        Node newNode = new Node(id, data);
        newNode.setPreviousNode(null);
        if(linkedList.getHeadNode()!=null && currentSize<Constants.CAPACITY){
            add(newNode);
            currentSize++;

        }else if(linkedList.getHeadNode()!=null && currentSize==Constants.CAPACITY) {
            removeTail();
            add(newNode);
        } else
        {
            linkedList.setHeadNode(newNode);
            linkedList.setTailNode(newNode);
            currentSize++;
        }
        nodeMap.put(id, newNode);
    }

    public void add(Node newNode){
        newNode.setNextNode(linkedList.getHeadNode());
        linkedList.getHeadNode().setPreviousNode(newNode);
        linkedList.setHeadNode(newNode);
    }

    public void removeTail(){
        Node tailNode = linkedList.getTailNode();
        Node previousNode = tailNode.getPreviousNode();
        linkedList.setTailNode(previousNode);
        linkedList.getTailNode().setNextNode(null);
        tailNode=null;
//        if(linkedList.getTailNode()!=null){
//            linkedList.getTailNode().setNextNode(null);
//        }
//        tailNode=null;

    }

    public Node get(int id){
        if(nodeMap.containsKey(id)){
            Node node = nodeMap.get(id);
            update(node);
            return node;
        }else{
            return null;
        }

    }

    public void update(Node node){
        Node previousNode = node.getPreviousNode();
        Node nextNode = node.getNextNode();
        if(previousNode!=null){
            previousNode.setNextNode(nextNode);
        }
        if(nextNode!=null){
            nextNode.setPreviousNode(previousNode);
        }else{
            linkedList.setTailNode(previousNode);
            previousNode.setNextNode(null);
        }
        add(node);
    }

    public void show(){
        Node node = linkedList.getHeadNode();
        while(node!=null){
            System.out.println(node);
            node=node.getNextNode();
        }
    }
}

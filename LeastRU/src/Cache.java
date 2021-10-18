import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
    public static final int CAPACITY = 5;
    Node<K, V> head;
    Node<K, V> tail;
    private int size = 0;
    Map<K, Node<K, V>> hMap = new HashMap<>();

    public Cache() {
    }

    public void put(K key, V value){
        if(hMap.get(key)==null){
            Node<K, V> newNode = new Node<K, V>(key, value);
            hMap.put(key,newNode);
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                Node<K, V> temp = head;
                head = newNode;
                head.next=temp;
                temp.previous=head;
            }
            size++;
            if(size>CAPACITY){
                Node<K, V> temp = tail;
                tail = temp.previous;
                temp = null;
                tail.next = null;
                size--;
            }
        } else{
            Node<K, V> existingNode = hMap.get(key);
            Node<K, V> previous = existingNode.previous;
            Node<K, V> next = existingNode.next;

            existingNode.setValue(value);
            Node<K, V> temp = head;
            head = existingNode;
            head.next=temp;
            temp.previous=head;

            previous.next=next;
            if(next!=null){
                next.previous = previous;
                tail = next;
            }else{
                tail=previous;
            }

        }


    }

    public void show(){
        if(head == null){
            System.out.println("Cache is empty!!!");
            return;
        }
        Node<K, V> current = head;

        while(current!=null){
            System.out.println(current.getKey() + " " + current.getValue());
            current=current.next;
        }

        System.out.println("Head: " + head.getKey() + " Tail: " +tail.getKey());
    }
}

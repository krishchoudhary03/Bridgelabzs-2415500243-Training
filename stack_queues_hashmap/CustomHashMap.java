import java.util.LinkedList;

public class CustomHashMap {

    static class Node {
        int key, value;
        Node(int k, int v) { key = k; value = v; }
    }

    private int SIZE = 1000;
    private LinkedList<Node>[] buckets;

    public CustomHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key == key) return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].removeIf(node -> node.key == key);
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(1, 300);

        System.out.println(map.get(1)); // 300
        map.remove(1);
        System.out.println(map.get(1)); // -1
    }
}

package dsatutorial.datastructures.hashing;

public class HashTable {

    HashNode[] buckets;
    int numOfBuckets; // capacity
    int size; // number of key - value pairs in hash table or number of hash nodes in hash table

    private class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this(10); // default capacity
    }

    public HashTable(int capacity) {
        this.size = 0;
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Integer key, String value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("Key or Value is null. ");
        int bucketIndex = getBucketIndex(key);
        HashNode head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        this.size++;
        head = this.buckets[bucketIndex];
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        this.buckets[bucketIndex] = newNode;
    }

    public String get(Integer key) {
        if (key == null)
            throw new IllegalArgumentException("Key or Value is null. ");
        int bucketIndex = getBucketIndex(key);
        HashNode head = this.buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key) {
        if (key == null)
            throw new IllegalArgumentException("Key or Value is null. ");
        int bucketIndex = getBucketIndex(key);
        HashNode head = this.buckets[bucketIndex];
        HashNode previous = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null)
            return null;
        this.size--;
        if (previous != null) {
            previous.next = head.next;
        } else {
            this.buckets[bucketIndex] = head.next;
        }
        return head.value;
    }

    public int getBucketIndex(int key) {
        return key % buckets.length; // numOfBuckets
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.put(105, "Giorgos");
        ht.put(21, "Georgios");
        ht.put(21, "Maria");
        ht.put(31, "Vasilis");
        System.out.println(ht.size);
        System.out.println(ht.get(105));
        System.out.println(ht.get(21));
        System.out.println(ht.get(31));
        System.out.println(ht.get(100));
        System.out.println();
        System.out.println(ht.remove(21));
        System.out.println(ht.remove(31));
        System.out.println(ht.remove(105));
        System.out.println(ht.remove(90));
        System.out.println(ht.size);

    }
}

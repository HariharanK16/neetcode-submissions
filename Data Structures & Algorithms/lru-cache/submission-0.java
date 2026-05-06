class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    int cap;
    HashMap<Integer, Node> cache;
    Node head, slider;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.head = new Node(0,0);
        this.slider = new Node(-1,-1);
        this.head.next = this.slider;
        this.slider.prev = this.head;
    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        Node prev = this.slider.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.slider;
        this.slider.prev = node;

    }
    public int get(int key) {
        System.out.println(cache);
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int val) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key,val);
        cache.put(key, node);
        insert(node);

        if(cache.size()> cap){
            Node leftMost = this.head.next;
            remove(leftMost);
            cache.remove(leftMost.key);
        }
    }
}

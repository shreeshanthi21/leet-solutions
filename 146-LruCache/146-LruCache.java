// Last updated: 5/26/2026, 12:32:34 PM
class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> hm=new HashMap<>();
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    private void deleteNode(Node delNode){
        Node prevv=delNode.prev;
        Node nextt=delNode.next;
        prevv.next=nextt;
        nextt.prev=prevv;
    }
    private void addNode(Node newNode){
        Node temp=head.next;
        newNode.next=temp;
        newNode.prev=head;
        head.next=newNode;
        temp.prev=newNode;
    }
    public int get(int key) {
        if(hm.containsKey(key)){
            Node result=hm.get(key);
            int ans=result.val;
            hm.remove(result);
            deleteNode(result);
            addNode(result);
            hm.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node curr=hm.get(key);
            hm.remove(key);
            deleteNode(curr);
        }
        if(hm.size()==cap){
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value));
        hm.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
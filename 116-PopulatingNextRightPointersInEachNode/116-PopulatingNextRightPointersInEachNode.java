// Last updated: 5/26/2026, 12:33:08 PM
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public List<List<Node>> levelOrder(Node root){
        Queue<Node> queue=new LinkedList<Node>();
        List<List<Node>> wraplist=new LinkedList<List<Node>>();
        if(root==null) return wraplist;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            List<Node> sublist=new LinkedList<Node>();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll());
            }
            wraplist.add(sublist);
        }
        return wraplist;
    }
    public Node connect(Node root) {
        List<List<Node>> traversal=levelOrder(root);
        for (int i = 0; i < traversal.size(); i++) {
            for (int j = 0; j < traversal.get(i).size(); j++) {
                Node currentNode = traversal.get(i).get(j);
                if (j < traversal.get(i).size() - 1) {
                    currentNode.next = traversal.get(i).get(j + 1);
                } else {
                    currentNode.next = null; 
                }
            }            
        }
        return root;
    }
}
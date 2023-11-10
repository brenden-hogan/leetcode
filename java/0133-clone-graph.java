/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Node cloneNode = new Node(node.val, new ArrayList());
        
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        visited.put(node, cloneNode);
        
        for(Node n : node.neighbors){
            visited.get(node).neighbors.add(cloneGraph(n));
        }
        
        return visited.get(node);
        
    }
}
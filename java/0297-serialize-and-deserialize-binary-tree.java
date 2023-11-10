/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }
    
    public StringBuilder serial(StringBuilder sb, TreeNode tn){
        if(tn == null) return sb.append("null");
        sb.append(tn.val).append(",");
        serial(sb, tn.left).append(",");
        serial(sb, tn.right);
        return sb;
    }
    
    public TreeNode deserial(Queue<String> q){
        String cur = q.poll();
        if(cur.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserial(q);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
                List<List<Integer>> out = new ArrayList<>();
        
        if(root == null) return out;
        
        Queue<Pair<Integer, Pair<Integer, TreeNode>>> q = new ArrayDeque<>();
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>((n1,n2) -> n1 - n2); 
        
        int col = 0;
        int depth = 0;
        q.offer(new Pair(depth, new Pair(col, root)));
        
        Map<Integer, ArrayList<Pair<Integer, Integer>>> colMap = new HashMap<>();
        
        while(!q.isEmpty()){
            
            Pair<Integer, Pair<Integer, TreeNode>> p = q.poll();
            depth = p.getKey();
            Pair<Integer, TreeNode> origPair = p.getValue();
            col = origPair.getKey();
            TreeNode cur = origPair.getValue();
            
            if(cur != null){
                if(!colMap.containsKey(col)){
                    colMap.put(col, new ArrayList<Pair<Integer, Integer>>());
                    minQ.offer(col);
                }
                colMap.get(col).add(new Pair(cur.val, depth));
                q.offer(new Pair(depth++, new Pair(col - 1, cur.left)));
                q.offer(new Pair(depth++, new Pair(col + 1, cur.right)));
            }
            
        }
        
        while(!minQ.isEmpty()){
            List<Pair<Integer, Integer>> pairList = colMap.get(minQ.poll());
            Collections.sort(pairList, Comparator.comparing(p -> p.getKey()));
            Collections.sort(pairList, Comparator.comparing(p -> p.getValue()));
            List<Integer> tempList = new ArrayList<>();
            for(Pair<Integer, Integer> p: pairList){
                tempList.add(p.getKey());
            }

            out.add(tempList);
        }
        
        return out;
    }
}
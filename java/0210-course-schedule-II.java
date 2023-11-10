class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         
        //Initialize
        Map<Integer, ArrayList> vertex = new HashMap<>();
        Map<Integer, Integer> inEdges = new HashMap<>();
        //O(C)
        for(int i = 0; i < numCourses; i++){
            inEdges.put(i,0);
            vertex.put(i, new ArrayList<>());
        }
        //(O(P))
        //Fill
        for(int i=0; i < prerequisites.length; i++){
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];
            inEdges.put(child, inEdges.get(child) + 1);
            vertex.get(parent).add(child);
        }
        
        //O(C)
        //Set up the queue for our sources
        Queue<Integer> q = new ArrayDeque<>();
        for(HashMap.Entry<Integer, Integer> eS : inEdges.entrySet()){
            if(eS.getValue() == 0){
                q.offer(eS.getKey());
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        //Work through the graph removing all nodes with no out in edges (sources) and their out edges
        while(!q.isEmpty()){
            int v = q.poll();
            resultList.add(v);
            List<Integer> children = vertex.get(v);
            for(int child : children){
                if(inEdges.get(child) !=0){
                    inEdges.put(child, inEdges.get(child) -1);
                } 
                
                if(inEdges.get(child) == 0){
                    
                    q.offer(child);
                } 
                
            }
            
        }
        
        //Check if we have no more edges
        if(resultList.size() == numCourses) return resultList.stream().mapToInt(i->i).toArray();
        return new int[0];
    }
}
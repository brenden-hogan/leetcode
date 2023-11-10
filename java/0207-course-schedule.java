class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Init 
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inEdges = new HashMap<>();
        for(int i=0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
            inEdges.put(i,0);
        }
        
        // Set up
        for(int i = 0; i < prerequisites.length; i++){
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inEdges.put(child, inEdges.get(child) + 1);
        }
        
        //Get the intial sources
        Queue<Integer> sources = new LinkedList<>();
        for (HashMap.Entry<Integer, Integer> entry : inEdges.entrySet()){
            if(entry.getValue() == 0){
                sources.offer(entry.getKey());
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        //Break it down source by source batch
        while(sources.size() > 0){
            int curNode = sources.poll();
            resultList.add(curNode);
            ArrayList<Integer> children = graph.get(curNode);
            for(int child : children){
                inEdges.put(child, inEdges.get(child)-1);
                if(inEdges.get(child) == 0){
                    sources.offer(child);
                }
            }
        }
        
        if(resultList.size() == numCourses) return true;
        return false;
        
    }
}
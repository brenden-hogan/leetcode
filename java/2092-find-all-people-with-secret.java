class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>(); //<a, <time, <b,c,d>>>
        for (int[] meeting : meetings) {
            int a = meeting[0], b = meeting[1], time = meeting[2];
            graph.putIfAbsent(a, new HashMap());
            graph.putIfAbsent(b, new HashMap()); 
            graph.get(a).computeIfAbsent(time, x -> new ArrayList<>()).add(b);
            graph.get(b).computeIfAbsent(time, x -> new ArrayList<>()).add(a);
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{firstPerson, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curPerson = cur[0], curTime = cur[1];
            if (visited.add(curPerson)) res.add(curPerson);
            else continue;
            for (int otherTime : graph.getOrDefault(curPerson, new HashMap<>()).keySet()) {
                if (otherTime < curTime) continue;
                for (int nextPerson : graph.getOrDefault(curPerson, new HashMap<>()).get(otherTime))
                    pq.offer(new int[]{nextPerson, otherTime});
            }
        }
        return res;
    }
 }
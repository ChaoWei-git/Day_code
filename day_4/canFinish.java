import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表
        int[][] graph = new int[numCourses][numCourses];
        int[] in_node = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
            in_node[prerequisites[i][0]] +=1;
        }

        Set<Integer> visit = new HashSet<>();
        int start_node = 0;
        while(start_node < numCourses){
            if(!visit.contains(start_node) && in_node[start_node]==0){
                visit.add(start_node);
                for(int i=0;i<numCourses;i++){
                    if(graph[start_node][i]>0){
                        in_node[i] -=1;
                    }
                }
                start_node = -1;
            }
            start_node++;
        }
        return visit.size() >= numCourses;
    }
}
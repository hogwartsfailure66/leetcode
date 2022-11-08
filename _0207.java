import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _0207 {
//    Course Schedule

    /**
     * topo, or dfs, see 210
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> prerequisites_map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int prerequisite = prerequisites[i][1], course = prerequisites[i][0];
            ArrayList<Integer> related_courses = prerequisites_map.getOrDefault(prerequisite, new ArrayList<>());
            related_courses.add(course);
            prerequisites_map.put(prerequisite, related_courses);
            indegree[course]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int course: prerequisites_map.getOrDefault(current, new ArrayList<>())) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.add(course);
                }
            }
            prerequisites_map.put(current, new ArrayList<>());
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }
}

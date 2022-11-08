import java.util.*;

public class _210 {
//    Course Schedule II

    /**
     * dfs
     */
    public final int WHITE = 0;
    public final int GRAY = 1;
    public int BLACK = 2;
    public int[] color;
    public boolean hasCycle = false;
    public int[] result;
    public int index;
    public List<List<Integer>> courses;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        color = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        courses = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites) {
            List<Integer> current = courses.get(prerequisite[1]);
            current.add(prerequisite[0]);
            courses.set(prerequisite[1], current);
        }
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == WHITE) {
                dfs(i);
            }
        }
        if (hasCycle) {
            return new int[]{};
        }
        return result;
    }

    public void dfs(int i) {
        if (hasCycle) {
            return;
        }
        color[i] = GRAY;
        for (int course: courses.get(i)) {
            if (color[course] == WHITE) {
                dfs(course);
            } else if (color[course] == GRAY) {
                hasCycle = true;
                return;
            }
        }
        result[index--] = i;
        color[i] = BLACK;
    }

    /**
     * topo sort
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses], result = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0], prerequisite = prerequisites[i][1];
            courses.get(prerequisite).add(course);
            indegree[course]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;
            for (int course: courses.get(current)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.add(course);
                }
            }
            courses.set(current, new ArrayList<>());
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}

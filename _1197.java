import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1197 {
//    Minimum Knight Moves

    /**
     * We claim that the target (x, y)(x,y), its horizontally, vertically, and diagonally symmetric points
     * (i.e. (x, -y), (-x, y), (-x, -y)(x,−y),(−x,y),(−x,−y)) share the same answer as the target point.
     * we can focus on the first quadrant of the coordinate plane where both xx and yy are positive.
     * AC finally
     */
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0, 0, 0};
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add(start);
        visited.put("0,0", 0);
        while (true) {
            int[] current = queue.poll();
            if (current[0] == x && current[1] == y) {
                return current[2];
            }
            for (int i = 0; i < 8; i++) {
                int[] next = {current[0] + offsets[i][0], current[1] + offsets[i][1], current[2] + 1};
                String next_string = next[0] + "," + next[1];
                /**
                 * the issue is that coming up with the "newX >= -1 && newY >= -1" requires you to draw out the graph and, again,
                 * realize you sometimes needs to travel outside the first quadrant a little to get the optimal answer for (x,y)'s
                 * closer to the origin. Specifically,
                 * finding the optimal answer for coordinates: (0,0) (1,1) (2,0) (0, 2). Imo, this can easily go over your head.
                 */
                if (next[0] >= -1 && next[1] >= -1 && !visited.containsKey(next_string)) {
                    queue.add(next);
                    visited.put(next_string, next[2]);
                }
            }
        }
    }

    /**
     * bidirectional bfs, TLE
     */
    public int minKnightMoves2(int x, int y) {
        int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        int[] start = {0, 0, 0}, target = {x, y, 0};
        Queue<int[]> start_queue = new LinkedList<>(), target_queue = new LinkedList<>();
        HashMap<String, Integer> start_visited = new HashMap<>(), target_visited = new HashMap<>();
        start_queue.add(start);
        start_visited.put("0,0", 0);
        target_queue.add(target);
        target_visited.put(x + "," + y, 0);
        while (true) {
            int[] current_start = start_queue.poll(), current_target = target_queue.poll();
            String start_string = current_start[0] + "," + current_start[1];
            if (target_visited.containsKey(start_string)) {
                return target_visited.get(start_string) + current_start[2];
            }

            String current_string = current_target[0] + "," + current_target[1];
            if (start_visited.containsKey(current_string)) {
                return start_visited.get(current_string) + current_target[2];
            }

            for (int i = 0; i < 8; i++) {
                int[] next_start = {current_start[0] + offsets[i][0], current_start[1] + offsets[i][1],
                        current_start[2] + 1};
                String next_start_string = next_start[0] + "," + next_start[1];
                if (!start_visited.containsKey(next_start_string)) {
                    start_visited.put(next_start_string, next_start[2]);
                    start_queue.add(next_start);
                }

                int[] next_target = {current_target[0] + offsets[i][0], current_target[1] + offsets[i][1],
                        current_target[2] + 1};
                String next_target_string = next_target[0] + "," + next_target[1];
                if (!target_visited.containsKey(next_target_string)) {
                    target_visited.put(next_target_string, next_target[2]);
                    target_queue.add(next_target);
                }
            }
        }
    }

    /**
     * bfs, brute force => TLE
     */

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int minKnightMoves1(int x, int y) {
        Pair start = new Pair(0, 0), end = new Pair(x, y);
        HashSet<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        int level = -1;
        int[][] direction = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};
        visited.add("0,0");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                if (visited.contains(current) || Math.abs(current.x) > 300 || Math.abs(current.y) > 300) {
                    continue;
                }
                visited.add(current.x + "," + current.y);
                if (current.x == x && current.y == y) {
                    return level + 1;
                }
                for (int j = 0; j < 8; j++) {
                    Pair next = new Pair(current.x + direction[j][0], current.y + direction[j][1]);
                    queue.add(next);
                }
            }
            level++;
        }
        return 0;
    }
}

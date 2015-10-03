package traprain;

import java.util.*;

public class Followup {
	/**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        int m = heights.length;
        if (m <= 2) return 0;
        int n = heights[0].length;
        if (n <= 2) return 0;
        PriorityQueue<WaterNode> curEdge = new PriorityQueue();
        Set<Integer> visited = new HashSet();
        int sum = 0;
        // add edge nodes to the heap
        for (int i = 0; i < n; i++){
            curEdge.offer(new WaterNode(heights[0][i], i));
            visited.add(i);
            curEdge.offer(new WaterNode(heights[m - 1][i], (m - 1) * n + i));
            visited.add((m - 1) * n + i);
        }
        for (int i = 1; i < m - 1; i++){
            curEdge.offer(new WaterNode(heights[i][0], i * n));
            visited.add(i * n);
            curEdge.offer(new WaterNode(heights[i][n - 1], i * n + n - 1));
            visited.add(i * n + n - 1);
        }
        // find min in the edge, then fill water to its neighbor cell
        while (visited.size() < m * n){
            WaterNode min = curEdge.poll();
            // position
            int x = min.idx / n;
            int y = min.idx % n;
            // left
            if ((y - 1) >= 0 && !visited.contains(min.idx - 1)){
                if (heights[x][y - 1] < min.height){
                    sum += min.height - heights[x][y - 1];
                    curEdge.offer(new WaterNode(min.height, min.idx - 1));
                } else {
                    curEdge.offer(new WaterNode(heights[x][y - 1], min.idx - 1));
                }
                visited.add(min.idx - 1);
            }
            // right
            if ((y + 1) < n && !visited.contains(min.idx + 1)){
                if (heights[x][y + 1] < min.height){
                    sum += min.height - heights[x][y + 1];
                    curEdge.offer(new WaterNode(min.height, min.idx + 1));
                } else {
                    curEdge.offer(new WaterNode(heights[x][y + 1], min.idx + 1));
                }
                visited.add(min.idx + 1);
            }
            // up
            if ((x - 1) >= 0 && !visited.contains(min.idx - n)){
                if (heights[x - 1][y] < min.height){
                    sum += min.height - heights[x - 1][y];
                    curEdge.offer(new WaterNode(min.height, min.idx - n));
                } else {
                    curEdge.offer(new WaterNode(heights[x - 1][y], min.idx - n));
                }
                visited.add(min.idx - n);
            }
            // down
            if ((x + 1) < m && !visited.contains(min.idx + n)){
                if (heights[x + 1][y] < min.height){
                    sum += min.height - heights[x + 1][y];
                    curEdge.offer(new WaterNode(min.height, min.idx + n));
                } else {
                    curEdge.offer(new WaterNode(heights[x + 1][y], min.idx + n));
                }
                visited.add(min.idx + n);
            }
        }
        return sum;
    }
    public class WaterNode implements Comparable<WaterNode>{
        public int height;
        public int idx;
        public WaterNode(int h, int i){
            this.height = h;
            this.idx = i;
        }
        public int compareTo(WaterNode other){
            return height - other.height;
        }
    }
    
    public static void main(String[] args){
    	int[][] heights = {{12,13,0,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
    	Followup sln = new Followup();
    	System.out.println(sln.trapRainWater(heights));
    }
}

package main.java.com.kha.ds;

import main.java.com.kha.ds.priorityqueue.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mohammad.Ansari1 on 26-09-2017.
 */
/* Java program to solve Rat in a Maze problem using
   backtracking */

public class RatMaze{

    static int[] X=new int[]{0,1,0,-1};
    static int[] Y=new int[]{1,0,-1,0};

    static HashMap<Integer, String> map = new HashMap();
    static {
        map.put(0, "R");
        map.put(1, "D");
        map.put(2, "L");
        map.put(3, "U");
    }

    public static boolean isSafe(int[][] maze, int n, int x, int y, boolean[][] visited){
        return (x>=0 && y>=0 && x<n && y<n && maze[x][y]==1 && !visited[x][y]);
    }

    public static ArrayList<String> printPath(int[][] m, int n){
        boolean[][] visited = new boolean[m.length][m[0].length];
        ArrayList<String> results =doPrintPath(m, n, 0, 0, visited, new StringBuilder(), new ArrayList<>());
        return results;
    }
    public static ArrayList<String> doPrintPath(int[][] maze, int n, int x, int y, boolean[][] visited, StringBuilder sb, ArrayList<String> res){
        if(x==n-1 && y==n-1){
            res.add(sb.toString());
            return res;
        }
        visited[x][y]=true;
        //if(isSafe(maze, n, x, y, visited)) {
        for(Integer i : map.keySet()){
            int newX = x + X[i];
            int newY = y + Y[i];
            if(isSafe(maze, n, newX, newY, visited)) {
                sb.append(map.get(i));
                doPrintPath(maze, n, newX, newY, visited, sb, res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        visited[x][y]=false;

        return res;
    }

    public static void main(String args[])  {

        int maze[][] = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        List<String> str = printPath(maze, 4);
        for(String s : str){
            System.out.println(s);
        }
    }
}
// This code is contributed by Abhishek Shankhadhar

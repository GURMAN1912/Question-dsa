package dp;

import java.util.ArrayList;
import java.util.List;

public class TrianglePath {
    public static  int minimunTotal(List<List<Integer>> triangle)
    {
        return f(0,0,triangle);
    }
    public static int f(int row,int col,List<List<Integer>> triangle){
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        int down = f(row + 1, col, triangle);
        int diagonal = f(row + 1, col + 1, triangle);

        return triangle.get(row).get(col) + Math.min(down, diagonal);
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>(); 
    }
}

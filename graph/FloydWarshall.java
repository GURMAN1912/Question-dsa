package graph;

public class FloydWarshall {
    public static void floydWarshall(int [][]matrix){
        int n=matrix.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]!=Integer.MAX_VALUE && matrix[k][j]!=Integer.MAX_VALUE && matrix[i][k]+matrix[k][j]<matrix[i][j]){
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
        //for negative cycle
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]!=Integer.MAX_VALUE && matrix[k][j]!=Integer.MAX_VALUE && matrix[i][k]+matrix[k][j]<matrix[i][j]){
                        matrix[i][j]=Integer.MIN_VALUE;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int [][]matrix={
            {0,5,Integer.MAX_VALUE,10},
            {Integer.MAX_VALUE,0,3,Integer.MAX_VALUE},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,0,1},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}
        };
        floydWarshall(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

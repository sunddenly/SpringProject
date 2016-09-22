package org.hebut.scse.algorithm.advanced;

public class DynamicPlanning {
        private static int[][] matrix = {  
                            {1,10,3,8},  
                            {12,2,9,6},  
                            {5,7,4,11},  
                            {3,7,16,5}  
                         };  
        public static void main(String[] args){  
            System.out.println("the max value from lefttop to the rightbottom is:"+getMax(matrix));  
        }  
        public static int getMax(int[][] grid){  
            //如果传过来的是一个空的或长度为零的矩阵，特殊情况  
            if(grid == null || grid.length == 0){  
                return 0;  
            }  
            //分别为矩阵的行，列数。  
            int row = grid.length;  
            int col = grid[0].length;
            int[][] val = new int[row][col];
            for(int i = 0; i < row; i++){  
                for(int j = 0;j < col; j++){
                    if(i == 0 && j == 0){//初始价值，属于条件部分
                        val[i][j] = grid[i][j];  
                    }else if(i == 0 && j > 0){//第一行只能从左边过来
                        val[i][j] = val[i][j-1]+grid[i][j];  
                    }else if(i > 0 && j == 0){//第一列只能从上边边过来
                        val[i][j] = val[i-1][j] + grid[i][j];  
                    }else{//非第一列/行可能从上边/左边过来
                        val[i][j] = Math.max(val[i-1][j], val[i][j-1]) + grid[i][j];  //最优结构
                    }  
                }  
            }  
            return val[row-1][col-1];
        }  
    }  
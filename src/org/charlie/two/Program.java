package org.charlie.two;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args){
        System.out.println("hi");
        String first = "2 3";
        String second = "3 7";
        String third = "4 1";
        ArrayList<String> upRight = new ArrayList();
        upRight.add(first);
        upRight.add(second);
        upRight.add(third);
        int result = countMax(upRight);
        System.out.println("Result is: " + result);
    }

    public static int countMax(ArrayList<String> upRight){
        int result = 0;
        ArrayList<Grid> grids = getGrids(upRight);
        result = getTheCountOfMax(grids);
        return result;
    }

    private static int getTheCountOfMax(ArrayList<Grid> grids) {
        int counter = 0;
        int max = grids.size();
        int maxRow = getMaxRow(grids);
        int maxCol = getMaxCol(grids);
        int[][] finalGrid = new int[maxRow][maxCol];
        for(Grid grid: grids){
            for(int row = 0; row < grid.getA(); row++){
                for(int col = 0; col < grid.getB(); col++){
                    finalGrid[row][col] = finalGrid[row][col] + 1;
                }
            }
        }
        for(int i = 0; i < maxRow; i++){
            for(int j = 0; j < maxCol; j++){
                if(finalGrid[i][j] == max){
                    counter = counter + 1;
                }
            }
        }
        return counter;
    }

    private static int getMaxCol(ArrayList<Grid> grids) {
        int maxCol = 0;
        for(Grid grid: grids){
            maxCol = grid.getB()>maxCol ? grid.getB() : maxCol;
        }
        return maxCol;
    }

    private static int getMaxRow(ArrayList<Grid> grids) {
        int maxRow = 0;
        for(Grid grid: grids){
            maxRow = grid.getA()>maxRow ? grid.getA() : maxRow;
        }
        return maxRow;
    }

    private  static ArrayList<Grid> getGrids(ArrayList<String> upRight) {
        ArrayList<Grid> grids = new ArrayList<>();
        for(String input: upRight){
            String[] values = input.split(" ", 2);
            Integer row = Integer.parseInt(values[0]);
            Integer column = Integer.parseInt(values[1]);
            Grid grid = new Grid(row, column);
            grids.add(grid);
        }
        return grids;
    }
}

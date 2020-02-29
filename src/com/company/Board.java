package com.company;

import java.util.*;


public class Board {

    // create a board from an n-by-n array of tiles,
// where tiles[row][col] = tile at (row, col)
    private int[][] tiles;
    private int[][] goal;
    private int size;


    public Board(int[][] tiles) {
        this.goal = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };

        this.tiles = tiles;

        size = dimension();
    }


    // unit testing (not graded)
    public static void main(String[] args) {



    }

    // string representation of this board
    public String toString() {
        return Arrays.stream(this.tiles).toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    public int hamming() {


        int count = 0;

        for (int row = 0; row <= size; row++) {
            for (int col = 0; col <= size; col++) {
                if (tiles[row][col] != goal[row][col]) {
                    count++;
                    manhattan();
                }
            }
        }

        return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {

// {0, 1, 3},
// {4, 2, 5},
// {7, 8, 6},

        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if ((tiles[i][j] != 0) && (tiles[i][j] != goal[i][j])) {
                    int goalI = (tiles[i][j] - 1 ) / size;
                    int goalJ = (tiles[i][j] - 1) % size;

// sum vertical and horizontal difference in distance
                    sum += Math.abs(i - goalI) + Math.abs(j - goalJ);
                }
            }
        }

        return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return manhattan() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {

        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) return false;

        Board that = (Board) y;
        return (Arrays.equals(that.tiles,this.tiles));
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {



        return findZero();
    }

    private Iterable<Board> findZero() {

        int row = 0;
        int col = 0;

        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {

                if (tiles[row][col] == 0) {

                    return addNeighbours(row,col);



                }

            }
        }
return null;
    }

    private Iterable<Board> addNeighbours(int row, int col) {
        ArrayList<Board> neighbours = new ArrayList<>();

        if(row > 0){
//top n
            neighbours.add(swap(row,col, row-1, col));

        }
         if(col > 0){
//right n
            neighbours.add(swap(row,col, row, col-1));
        }
         if (row < size-1){
//bottom
            neighbours.add(swap(row,col, row+1, col));
        }
        if (col < size-1){
//left
            neighbours.add(swap(row,col, row, col+1));

        }


        return neighbours;
    }

    private Board swap(int row, int col, int newRow, int newCol) {

        int[][] newBoard = copyBoard(tiles);

        newBoard[row][col] = tiles[newRow][newCol];
        newBoard[newRow][newCol] = tiles[row][col];

        return new Board(newBoard);
    }

    private int[][] copyBoard(int[][] original) {

        int[][] newBoard = new int[size][size];

        for (int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){

                newBoard[i][j] = original[i][j];
            }
        }

        return newBoard;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {

        int swapRow = 0;
        int swapCol = 0;

        int twinRow = size -1;
        int twinCol = size -1;


        return swap(swapRow,swapCol,twinRow,twinCol);
    }



}
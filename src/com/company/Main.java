package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] intArray;

        intArray = new int[][]{
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6},
        };
        Board board = new Board(intArray);

        board.hamming();
        board.manhattan();
    }
}

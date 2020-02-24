package com.company;

import java.util.*;


public class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private int[][] tiles;
    private int[][] goal;


    public Board(int[][] tiles) {
        this.goal = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };

        this.tiles = tiles;

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
        return tiles[0].length * tiles.length;
    }

    // number of tiles out of place
    public int hamming() {



        int count = 0;

        for (int i = 0; i <= tiles.length - 1; i++) {
            for (int j = 0; j <= tiles.length - 1; j++) {
                if (tiles[i][j] == goal[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {


        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }


}

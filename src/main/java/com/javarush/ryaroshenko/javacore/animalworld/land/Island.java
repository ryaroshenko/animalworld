package com.javarush.ryaroshenko.javacore.animalworld.land;

public class Island {
    public static final int SIZE_X = 100;
    public static final int SIZE_Y = 20;

    private static final Island ISLAND = new Island();

    private Cell[][] cells = new Cell[SIZE_X][SIZE_Y];

    private Island() {
        Thread[][] threads = new Thread[SIZE_X][SIZE_Y];
        for (int x = 0; x < cells.length; x++)
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = new Cell(x, y);
                threads[x][y] = new CellIniter(cells[x][y]).getThread();
            }
        try {
            for (int x = 0; x < threads.length; x++)
                for (int y = 0; y < threads[x].length; y++)
                    threads[x][y].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Island getInstance() {
        return ISLAND;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

}

package com.javarush.ryaroshenko.javacore.animalworld.land;

public class CellMaker implements Runnable {
    private Cell cell;
    private Thread thread;

    public CellMaker(Cell cell) {
        this.cell = cell;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (cell) {
            cell.makeCycle();
        }
    }

    public Thread getThread() {
        return thread;
    }
}

package com.javarush.ryaroshenko.javacore.animalworld.land;

public class CellIniter implements Runnable {
    private Cell cell;
    private Thread thread;

    public CellIniter(Cell cell) {
        this.cell = cell;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (cell) {
            cell.init();
        }
    }

    public Thread getThread() {
        return thread;
    }
}

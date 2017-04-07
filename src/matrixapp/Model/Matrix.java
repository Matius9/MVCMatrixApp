/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixapp.Model;

/**
 *
 * @author Matius
 */
public class Matrix {

    private int r;
    private int c;
    private int[][] tab;

    public Matrix(int r, int c) {
        this.r = r;
        this.c = c;
        this.tab = new int[r][c];
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void newTab(int r, int c) {
        this.tab = new int[r][c];
    }

    public int[][] getTab() {
        return tab;
    }

    public int getTabElement(int r, int c) {
        return tab[r][c];
    }

    public void setTabElement(int r, int c, int value) {
        this.tab[r][c] = value;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

}

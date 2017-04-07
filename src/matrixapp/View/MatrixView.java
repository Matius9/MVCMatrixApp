/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixapp.View;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Matius
 */
public class MatrixView {

    public void printMatrix(int[][] tab, int r, int c) {
        System.out.println();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void errMatrix() throws InterruptedException {
        System.err.print("Macierz posiada bledy!\n");
        TimeUnit.MILLISECONDS.sleep(100);
    }

    public void menuView(int n) {
        switch (n) {
            case 1:
                System.out.print("\n(1)Wprowadz macierze wejsciowe\n"
                        + "(2)Operacje arytmetyczne\n"
                        + "(3)Wyswietl macierze\n"
                        + "Podaj nr: ");
                break;
            case 11:
                System.out.print("Wymiar m i k: ");
                break;
            case 2:
                System.out.print("Operacje arytmetyczne\n"
                        + "(1)Transponuj macierze wejsciowe\n"
                        + "(2)Pomnoz macierze wejsciowe\n"
                        + "(3)Transponuj macierz wynikowa\n"
                        + "Podaj nr: ");
                break;
            case 211:
                System.out.print("Transponowanie A.\n");
                break;
            case 212:
                System.out.print("Transponowanie B.\n");
                break;
            case 22:
                System.out.print("Mnozenie A i B.\n");
                break;
            case 23:
                System.out.print("Transponowanie C:\n");
                break;
            case 3:
                System.out.print("Wyswietl macierze\n"
                        + "(1)Wyswietl macierze wejsciowe\n"
                        + "(2)Wyswietl macierze wynikowe\n"
                        + "Podaj nr: ");
                break;
            case 311:
                System.out.print("Macierz A:\n");
                break;
            case 312:
                System.out.print("Macierz B:\n");
                break;
            case 32:
                System.out.print("Macierz C:\n");

        }
    }

    public String formButtonsText(int n) {
        switch (n) {
            case 0:
                return "Wprowadz macierze wejsciowe.";
            case 1:
                return "Transponuj macierze wejsciowe";
            case 2:
                return "Pomnoz macierze wejsciowe";
            case 3:
                return "Transponuj macierz wynikowa";
            case 4:
                return "Wyswietl macierze wejsciowe";
            case 5:
                return "Wyswietl macierze wynikowe";
            case 6:
                return "Zatwierdź rozmiar";
            case 7:
                return "Zatwierdź macierz";
            case 8:
                return "";
        }
        return null;
    }

    public String formLabelsText(int n) {
        switch (n) {
            case 0:
                return "Wypełnianie macierzy.";
            case 1:
                return "Operacje arytmetyczne.";
            case 2:
                return "Wyswietl macierze.";
            case 3:
                return "Podaj wymiary macierzy R x C";
            case 4:
                return "Podaj wartości macierzy A";
            case 5:
                return "Podaj wartości macierzy B";
            case 6:
                return "Macierz A";
            case 7:
                return "Macierz B";
            case 8:
                return "Macierz C";
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixapp.Controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import matrixapp.Model.Matrix;
import matrixapp.View.MatrixView;

/**
 *
 * @author Matius
 */
public class MatrixController extends JFrame implements ActionListener {

    private MatrixView view;
    private Matrix[] models;

    private final JFrame frame;
    private final JPanel[] panels;
    private int panelsCount;

    private final JButton[] buttons;
    private final JLabel[] labels;
    private final JLabel errMenuLabel;
    private JTextField[] textFields;

    /*public MatrixController(int n) {
        this.models = new Matrix[n];
        this.view = new MatrixView();
        //this.view.createFrame();
    }*/
    public MatrixController(MatrixView view, int n) {
        this.view = view;
        this.models = new Matrix[n];
        frame = new JFrame();
        panels = new JPanel[3];
        panelsCount = 0;
        buttons = new JButton[8];
        labels = new JLabel[9];
        errMenuLabel = new JLabel();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(view.formButtonsText(i));
        }
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(view.formLabelsText(i), JLabel.CENTER);
        }

        frame.setLayout(new GridLayout());
        panels[panelsCount] = createMenuPanel();
        frame.add(panels[panelsCount - 1]);

        //event a = new event();
        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);
        buttons[2].addActionListener(this);
        buttons[3].addActionListener(this);
        buttons[4].addActionListener(this);
        buttons[5].addActionListener(this);
        buttons[6].addActionListener(this);
        buttons[7].addActionListener(this);
    }

    //public class event implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == buttons[0]) {
            removePanel();
            panels[panelsCount] = createMatrixSizePanel();
            frame.add(panels[panelsCount - 1]);
            frame.pack();
        } else if (obj == buttons[1]) {
            removePanel();
            transposeMatrixController(0);
            transposeMatrixController(1);
            frame.pack();
        } else if (obj == buttons[2]) {
            removePanel();

            mulMatrixController(this.getMatrixController(0), this.getMatrixController(1), 2);
            frame.pack();
        } else if (obj == buttons[3]) {
            removePanel();
            transposeMatrixController(2);
            frame.pack();
        } else if (obj == buttons[4]) {
            removePanel();
            panels[panelsCount] = createMatrixViewPanel(labels[6].getText(), getTabController(0), getRController(0), getCController(0));
            frame.add(panels[panelsCount - 1]);
            panels[panelsCount] = createMatrixViewPanel(labels[7].getText(), getTabController(1), getRController(1), getCController(1));
            frame.add(panels[panelsCount - 1]);
            frame.pack();
        } else if (obj == buttons[5]) {
            removePanel();
            panels[panelsCount] = createMatrixViewPanel(labels[8].getText(), getTabController(2), getRController(2), getCController(2));
            frame.add(panels[panelsCount - 1]);
            frame.pack();
        } else if (obj == buttons[6]) {
            removePanel();
            newMatrixController(Integer.parseInt(textFields[0].getText()), Integer.parseInt(textFields[1].getText()), 0);
            newMatrixController(Integer.parseInt(textFields[1].getText()), Integer.parseInt(textFields[0].getText()), 1);
            panels[panelsCount] = createMatrixInsertPanel(getRController(0), getCController(0), 4);
            frame.add(panels[panelsCount - 1]);
            //panels[panelsCount] = createMatrixInsertPanel(getRController(1), getCController(1), 5);
            //frame.add(panels[panelsCount - 1]);
            frame.pack();
        } else if (obj == buttons[7]) {

        }
    }
    //}

    public void createFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(900, 400);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Macierze");
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        //panel.setPreferredSize(new Dimension(250, 400));
        panel.add(labels[0]);
        panel.add(buttons[0]);
        panel.add(labels[1]);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(labels[2]);
        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(errMenuLabel);
        panelsCount++;
        return panel;
    }

    private JPanel createMatrixSizePanel() {
        JPanel panel = new JPanel();
        textFields = new JTextField[2];
        panel.setLayout(new GridLayout(0, 1));

        panel.add(labels[3]);
        panel.add(textFields[0] = new JTextField());
        panel.add(textFields[1] = new JTextField());
        panel.add(buttons[6]);
        panel.add(errMenuLabel);
        panelsCount++;
        return panel;

    }

    private JPanel createMatrixInsertPanel(int a, int b, int n) {
        JPanel panel = new JPanel();
        GridBagConstraints x = new GridBagConstraints();
        textFields = new JTextField[a * b];
        panel.setLayout(new GridBagLayout());

        x.fill = GridBagConstraints.HORIZONTAL;
        x.gridwidth = b;
        x.gridx = 0;
        x.gridy = 0;
        panel.add(labels[n], x);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                x.fill = GridBagConstraints.HORIZONTAL;
                x.gridwidth = 1;
                x.gridx = j;
                x.gridy = i + 1;
                x.weightx = 0.5;
                x.weighty = 0.5;
                panel.add(textFields[i + j] = new JTextField(), x);
            }
        }
        x.fill = GridBagConstraints.HORIZONTAL;
        x.gridwidth = 1;
        x.gridx = 0;
        x.gridy = a + 1;
        panel.add(buttons[7]);
//        x.fill = GridBagConstraints.HORIZONTAL;
//        x.gridwidth = b;
//        x.gridx = 0;
//        x.gridy = a + 2;
//
//        panel.add(errMenuLabel);
        panelsCount++;
        return panel;
    }

    private JPanel createMatrixViewPanel(String text, int[][] tab, int r, int c) {
        JPanel panel = new JPanel();
        GridBagConstraints x = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());

        x.fill = GridBagConstraints.HORIZONTAL;
        x.gridwidth = c;
        x.gridx = 0;
        x.gridy = 0;
        panel.add(new JLabel(text, JLabel.CENTER), x);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                x.fill = GridBagConstraints.HORIZONTAL;
                x.gridwidth = 1;
                x.gridx = j;
                x.gridy = i + 1;
                panel.add(new JLabel(this.toString(tab[i][j]), JLabel.CENTER), x);
            }
        }
        panelsCount++;
        return panel;
    }

    private void removePanel() {
        for (int i = panelsCount; i > 1; i--) {
            frame.remove(panels[panelsCount - 1]);
            panels[panelsCount - 1].removeAll();
            panelsCount--;
        }
    }

    private String toString(int i) {
        return " " + i;
    }

    public void newMatrixController(int r, int c, int n) {
        models[n] = new Matrix(r, c);
    }

    public Matrix getMatrixController(int n) {
        return models[n];
    }

    public void setMatrixController(Matrix matrix, int n) {
        this.models[n] = matrix;
    }

    public MatrixView getViewController() {
        return view;
    }

    public void setViewController(MatrixView view) {
        this.view = view;
    }

    public int getRController(int n) {
        if (models[n] != null) {
            return models[n].getR();
        } else {
            //view.errMatrix();
            errMatrixLabel("Brak rozmiaru wierszy");
            return 0;
        }
    }

    public void setRController(int r, int n) {
        models[n].setR(r);
    }

    public int getCController(int n) {
        if (models[n] != null) {
            return models[n].getC();
        } else {
            //view.errMatrix();
            errMatrixLabel("Brak rozmiaru kolumn");
            return 0;
        }
    }

    public void setCController(int c, int n) {
        models[n].setC(c);
    }

    public void newTabController(int r, int c, int n) {
        models[n].newTab(r, c);
    }

    public int[][] getTabController(int n) {
        if (models[n] != null) {
            return models[n].getTab();
        } else {
            //view.errMatrix();
            errMatrixLabel("Brak tablicy");
            return null;
        }
    }

    public void setTabController(int[][] tab, int n) {
        models[n].setTab(tab);
    }

    public void fillMatrixController(int n, int[][] tab) {
        if (models[n] != null) {
            if (tab == null) {
                Scanner z;
                System.out.printf("Wypelnianie macierzy:\n");
                z = new Scanner(System.in);
                for (int i = 0; i < models[n].getR(); i++) {
                    System.out.print("R" + i + " C" + models[n].getC() + " ");

                    for (int j = 0; j < models[n].getC(); j++) {
                        models[n].setTabElement(i, j, z.nextInt());
                    }
                }
            } else {
                for (int i = 0; i < models[n].getR(); i++) {
                    for (int j = 0; j < models[n].getC(); j++) {
                        models[n].setTabElement(i, j, tab[i][j]);
                    }
                }
            }
        } else {
            //view.errMatrix();
            errMatrixLabel("Brak modelu");
        }
    }

    public void transposeMatrixController(int n) {
        if (models[n] != null) {
            int[][] tab2 = new int[models[n].getR()][models[n].getC()];
            int t;

            tab2 = models[n].getTab();
            t = models[n].getR();
            models[n].setR(models[n].getC());
            models[n].setC(t);
            models[n].newTab(models[n].getR(), models[n].getC());

            for (int i = 0; i < models[n].getR(); i++) {
                for (int j = 0; j < models[n].getC(); j++) {
                    models[n].setTabElement(i, j, tab2[j][i]);
                }
            }
        } else {
            errMatrixLabel("Brak macierzy");
            //view.errMatrix();
        }
    }

    public void mulMatrixController(Matrix matrixA, Matrix matrixB, int n) {
        if ((matrixA != null) && (matrixB != null)) {
            if (matrixA.getR() == matrixB.getC()) {
                newMatrixController(matrixA.getR(), matrixB.getC(), 2);

                for (int i = 0; i < matrixA.getR(); i++) {
                    for (int j = 0; j < matrixB.getC(); j++) {
                        for (int k = 0; k < matrixB.getR(); k++) {
                            models[n].setTabElement(i, j, models[n].getTabElement(i, j) + matrixA.getTabElement(i, k) * matrixB.getTabElement(k, j));
                        }
                    }
                }
            } else {
                System.err.printf("Liczba kolumn macierzy A musi być równa liczbie wierszy macierzy B!\n");
            }
        } else {
            if (matrixA == null) {
                errMatrixLabel("Brak macierzy A");
                //view.errMatrix();
            }
            if (matrixB == null) {
                errMatrixLabel("Brak macierzy B");
                //view.errMatrix();
            }
        }
    }

    public void printViewController(int n) throws InterruptedException {
        if (models[n] != null) {
            view.printMatrix(models[n].getTab(), models[n].getR(), models[n].getC());
        } else {
            view.errMatrix();
        }
    }

    public void printMenuController() throws InterruptedException {
        Scanner n;
        int m, k;

        while (true) {
            n = new Scanner(System.in);
            view.menuView(1);
            switch (n.nextInt()) {
                case 1:
                    view.menuView(11);
                    m = n.nextInt();
                    k = n.nextInt();
                    this.models[0] = new Matrix(m, k);
                    this.fillMatrixController(0, null);
                    this.models[1] = new Matrix(k, m);
                    this.fillMatrixController(1, null);

                    break;

                case 2:
                    view.menuView(2);
                    switch (n.nextInt()) {
                        case 1:
                            this.view.menuView(211);
                            this.transposeMatrixController(0);
                            this.view.menuView(212);
                            this.transposeMatrixController(1);
                            break;

                        case 2:
                            view.menuView(22);
                            this.models[2] = new Matrix(this.models[0].getR(), this.models[1].getC());
                            this.mulMatrixController(models[0], models[1], 2);
                            break;

                        case 3:
                            view.menuView(23);
                            this.transposeMatrixController(2);
                            break;

                        default:
                            System.out.print("2 Podaj nr 1-3!\n");
                    }
                    break;

                case 3:
                    view.menuView(3);
                    switch (n.nextInt()) {
                        case 1:
                            view.menuView(311);
                            this.printViewController(0);
                            view.menuView(312);
                            this.printViewController(1);
                            break;

                        case 2:
                            view.menuView(32);
                            this.printViewController(2);
                            break;

                        default:
                            System.out.print("3 Podaj nr 1-2!\n");
                    }
                    break;

                default:
                    System.out.print("0 Podaj nr 1-3!\n");
            }
        }
    }

    public void errMatrixLabel(String text) {
        if (text == null) {
            errMenuLabel.setText("Macierz posiada bledy!");
        } else {
            errMenuLabel.setText(text);
        }
        //TimeUnit.MILLISECONDS.sleep(100);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixapp;

import matrixapp.Controller.MatrixController;
import matrixapp.View.MatrixView;

/**
 *
 * @author Matius
 */
public class MatrixApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        MatrixController Controller;
        MatrixView view = new MatrixView();
        Controller = new MatrixController(view, 3);
        Controller.createFrame();
        Controller.printMenuController();
        //View.createFrame();
        //Controller.run();
        //Controller.printMenuController();
    }

}

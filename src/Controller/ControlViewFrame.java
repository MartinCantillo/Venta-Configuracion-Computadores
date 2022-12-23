/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import View.Register;
import View.ViewFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import javax.swing.JPanel;

/**
 *
 * @author marti
 */
public class ControlViewFrame {

    private Register regist;
    private Centralunit comput;
    private Customer custo;
    private Input inp;
    private Outs out;
    private Peripherals peri;
    private Sales sal;
    ViewFrame view = new ViewFrame();

    public ControlViewFrame(Register regist, Centralunit comput, Customer custo, Input inp, Outs out, Peripherals peri, Sales sal) {
        this.regist = regist;
        this.comput = comput;
        this.custo = custo;
        this.inp = inp;
        this.out = out;
        this.peri = peri;
        this.sal = sal;
    }

    public void iniciar() {
        view.setVisible(true);
    }

}

/**
 *
 * @param e
 */

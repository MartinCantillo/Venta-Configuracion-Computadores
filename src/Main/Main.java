/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.ControlViewFrame;
import Model.*;
import View.*;

/**
 *
 * @author marti
 */
public class Main {

    public static void main(String[] args) {
        Register regist = new Register();
        Centralunit comput = new Centralunit();
        Customer custo = new Customer();
        Input inp = new Input();
        Outs out = new Outs();
        Peripherals peri = new Peripherals();
        Sales sal = new Sales();
        ControlViewFrame c = new ControlViewFrame(regist, comput, custo, inp, out, peri, sal);
        c.iniciar();

    }
}

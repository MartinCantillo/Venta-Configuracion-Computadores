/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author marti
 */
public class Sales {

    private int codigoventa;
    private String vendedor;
    private Date fecha;

    public Sales() {
    }

    public Sales(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public int getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Sales{" + "codigoventa=" + codigoventa + ", vendedor=" + vendedor + ", fecha=" + fecha + '}';
    }

}

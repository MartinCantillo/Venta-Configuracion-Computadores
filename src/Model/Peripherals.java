/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author marti
 */
public class Peripherals {

    protected int codigo;
    protected String nombreFabricante;
    protected String modelo;
    protected int precio;

    public Peripherals() {
    }

    public Peripherals(int precio) {
        this.precio = precio;
    }

    public Peripherals(int codigo, String nombreFabricante, String modelo, int precio) {
        this.codigo = codigo;
        this.nombreFabricante = nombreFabricante;
        this.modelo = modelo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Peripherals{" + "codigo=" + codigo + ", nombreFabricante=" + nombreFabricante + ", modelo=" + modelo + ", precio=" + precio + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author marti
 */
public class Centralunit extends Peripherals {

    private String nombre;
    private String tipo;

    public Centralunit() {
    }

    public Centralunit(String nombre, int precio) {
        super(precio);
        this.nombre = nombre;
    }

    public Centralunit(String nombre) {
        this.nombre = nombre;
    }

    public Centralunit(String nombre, int codigo, String nombreFabricante, String modelo, int precio) {
        super(codigo, nombreFabricante, modelo, precio);
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Centralunit{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }

}

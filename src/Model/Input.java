/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author marti
 */
public class Input extends Peripherals {

    private String nombre;
    private String tipo;

    public Input() {
    }

    public Input(String nombre, int precio) {
        super(precio);
        this.nombre = nombre;
    }

    public Input(String nombre, int codigo, String nombreFabricante, String modelo, int precio) {
        super(codigo, nombreFabricante, modelo, precio);
        this.nombre = nombre;
    }

    public Input(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = "Entrada";
    }

    public Input(String nombre, String tipo, int codigo, String nombreFabricante, String modelo, int precio) {
        super(codigo, nombreFabricante, modelo, precio);
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNombreFabricante() {
        return nombreFabricante;
    }

    @Override
    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Input{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }

}

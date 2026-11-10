/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melany Chara,Sara Catacoli y Nicolas Garzon
 */
public class Moto extends Vehiculo {
    private static final double PRECIO_HORA = 1000;
    private static final int LIMITE_CILINDRAJE = 200;
    private static final double RECARGO = 1.2; 
    private int cilindraje;
    
    public int getCilindraje(){
    return this.cilindraje;
    }
    public void setCilindraje(int cilindraje){
    if (cilindraje>0){
    this.cilindraje=cilindraje;
    }else{
        System.out.println("El cilindraje debe ser mayor a 0");
    }
    }
    public Moto(String placa,int hora,int cilindraje){
    super(placa,hora);
    setCilindraje(cilindraje);
    }
    @Override
    public double calcularCobro(){
        double total = getHora() * PRECIO_HORA;
        if(cilindraje>LIMITE_CILINDRAJE){
        return total*RECARGO;
        }else{
        return total;
        }
    
    }
    @Override
    public String toString(){
    return super.toString()+" | Cilindraje: "+cilindraje;
    }
}

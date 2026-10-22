/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOME
 */
public class Moto extends Vehiculo {
    
    private int cilindraje;
    
    public int getCilindraje(){
    return this.cilindraje;
    }
    public void setCilindraje(int cilindraje){
    if (cilindraje>0){
    this.cilindraje=cilindraje;
    }
    }
    public Moto(String placa,int hora,int cilindraje){
    super(placa,hora);
    setCilindraje(cilindraje);
    }
    @Override
    public double calcularCobro(){
        int precioHora=1000;
        if(cilindraje>200){
        double totalCobro=getHora()*precioHora;
        return totalCobro*0.2;
        }else{
        return getHora()*precioHora;
        }
    
    }
    @Override
    public String toString(){
    return super.toString()+" | Cilindraje: "+cilindraje;
    }
}

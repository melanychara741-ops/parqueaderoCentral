/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOME
 */
public abstract class Vehiculo {
    
    private String placa;
    private int hora;
    private static int totalVehiculosCreados=0;
    
    public String getPlaca(){return this.placa;}
    public void setPlaca(String placa){
    if(placa==null|| placa.isEmpty()){
    System.out.println("La placa no puede ser nula ni vacia");
    }else{
    this.placa=placa;
    }
    }
    
    public int getHora(){return this.hora;}
    public void setHora(int hora){
    if (hora<1){
    System.out.println("La hora debe ser mayor a una");
    }else{
    this.hora=hora;
    }
    }
    
    public Vehiculo(String placa,int hora){
    setPlaca(placa);
    setHora(hora);
    totalVehiculosCreados++;
    }

    public static int getTotalVehiculos(){
    return totalVehiculosCreados;
    }
    
    public abstract double calcularCobro();
    @Override
    public String toString(){
    return "Placa: "+placa+" | Cantidad de horas: "+hora+" | cobro: "+calcularCobro();
    }
    public void mostrar(){
    System.out.println("Vehiculo: "+this.toString());
    }

}

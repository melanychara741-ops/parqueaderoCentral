/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOME
 */
public class Camion extends Vehiculo{
   
    private int toneladas;
    double precioHora=3000;
    
    public int getToneladas(){return this.toneladas;}
    public void setToneladas(int toneladas){
    if(toneladas>0){
    this.toneladas=toneladas;
    }else{
    System.out.println("No se puede tener valores negativos en las toneladas");
    }
    }
    public Camion(String placa,int hora,int toneladas){
    super(placa,hora);
    setToneladas(toneladas);
    }
    @Override
    public double calcularCobro(){
    double totalcobro=precioHora*getHora();
    return totalcobro+500*toneladas;
    }
    @Override
    public String toString(){
    return super.toString()+" | Toneladas: "+toneladas;
    }
}

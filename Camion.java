/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melany Chara,Sara Catacoli y Nicolas Garzon
 */
public class Camion extends Vehiculo{
   
    private int toneladas;
    private static final double PRECIO_HORA = 3000;
    private static final double COSTO_POR_TONELADA = 500;
    
    public int getToneladas(){return this.toneladas;}
    public void setToneladas(int toneladas){
    if(toneladas>=0){
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
    return getHora()*(PRECIO_HORA + COSTO_POR_TONELADA * toneladas);
    }
    @Override
    public String toString(){
    return super.toString()+" | Toneladas: "+toneladas;
    }
}

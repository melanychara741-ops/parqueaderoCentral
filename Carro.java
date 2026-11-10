/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOME
 */
public class Carro extends Vehiculo{
    double precioHora=2000;
    
    public Carro(String placa,int hora){
    super(placa,hora);
    }

    @Override
    public double calcularCobro(){
    double total=0;
    total=getHora()*precioHora;
    if(total>15000){
    total=15000;
    return total;
    }else{
    return total;
    }
    }
}

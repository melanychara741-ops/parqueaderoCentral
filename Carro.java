/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melany Chara,Sara Catacoli y Nicolas Garzon
 */
public class Carro extends Vehiculo{
    private static final double PRECIO_HORA = 2000;
    private static final double TOPE_DIARIO = 15000;
    
    public Carro(String placa,int hora){
    super(placa,hora);
    }
    public Carro(String placa) {
    super(placa);
    }

    @Override
    public double calcularCobro(){
    double total = getHora() * PRECIO_HORA;
    if(total>TOPE_DIARIO){
    return TOPE_DIARIO;
    }
    return total;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

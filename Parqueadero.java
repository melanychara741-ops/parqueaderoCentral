/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOME
 */
public class Parqueadero {
    private Vehiculo[][]cupos =new Vehiculo[3][4];
    static double totalRecaudado;
    
    public static double getTotalRecaudado(){
    return totalRecaudado;
    }
    

    public boolean estacionar(Vehiculo v){
    for(int i=0;i<cupos.length;i++){
    for(int j=0;j<cupos[i].length;j++){
    if(cupos[i][j]==null){
    cupos[i][j]=v;
    return true;
    }
    }
    }
    return false;
    }
    
    Vehiculo buscarPlaca(String placa){
    for(int i=0;i<cupos.length;i++){
    for(int j=0;j<cupos[i].length;j++){
    if(cupos[i][j]!=null && cupos[i][j].getPlaca().equals(placa)){
    return cupos[i][j];
    }
    }
    }
    return null;
    }
    
        public double retirar(String placa) {
        for (int i = 0; i < cupos.length; i++) {
            for (int j = 0; j < cupos[i].length; j++) {
                Vehiculo v = cupos[i][j];
                if (v != null && v.getPlaca().equals(placa)) {
                    double cobro = v.calcularCobro();
                    totalRecaudado += cobro;
                    cupos[i][j] = null;        
                    return cobro;
                }
            }
        }
        return -1;
    }
 
    public int cuposLibres() {
        int libres = 0;
        for (Vehiculo[] piso : cupos) {
            for (Vehiculo v : piso) {
                if (v == null) {
                    libres++;
                }
            }
        }
        return libres;
    }
 

    public Vehiculo mayorCobro() {
        Vehiculo mayor = null;
        for (Vehiculo[] piso : cupos) {
            for (Vehiculo v : piso) {
                if (v != null) {
                    if (mayor == null || v.calcularCobro() > mayor.calcularCobro()) {
                        mayor = v;
                    }
                }
            }
        }
        return mayor;
    }
 
    public void mostrarOcupacion() {
        for (int i = 0; i < cupos.length; i++) {
            System.out.println("Piso " + (i + 1) + ":");
            for (int j = 0; j < cupos[i].length; j++) {
                if (cupos[i][j] == null) {
                    System.out.println("  Cupo " + (j + 1) + ": LIBRE");
                } else {
                    System.out.println("  Cupo " + (j + 1) + ": " + cupos[i][j].getPlaca());
                }
            }
        }
    }
}



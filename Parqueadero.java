/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melany Chara,Sara Catacoli y Nicolas Garzon
 */
public class Parqueadero {
    private Vehiculo[][]cupos =new Vehiculo[3][4];
    private static double totalRecaudado;
    private Vehiculo vehiculoMayorCobro;
    private double mayorCobroValor;
    
    public static double getTotalRecaudado(){
    return totalRecaudado;
    }
    

    public boolean estacionar(Vehiculo v){
    if(buscarPlaca(v.getPlaca())!=null){
    return false;
    }
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
    
    public Vehiculo buscarPlaca(String placa){
    for(int i=0;i<cupos.length;i++){
    for(int j=0;j<cupos[i].length;j++){
    if(cupos[i][j]!=null && cupos[i][j].getPlaca().equalsIgnoreCase(placa)){
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
    if (v != null && v.getPlaca().equalsIgnoreCase(placa)) {
    double cobro = v.calcularCobro();
    totalRecaudado += cobro;
    
    if(vehiculoMayorCobro==null || cobro>mayorCobroValor){   
    vehiculoMayorCobro=v;                                
    mayorCobroValor=cobro;                               
}   
    cupos[i][j] = null;        
    return cobro;
    }
    }
    }
    
    return -1;
    }
 
    public int cuposLibres() {
    int libres = 0;
    for (int i = 0; i < cupos.length; i++) {
    for (int j = 0; j < cupos[i].length; j++) {
    if (cupos[i][j] == null) {
    libres++;
    }
    }
    }
    return libres;
    }
    
    public boolean estaVacio(){               
        return cuposLibres()==cupos.length*cupos[0].length;
    }
 

    public Vehiculo mayorCobro() {
    Vehiculo mayor = null;
    for (int i = 0; i < cupos.length; i++) {
    for (int j = 0; j < cupos[i].length; j++) {
    if (cupos[i][j] != null) {
    if (mayor == null || cupos[i][j].calcularCobro() > mayor.calcularCobro()) {
    mayor = cupos[i][j];
    }
    }
    }
    }
    if(vehiculoMayorCobro!=null && (mayor==null || mayorCobroValor>mayor.calcularCobro())){
        return vehiculoMayorCobro;      
     }
     return mayor;   
    
    }
 
    public void mostrarOcupacion(){
    System.out.print("        ");
    for(int j=0;j<cupos[0].length;j++){
        System.out.print("Cupo"+(j+1)+"  ");
    }
    System.out.println();
    for(int i=0;i<cupos.length;i++){
        System.out.print("Piso "+(i+1)+"  ");
        for(int j=0;j<cupos[i].length;j++){
            if(cupos[i][j]==null){
                System.out.print("  L    ");
            }else{
                System.out.print("  X    ");
            }
        }
        System.out.println();
    }
    System.out.println("X = ocupado   L = libre");
}
}



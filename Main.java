/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melany Chara,Sara Catacoli y Nicolas Garzon
 */
import java.util.Scanner;

public class Main {
   
static int leerEntero(Scanner scan, String mensaje, int minimo) {
int valor;
    do {
    System.out.print(mensaje);
    valor = scan.nextInt();
    if (valor < minimo) {
      System.out.println("El valor debe ser mayor o igual a " + minimo);
       }
    } while (valor < minimo);
        return valor;
    }
 
   
    static Vehiculo pedirVehiculo(Scanner scan) {
    int tipo;
    do {
    System.out.println("Tipo de vehiculo: 1. Moto  2. Carro  3. Camion");
    tipo = scan.nextInt();
    if (tipo < 1 || tipo > 3) {
      System.out.println("Tipo invalido");
      }
    } while (tipo < 1 || tipo > 3);
 
    System.out.print("Placa: ");
    String placa = scan.next();
    int horas = leerEntero(scan, "Horas de permanencia: ", 1);
 
    switch (tipo) {
    case 1:
    int cilindraje = leerEntero(scan, "Cilindraje: ", 1);
    return new Moto(placa, horas, cilindraje);
      case 2:
        return new Carro(placa, horas);
        default:
        int toneladas = leerEntero(scan, "Toneladas: ", 0);
        return new Camion(placa, horas, toneladas);
        }
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();
        int opc;
        System.out.println("Bienvenido...");
 
        do {
            
            System.out.println("////PARQUEADERO CENTRAL////");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Mostrar ocupacion");
            System.out.println("3. Retirar vehiculo y cobrar");
            System.out.println("4. Cupos libres");
            System.out.println("5. Vehiculo con mayor cobro");
            System.out.println("6. Reporte (vehiculos creados y total recaudado)");
            System.out.println("7. Salir");
            System.out.print("Ingresa una opcion: ");
            opc = scan.nextInt();
            boolean vacio = parqueadero.mayorCobro() == null;
            if ((opc == 2 || opc == 3 || opc == 5) && vacio) {
                System.out.println("El parqueadero esta vacio. Primero registra un vehiculo");
                continue;
            }
 
            switch (opc) {
            case 1: {
                Vehiculo v = pedirVehiculo(scan);
                  
                if (parqueadero.estacionar(v)) {
                System.out.println("Vehiculo registrado correctamente.");
                } else if (parqueadero.buscarPlaca(v.getPlaca()) != null) {
                System.out.println("Esa placa ya esta registrada.");
                }else {
                System.out.println("No hay cupos disponibles.");
                }
                break;
                }
                case 2:
                    
                    parqueadero.mostrarOcupacion();
                    break;
                    
                    case 3: {
                    System.out.print("Placa del vehiculo a retirar: ");
                    String placa = scan.next();
                    double cobro = parqueadero.retirar(placa);
                    if (cobro == -1) {
                        System.out.println("No hay ningun vehiculo con esa placa.");
                    } else {
                        System.out.println("Vehiculo retirado. Total a pagar: $" + cobro);
                    }
                    break;
                }
                    case 4:
                        System.out.println("Cupos libres: " + parqueadero.cuposLibres());
                    break;
                    case 5:
                        System.out.println("Vehiculo con mayor cobro:");
                        parqueadero.mayorCobro().mostrar();
                        break;
                        case 6:  
                            System.out.println("Vehiculos creados: " + Vehiculo.getTotalVehiculos());
                            System.out.println("Total recaudado: $" + Parqueadero.getTotalRecaudado());
                            break;
                            case 7:
                        
                                System.out.println("Hasta luego...");
                                break;
                                default:
                                System.out.println("Opcion invalida");
                                break;
            }
 
        } while (opc != 7);
 
        scan.close();
    }    
}

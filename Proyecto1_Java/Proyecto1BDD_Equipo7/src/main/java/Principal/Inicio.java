/*
 * PROGRAMA PRINCIPAL PARA LA REALIZACION Y BUSQUEDA DE LAS CONSULTAS DEL PROYECTO
 */
package Principal;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Equipo7BDD
 */
public class Inicio {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //Comenzamos con un menu para realizar las diferentes consultas
    Scanner sn=new Scanner(System.in);
    boolean salir = false;
    int op;
    while(!salir){
    System.out.println("------------MENU------------");
    System.out.println("1.-Total de Ventas de producto");
    System.out.println("2.-Consultar producto mas solicitado para norteamerica");
    System.out.println("3.-Actualizar Stock por categoria un 5%");
    System.out.println("4.-Determinacion de clientes en otras regiones");
    System.out.println("5.-Actualizar cantidad de productos por orden");
    System.out.println("6.-Actualizar Metodo de envio de una orden");
    System.out.println("7.-Actualizar correo electronico de cliente");
    try{
        System.out.println("Escoga una opcion");
        op=sn.nextInt();
        switch(op){
        case 1:
            System.out.println("---Total de Ventas de producto---");
            break;
        case 2:
            System.out.println("---Consultar producto mas solicitado para norteamerica---");
            break;
        case 3:
            System.out.println("---Actualizar Stock por categoria un 5%---");
            break;
        case 4:
            System.out.println("---Determinacion de clientes en otras regiones---");
            break;
        case 5:
            System.out.println("---Actualizar cantidad de productos por orden---");
            break;
        case 6:
            System.out.println("---Actualizar Metodo de envio de una orden---");
            break;
        case 7:
            System.out.println("---Actualizar correo electronico de cliente---");
            break;
        case 8:
            salir=true;
            break;
        default:
            System.out.println("Solo numeros de 1 a 8");
        }
    }catch(InputMismatchException e){
        System.out.println("Debe de insertar un numero");
        sn.next();
    }   
}
}
}

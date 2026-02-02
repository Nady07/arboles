/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examendearbol;
import java.util.ArrayList;
/**
 *
 * @author nadia
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolABB A = new ArbolABB();
        A.insertar(21);
        System.out.println("insertar:");
        A.insertar(9);
        A.insertar(20);
        A.inOrden();
        
        System.out.println("inOrde:" + A.inOrden());
        System.out.println("se encuentra?:" + A.seEncuentra(8));
        System.out.println("cantidad:" + A.cantidad());
        System.out.println("suma: " + A.suma());
        System.out.println("mayor: " + A.mayor());
        System.out.println("menor: " + A.menor());
        System.out.println("menor1: " + A.menor1());
        
        A.eliminar(9);
        System.out.println("eliminar " + A.inOrden());
    }
    
}

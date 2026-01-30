/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author nadia
 */
public class Pract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista L1 = new Lista();
        Lista L2 = new Lista();
        Lista L3 = new Lista();
        

        
        L1.inseratPrim(2);
        L1.insertarUlt(4);
        L1.insertarLugarAsc(3);
        L1.insertarDesc(4);
        System.out.println("Lista con inertar" + L1);
        
        L1.insertarIesimo(5, 5);
        System.out.println("insertar desde una poscision" + L1);
        L2.inseratPrim(7);
        L2.insertarUlt(8);
        System.out.println("LIsta L2:" +L2);
        L1.insertatLista(L2, 0);
        System.out.println("insertar L2 en L1:" + L1);
                L3.inseratPrim(9);
        L3.insertarUlt(10);
        System.out.println("Lista L3:"+L3);
        
        L1.unir(L2, L3);
        System.out.println("unir L2 y L3:" + L2);
        
        
    }
    
}

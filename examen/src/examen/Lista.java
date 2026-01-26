/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author nadia
 */
public class Lista {

    Nodo prim, ult;
    int canElem;

    Lista() {
        prim = ult = null;
        canElem = 0;
    }

    public String toString() {
        String s = "[";
        Nodo p = prim;
        while (p != null) {
            s += p.elem;
            if (p.prox != null) {
                s += ",";
            }
            p = p.prox;
        }
        return s + "]";
    }

    public boolean vacia() {
        return prim == null;
    }

    public void insertPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            prim = prim.ant = new Nodo(null, x, prim);
        }
        canElem++;

    }

    public void insertUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        canElem++;
    }

    public void elimPrim() {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            prim.prox.ant = null;
            prim = prim.prox;
        }
        canElem--;
    }

    public void elimUlt() {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            ult.ant.prox = null;
            ult = ult.ant;
        }
        canElem--;
    }

    public boolean iguales() {
        if (vacia()) {
            return true;
        }
        int x = prim.elem;
        Nodo p = prim;
        while (p != null) {
            if (p.elem != x) {
                return false;
            } else {
                p = p.prox;
            }
        }
        return true;
    }

    public int MayorElem() {
        if (vacia()) {
            return -1;
        }
        int x = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem > x) {
                x = p.elem;
            }
            p = p.prox;

        }
        return x;
    }

    public boolean pares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public void reemplazar(int x, int y) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }

    public boolean seEncuentra(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    public boolean todoPares() {
        return pares();
    }

    public void insertarPrim(Lista L2) {
        if (L2.vacia()) {
            return;
        }

        Nodo p = L2.ult; // recorrer L2 desde el final
        while (p != null) {
            insertPrim(p.elem);
            p = p.ant;
        }
    }

    public void insertarUlt(Lista L2) {
        if (L2.vacia()) {
            return;
        }

        Nodo p = L2.prim;
        while (p != null) {
            insertUlt(p.elem);
            p = p.prox;
        }
    }

    public void unir(Lista L1, Lista L2) {
        Nodo p = L1.prim;
        while (p != null) {
            insertUlt(p.elem);
            p = p.prox;
        }
        p = L2.prim;
        while (p != null) {
            insertUlt(p.elem);
            p = p.prox;
        }
    }

    public void intercalar(Lista L2, Lista L3) {
        prim = ult = null;
        canElem = 0;

        Nodo p2 = L2.prim;
        Nodo p3 = L3.prim;

        while (p2 != null || p3 != null) {
            if (p2 != null) {
                insertUlt(p2.elem);
                p2 = p2.prox;
            }
            if (p3 != null) {
                insertUlt(p3.elem);
                p3 = p3.prox;
            }
        }
    }

    public void eliminarX(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                if (p == prim) {
                    elimPrim();
                } else if (p == ult) {
                    elimUlt();
                } else {
                    p.ant.prox = p.prox;
                    p.prox.ant = p.ant;
                    canElem--;
                }
                return;
            }
            p = p.prox;
        }
    }

    public void eliminarPares() {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (p.elem % 2 == 0) {
                eliminarX(p.elem);
            }
            p = sig;
        }
    }

    public void eliminarPrim(int n) {
        while (n-- > 0 && prim != null) {
            elimPrim();
        }
    }

    public void eliminarUlt(int n) {
        while (n-- > 0 && ult != null) {
            elimUlt();
        }
    }

    public void vaciar() {
        prim = ult = null;
        canElem = 0;
    }

    public void eliminarExtremos(int n) {
        eliminarPrim(n);
        eliminarUlt(n);
    }

    public boolean todoImpares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
}

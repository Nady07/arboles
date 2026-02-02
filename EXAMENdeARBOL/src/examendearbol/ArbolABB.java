package examendearbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolABB {

    NodoA raiz;

    public ArbolABB() {
        raiz = null;
    }

    public void insertar(int x) {
        raiz = insertarRec(raiz, x);
    }

    private NodoA insertarRec(NodoA p, int x) {
        if (p == null) {
            return new NodoA(x);
        }
        if (x < p.elem) {
            p.izq = insertarRec(p.izq, x);
        } else if (x > p.elem) {
            p.der = insertarRec(p.der, x);
        }
        return p;
    }

    public boolean seEncuentra(int x) {
        NodoA p = raiz;
        while (p != null) {
            if (x == p.elem) {
                return true;
            }
            if (x < p.elem) {
                p = p.izq;
            } else {
                p = p.der;
            }
        }
        return false;
    }

    public int cantidad() {
        return cantidadRec(raiz);
    }

    private int cantidadRec(NodoA p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidadRec(p.izq) + cantidadRec(p.der);
    }

    public int suma() {
        return sumaRec(raiz);
    }

    private int sumaRec(NodoA p) {
        if (p == null) {
            return 0;
        }
        return p.elem + sumaRec(p.izq) + sumaRec(p.der);
    }

    public int mayor() {
        NodoA p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        return p.elem;
    }

    public int menor() {
        NodoA p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        return p.elem;
    }

    public ArrayList<Integer> inOrden() {
        ArrayList<Integer> L = new ArrayList<>();
        inOrdenRec(raiz, L);
        return L;
    }

    private void inOrdenRec(NodoA p, ArrayList<Integer> L) {
        if (p != null) {
            inOrdenRec(p.izq, L);
            L.add(p.elem);
            inOrdenRec(p.der, L);
        }
    }

    public void eliminar(int x) {
        raiz = eliminarRec(raiz, x);
    }

    private NodoA eliminarRec(NodoA p, int x) {
        if (p == null) {
            return null;
        }

        if (x < p.elem) {
            p.izq = eliminarRec(p.izq, x);
        } else if (x > p.elem) {
            p.der = eliminarRec(p.der, x);
        } else {
            if (p.izq == null) {
                return p.der;
            }
            if (p.der == null) {
                return p.izq;
            }

            int menor = menorNodo(p.der);
            p.elem = menor;
            p.der = eliminarRec(p.der, menor);
        }
        return p;
    }

    public void eliminarHojas() {
        raiz = eliminarHojasRec(raiz);
    }

    private NodoA eliminarHojasRec(NodoA p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null) {
            return null;
        }

        p.izq = eliminarHojasRec(p.izq);
        p.der = eliminarHojasRec(p.der);
        return p;
    }

    public void eliminarPares() {
        eliminarParesRec(raiz);
    }

    private void eliminarParesRec(NodoA p) {
        if (p != null) {
            eliminarParesRec(p.izq);
            eliminarParesRec(p.der);
            if (p.elem % 2 == 0) {
                eliminar(p.elem);
            }
        }
    }

    public void eliminarMenor() {
        eliminar(menor());
    }

    public void eliminarMayor() {
        eliminar(mayor());
    }

    public void eliminarArray(ArrayList<Integer> A) {
        for (int x : A) {
            eliminar(x);
        }
    }

    public void eliminarNivel(int n) {
        if (raiz == null) {
            return;
        }

        Queue<NodoA> cola = new LinkedList<>();
        Queue<Integer> niveles = new LinkedList<>();

        cola.add(raiz);
        niveles.add(0);

        while (!cola.isEmpty()) {
            NodoA p = cola.poll();
            int nivel = niveles.poll();

            if (nivel == n) {
                eliminar(p.elem);
            }
            if (p.izq != null) {
                cola.add(p.izq);
                niveles.add(nivel + 1);
            }
            if (p.der != null) {
                cola.add(p.der);
                niveles.add(nivel + 1);
            }
        }
    }

    ///aux
    private int menorNodo(NodoA p) {
        while (p.izq != null) {
            p = p.izq;
        }
        return p.elem;
    }

    public int menor1() {
        return menorNodo(raiz);
    }
}

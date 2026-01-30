
public class Lista {

    Nodo prim, ult;
    int cantElem;

    public Lista() {
        this.cantElem = 0;
        this.prim = null;
        this.ult = null;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo p = prim;
        while (p != null) {
            s += p.elem;
            if (p.prox != null) {
                s = s + ",";
            }
            p = p.prox;
        }
        return s + "]";
    }

    public boolean vacia() {
        return cantElem == 0;
    }

    public void inseratPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            prim = prim.ant = new Nodo(null, x, prim);
        }
        cantElem++;
    }

    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        cantElem++;
    }

    public void eliminarPri() {
        if (prim == ult) {
            prim = ult = null;
        } else {
            prim = prim.prox;
            prim.ant = null;
        }
        cantElem--;
    }

    public void eliminarUlt() {
        if (prim == ult) {
            prim = ult = null;
        } else {
            ult = ult.ant;
            ult.prox = null;
        }
    }

    public void insertarNodo(Nodo ap, Nodo p, int x) {
        if (ap == null) {
            this.inseratPrim(x);
            return;
        }
        if (p == null) {
            this.insertarUlt(x);
            return;
        }
        ap.prox = p.ant = new Nodo(ap, x, p);
        cantElem++;
    }

    public void insertarIesimo(int x, int pos) {
        int k = 0;
        Nodo p = prim;
        Nodo ap = null;
        while (k < pos && p != null) {
            ap = p;
            p = p.prox;
            k++;
        }
        this.insertarNodo(ap, p, x);
    }
    public void unir(Lista L2, Lista L3){
       vacia();
       L2.insertatLista(L3, L2.cantElem);
    }

    public void eliminarIesimo(int pos) {
        int k = 0;
        Nodo p = prim;
        Nodo ap = null;
        while (k < pos && p != null) {
            ap = p;
            p = p.prox;
            k = k + 1;
        }
        this.eliminarNodo(ap, p);

    }

    public Nodo eliminarNodo(Nodo ant, Nodo act) {
        if (act == null) {
            return null;
        }
        if (act == prim) {
            eliminarPri();
            return prim;
        }
        if (act == ult) {
            eliminarUlt();
            return null;
        }
        ant.prox = act.prox;
        act.prox.ant = ant;
        cantElem--;

        return ant.prox;
    }

    public void insertatLista(Lista L2, int pos) {
        Nodo p = L2.prim;
        int i = pos;
        while (p != null) {
            this.insertarIesimo(p.elem, i);
            p = p.prox;
            i++;
        }
    }

    public void insertarLugarAsc(int x) {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null && p.elem < x) {
            ap = p;
            p = p.prox;
        }
        this.insertarNodo(ap, p, x);
    }

    public void insertarDesc(int x) {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null && p.elem > x) {
            ap = p;
            p = p.prox;
        }
        this.insertarNodo(ap, p, x);
    }

    public void generarAsc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int)(Math.random() * (b - a + 1));
            this.insertarLugarAsc(x);
        }
    }

    public void generDesc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            this.insertarDesc(x);
        }
    }

    public boolean seencuentra(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    public void eliminarTodoL2(Lista L2) {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null) {
            if (L2.seencuentra(p.elem)) {
                p = this.eliminarNodo(ap, p);
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

    public void EliminarPrim(int x) {
        Nodo p = prim;
        Nodo ap = null;
        while(p != null){
            if(p.elem == x){
                this.eliminarNodo(ap, p);
                return;
            }
            ap = p;
            p = p.prox;
        }
    }

    public void EliminarUlt(int x) {
        Nodo p = ult;
        while(p != null){
            if(p.elem == x){
                this.eliminarNodo(p.ant, p);
                return;
            }
            p = p.ant;
        }
    }

    public void EliminarTodo(int x) {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null) {
            if (p.elem == x) {
                this.eliminarNodo(ap, p);
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

    public void eliminarPares() {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null) {
            if (p.elem % 2 == 0) {
                this.eliminarNodo(ap, p);
            }else{
                ap = p;
                p = p.prox;
            }
        }
    }
}

// v= (1,4,5,7,9)
// a= {(1-4),(4-1),(5-1),(1-5),(7-9),(9-7),(7-5),(5-7),(4-9),(9-4)}.

// Segundo ejemplo
// V=(c,d,e,f,h)
// y de los arcos
// A= {(C,D), (D,F), (E,H),(H,E) ,(E,C)}
// FORMA DEL GRAFO DIRIGIDO G={V,A}

// añadir arco, borrar arco, añadir arista, borrar arista,
public class Main {

    public static void main(String[] args) {
        operaciones o = new operaciones();
        o.agregarVertice(new Nodo(1));
        o.agregarVertice(new Nodo(4));
        o.agregarVertice(new Nodo(5));
        o.agregarVertice(new Nodo(7));
        o.agregarVertice(new Nodo(9));
        o.agregarArista(1, 4);
        o.agregarArista(4, 1);
        o.agregarArista(5, 1);
        o.agregarArista(1, 5);
        o.agregarArista(7, 9);
        o.agregarArista(9, 7);
        o.agregarArista(7, 5);
        o.agregarArista(5, 7);
        o.agregarArista(4, 9);
        o.agregarArista(9, 4);

        o.mostrarGrafo();
        o.eliminarArista(1, 4);
        o.eliminarVertice(1);
        o.mostrarGrafo();


    }
}

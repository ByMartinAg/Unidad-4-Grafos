// v= (1,4,5,7,9)
// a= {(1-4),(4-1),(5-1),(1-5),(7-9),(9-7),(7-5),(5-7),(4-9),(9-4)}.

// Segundo ejemplo
// V=(c,d,e,f,h)
// y de los arcos
// A= {(C,D), (D,F), (E,H),(H,E) ,(E,C)}
// FORMA DEL GRAFO DIRIGIDO G={V,A}

import java.util.Scanner;

// añadir arco, borrar arco, añadir arista, borrar arista,
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        operaciones grafito = new operaciones();

        int opcion;

        do{
            System.out.println("\nMENU");
            System.out.println("1. Agregar vertice");
            System.out.println("2. Agregar arista");
            System.out.println("3. Eliminar vertice");
            System.out.println("4. Eliminar arista");
            System.out.println("5. Mostrar grafo");
            System.out.println("6. Algoritmo de la ruta mas corta");
            System.out.println("7. Salir");
            System.out.print("\nIngrese una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el dato del vertice");
                    int vertice = teclado.nextInt();
                    grafito.agregarVertice(new Nodo(vertice));
                    break;
                case 2:
                    System.out.println("Ingresa el origen");
                    int origen = teclado.nextInt();
                    System.out.println("Ingresa el destino");
                    int destino = teclado.nextInt();
                    grafito.agregarArista(origen, destino);
                    break;
                case 3:
                    System.out.println("Ingresa el vertice a eliminar");
                    int verticeEliminar = teclado.nextInt();
                    grafito.eliminarVertice(verticeEliminar);
                    break;
                case 4:
                    System.out.println("Ingresa el origen");
                    int origenEliminar = teclado.nextInt();
                    System.out.println("Ingresa el destino");
                    int destinoEliminar = teclado.nextInt();
                    grafito.eliminarArista(origenEliminar, destinoEliminar);
                    break;
                case 5:
                    grafito.mostrar();
                    break;
                case 6:
                    System.out.println("Ingresa el origen");
                    int origenAlgortimo = teclado.nextInt();
                    System.out.println("Ingresa el destino");
                    int destinoAlgoritmo = teclado.nextInt();
                    grafito.dijkstra(origenAlgortimo, destinoAlgoritmo);
                    break;
                case 7:
                    System.out.println("Fin del programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion != 6);
    }
}

// v= {1,2,3,4,5,6}
// a= {(1,2),(1,3),(2,4),(2,5),(3,6),(4,5)}
git
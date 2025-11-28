import java.util.Scanner;
// cosas que tiene que hacer el programa
// añadir arco, borrar arco, añadir arista, borrar arista
public class Main {

    public static void main(String[] args) {
        // variables y objeto
        Scanner teclado = new Scanner(System.in);
        operaciones grafito = new operaciones();
        int opcion;
        // ciclo para el uso del programa
        do{
            // Es el menu del programa para elegir lo que hace
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
                case 1: // Agrega un vertice
                    System.out.println("Ingresa el dato del vertice");
                    int vertice = teclado.nextInt();
                    grafito.agregarVertice(new Nodo(vertice));
                    break;
                case 2: // agrega una arista
                    System.out.println("Ingresa el origen");
                    int origen = teclado.nextInt();
                    System.out.println("Ingresa el destino");
                    int destino = teclado.nextInt();
                    grafito.agregarArista(origen, destino);
                    break;
                case 3: // elimina el vertice
                    System.out.println("Ingresa el vertice a eliminar");
                    int verticeEliminar = teclado.nextInt();
                    grafito.eliminarVertice(verticeEliminar);
                    break;
                case 4: // elimina una arista
                    System.out.println("Ingresa el origen");
                    int origenEliminar = teclado.nextInt();
                    System.out.println("Ingresa el destino");
                    int destinoEliminar = teclado.nextInt();
                    grafito.eliminarArista(origenEliminar, destinoEliminar);
                    break;
                case 5: // muestra el grafo
                    grafito.mostrar();
                    break;
                case 6: // algoritmo de la ruta mas corta con dijkstra
                    System.out.println("Ingresa el origen");
                    int origenAlgortimo = teclado.nextInt();
                    System.out.println("Ingresa el destino");
                    int destinoAlgoritmo = teclado.nextInt();
                    grafito.dijkstra(origenAlgortimo, destinoAlgoritmo);
                    break;
                case 7: // sale del programa
                    System.out.println("Fin del programa");
                    System.exit(0);
                    break;
                default: // en caso de que ninguna sea la que se eligio
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion != 6); // finaliza el programa en la salida.
    }
}

// v= {1,2,3,4,5,6}
// a= {(1,2),(1,3),(2,4),(2,5),(3,6),(4,5)}
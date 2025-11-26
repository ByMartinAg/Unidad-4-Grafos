import java.util.*;

public class operaciones {
    private final Map<Integer, List<Integer>> grafo;

    public operaciones(){
        grafo = new HashMap<>();;
    }

    // agregar vertice
    public void agregarVertice (Nodo nodo) {
        int vertic_e = nodo.getValor();
        if (!grafo.containsKey(vertic_e)) {
            grafo.put(vertic_e, new ArrayList<>());
            System.out.println("Vertice: " + vertic_e + " Agregado");
        } else {
            System.out.println("Ya existe el elemento");
        }
    }

    // agregar arista no dirigida
    public void agregarArista (int origen, int destino){
        if (grafo.containsKey(origen) && grafo.containsKey(destino)){
            grafo.get(origen).add(destino);
            grafo.get(destino).add(origen);
            System.out.println("Arista agregada" + origen + " , " + destino);
        }
        else{
            System.out.println("vertice no existe");
        }
    }

    // eliminar veetice
    public void eliminarVertice(int vert){
        if (grafo.containsKey(vert)){

            grafo.remove(vert);
            for (List<Integer> Lista : grafo.values()){
                Lista.remove(Integer.valueOf(vert));
            }
            System.out.println("Vertice: " + vert + " Eliminado");
        } else {
            System.out.println("Vertice no existe");
        }

    }

    // eliminar arista

    public void eliminarArista(int origen, int destino){
        if (grafo.containsKey(origen) && grafo.containsKey(destino)){
            grafo.get(origen).remove(Integer.valueOf(destino));
            grafo.get(destino).remove(Integer.valueOf(origen));
            System.out.println("Arista eliminada" + origen + " , " + destino);
        }
        else{
            System.out.println("arista no eliminada");
        }
    }

    // mostrar
    public void mostrar(){
        if (grafo.isEmpty()){
            System.out.println("Esta vacio");
        } else {
            System.out.println("El grafo es:");

            for (Integer verti : grafo.keySet()){
                System.out.println(verti + " -> " + grafo.get(verti));
            }
        }
    }

    // algoritmo de Dijkstra
    public void dijkstra(int inicio, int destino) {
        if (!grafo.containsKey(inicio) || !grafo.containsKey(destino)) {
            System.out.println("Vertice de inicio o destino no existe");
            return;
        }

        // Mapa de distancias (todas las aristas tienen peso 1)
        Map<Integer, Integer> distancias = new HashMap<>();
        // Mapa de predecesores para reconstruir el camino
        Map<Integer, Integer> predecesores = new HashMap<>();
        // Conjunto de vertices visitados
        HashSet<Integer> visitados = new HashSet<>();
        // Cola de prioridad (vertice, distancia)
        PriorityQueue<int[]> cola = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Inicializar distancias
        for (int vertice : grafo.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);

        // Agregar vertice inicial a la cola
        cola.offer(new int[]{inicio, 0});

        while (!cola.isEmpty()) {
            int[] actual = cola.poll();
            int verticeActual = actual[0];
            int distanciaActual = actual[1];

            // Si ya visitamos este vertice, continuar
            if (visitados.contains(verticeActual)) {
                continue;
            }

            visitados.add(verticeActual);

            // Si llegamos al destino, terminamos
            if (verticeActual == destino) {
                break;
            }

            // Explorar vecinos (peso = 1 para todas las aristas)
            for (int vecino : grafo.get(verticeActual)) {
                if (!visitados.contains(vecino)) {
                    int nuevaDistancia = distanciaActual + 1;

                    // Si encontramos una distancia mas corta
                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        predecesores.put(vecino, verticeActual);
                        cola.offer(new int[]{vecino, nuevaDistancia});
                    }
                }
            }
        }

        // MOSTRAR RESULTADOS
        System.out.println("\n=== ALGORITMO DE DIJKSTRA ===");
        System.out.println("Origen: " + inicio + " | Destino: " + destino);

        int distanciaFinal = distancias.get(destino);

        if (distanciaFinal == Integer.MAX_VALUE) {
            System.out.println("No existe camino entre " + inicio + " y " + destino);
            System.out.println("==============================\n");
            return;
        }

        // Reconstruir camino
        List<Integer> camino = new ArrayList<>();
        int actual = destino;

        while (actual != inicio) {
            camino.add(0, actual);
            actual = predecesores.get(actual);
        }
        camino.add(0, inicio);

        // Mostrar camino
        System.out.println("Camino mas corto: " + camino);
        System.out.println("Distancia total: " + distanciaFinal);

        // Mostrar paso a paso
        System.out.print("Ruta: ");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i));
            if (i < camino.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println("\n==============================\n");
    }

}

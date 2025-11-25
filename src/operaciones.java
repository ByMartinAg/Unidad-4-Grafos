import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class operaciones {
    private final Map<Integer, List<Integer>> grafo;

    public operaciones(){
        grafo = new HashMap<>();
    }

    // agregar vertice
    public void agregarVertice (Nodo nodo) {
        int vertic_e = nodo.getValor();
        if (!grafo.containsKey(vertic_e)) {
            grafo.put(vertic_e, new ArrayList<>());
            System.out.println("Vertice: " + vertic_e + " Agregado");
        } else {
            System.out.println("Ya existe");
        }
    }

    // agregar arista
    public void agregarArista (int origen, int destino){
        if (grafo.containsKey(origen) && grafo.containsKey(destino)){
            grafo.get(origen).add(destino);
            grafo.get(destino).add(origen);
        }
        else{
            System.out.println("vertice no existe");
        }
    }
    // eliminar arista
    public void eliminarArista(int origen, int destino) {
        if (grafo.containsKey(origen) && grafo.containsKey(destino)) {
            grafo.get(origen).remove(Integer.valueOf(destino));
            grafo.get(destino).remove(Integer.valueOf(origen));
            System.out.println("Arista eliminada: " + origen + " - " + destino);
        } else {
            System.out.println("Vértice no existe");
        }
    }

    // eliminar vertice
    public void eliminarVertice(int vertice) {
        if (grafo.containsKey(vertice)) {
            // Eliminar todas las aristas que apuntan a este vertice
            for (int v : grafo.get(vertice)) {
                grafo.get(v).remove(Integer.valueOf(vertice));
            }
            // Eliminar el vertice
            grafo.remove(vertice);
            System.out.println("Vértice " + vertice + " eliminado");
        } else {
            System.out.println("Vértice no existe");
        }
    }
    // mostrar grafo
    public void mostrarGrafo(){
        for (Map.Entry<Integer, List<Integer>> entry : grafo.entrySet()){
            System.out.println(entry.getKey() + " a " + entry.getValue());
        }
    }
}

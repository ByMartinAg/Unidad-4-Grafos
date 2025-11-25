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
            grafo.put(vertic_e, new ArrayList<>());  // put en lugar de putAll
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
    public void eliminarArista (int origen, int destino){
        if (grafo.containsKey(origen) && grafo.containsKey(destino)){
            grafo.get(origen).remove(destino);
            grafo.get(destino).remove(origen);
        }
        else{
            System.out.println("vertice no existe");
        }
    }
    // eliminar vertice
    public void eliminarVertice (int vertice){
        if (grafo.containsKey(vertice)){
            grafo.remove(vertice);
        }
        else{
            System.out.println("vertice no existe");
        }
    }
    // mostrar grafo
    public void mostrarGrafo(){
        for (Map.Entry<Integer, List<Integer>> entry : grafo.entrySet()){
            System.out.println(entry.getKey() + " a " + entry.getValue());
        }
    }
}

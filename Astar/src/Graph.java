import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Noeud, Map<Integer,Noeud>> map = new HashMap<>();

    public Map<Noeud, Map<Integer, Noeud>> getMap() {
        return map;
    }

    public void addVertex(Noeud n){
        map.put(n,new HashMap<Integer,Noeud>());
    }

    public Noeud getVertex(int Etat){

        Noeud noeud =new Noeud();
        noeud.setEtat(Etat);

        Noeud key=null;
        for (Map.Entry<Noeud, Map<Integer, Noeud>> entry : map.entrySet()) {
            key = entry.getKey();
            if (key.equals(noeud))
                return key;
        }
        return null;
    }

    public void addEdge(Noeud pere, int cout, Noeud fils)
    {
        if (!map.containsKey(pere))
            addVertex(pere);

        if (!map.containsKey(fils))
            addVertex(fils);

        map.get(pere).put(cout,fils);
   }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Noeud, Map<Integer, Noeud>> entry : map.entrySet()) {
            Noeud key = entry.getKey();
            Map<Integer, Noeud> value = entry.getValue();

            str.append(key + ": ");
            for (Map.Entry<Integer, Noeud> nestedEntry : value.entrySet()) {
                int nestedKey = nestedEntry.getKey();
                Noeud nestedValue = nestedEntry.getValue();

                str.append(nestedValue+" (Cout = " + nestedKey+ ") ");
            }
            str.append("\n");
        }
        return str.toString();
    }

}

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Graph graph = GenererGraphe();

        Noeud solution = A_Star(graph.getVertex(0),graph.getVertex(6),graph);

        System.out.println(solution);
    }

    public static Noeud A_Star(Noeud initial, Noeud but, Graph graphe){

        // get hashMap
//        Map<Noeud, Map<Integer, Noeud>> graph = graphe.getMap();
        Map<Noeud, Map<Integer, Noeud>> map = new HashMap<>(graphe.getMap());

        Noeud noeud = new Noeud(initial.getEtat(),initial.getH()) ;
        noeud.CalculeF();

        PriorityQueue<Noeud> frontiere = new PriorityQueue<Noeud>();
        frontiere.add(noeud);

        List<Noeud> visites = new ArrayList<>();

        while (true){

            if (frontiere.isEmpty()) return null;

            noeud = frontiere.poll();

            if (noeud.equals(but)) return noeud;

            visites.add(noeud);

            Map<Integer,Noeud> currentNoeud = map.get(noeud);

            for (Map.Entry<Integer, Noeud> CoutFils : currentNoeud.entrySet()) {

                // getValue return le noeud
                Noeud fils = new Noeud(CoutFils.getValue().getEtat(),CoutFils.getValue().getH());
                fils.setCout_chemin(noeud.getCout_chemin()+CoutFils.getKey());

                // getKey return le cout
                fils.CalculeF();

                if(!frontiere.contains(fils) && !visites.contains(fils))
                    frontiere.add(fils);
                else if (frontiere.contains(fils)) {
                    for (Noeud n : frontiere) {
                        if (n.equals(fils) && n.getF() > fils.getF()){
                            n.setF(fils.getF());
                            n.setCout_chemin(fils.getCout_chemin());
                        }
                    }
                } else if (visites.contains(fils)) {
                    int i = 0;
                    for (Noeud n : visites) {
                        if (n.equals(fils) && n.getF() > fils.getF()){
                            i=1;
                        }
                    }
                    if (i == 1){
                        frontiere.add(fils);
                        visites.remove(fils);
                    }
                }
            }
        }
    }

    public static Graph GenererGraphe(){

        Graph graph = new Graph();

        Noeud s0 = new Noeud(0,9);
        Noeud s1 = new Noeud(1,8);
        Noeud s2 = new Noeud(2,5);
        Noeud s3 = new Noeud(3,0);
        Noeud s4 = new Noeud(4,7);
        Noeud s5 = new Noeud(5,7);
        Noeud s6 = new Noeud(6,0);

        // s0  avec ces fils
        graph.addEdge(s0,1,s1);
        graph.addEdge(s0,8,s3);

        // s1 avec ces fils
        graph.addEdge(s1,2,s4);

        // s2 avec ces fils
        graph.addEdge(s2,2,s0);
        graph.addEdge(s2,3,s1);
        graph.addEdge(s2,1,s3);
        graph.addEdge(s2,5,s5);

        // s3 avec ces fils
        graph.addEdge(s3,4,s6);

        // s4 avec ces fils
        graph.addEdge(s4,2,s2);
        graph.addEdge(s4,3,s5);

        // s5 avec ces fils
        graph.addEdge(s5,7,s6);

        return graph;
    }
}
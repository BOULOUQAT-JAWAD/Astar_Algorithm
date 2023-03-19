public class Noeud implements Comparable<Noeud>{
    private int Etat,f,h,cout_chemin=0;

    public Noeud(){}
    public Noeud(int Etat, int h){
        this.Etat = Etat;
        this.h = h;
    }

    public int getCout_chemin() {
        return cout_chemin;
    }

    public void setCout_chemin(int cout_chemin) {
        this.cout_chemin = cout_chemin;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getEtat(){
        return Etat;
    }

    public int getH() {
        return h;
    }

    public int getF() {
        return f;
    }

    // c represente le coût du père
    public void CalculeF(){
        f = h + cout_chemin;
    }

    @Override
    public int compareTo(Noeud other) {
        if(this.f < other.f) return -1;
        if(this.f > other.f) return 1;
        return 0;
    }

    @Override
    public int hashCode(){
        return Etat;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Noeud) obj).Etat == Etat;
    }

    @Override
    public String toString(){
        return "{"+Etat+",f="+f+",h="+h+",cout="+cout_chemin+"}";
    }
}

public class Noeud {

    private char libelle;
    private int poid;
    private Noeud fils_droit;
    private Noeud fils_gauche;

    public Noeud(char libelle, int poid) {
        this.libelle = libelle;
        this.poid = poid;
        this.fils_droit = null;
        this.fils_gauche = null;
    }

    public Noeud(char libelle, int poid, Noeud fils_droit, Noeud fils_gauche) {
        this.libelle = libelle;
        this.poid = poid;
        this.fils_droit = fils_droit;
        this.fils_gauche = fils_gauche;
    }

    public char getLibelle() {
        return libelle;
    }

    public void setLibelle(char libelle) {
        this.libelle = libelle;
    }

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public Noeud getFils_droit() {
        return fils_droit;
    }

    public void setFils_droit(Noeud fils_droit) {
        this.fils_droit = fils_droit;
    }

    public Noeud getFils_gauche() {
        return fils_gauche;
    }

    public void setFils_gauche(Noeud fils_gauche) {
        this.fils_gauche = fils_gauche;
    }

   public boolean est_Feuille(){
        if((this.fils_gauche == null)&&(this.fils_droit == null))
            return true;
        return false;
   }

}

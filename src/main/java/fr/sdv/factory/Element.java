package fr.sdv.factory;

/**
 * Classe abstraite représentant un élément (Ingrédient, Allergène ou Additif)
 */
public abstract class Element {
    
    protected String nom;
    protected double valeur;
    protected Unite unite;

    /**
     * Constructeur de la classe Element
     * @param nom le nom de l'élément
     * @param valeur la quantité de l'élément
     * @param unite l'unité de mesure
     */
    public Element(String nom, double valeur, Unite unite) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "nom='" + nom + '\'' +
                ", valeur=" + valeur +
                ", unite=" + unite +
                '}';
    }
}

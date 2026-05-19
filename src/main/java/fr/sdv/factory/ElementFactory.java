package fr.sdv.factory;

/**
 * Factory pour créer des éléments (Ingrédient, Allergène ou Additif)
 * en fonction du type passé en paramètre
 */
public class ElementFactory {

    /**
     * Crée une instance d'Element en fonction du type d'élément
     * @param type le type d'élément à créer
     * @param nom le nom de l'élément
     * @param valeur la valeur/quantité de l'élément
     * @param unite l'unité de mesure
     * @return une instance d'Element appropriée
     */
    public static Element creerElement(ElementType type, String nom, double valeur, Unite unite) {
        if (type == null) {
            throw new IllegalArgumentException("Le type d'élément ne peut pas être null");
        }

        switch (type) {
            case INGREDIENT:
                return new Ingredient(nom, valeur, unite);
            case ALLERGENE:
                return new Allergene(nom, valeur, unite);
            case ADDITIF:
                return new Additif(nom, valeur, unite);
            default:
                throw new IllegalArgumentException("Type d'élément inconnu : " + type);
        }
    }
}

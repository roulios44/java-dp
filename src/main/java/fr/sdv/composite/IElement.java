package fr.sdv.composite;

/**
 * Interface commune pour le pattern Composite.
 */
public interface IElement {

    /**
     * Calcule le salaire total de l'élément.
     *
     * @return salaire de l'employé ou total du service
     */
    double calculerSalaire();
}

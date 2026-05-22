package fr.sdv.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Représente un service qui peut contenir des employés et des sous-services.
 */
public class Service implements IElement {

    private final String nom;
    private final List<IElement> elements = new ArrayList<>();

    public Service(String nom) {
        this.nom = Objects.requireNonNull(nom, "Le nom du service ne peut pas être null");
    }

    public String getNom() {
        return nom;
    }

    public void ajouter(IElement element) {
        this.elements.add(Objects.requireNonNull(element, "L'élément ne peut pas être null"));
    }

    public void supprimer(IElement element) {
        this.elements.remove(element);
    }

    public List<IElement> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public double calculerSalaire() {
        return elements.stream()
                .mapToDouble(IElement::calculerSalaire)
                .sum();
    }

    @Override
    public String toString() {
        return "Service{" +
                "nom='" + nom + '\'' +
                ", elements=" + elements +
                '}';
    }
}

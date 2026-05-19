package org.sebsy.grasps.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

    @Id
    private Long id;

    private LocalDateTime date;

    private int nbPlaces;

    private double total;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    public Reservation() {

    }

    public Reservation(LocalDateTime date) {
        super();
        this.date = date;
    }

    public Reservation(LocalDateTime date, Client client, int nbPlaces) {
        this.date = date;
        this.client = client;
        this.nbPlaces = nbPlaces;
    }

    /**
     * Calcule le montant total de la réservation en utilisant les informations du type.
     *
     * @param typeReservation informations tarifaires de la réservation
     */
    public void calculerTotal(TypeReservation typeReservation) {
        this.total = typeReservation.calculerTotal(nbPlaces, client != null && client.isPremium());
    }

    /**
     * Getter
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter
     *
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter
     *
     * @return the nbPlaces
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * Setter
     *
     * @param nbPlaces the nbPlaces to set
     */
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    /**
     * Getter
     *
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter
     *
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter
     *
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}

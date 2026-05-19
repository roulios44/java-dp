package org.sebsy.grasps.service;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public Reservation creerReservation(Client client, java.time.LocalDateTime dateReservation, int nbPlaces, TypeReservation typeReservation) {
        if (client == null) {
            throw new IllegalArgumentException("Client must not be null");
        }
        if (typeReservation == null) {
            throw new IllegalArgumentException("TypeReservation must not be null");
        }

        Reservation reservation = new Reservation(dateReservation, client, nbPlaces);
        reservation.calculerTotal(typeReservation);
        client.addReservation(reservation);
        return reservation;
    }
}

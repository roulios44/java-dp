package org.sebsy.grasps.service;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;

public interface ReservationService {

    Reservation creerReservation(Client client, java.time.LocalDateTime dateReservation, int nbPlaces, TypeReservation typeReservation);
}

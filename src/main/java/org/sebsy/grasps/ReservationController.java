package org.sebsy.grasps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;
import org.sebsy.grasps.service.ReservationService;
import org.sebsy.grasps.service.ReservationServiceImpl;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
public class ReservationController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final ClientDao clientDao;
    private final TypeReservationDao typeReservationDao;
    private final ReservationService reservationService;

    public ReservationController() {
        this(new ClientDao(), new TypeReservationDao(), new ReservationServiceImpl());
    }

    public ReservationController(ClientDao clientDao, TypeReservationDao typeReservationDao, ReservationService reservationService) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
        this.reservationService = reservationService;
    }

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(ReservationRequest params) {
        String identifiantClient = params.identifiantClient();
        LocalDateTime dateReservation = toDate(params.dateReservation());
        Client client = clientDao.extraireClient(identifiantClient);
        TypeReservation typeReservation = typeReservationDao.extraireTypeReservation(params.typeReservation());

        return reservationService.creerReservation(client, dateReservation, params.nbPlaces(), typeReservation);
    }

    /**
     * Transforme une date au format String en {@link LocalDateTime}
     *
     * @param dateStr date au format String
     * @return LocalDateTime
     */
    private LocalDateTime toDate(String dateStr) {
        return LocalDateTime.parse(dateStr, FORMATTER);
    }
}

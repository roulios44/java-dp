package org.sebsy.grasps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
public class ReservationController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final ClientDao clientDao;
    private final TypeReservationDao typeReservationDao;

    public ReservationController() {
        this(new ClientDao(), new TypeReservationDao());
    }

    public ReservationController(ClientDao clientDao, TypeReservationDao typeReservationDao) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
    }

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(Params params) {
        String identifiantClient = params.getIdentifiantClient();
        LocalDateTime dateReservation = toDate(params.getDateReservation());
        Client client = clientDao.extraireClient(identifiantClient);
        TypeReservation typeReservation = typeReservationDao.extraireTypeReservation(params.getTypeReservation());

        return client.creerReservation(dateReservation, params.getNbPlaces(), typeReservation);
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

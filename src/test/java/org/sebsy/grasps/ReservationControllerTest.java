package org.sebsy.grasps;

import org.junit.Test;
import org.sebsy.grasps.beans.Reservation;

import junit.framework.TestCase;

public class ReservationControllerTest extends TestCase {

    /**
     * DELTA
     */
    private static final double DELTA = 0.0000001;

    @Test
    public void testCreerReservationTheatrePremium() {

        ReservationRequest params = new ReservationRequest("1", "20/11/2020 19:55:00", "TH", 3);

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(382.5, reservation.getTotal(), DELTA);
    }

    @Test
    public void testCreerReservationTheatreNonPremium() {

        ReservationRequest params = new ReservationRequest("3", "20/11/2020 19:55:00", "TH", 3);

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(450.0, reservation.getTotal(), DELTA);
    }

    @Test
    public void testCreerReservationCinemaPremium() {

        ReservationRequest params = new ReservationRequest("2", "21/11/2020 20:30:00", "CI", 4);

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(43.6, reservation.getTotal(), DELTA);
    }

    @Test
    public void testCreerReservationCinemaNonPremium() {

        ReservationRequest params = new ReservationRequest("3", "21/11/2020 20:30:00", "CI", 4);

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(43.6, reservation.getTotal(), DELTA);
    }
}
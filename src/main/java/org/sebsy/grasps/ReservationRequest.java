package org.sebsy.grasps;
public record ReservationRequest(String identifiantClient, String dateReservation, String typeReservation, int nbPlaces) {
}

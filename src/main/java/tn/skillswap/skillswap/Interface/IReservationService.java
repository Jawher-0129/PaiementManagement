package tn.skillswap.skillswap.Interface;

import tn.skillswap.skillswap.Entity.Paiement;
import tn.skillswap.skillswap.Entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(long idReservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(long idReservation);

    public List<Reservation> getUserReservations(Long userId);

    // double calculerMontantTotalReservations();
}

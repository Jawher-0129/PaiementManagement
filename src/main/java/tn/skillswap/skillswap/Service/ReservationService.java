package tn.skillswap.skillswap.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.skillswap.skillswap.Entity.Reservation;
import tn.skillswap.skillswap.Interface.IReservationService;
import tn.skillswap.skillswap.Repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
       return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }


    @Override
    public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findReservationsByUserId(userId);
    }







   /* @Override
    public double calculerMontantTotalReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        double montantTotal = 0;
        for (Reservation reservation : reservations)
        {
            if (reservation.getCourse()!=null)
            {
                montantTotal+=reservation.getCourse().getPrice_Course();
            }
        }
        return montantTotal;
    }*/

}

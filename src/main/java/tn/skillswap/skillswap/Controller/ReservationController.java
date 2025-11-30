package tn.skillswap.skillswap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.skillswap.skillswap.Entity.Paiement;
import tn.skillswap.skillswap.Entity.Reservation;
import tn.skillswap.skillswap.Entity.Role;
import tn.skillswap.skillswap.Entity.User;
import tn.skillswap.skillswap.Interface.IPaiementService;
import tn.skillswap.skillswap.Interface.IReservationService;
import tn.skillswap.skillswap.Repository.UserRepository;
import tn.skillswap.skillswap.Service.UserService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        reservation.setStatus(0);
        reservation.setDate(LocalDateTime.now());
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/get/{idReservation}")
    public Reservation getReservationById(@PathVariable long idReservation) {
        return reservationService.getReservationById(idReservation);
    }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        reservation.setDate(LocalDateTime.now());
        reservation.setStatus(1);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable long idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    @GetMapping("/reservationByUser/{userId}")
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getUserReservations(userId);
        return ResponseEntity.ok(reservations);
    }

   /* @GetMapping("/montant-total")
    public ResponseEntity<Double> getMontantTotalReservations() {
        double montantTotal = reservationService.calculerMontantTotalReservations();
        return ResponseEntity.ok(montantTotal);
    }*/


}

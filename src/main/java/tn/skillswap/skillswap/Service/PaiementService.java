package tn.skillswap.skillswap.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.skillswap.skillswap.Entity.Course;
import tn.skillswap.skillswap.Entity.Paiement;
import tn.skillswap.skillswap.Entity.Reservation;
import tn.skillswap.skillswap.Interface.IPaiementService;
import tn.skillswap.skillswap.Repository.PaiementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaiementService implements IPaiementService {

    @Autowired
    private PaiementRepository paiementRepository;


    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);

    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        paiement.setDate(LocalDateTime.now());
        return paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement getPaiementById(long idPaiement)
    {
        return paiementRepository.findById(idPaiement).get();
    }

   /* @Override
    public double calculerTotalReservationParUser(Paiement paiement) {
        double montantTotal = 0;

        for (Reservation reservation : paiement.getReservations())
        {
            if(reservation.getCourse()!=null)
            {
                montantTotal+=reservation.getCourse().getPrice_Course();
            }
        }
        return montantTotal;
    }*/
}

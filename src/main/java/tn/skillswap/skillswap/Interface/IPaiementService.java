package tn.skillswap.skillswap.Interface;



import tn.skillswap.skillswap.Entity.Paiement;

import java.util.List;
import java.util.Optional;

public interface IPaiementService {

    Paiement addPaiement(Paiement paiement);
    Paiement updatePaiement(Paiement paiement);
    void deletePaiement(long idPaiement);
    List<Paiement> getAllPaiements();
    Paiement getPaiementById(long idPaiement);

   // double calculerTotalReservationParUser(Paiement paiement);



}

package tn.skillswap.skillswap.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.skillswap.skillswap.Entity.CompteBancaire;
import tn.skillswap.skillswap.Entity.User;
import tn.skillswap.skillswap.Interface.ICompteBancaireService;
import tn.skillswap.skillswap.Repository.CompteBancaireRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompteBancaireService implements ICompteBancaireService {

    @Autowired
    private CompteBancaireRepository compteBancaireRepository;
    @Override
    public CompteBancaire addcomptebancaire(CompteBancaire compteBancaire) {
        User user = compteBancaire.getUser();
        if (user != null) {
            user.setCompteBancaire(compteBancaire); // Synchroniser l'autre côté
        }
        return compteBancaireRepository.save(compteBancaire);
    }

    @Override
    public CompteBancaire updatecomptebancaire(CompteBancaire compteBancaire) {
        CompteBancaire existingCompte = compteBancaireRepository.findById(compteBancaire.getIdCompteBancaire())
                .orElseThrow(() -> new RuntimeException("Compte bancaire non trouvé avec l'ID: " + compteBancaire.getIdCompteBancaire()));
        existingCompte.setMontant(compteBancaire.getMontant());
        return compteBancaireRepository.save(existingCompte);
    }

    @Override
    public void deletecomptebancaire(CompteBancaire compteBancaire) {
        compteBancaireRepository.delete(compteBancaire);
    }

    @Override
    public List<CompteBancaire> getcomptebancaire() {
        return compteBancaireRepository.findAll();
    }

    @Override
    public CompteBancaire getCompteBancaireById(long idCompteBancaire) {
        return compteBancaireRepository.findById(idCompteBancaire).get();
    }

    @Override
    public Optional<CompteBancaire> getCompteByUserId(long userId) {
        return compteBancaireRepository.findByUserId(userId);
    }



}

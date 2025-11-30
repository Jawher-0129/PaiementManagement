package tn.skillswap.skillswap.Interface;


import tn.skillswap.skillswap.Entity.CompteBancaire;

import java.util.List;
import java.util.Optional;

public interface ICompteBancaireService {

    CompteBancaire addcomptebancaire(CompteBancaire compteBancaire);
    CompteBancaire updatecomptebancaire(CompteBancaire compteBancaire);
    void deletecomptebancaire(CompteBancaire compteBancaire);
    List<CompteBancaire> getcomptebancaire();
    CompteBancaire getCompteBancaireById(long idCompteBancaire);

    public Optional<CompteBancaire> getCompteByUserId(long userId);



}

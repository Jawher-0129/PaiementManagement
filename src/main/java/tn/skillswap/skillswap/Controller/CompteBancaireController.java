package tn.skillswap.skillswap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.skillswap.skillswap.Entity.CompteBancaire;
import tn.skillswap.skillswap.Interface.ICompteBancaireService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comptebancaire")
@CrossOrigin(origins = "http://localhost:4200")
public class CompteBancaireController {
    @Autowired
    ICompteBancaireService compteBancaireService;

    @PostMapping("/addcomptebancaire")
    public CompteBancaire addCompteBancaire(@RequestBody CompteBancaire compteBancaire) {
        return compteBancaireService.addcomptebancaire(compteBancaire);
    }

    @GetMapping("/getcomptebancaire")
    public List<CompteBancaire> getAllcomptebancaire() {
        return compteBancaireService.getcomptebancaire();
    }

    @GetMapping("/getcomptebancaire/{idCompteBancaire}")
    public CompteBancaire getcomptebancaireById(@PathVariable long idCompteBancaire) {
        return compteBancaireService.getCompteBancaireById(idCompteBancaire);
    }

    /*@PutMapping("/updatecomptebancaire")
    public CompteBancaire updatecomptebancaire(@RequestBody CompteBancaire compteBancaire)
    {
        return compteBancaireService.updatecomptebancaire(compteBancaire);
    }*/

    @PutMapping("/updatecomptebancaire/{id}")
    public CompteBancaire updatecomptebancaire(
            @PathVariable long id,
            @RequestBody CompteBancaire compteBancaire) {

        if (compteBancaire.getIdCompteBancaire() != id) {
            throw new IllegalArgumentException("ID in path and body don't match");
        }

        return compteBancaireService.updatecomptebancaire(compteBancaire);
    }

    /*@DeleteMapping("/deletecomptebancaire/{idCompteBancaire}")
    public void deletecomptebancaire(@PathVariable long idCompteBancaire) {
        compteBancaireService.deletecomptebancaire(idCompteBancaire);
    }*/
    @DeleteMapping("/deletecomptebancaire/{idCompteBancaire}")
    public ResponseEntity<String> deletecomptebancaire(@PathVariable long idCompteBancaire) {
        try {
            CompteBancaire compteBancaire = compteBancaireService.getCompteBancaireById(idCompteBancaire);

            // On rompt aussi le lien avec l'utilisateur
            if (compteBancaire.getUser() != null) {
                compteBancaire.getUser().setCompteBancaire(null);
                compteBancaire.setUser(null);
            }

            compteBancaireService.deletecomptebancaire(compteBancaire);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Compte bancaire supprimé avec succès.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression du compte bancaire : " + ex.getMessage());
        }
    }




    @GetMapping("/byuser/{userId}")
    public CompteBancaire getCompteByUser(@PathVariable Long userId) {
        return compteBancaireService.getCompteByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé"));
    }





}



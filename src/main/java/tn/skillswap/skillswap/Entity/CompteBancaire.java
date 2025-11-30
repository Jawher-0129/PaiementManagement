package tn.skillswap.skillswap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompteBancaire;
    private double montant;
    @OneToOne
    private User user;

    public long getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(long idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


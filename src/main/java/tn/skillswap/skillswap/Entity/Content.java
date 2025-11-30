package tn.skillswap.skillswap.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Titre du contenu
    private String type; // Type (Vidéo, PDF, Quiz, Texte)
    private String url; // Lien vers le contenu
    private Integer orderIndex; // Ordre dans le cours

    @ManyToOne
    private Course course; // Cours associé
}

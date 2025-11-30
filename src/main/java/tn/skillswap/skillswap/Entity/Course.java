package tn.skillswap.skillswap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Course;

    private String title_Course; // Titre du cours
    private String description_Course; // Description du cours
    private String language_Course; // Langue du cours
    private Double price_Course; // Prix du cours
    private String level_Course; // Niveau du cours (Débutant, Intermédiaire, Avancé)
    private Boolean published_Course; // Statut du cours (publié ou brouillon)
    private String thumbnailUrl_Course; // URL de l'image du cours
    private Integer duration_Course; // Durée du cours en minutes
    private LocalDateTime createdAt_Course; // Date de création
    private LocalDateTime updatedAt_Course; // Date de mise à jour
    private Integer rating_Course;
    private String name_Category;
    @Enumerated(EnumType.STRING)
    private CourseType courseType; //online ou live

    private LocalDateTime sessionDate; // Date et heure de la session en direct

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Reservation> reservations;

    @ElementCollection
    @JsonIgnore
    private List<LocalDateTime> sessionDates;

    public Long getId_Course() {
        return id_Course;
    }

    public void setId_Course(Long id_Course) {
        this.id_Course = id_Course;
    }

    public String getTitle_Course() {
        return title_Course;
    }

    public void setTitle_Course(String title_Course) {
        this.title_Course = title_Course;
    }

    public String getDescription_Course() {
        return description_Course;
    }

    public void setDescription_Course(String description_Course) {
        this.description_Course = description_Course;
    }

    public String getLanguage_Course() {
        return language_Course;
    }

    public void setLanguage_Course(String language_Course) {
        this.language_Course = language_Course;
    }

    public Double getPrice_Course() {
        return price_Course;
    }

    public void setPrice_Course(Double price_Course) {
        this.price_Course = price_Course;
    }

    public String getLevel_Course() {
        return level_Course;
    }

    public void setLevel_Course(String level_Course) {
        this.level_Course = level_Course;
    }

    public Boolean getPublished_Course() {
        return published_Course;
    }

    public void setPublished_Course(Boolean published_Course) {
        this.published_Course = published_Course;
    }

    public String getThumbnailUrl_Course() {
        return thumbnailUrl_Course;
    }

    public void setThumbnailUrl_Course(String thumbnailUrl_Course) {
        this.thumbnailUrl_Course = thumbnailUrl_Course;
    }

    public Integer getDuration_Course() {
        return duration_Course;
    }

    public void setDuration_Course(Integer duration_Course) {
        this.duration_Course = duration_Course;
    }

    public LocalDateTime getCreatedAt_Course() {
        return createdAt_Course;
    }

    public void setCreatedAt_Course(LocalDateTime createdAt_Course) {
        this.createdAt_Course = createdAt_Course;
    }

    public LocalDateTime getUpdatedAt_Course() {
        return updatedAt_Course;
    }

    public void setUpdatedAt_Course(LocalDateTime updatedAt_Course) {
        this.updatedAt_Course = updatedAt_Course;
    }

    public Integer getRating_Course() {
        return rating_Course;
    }

    public void setRating_Course(Integer rating_Course) {
        this.rating_Course = rating_Course;
    }

    public String getName_Category() {
        return name_Category;
    }

    public void setName_Category(String name_Category) {
        this.name_Category = name_Category;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<LocalDateTime> getSessionDates() {
        return sessionDates;
    }

    public void setSessionDates(List<LocalDateTime> sessionDates) {
        this.sessionDates = sessionDates;
    }

    /*
    @ManyToOne
    private Teacher teacher; // Enseignant responsable

    @ManyToMany
    private List<Category> categories; // Catégories du cours

    @OneToMany(mappedBy = "course")
    private List<Content> contents; // Liste des contenus (vidéos, PDF, quiz, etc.)

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments; // Liste des étudiants inscrits

    @OneToMany(mappedBy = "course")
    private List<Notification> notifications; // Notifications du cours

    @OneToMany(mappedBy = "course")
    private List<Prerequisite> prerequisites; // Prérequis

    @OneToMany(mappedBy = "course")
    private List<Review> reviews; // Avis des étudiants

    @OneToMany(mappedBy = "course")
    private List<Session> sessions; // Sessions en direct associées au cours

    @Enumerated(EnumType.STRING)
    private CourseType courseType; // Type de cours (en ligne ou en direct)*/
}


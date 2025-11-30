package tn.skillswap.skillswap.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_User;

    private String First_name;
    private String last_Name;
    private Date date_Birthday ;
    private String gender ;
    private String address ;

    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private  Role role;

    private String photo;
    private String phone_Number;
    private boolean is_Activated;
    private Date created_At;

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Reservation> reservations;

  @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE,orphanRemoval = true)
  @JsonIgnore
    private CompteBancaire compteBancaire;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Paiement> paiements;


    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

   public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    /*public User(long id_User, String first_name, String last_Name, Date date_Birthday, String gender, String address, String email, String password, Role role, String photo, String phone_Number, boolean is_Activated, Date created_At, Set<Reservation> reservations, Paiement paiement) {
        this.id_User = id_User;
        First_name = first_name;
        this.last_Name = last_Name;
        this.date_Birthday = date_Birthday;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
        this.photo = photo;
        this.phone_Number = phone_Number;
        this.is_Activated = is_Activated;
        this.created_At = created_At;
        this.reservations = reservations;
        this.paiement = paiement;
    }*/



    public long getId_User() {
        return id_User;
    }

    public void setId_User(long id_User) {
        this.id_User = id_User;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Date getDate_Birthday() {
        return date_Birthday;
    }

    public void setDate_Birthday(Date date_Birthday) {
        this.date_Birthday = date_Birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public boolean isIs_Activated() {
        return is_Activated;
    }

    public void setIs_Activated(boolean is_Activated) {
        this.is_Activated = is_Activated;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
}





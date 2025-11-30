package tn.skillswap.skillswap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long RegistrationId;
    boolean IsSelected;

    @ManyToOne
    @JsonIgnore
    Event Eventregis;

    @ManyToOne
    @JsonIgnore
    User user;

    public long getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(long registrationId) {
        RegistrationId = registrationId;
    }

    public boolean isSelected() {
        return IsSelected;
    }

    public void setSelected(boolean selected) {
        IsSelected = selected;
    }

    public Event getEvent() {
        return Eventregis;
    }

    public void setEvent(Event event) {
        Eventregis = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

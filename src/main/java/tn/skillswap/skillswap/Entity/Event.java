package tn.skillswap.skillswap.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.persister.collection.mutation.UpdateRowsCoordinatorNoOp;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long EventId;
    String EventName;
    String EventDescription;
    String EventType;
    String PosterURL;
    Date EventStartDate;
    Date EventEndDate;
    long MaxParticipants;
    Date RegistrationEndDate;

    @OneToMany(mappedBy = "Eventregis")
    Set<EventRegistration> EventRegistrations = new HashSet<>();

    @OneToMany(mappedBy = "Event")
    Set<EventFeedback> EventFeedBacks = new HashSet<>();

    public long getEventId() {
        return EventId;
    }

    public void setEventId(long eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getPosterURL() {
        return PosterURL;
    }

    public void setPosterURL(String posterURL) {
        PosterURL = posterURL;
    }

    public Date getEventStartDate() {
        return EventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        EventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return EventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        EventEndDate = eventEndDate;
    }

    public long getMaxParticipants() {
        return MaxParticipants;
    }

    public void setMaxParticipants(long maxParticipants) {
        MaxParticipants = maxParticipants;
    }

    public Date getRegistrationEndDate() {
        return RegistrationEndDate;
    }

    public void setRegistrationEndDate(Date registrationEndDate) {
        RegistrationEndDate = registrationEndDate;
    }

    public Set<EventRegistration> getEventRegistrations() {
        return EventRegistrations;
    }

    public void setEventRegistrations(Set<EventRegistration> eventRegistrations) {
        EventRegistrations = eventRegistrations;
    }

    public Set<EventFeedback> getEventFeedBacks() {
        return EventFeedBacks;
    }

    public void setEventFeedBacks(Set<EventFeedback> eventFeedBacks) {
        EventFeedBacks = eventFeedBacks;
    }

}

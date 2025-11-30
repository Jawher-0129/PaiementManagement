package tn.skillswap.skillswap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.skillswap.skillswap.Entity.User;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long FeedbackId;
    long EventRating;
    String Comment;

    @ManyToOne
    @JsonIgnore
    Event Event;

    @ManyToOne
    @JsonIgnore
    User user;

    public long getFeedbackId() {
        return FeedbackId;
    }

    public void setFeedbackId(long feedbackId) {
        FeedbackId = feedbackId;
    }

    public long getEventRating() {
        return EventRating;
    }

    public void setEventRating(long eventRating) {
        EventRating = eventRating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Event getEvent() {
        return Event;
    }

    public void setEvent(Event event) {
        Event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

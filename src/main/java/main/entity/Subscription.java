package main.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class Subscription implements Serializable {
    @EmbeddedId
    private SubscriptionKey key;
    @Column(name = "subscription_date")
    private LocalDateTime time;

    @Override
    public String toString() {
        return "Подписка:\n\tкурс: \"" + key.getCourse().getName() +
                "\", студент: " + key.getStudent().getName() +
                ", дата: " + time;
    }
}

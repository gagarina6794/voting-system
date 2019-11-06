package ua.com.system.restaurant.vote.to;

import java.io.Serializable;
import java.time.LocalDate;

public class VoteDateTo implements Serializable {
    private LocalDate registration;
    private Long count;

    public VoteDateTo(LocalDate registration, Long count) {
        this.registration = registration;
        this.count = count;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

package ua.com.system.restaurant.vote.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractRegisteredEntity extends AbstractNamedEntity {

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private Date registered = new Date();

    protected AbstractRegisteredEntity() {
    }

    protected AbstractRegisteredEntity(Integer id, String name, Date registered) {
        super(id, name);
        this.name = name;
        this.registered = registered;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + registered + ')';
    }
}

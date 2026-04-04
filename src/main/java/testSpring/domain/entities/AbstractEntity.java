package testSpring.domain.entities;

import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
public class AbstractEntity {
    public static final String SEQUENCE_NAME = "HIBERNATE_SEQ";

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "HIBERNATE_SEQ", sequenceName = SEQUENCE_NAME, allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HIBERNATE_SEQ")
    protected Long id;

    public AbstractEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        AbstractEntity object = (AbstractEntity) obj;
        if (this.getId() == null || object.getId() == null) {
            return false;
        }

        return Objects.equals(this.getId(), object.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

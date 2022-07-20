package com.example.trackcoins.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "user")
public class User implements Serializable {
    private Integer id;
    private UUID uuid;
    @PrePersist
    public void prePersist() {
        if (getUuid() == null) {
            uuid = UUID.randomUUID();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    @NotNull
    @Column(name = "uuid", unique = true, nullable = false)
    @Type(type = "uuid-char")
    public UUID getUuid() {
        return uuid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

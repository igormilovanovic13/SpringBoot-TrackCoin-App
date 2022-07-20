package com.example.trackcoins.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "user_token_quantity")
@Entity
public class UserTokenQuantity {
    private User user;
    private Integer id;
    private Token token;
    private Double quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "token_code")
    public Token getToken() {
        return token;
    }

    @NotNull
    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTokenQuantity that = (UserTokenQuantity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

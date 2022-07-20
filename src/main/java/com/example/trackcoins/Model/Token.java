package com.example.trackcoins.Model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "token")
public class Token implements Serializable {
    private String code;
    private Double price;

    @Id
    @Column(name = "code")
    @NotNull
    public String getCode() {
        return code;
    }

    @Column(name = "price")
    @NotNull
    public Double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return code.equals(token.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

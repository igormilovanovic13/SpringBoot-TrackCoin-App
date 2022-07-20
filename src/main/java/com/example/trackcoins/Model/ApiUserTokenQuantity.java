package com.example.trackcoins.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ApiUserTokenQuantity implements Serializable {
//    private User user;
    private String tokenSymbol;
    private Double tokenPrice;
    private Double value;
    private Boolean aboveDollar;

    @JsonCreator
    @SuppressWarnings("unused")
    public ApiUserTokenQuantity() {
    }

    public ApiUserTokenQuantity(UserTokenQuantity userTokenQuantity) {
//        this.user =userTokenQuantity.getUser(); //Vec nasli po useru
        this.tokenSymbol = userTokenQuantity.getToken().getCode();
        this.tokenPrice = userTokenQuantity.getToken().getPrice();
        this.value = userTokenQuantity.getToken().getPrice() * userTokenQuantity.getQuantity();
        this.aboveDollar = userTokenQuantity.getToken().getPrice() >= 1 ? Boolean.TRUE : Boolean.FALSE;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    public Double getTokenPrice() {
        return tokenPrice;
    }

    public void setTokenPrice(Double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getAboveDollar() {
        return aboveDollar;
    }

    public void setAboveDollar(Boolean aboveDollar) {
        this.aboveDollar = aboveDollar;
    }
}

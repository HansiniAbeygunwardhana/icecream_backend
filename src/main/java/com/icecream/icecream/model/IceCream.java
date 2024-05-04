package com.icecream.icecream.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ice_cream")
public class IceCream {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iceCreamId;

    @Column(name = "ice_cream_name")
    private String iceCreamName;
    @Column(name = "flavour")
    private String flavourType;
    @Column(name = "ice_cream_descript")
    private String icecreamDescription;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "img_url")
    private String imgUrl;

    public Integer getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(Integer iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public String getIceCreamName() {
        return iceCreamName;
    }

    public void setIceCreamName(String iceCreamName) {
        this.iceCreamName = iceCreamName;
    }

    public String getIcecreamDescription() {
        return icecreamDescription;
    }

    public void setIcecreamDescription(String icecreamDescription) {
        this.icecreamDescription = icecreamDescription;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFlavourType() {
        return flavourType;
    }

    public void setFlavourType(String flavourType) {
        this.flavourType = flavourType;
    }
}

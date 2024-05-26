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
    @Column(name = "ice_cream_descript")
    private String iceCreamDescription;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "allegerns")
    private String allergerns;

    @Column(name = "ingredients")
    private String ingredients;

    @ManyToOne
    @JoinColumn(name = "flavour_id")
    Flavour flavour;

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

    public String getIceCreamDescription() {
        return iceCreamDescription;
    }

    public void setIceCreamDescription(String icecreamDescription) {
        this.iceCreamDescription = icecreamDescription;
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

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getAllergerns() {
        return allergerns;
    }

    public void setAllergerns(String allergerns) {
        this.allergerns = allergerns;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}

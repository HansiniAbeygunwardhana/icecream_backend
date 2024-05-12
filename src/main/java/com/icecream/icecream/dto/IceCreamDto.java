package com.icecream.icecream.dto;

import com.icecream.icecream.model.Flavour;

public class IceCreamDto {

    private Integer iceCreamId;

    private String iceCreamName;

    private Integer flavour;

    private String iceCreamDescription;

    private Double rating;

    private Double price;

    private Long quantity;

    private String imgUrl;

    public IceCreamDto(Integer iceCreamId, String iceCreamName, Integer flavour, String iceCreamDescription, Double rating, Double price, Long quantity, String imgUrl) {
        this.iceCreamId = iceCreamId;
        this.iceCreamName = iceCreamName;
        this.flavour = flavour;
        this.iceCreamDescription = iceCreamDescription;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

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

    public Integer getFlavour() {
        return flavour;
    }

    public void setFlavourType(Integer flavour) {
        this.flavour = flavour;
    }

    public String getIceCreamDescription() {
        return iceCreamDescription;
    }

    public void setIceCreamDescription(String iceCreamDescription) {
        this.iceCreamDescription = iceCreamDescription;
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
}
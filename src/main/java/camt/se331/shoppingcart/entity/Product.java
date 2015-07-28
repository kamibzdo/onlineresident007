package camt.se331.shoppingcart.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Product implements Comparable{
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    Double totalPrice;

    @OneToMany(fetch= FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product(){

    }

    public Product(Long id,String name, String description, Double price,Image image) {
        this.name = name;
        this.description = description;
        this.totalPrice = price;
        this.id = id;
        this.getImages().add(image);
    }

    public Double getNetPrice(){
        return getTotalPrice()*(1-VatEntity.getInstance().getVat());
    }

    public Double getTax(){
        return 0.0;
    }


    public Product(Long id,String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.totalPrice = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Product)o).getId());
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getTotalPrice() != null ? !getTotalPrice().equals(product.getTotalPrice()) : product.getTotalPrice() != null)
            return false;
        return !(getImages() != null ? !getImages().equals(product.getImages()) : product.getImages() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getTotalPrice() != null ? getTotalPrice().hashCode() : 0);
        result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
        return result;
    }
}

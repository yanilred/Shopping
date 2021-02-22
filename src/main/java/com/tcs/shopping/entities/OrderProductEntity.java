package com.tcs.shopping.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_product")
public class OrderProductEntity{

  
	@EmbeddedId
    private OrderProductRelation oPRelation;

    @Column(nullable = false) private Integer quantity;

    public OrderProductEntity() {}
    public OrderProductEntity(OrderEntity order, ProductEntity product, Integer quantity) {
        oPRelation = new OrderProductRelation();
        oPRelation.setOrder(order);
        oPRelation.setProduct(product);
        oPRelation.setCreatedOn(new Date());
        oPRelation.setCreatedBy("admin");
        oPRelation.setUpdatedOn(new Date());
        oPRelation.setUpdatedBy("admin");
        this.quantity = quantity;
        
    }

   
    public ProductEntity getProduct() {
        return this.oPRelation.getProduct();
    }

   
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderProductRelation getPk() {
        return oPRelation;
    }

    public void setPk(OrderProductRelation pk) {
        this.oPRelation = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

  
}
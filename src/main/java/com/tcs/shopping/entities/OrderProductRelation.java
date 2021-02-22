package com.tcs.shopping.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class OrderProductRelation  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 476151177562655457L;
  
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

   
}
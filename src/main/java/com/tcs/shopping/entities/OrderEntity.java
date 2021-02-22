package com.tcs.shopping.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "t_orders")
@JsonRootName("order")
public class OrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    @JsonManagedReference
    @OneToMany(mappedBy = "oPRelation.order")
    private List<OrderProductEntity> orderProducts = new ArrayList<>();

   
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderProductEntity> orderProducts = getOrderProducts();
        for (OrderProductEntity op : orderProducts) {
            sum += op.getTotalPrice();
        }

        return sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProductEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }

 
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }
}
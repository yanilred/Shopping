package com.tcs.shopping.daos;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcs.shopping.entities.OrderEntity;

@Repository
public interface OrdersRepo extends CrudRepository<OrderEntity, Long> {
   // List<OrderEntity> findByCustomerId(String firstName);
	//@EntityGraph(attributePaths = {"orderProducts", "orderProduct.oPRelation"})
	//@Query("SELECT p.name,p.picture_url,price,op.quantity"
	//		+ " FROM OrderEntity o JOIN FETCH o.orderProducts WHERE o.id = (:id)")
   // public OrderEntity findByIdAndFetchProductsEagerly(@Param("id") Long id);
}




/*
 * SELECT o.id,p.name,p.picture_url,price,op.quantity,o.status FROM t_orders o
 * JOIN T_PRODUCTS p JOIN t_order_product op where o.id=op.order_id and
 * p.id=op.product_id and o.id=1
 */

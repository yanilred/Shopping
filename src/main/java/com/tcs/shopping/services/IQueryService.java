package com.tcs.shopping.services;
import java.util.List;

import com.tcs.shopping.dtos.OrderDetails;

public interface IQueryService {

    List<OrderDetails> JPQLQuery();

}
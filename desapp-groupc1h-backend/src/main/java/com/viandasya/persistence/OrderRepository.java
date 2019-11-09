package com.viandasya.persistence;

import com.viandasya.model.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Long> {
}

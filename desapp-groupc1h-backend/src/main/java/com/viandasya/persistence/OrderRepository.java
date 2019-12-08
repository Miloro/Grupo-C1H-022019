package com.viandasya.persistence;

import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface OrderRepository  extends CrudRepository<Order, Long> {

    @Modifying
    @Query("update order_info o set o.state = :confirmed where o.state = :pending")
    void acceptOrders(@Param("pending") OrderState pending,@Param("confirmed") OrderState confirmed);

    @Modifying
    @Query("update order_info o set o.state = com.viandasya.model.order.OrderState.DELIVERED" +
            " where o.state = com.viandasya.model.order.OrderState.CONFIRMED and o.orderDate.to < ?1")
    void setOrdersAsDelivered(LocalDateTime now);

    @Query("from order_info o where o.client.id=?1 and o.state = " +
            "com.viandasya.model.order.OrderState.DELIVERED and o.score is null")
    List<Order> findUnratedOrdersByClientId(Long id);

    @Modifying
    @Query("update order_info o set o.score= ?1 where o.id =?2")
    void updateScoreById(Integer score, Long id);
}

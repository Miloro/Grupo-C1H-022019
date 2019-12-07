package com.viandasya.persistence;

import com.viandasya.model.order.OrderState;
import com.viandasya.model.user.ServiceProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceProfileRepository extends CrudRepository<ServiceProfile, Long> {

    @Query("select s from ServiceProfile s join fetch s.menus")
    List<ServiceProfile> findAllWithFetchedMenus();

}

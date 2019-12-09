package com.viandasya.persistence;

import com.viandasya.model.menu.Menu;
import com.viandasya.webservice.dtos.MenuOrderCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Page<Menu> findByNameContainingIgnoreCaseAndScoreGreaterThanEqualOrScoreNull(String name, Double score, Pageable pageable);

    Page<Menu> findByServiceProfileLocationCityContainsIgnoreCaseAndScoreGreaterThanEqualOrScoreNull(String city, Double score, Pageable pageable);

    Page<Menu> findByScoreGreaterThanEqualOrScoreNull(Double score, Pageable pageable);

    @Query(value = "SELECT m as menu, sum(o.amount) as orderCount FROM Menu m JOIN m.orders o GROUP BY m")
    List<MenuOrderCountDTO> findAllAsToUpdateMenuDTO();

}

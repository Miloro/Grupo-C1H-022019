package com.viandasya.persistence;

import com.viandasya.model.menu.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Page<Menu> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Menu> findByCategoriesContains(String category, Pageable pageable);

    Page<Menu> findByServiceProfileLocationCityContainsIgnoreCase(String city, Pageable pageable);
}

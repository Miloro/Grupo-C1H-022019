package com.viandasya.persistence;

import com.viandasya.model.menu.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Page<Menu> findByNameContaining(String name, Pageable pageable);

    Page<Menu> findByCategoriesContaining(String category, Pageable pageable);

    Page<Menu> findByServiceProfileLocationCityContaining(String city, Pageable pageable);
}

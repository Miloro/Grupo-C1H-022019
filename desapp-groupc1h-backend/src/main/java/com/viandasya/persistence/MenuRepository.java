package com.viandasya.persistence;

import com.viandasya.model.menu.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

}

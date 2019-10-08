package com.viandasya.persistence;

import com.viandasya.model.menu.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {

}

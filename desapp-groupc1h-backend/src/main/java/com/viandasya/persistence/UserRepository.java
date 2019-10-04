package com.viandasya.persistence;

import org.springframework.data.repository.CrudRepository;
import com.viandasya.model.user.User;

public interface UserRepository  extends CrudRepository<User, Long> {
}

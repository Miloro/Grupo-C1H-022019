package com.viandasya.persistence;

import org.springframework.data.repository.CrudRepository;
import com.viandasya.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

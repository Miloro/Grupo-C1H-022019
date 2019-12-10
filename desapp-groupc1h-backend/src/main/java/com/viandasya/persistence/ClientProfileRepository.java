package com.viandasya.persistence;

import com.viandasya.model.user.ClientProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProfileRepository extends CrudRepository<ClientProfile, Long> {

}

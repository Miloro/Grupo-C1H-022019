package com.viandasya.persistence;

import com.viandasya.model.user.ServiceProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProfileRepository extends CrudRepository<ServiceProfile, Long> {

}

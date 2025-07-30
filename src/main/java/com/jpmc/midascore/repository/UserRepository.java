package com.jpmc.midascore.repository;

import com.jpmc.midascore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

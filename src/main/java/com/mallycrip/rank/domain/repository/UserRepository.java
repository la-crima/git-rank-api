package com.mallycrip.rank.domain.repository;

import com.mallycrip.rank.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}

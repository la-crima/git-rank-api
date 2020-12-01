package com.mallycrip.rank.domain.repository;

import com.mallycrip.rank.domain.entity.Auth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, String> {
    Optional<Auth> findByAuthCode(String authCode);
}

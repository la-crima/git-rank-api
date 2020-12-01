package com.mallycrip.rank.domain.repository;

import com.mallycrip.rank.domain.entity.Auth;
import com.mallycrip.rank.domain.entity.Contributions;
import org.springframework.data.repository.CrudRepository;

public interface ContributionsRepository extends CrudRepository<Contributions, String> {
}

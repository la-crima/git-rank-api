package com.mallycrip.rank.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash(value = "contributions")
@AllArgsConstructor
public class Contributions {
    @Id
    private String email;

    @Indexed
    private Long numOfContributions;
}

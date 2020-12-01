package com.mallycrip.rank.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="tbl_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String email;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(name = "github_id", nullable = false, length = 50)
    private String githubId;
}

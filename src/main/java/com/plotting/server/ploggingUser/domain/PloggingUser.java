package com.plotting.server.ploggingUser.domain;


import com.plotting.server.plogging.domain.Plogging;
import com.plotting.server.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name = "plogging_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PloggingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "plogging_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Plogging plogging;


    @Column(name = "is_assigned", nullable = false)
    private Boolean isAssigned;

    @Builder
    public PloggingUser(User user, Plogging plogging, Boolean isAssigned){
        this.user = user;
        this.plogging = plogging;
        this.isAssigned = isAssigned;
    }
}

package com.one.compass.track.entity;

import com.one.compass.utils.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CHANTING_ROUNDS")
@Builder
@IdClass(ChantingRoundsEntityId.class)
public class ChantingRoundsEntity extends Auditable {

    @Id
    @Column(name = "CHANTING_SEQ_NBR", nullable = false)
    private Long chantingSeqNbr;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "CHANTING_ROUNDS", nullable = false)
    private Integer chantingRounds;

    @Column(name = "DATE_EPOCH", nullable = false)
    private Long dateEpoch;
}

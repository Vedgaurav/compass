package com.one.compass.track.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChantingRoundsDto {
    private Long chantingSeqNbr;
    private Long userId;
    private Integer chantingRounds;
    private Long dateEpoch;
}

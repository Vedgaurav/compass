package com.one.compass.track.service;

import com.one.compass.track.dto.ChantingRoundsDto;
import com.one.compass.track.entity.ChantingRoundsEntity;
import com.one.compass.track.repository.ChantingRoundsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ChantingRoundsService {

    private final Logger logger = LoggerFactory.getLogger(ChantingRoundsService.class);

    private final ChantingRoundsRepository chantingRoundsRepository;

    public ChantingRoundsService(ChantingRoundsRepository chantingRoundsRepository) {
        this.chantingRoundsRepository = chantingRoundsRepository;
    }

    //TODO Global Exception Handler with proper logging and ResponseEntityUtils
    public ResponseEntity<ChantingRoundsDto> createChantingRounds(ChantingRoundsDto chantingRoundsDto) {
        logger.info("Creating chanting rounds");
        if (Objects.isNull(chantingRoundsDto)) {
            //TODO throw exception
            return ResponseEntity.badRequest().build();
        }

        ChantingRoundsEntity chantingRoundsEntity = getChantingRoundsEntityFromDto(chantingRoundsDto);
        Optional<ChantingRoundsEntity> chantingRoundsEntityOptional = chantingRoundsRepository.findByChantingSeqNbrAndUserId(chantingRoundsDto.getChantingSeqNbr(), chantingRoundsDto.getUserId());

        if (chantingRoundsEntityOptional.isPresent()) {
            //TODO throw exception
            return ResponseEntity.badRequest().build();
        }

        ChantingRoundsEntity chantingRoundsEntityResponse = chantingRoundsRepository.save(chantingRoundsEntity);
        ChantingRoundsDto chantingRoundsDtoResponse = getChantingRoundsDtoFromEntity(chantingRoundsEntityResponse);
        logger.info("Created chanting rounds with id:{}", chantingRoundsDtoResponse.getChantingSeqNbr());
        return ResponseEntity.ok(chantingRoundsDtoResponse);

    }

    private ChantingRoundsEntity getChantingRoundsEntityFromDto(ChantingRoundsDto chantingRoundsDto) {
        return ChantingRoundsEntity.builder()
                .chantingRounds(chantingRoundsDto.getChantingRounds())
                .chantingSeqNbr(chantingRoundsDto.getChantingSeqNbr())
                .userId(chantingRoundsDto.getUserId())
                .dateEpoch(System.currentTimeMillis() / 1000).build();
    }

    private ChantingRoundsDto getChantingRoundsDtoFromEntity(ChantingRoundsEntity chantingRoundsEntity) {
        return ChantingRoundsDto.builder()
                .chantingRounds(chantingRoundsEntity.getChantingRounds())
                .chantingSeqNbr(chantingRoundsEntity.getChantingSeqNbr())
                .userId(chantingRoundsEntity.getUserId())
                .dateEpoch(System.currentTimeMillis() / 1000).build();
    }
}

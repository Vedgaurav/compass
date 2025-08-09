package com.one.compass.track.repository;

import com.one.compass.track.entity.ChantingRoundsEntity;
import com.one.compass.track.entity.ChantingRoundsEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChantingRoundsRepository extends JpaRepository<ChantingRoundsEntity, ChantingRoundsEntityId> {
    Optional<ChantingRoundsEntity> findByChantingSeqNbrAndUserId(Long chantingSeqNbr, Long userId);
}

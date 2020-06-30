package com.oogie.discographyrest;

import com.oogie.discographyrest.model.SongListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongListRepository extends JpaRepository<SongListEntity, Integer> {
}

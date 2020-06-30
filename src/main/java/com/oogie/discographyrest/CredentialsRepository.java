package com.oogie.discographyrest;

import com.oogie.discographyrest.model.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Integer> {
}

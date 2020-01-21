package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.KalkulationDetails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link KalkulationDetails}.
 */
public interface KalkulationDetailsService {

    /**
     * Save a kalkulationDetails.
     *
     * @param kalkulationDetails the entity to save.
     * @return the persisted entity.
     */
    KalkulationDetails save(KalkulationDetails kalkulationDetails);

    /**
     * Get all the kalkulationDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<KalkulationDetails> findAll(Pageable pageable);


    /**
     * Get the "id" kalkulationDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<KalkulationDetails> findOne(Long id);

    /**
     * Delete the "id" kalkulationDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

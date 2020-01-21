package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Kalkulation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Kalkulation}.
 */
public interface KalkulationService {

    /**
     * Save a kalkulation.
     *
     * @param kalkulation the entity to save.
     * @return the persisted entity.
     */
    Kalkulation save(Kalkulation kalkulation);

    /**
     * Get all the kalkulations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Kalkulation> findAll(Pageable pageable);


    /**
     * Get the "id" kalkulation.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Kalkulation> findOne(Long id);

    /**
     * Delete the "id" kalkulation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

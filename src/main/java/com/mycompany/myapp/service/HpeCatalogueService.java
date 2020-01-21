package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.HpeCatalogue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link HpeCatalogue}.
 */
public interface HpeCatalogueService {

    /**
     * Save a hpeCatalogue.
     *
     * @param hpeCatalogue the entity to save.
     * @return the persisted entity.
     */
    HpeCatalogue save(HpeCatalogue hpeCatalogue);

    /**
     * Get all the hpeCatalogues.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<HpeCatalogue> findAll(Pageable pageable);


    /**
     * Get the "id" hpeCatalogue.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<HpeCatalogue> findOne(Long id);

    /**
     * Delete the "id" hpeCatalogue.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

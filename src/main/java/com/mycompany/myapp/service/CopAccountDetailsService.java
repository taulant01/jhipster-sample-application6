package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.CopAccountDetails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link CopAccountDetails}.
 */
public interface CopAccountDetailsService {

    /**
     * Save a copAccountDetails.
     *
     * @param copAccountDetails the entity to save.
     * @return the persisted entity.
     */
    CopAccountDetails save(CopAccountDetails copAccountDetails);

    /**
     * Get all the copAccountDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CopAccountDetails> findAll(Pageable pageable);


    /**
     * Get the "id" copAccountDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CopAccountDetails> findOne(Long id);

    /**
     * Delete the "id" copAccountDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

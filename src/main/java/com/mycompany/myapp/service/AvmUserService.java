package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.AvmUser;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link AvmUser}.
 */
public interface AvmUserService {

    /**
     * Save a avmUser.
     *
     * @param avmUser the entity to save.
     * @return the persisted entity.
     */
    AvmUser save(AvmUser avmUser);

    /**
     * Get all the avmUsers.
     *
     * @return the list of entities.
     */
    List<AvmUser> findAll();


    /**
     * Get the "id" avmUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AvmUser> findOne(Long id);

    /**
     * Delete the "id" avmUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

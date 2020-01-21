package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.AvmUserService;
import com.mycompany.myapp.domain.AvmUser;
import com.mycompany.myapp.repository.AvmUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link AvmUser}.
 */
@Service
@Transactional
public class AvmUserServiceImpl implements AvmUserService {

    private final Logger log = LoggerFactory.getLogger(AvmUserServiceImpl.class);

    private final AvmUserRepository avmUserRepository;

    public AvmUserServiceImpl(AvmUserRepository avmUserRepository) {
        this.avmUserRepository = avmUserRepository;
    }

    /**
     * Save a avmUser.
     *
     * @param avmUser the entity to save.
     * @return the persisted entity.
     */
    @Override
    public AvmUser save(AvmUser avmUser) {
        log.debug("Request to save AvmUser : {}", avmUser);
        return avmUserRepository.save(avmUser);
    }

    /**
     * Get all the avmUsers.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<AvmUser> findAll() {
        log.debug("Request to get all AvmUsers");
        return avmUserRepository.findAll();
    }


    /**
     * Get one avmUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AvmUser> findOne(Long id) {
        log.debug("Request to get AvmUser : {}", id);
        return avmUserRepository.findById(id);
    }

    /**
     * Delete the avmUser by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AvmUser : {}", id);
        avmUserRepository.deleteById(id);
    }
}

package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.CopAccountDetailsService;
import com.mycompany.myapp.domain.CopAccountDetails;
import com.mycompany.myapp.repository.CopAccountDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CopAccountDetails}.
 */
@Service
@Transactional
public class CopAccountDetailsServiceImpl implements CopAccountDetailsService {

    private final Logger log = LoggerFactory.getLogger(CopAccountDetailsServiceImpl.class);

    private final CopAccountDetailsRepository copAccountDetailsRepository;

    public CopAccountDetailsServiceImpl(CopAccountDetailsRepository copAccountDetailsRepository) {
        this.copAccountDetailsRepository = copAccountDetailsRepository;
    }

    /**
     * Save a copAccountDetails.
     *
     * @param copAccountDetails the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CopAccountDetails save(CopAccountDetails copAccountDetails) {
        log.debug("Request to save CopAccountDetails : {}", copAccountDetails);
        return copAccountDetailsRepository.save(copAccountDetails);
    }

    /**
     * Get all the copAccountDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CopAccountDetails> findAll(Pageable pageable) {
        log.debug("Request to get all CopAccountDetails");
        return copAccountDetailsRepository.findAll(pageable);
    }


    /**
     * Get one copAccountDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CopAccountDetails> findOne(Long id) {
        log.debug("Request to get CopAccountDetails : {}", id);
        return copAccountDetailsRepository.findById(id);
    }

    /**
     * Delete the copAccountDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CopAccountDetails : {}", id);
        copAccountDetailsRepository.deleteById(id);
    }
}

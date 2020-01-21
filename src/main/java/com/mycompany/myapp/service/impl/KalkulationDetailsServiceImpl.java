package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.KalkulationDetailsService;
import com.mycompany.myapp.domain.KalkulationDetails;
import com.mycompany.myapp.repository.KalkulationDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link KalkulationDetails}.
 */
@Service
@Transactional
public class KalkulationDetailsServiceImpl implements KalkulationDetailsService {

    private final Logger log = LoggerFactory.getLogger(KalkulationDetailsServiceImpl.class);

    private final KalkulationDetailsRepository kalkulationDetailsRepository;

    public KalkulationDetailsServiceImpl(KalkulationDetailsRepository kalkulationDetailsRepository) {
        this.kalkulationDetailsRepository = kalkulationDetailsRepository;
    }

    /**
     * Save a kalkulationDetails.
     *
     * @param kalkulationDetails the entity to save.
     * @return the persisted entity.
     */
    @Override
    public KalkulationDetails save(KalkulationDetails kalkulationDetails) {
        log.debug("Request to save KalkulationDetails : {}", kalkulationDetails);
        return kalkulationDetailsRepository.save(kalkulationDetails);
    }

    /**
     * Get all the kalkulationDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<KalkulationDetails> findAll(Pageable pageable) {
        log.debug("Request to get all KalkulationDetails");
        return kalkulationDetailsRepository.findAll(pageable);
    }


    /**
     * Get one kalkulationDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<KalkulationDetails> findOne(Long id) {
        log.debug("Request to get KalkulationDetails : {}", id);
        return kalkulationDetailsRepository.findById(id);
    }

    /**
     * Delete the kalkulationDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete KalkulationDetails : {}", id);
        kalkulationDetailsRepository.deleteById(id);
    }
}

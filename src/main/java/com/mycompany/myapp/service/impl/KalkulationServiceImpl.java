package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.KalkulationService;
import com.mycompany.myapp.domain.Kalkulation;
import com.mycompany.myapp.repository.KalkulationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Kalkulation}.
 */
@Service
@Transactional
public class KalkulationServiceImpl implements KalkulationService {

    private final Logger log = LoggerFactory.getLogger(KalkulationServiceImpl.class);

    private final KalkulationRepository kalkulationRepository;

    public KalkulationServiceImpl(KalkulationRepository kalkulationRepository) {
        this.kalkulationRepository = kalkulationRepository;
    }

    /**
     * Save a kalkulation.
     *
     * @param kalkulation the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Kalkulation save(Kalkulation kalkulation) {
        log.debug("Request to save Kalkulation : {}", kalkulation);
        return kalkulationRepository.save(kalkulation);
    }

    /**
     * Get all the kalkulations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Kalkulation> findAll(Pageable pageable) {
        log.debug("Request to get all Kalkulations");
        return kalkulationRepository.findAll(pageable);
    }


    /**
     * Get one kalkulation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Kalkulation> findOne(Long id) {
        log.debug("Request to get Kalkulation : {}", id);
        return kalkulationRepository.findById(id);
    }

    /**
     * Delete the kalkulation by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Kalkulation : {}", id);
        kalkulationRepository.deleteById(id);
    }
}

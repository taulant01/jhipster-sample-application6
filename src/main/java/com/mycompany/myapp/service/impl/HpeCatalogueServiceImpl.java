package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.HpeCatalogueService;
import com.mycompany.myapp.domain.HpeCatalogue;
import com.mycompany.myapp.repository.HpeCatalogueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link HpeCatalogue}.
 */
@Service
@Transactional
public class HpeCatalogueServiceImpl implements HpeCatalogueService {

    private final Logger log = LoggerFactory.getLogger(HpeCatalogueServiceImpl.class);

    private final HpeCatalogueRepository hpeCatalogueRepository;

    public HpeCatalogueServiceImpl(HpeCatalogueRepository hpeCatalogueRepository) {
        this.hpeCatalogueRepository = hpeCatalogueRepository;
    }

    /**
     * Save a hpeCatalogue.
     *
     * @param hpeCatalogue the entity to save.
     * @return the persisted entity.
     */
    @Override
    public HpeCatalogue save(HpeCatalogue hpeCatalogue) {
        log.debug("Request to save HpeCatalogue : {}", hpeCatalogue);
        return hpeCatalogueRepository.save(hpeCatalogue);
    }

    /**
     * Get all the hpeCatalogues.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HpeCatalogue> findAll(Pageable pageable) {
        log.debug("Request to get all HpeCatalogues");
        return hpeCatalogueRepository.findAll(pageable);
    }


    /**
     * Get one hpeCatalogue by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<HpeCatalogue> findOne(Long id) {
        log.debug("Request to get HpeCatalogue : {}", id);
        return hpeCatalogueRepository.findById(id);
    }

    /**
     * Delete the hpeCatalogue by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HpeCatalogue : {}", id);
        hpeCatalogueRepository.deleteById(id);
    }
}

package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.HpeCatalogue;
import com.mycompany.myapp.service.HpeCatalogueService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.HpeCatalogue}.
 */
@RestController
@RequestMapping("/api")
public class HpeCatalogueResource {

    private final Logger log = LoggerFactory.getLogger(HpeCatalogueResource.class);

    private static final String ENTITY_NAME = "hpeCatalogue";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final HpeCatalogueService hpeCatalogueService;

    public HpeCatalogueResource(HpeCatalogueService hpeCatalogueService) {
        this.hpeCatalogueService = hpeCatalogueService;
    }

    /**
     * {@code POST  /hpe-catalogues} : Create a new hpeCatalogue.
     *
     * @param hpeCatalogue the hpeCatalogue to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new hpeCatalogue, or with status {@code 400 (Bad Request)} if the hpeCatalogue has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/hpe-catalogues")
    public ResponseEntity<HpeCatalogue> createHpeCatalogue(@RequestBody HpeCatalogue hpeCatalogue) throws URISyntaxException {
        log.debug("REST request to save HpeCatalogue : {}", hpeCatalogue);
        if (hpeCatalogue.getId() != null) {
            throw new BadRequestAlertException("A new hpeCatalogue cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HpeCatalogue result = hpeCatalogueService.save(hpeCatalogue);
        return ResponseEntity.created(new URI("/api/hpe-catalogues/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /hpe-catalogues} : Updates an existing hpeCatalogue.
     *
     * @param hpeCatalogue the hpeCatalogue to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated hpeCatalogue,
     * or with status {@code 400 (Bad Request)} if the hpeCatalogue is not valid,
     * or with status {@code 500 (Internal Server Error)} if the hpeCatalogue couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/hpe-catalogues")
    public ResponseEntity<HpeCatalogue> updateHpeCatalogue(@RequestBody HpeCatalogue hpeCatalogue) throws URISyntaxException {
        log.debug("REST request to update HpeCatalogue : {}", hpeCatalogue);
        if (hpeCatalogue.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HpeCatalogue result = hpeCatalogueService.save(hpeCatalogue);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, hpeCatalogue.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /hpe-catalogues} : get all the hpeCatalogues.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of hpeCatalogues in body.
     */
    @GetMapping("/hpe-catalogues")
    public ResponseEntity<List<HpeCatalogue>> getAllHpeCatalogues(Pageable pageable) {
        log.debug("REST request to get a page of HpeCatalogues");
        Page<HpeCatalogue> page = hpeCatalogueService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /hpe-catalogues/:id} : get the "id" hpeCatalogue.
     *
     * @param id the id of the hpeCatalogue to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the hpeCatalogue, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/hpe-catalogues/{id}")
    public ResponseEntity<HpeCatalogue> getHpeCatalogue(@PathVariable Long id) {
        log.debug("REST request to get HpeCatalogue : {}", id);
        Optional<HpeCatalogue> hpeCatalogue = hpeCatalogueService.findOne(id);
        return ResponseUtil.wrapOrNotFound(hpeCatalogue);
    }

    /**
     * {@code DELETE  /hpe-catalogues/:id} : delete the "id" hpeCatalogue.
     *
     * @param id the id of the hpeCatalogue to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/hpe-catalogues/{id}")
    public ResponseEntity<Void> deleteHpeCatalogue(@PathVariable Long id) {
        log.debug("REST request to delete HpeCatalogue : {}", id);
        hpeCatalogueService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

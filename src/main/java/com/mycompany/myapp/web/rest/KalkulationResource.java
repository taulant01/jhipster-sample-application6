package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Kalkulation;
import com.mycompany.myapp.service.KalkulationService;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.Kalkulation}.
 */
@RestController
@RequestMapping("/api")
public class KalkulationResource {

    private final Logger log = LoggerFactory.getLogger(KalkulationResource.class);

    private static final String ENTITY_NAME = "kalkulation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final KalkulationService kalkulationService;

    public KalkulationResource(KalkulationService kalkulationService) {
        this.kalkulationService = kalkulationService;
    }

    /**
     * {@code POST  /kalkulations} : Create a new kalkulation.
     *
     * @param kalkulation the kalkulation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new kalkulation, or with status {@code 400 (Bad Request)} if the kalkulation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/kalkulations")
    public ResponseEntity<Kalkulation> createKalkulation(@RequestBody Kalkulation kalkulation) throws URISyntaxException {
        log.debug("REST request to save Kalkulation : {}", kalkulation);
        if (kalkulation.getId() != null) {
            throw new BadRequestAlertException("A new kalkulation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Kalkulation result = kalkulationService.save(kalkulation);
        return ResponseEntity.created(new URI("/api/kalkulations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /kalkulations} : Updates an existing kalkulation.
     *
     * @param kalkulation the kalkulation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated kalkulation,
     * or with status {@code 400 (Bad Request)} if the kalkulation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the kalkulation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/kalkulations")
    public ResponseEntity<Kalkulation> updateKalkulation(@RequestBody Kalkulation kalkulation) throws URISyntaxException {
        log.debug("REST request to update Kalkulation : {}", kalkulation);
        if (kalkulation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Kalkulation result = kalkulationService.save(kalkulation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, kalkulation.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /kalkulations} : get all the kalkulations.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of kalkulations in body.
     */
    @GetMapping("/kalkulations")
    public ResponseEntity<List<Kalkulation>> getAllKalkulations(Pageable pageable) {
        log.debug("REST request to get a page of Kalkulations");
        Page<Kalkulation> page = kalkulationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /kalkulations/:id} : get the "id" kalkulation.
     *
     * @param id the id of the kalkulation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the kalkulation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/kalkulations/{id}")
    public ResponseEntity<Kalkulation> getKalkulation(@PathVariable Long id) {
        log.debug("REST request to get Kalkulation : {}", id);
        Optional<Kalkulation> kalkulation = kalkulationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(kalkulation);
    }

    /**
     * {@code DELETE  /kalkulations/:id} : delete the "id" kalkulation.
     *
     * @param id the id of the kalkulation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/kalkulations/{id}")
    public ResponseEntity<Void> deleteKalkulation(@PathVariable Long id) {
        log.debug("REST request to delete Kalkulation : {}", id);
        kalkulationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

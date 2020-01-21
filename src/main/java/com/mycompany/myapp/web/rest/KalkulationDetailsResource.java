package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.KalkulationDetails;
import com.mycompany.myapp.service.KalkulationDetailsService;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.KalkulationDetails}.
 */
@RestController
@RequestMapping("/api")
public class KalkulationDetailsResource {

    private final Logger log = LoggerFactory.getLogger(KalkulationDetailsResource.class);

    private static final String ENTITY_NAME = "kalkulationDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final KalkulationDetailsService kalkulationDetailsService;

    public KalkulationDetailsResource(KalkulationDetailsService kalkulationDetailsService) {
        this.kalkulationDetailsService = kalkulationDetailsService;
    }

    /**
     * {@code POST  /kalkulation-details} : Create a new kalkulationDetails.
     *
     * @param kalkulationDetails the kalkulationDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new kalkulationDetails, or with status {@code 400 (Bad Request)} if the kalkulationDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/kalkulation-details")
    public ResponseEntity<KalkulationDetails> createKalkulationDetails(@RequestBody KalkulationDetails kalkulationDetails) throws URISyntaxException {
        log.debug("REST request to save KalkulationDetails : {}", kalkulationDetails);
        if (kalkulationDetails.getId() != null) {
            throw new BadRequestAlertException("A new kalkulationDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        KalkulationDetails result = kalkulationDetailsService.save(kalkulationDetails);
        return ResponseEntity.created(new URI("/api/kalkulation-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /kalkulation-details} : Updates an existing kalkulationDetails.
     *
     * @param kalkulationDetails the kalkulationDetails to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated kalkulationDetails,
     * or with status {@code 400 (Bad Request)} if the kalkulationDetails is not valid,
     * or with status {@code 500 (Internal Server Error)} if the kalkulationDetails couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/kalkulation-details")
    public ResponseEntity<KalkulationDetails> updateKalkulationDetails(@RequestBody KalkulationDetails kalkulationDetails) throws URISyntaxException {
        log.debug("REST request to update KalkulationDetails : {}", kalkulationDetails);
        if (kalkulationDetails.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        KalkulationDetails result = kalkulationDetailsService.save(kalkulationDetails);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, kalkulationDetails.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /kalkulation-details} : get all the kalkulationDetails.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of kalkulationDetails in body.
     */
    @GetMapping("/kalkulation-details")
    public ResponseEntity<List<KalkulationDetails>> getAllKalkulationDetails(Pageable pageable) {
        log.debug("REST request to get a page of KalkulationDetails");
        Page<KalkulationDetails> page = kalkulationDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /kalkulation-details/:id} : get the "id" kalkulationDetails.
     *
     * @param id the id of the kalkulationDetails to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the kalkulationDetails, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/kalkulation-details/{id}")
    public ResponseEntity<KalkulationDetails> getKalkulationDetails(@PathVariable Long id) {
        log.debug("REST request to get KalkulationDetails : {}", id);
        Optional<KalkulationDetails> kalkulationDetails = kalkulationDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(kalkulationDetails);
    }

    /**
     * {@code DELETE  /kalkulation-details/:id} : delete the "id" kalkulationDetails.
     *
     * @param id the id of the kalkulationDetails to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/kalkulation-details/{id}")
    public ResponseEntity<Void> deleteKalkulationDetails(@PathVariable Long id) {
        log.debug("REST request to delete KalkulationDetails : {}", id);
        kalkulationDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

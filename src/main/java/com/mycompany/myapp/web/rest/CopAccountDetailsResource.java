package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.CopAccountDetails;
import com.mycompany.myapp.service.CopAccountDetailsService;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.CopAccountDetails}.
 */
@RestController
@RequestMapping("/api")
public class CopAccountDetailsResource {

    private final Logger log = LoggerFactory.getLogger(CopAccountDetailsResource.class);

    private static final String ENTITY_NAME = "copAccountDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CopAccountDetailsService copAccountDetailsService;

    public CopAccountDetailsResource(CopAccountDetailsService copAccountDetailsService) {
        this.copAccountDetailsService = copAccountDetailsService;
    }

    /**
     * {@code POST  /cop-account-details} : Create a new copAccountDetails.
     *
     * @param copAccountDetails the copAccountDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new copAccountDetails, or with status {@code 400 (Bad Request)} if the copAccountDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cop-account-details")
    public ResponseEntity<CopAccountDetails> createCopAccountDetails(@RequestBody CopAccountDetails copAccountDetails) throws URISyntaxException {
        log.debug("REST request to save CopAccountDetails : {}", copAccountDetails);
        if (copAccountDetails.getId() != null) {
            throw new BadRequestAlertException("A new copAccountDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CopAccountDetails result = copAccountDetailsService.save(copAccountDetails);
        return ResponseEntity.created(new URI("/api/cop-account-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cop-account-details} : Updates an existing copAccountDetails.
     *
     * @param copAccountDetails the copAccountDetails to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated copAccountDetails,
     * or with status {@code 400 (Bad Request)} if the copAccountDetails is not valid,
     * or with status {@code 500 (Internal Server Error)} if the copAccountDetails couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cop-account-details")
    public ResponseEntity<CopAccountDetails> updateCopAccountDetails(@RequestBody CopAccountDetails copAccountDetails) throws URISyntaxException {
        log.debug("REST request to update CopAccountDetails : {}", copAccountDetails);
        if (copAccountDetails.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CopAccountDetails result = copAccountDetailsService.save(copAccountDetails);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, copAccountDetails.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cop-account-details} : get all the copAccountDetails.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of copAccountDetails in body.
     */
    @GetMapping("/cop-account-details")
    public ResponseEntity<List<CopAccountDetails>> getAllCopAccountDetails(Pageable pageable) {
        log.debug("REST request to get a page of CopAccountDetails");
        Page<CopAccountDetails> page = copAccountDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cop-account-details/:id} : get the "id" copAccountDetails.
     *
     * @param id the id of the copAccountDetails to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the copAccountDetails, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cop-account-details/{id}")
    public ResponseEntity<CopAccountDetails> getCopAccountDetails(@PathVariable Long id) {
        log.debug("REST request to get CopAccountDetails : {}", id);
        Optional<CopAccountDetails> copAccountDetails = copAccountDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(copAccountDetails);
    }

    /**
     * {@code DELETE  /cop-account-details/:id} : delete the "id" copAccountDetails.
     *
     * @param id the id of the copAccountDetails to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cop-account-details/{id}")
    public ResponseEntity<Void> deleteCopAccountDetails(@PathVariable Long id) {
        log.debug("REST request to delete CopAccountDetails : {}", id);
        copAccountDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.AvmUser;
import com.mycompany.myapp.service.AvmUserService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.AvmUser}.
 */
@RestController
@RequestMapping("/api")
public class AvmUserResource {

    private final Logger log = LoggerFactory.getLogger(AvmUserResource.class);

    private static final String ENTITY_NAME = "avmUser";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AvmUserService avmUserService;

    public AvmUserResource(AvmUserService avmUserService) {
        this.avmUserService = avmUserService;
    }

    /**
     * {@code POST  /avm-users} : Create a new avmUser.
     *
     * @param avmUser the avmUser to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new avmUser, or with status {@code 400 (Bad Request)} if the avmUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/avm-users")
    public ResponseEntity<AvmUser> createAvmUser(@RequestBody AvmUser avmUser) throws URISyntaxException {
        log.debug("REST request to save AvmUser : {}", avmUser);
        if (avmUser.getId() != null) {
            throw new BadRequestAlertException("A new avmUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AvmUser result = avmUserService.save(avmUser);
        return ResponseEntity.created(new URI("/api/avm-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /avm-users} : Updates an existing avmUser.
     *
     * @param avmUser the avmUser to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated avmUser,
     * or with status {@code 400 (Bad Request)} if the avmUser is not valid,
     * or with status {@code 500 (Internal Server Error)} if the avmUser couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/avm-users")
    public ResponseEntity<AvmUser> updateAvmUser(@RequestBody AvmUser avmUser) throws URISyntaxException {
        log.debug("REST request to update AvmUser : {}", avmUser);
        if (avmUser.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AvmUser result = avmUserService.save(avmUser);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, avmUser.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /avm-users} : get all the avmUsers.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of avmUsers in body.
     */
    @GetMapping("/avm-users")
    public List<AvmUser> getAllAvmUsers() {
        log.debug("REST request to get all AvmUsers");
        return avmUserService.findAll();
    }

    /**
     * {@code GET  /avm-users/:id} : get the "id" avmUser.
     *
     * @param id the id of the avmUser to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the avmUser, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/avm-users/{id}")
    public ResponseEntity<AvmUser> getAvmUser(@PathVariable Long id) {
        log.debug("REST request to get AvmUser : {}", id);
        Optional<AvmUser> avmUser = avmUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(avmUser);
    }

    /**
     * {@code DELETE  /avm-users/:id} : delete the "id" avmUser.
     *
     * @param id the id of the avmUser to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/avm-users/{id}")
    public ResponseEntity<Void> deleteAvmUser(@PathVariable Long id) {
        log.debug("REST request to delete AvmUser : {}", id);
        avmUserService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

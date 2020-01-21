package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleApplication55App;
import com.mycompany.myapp.domain.AvmUser;
import com.mycompany.myapp.repository.AvmUserRepository;
import com.mycompany.myapp.service.AvmUserService;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.mycompany.myapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AvmUserResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication55App.class)
public class AvmUserResourceIT {

    @Autowired
    private AvmUserRepository avmUserRepository;

    @Autowired
    private AvmUserService avmUserService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restAvmUserMockMvc;

    private AvmUser avmUser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AvmUserResource avmUserResource = new AvmUserResource(avmUserService);
        this.restAvmUserMockMvc = MockMvcBuilders.standaloneSetup(avmUserResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AvmUser createEntity(EntityManager em) {
        AvmUser avmUser = new AvmUser();
        return avmUser;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AvmUser createUpdatedEntity(EntityManager em) {
        AvmUser avmUser = new AvmUser();
        return avmUser;
    }

    @BeforeEach
    public void initTest() {
        avmUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createAvmUser() throws Exception {
        int databaseSizeBeforeCreate = avmUserRepository.findAll().size();

        // Create the AvmUser
        restAvmUserMockMvc.perform(post("/api/avm-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(avmUser)))
            .andExpect(status().isCreated());

        // Validate the AvmUser in the database
        List<AvmUser> avmUserList = avmUserRepository.findAll();
        assertThat(avmUserList).hasSize(databaseSizeBeforeCreate + 1);
        AvmUser testAvmUser = avmUserList.get(avmUserList.size() - 1);
    }

    @Test
    @Transactional
    public void createAvmUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = avmUserRepository.findAll().size();

        // Create the AvmUser with an existing ID
        avmUser.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAvmUserMockMvc.perform(post("/api/avm-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(avmUser)))
            .andExpect(status().isBadRequest());

        // Validate the AvmUser in the database
        List<AvmUser> avmUserList = avmUserRepository.findAll();
        assertThat(avmUserList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAvmUsers() throws Exception {
        // Initialize the database
        avmUserRepository.saveAndFlush(avmUser);

        // Get all the avmUserList
        restAvmUserMockMvc.perform(get("/api/avm-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(avmUser.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getAvmUser() throws Exception {
        // Initialize the database
        avmUserRepository.saveAndFlush(avmUser);

        // Get the avmUser
        restAvmUserMockMvc.perform(get("/api/avm-users/{id}", avmUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(avmUser.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingAvmUser() throws Exception {
        // Get the avmUser
        restAvmUserMockMvc.perform(get("/api/avm-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAvmUser() throws Exception {
        // Initialize the database
        avmUserService.save(avmUser);

        int databaseSizeBeforeUpdate = avmUserRepository.findAll().size();

        // Update the avmUser
        AvmUser updatedAvmUser = avmUserRepository.findById(avmUser.getId()).get();
        // Disconnect from session so that the updates on updatedAvmUser are not directly saved in db
        em.detach(updatedAvmUser);

        restAvmUserMockMvc.perform(put("/api/avm-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAvmUser)))
            .andExpect(status().isOk());

        // Validate the AvmUser in the database
        List<AvmUser> avmUserList = avmUserRepository.findAll();
        assertThat(avmUserList).hasSize(databaseSizeBeforeUpdate);
        AvmUser testAvmUser = avmUserList.get(avmUserList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingAvmUser() throws Exception {
        int databaseSizeBeforeUpdate = avmUserRepository.findAll().size();

        // Create the AvmUser

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAvmUserMockMvc.perform(put("/api/avm-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(avmUser)))
            .andExpect(status().isBadRequest());

        // Validate the AvmUser in the database
        List<AvmUser> avmUserList = avmUserRepository.findAll();
        assertThat(avmUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAvmUser() throws Exception {
        // Initialize the database
        avmUserService.save(avmUser);

        int databaseSizeBeforeDelete = avmUserRepository.findAll().size();

        // Delete the avmUser
        restAvmUserMockMvc.perform(delete("/api/avm-users/{id}", avmUser.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AvmUser> avmUserList = avmUserRepository.findAll();
        assertThat(avmUserList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

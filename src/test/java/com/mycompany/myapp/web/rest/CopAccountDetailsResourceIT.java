package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleApplication55App;
import com.mycompany.myapp.domain.CopAccountDetails;
import com.mycompany.myapp.repository.CopAccountDetailsRepository;
import com.mycompany.myapp.service.CopAccountDetailsService;
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
 * Integration tests for the {@link CopAccountDetailsResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication55App.class)
public class CopAccountDetailsResourceIT {

    private static final String DEFAULT_COP_USER = "AAAAAAAAAA";
    private static final String UPDATED_COP_USER = "BBBBBBBBBB";

    private static final String DEFAULT_COP_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_COP_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_COP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COP_NAME = "BBBBBBBBBB";

    @Autowired
    private CopAccountDetailsRepository copAccountDetailsRepository;

    @Autowired
    private CopAccountDetailsService copAccountDetailsService;

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

    private MockMvc restCopAccountDetailsMockMvc;

    private CopAccountDetails copAccountDetails;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CopAccountDetailsResource copAccountDetailsResource = new CopAccountDetailsResource(copAccountDetailsService);
        this.restCopAccountDetailsMockMvc = MockMvcBuilders.standaloneSetup(copAccountDetailsResource)
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
    public static CopAccountDetails createEntity(EntityManager em) {
        CopAccountDetails copAccountDetails = new CopAccountDetails()
            .copUser(DEFAULT_COP_USER)
            .copPassword(DEFAULT_COP_PASSWORD)
            .copName(DEFAULT_COP_NAME);
        return copAccountDetails;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CopAccountDetails createUpdatedEntity(EntityManager em) {
        CopAccountDetails copAccountDetails = new CopAccountDetails()
            .copUser(UPDATED_COP_USER)
            .copPassword(UPDATED_COP_PASSWORD)
            .copName(UPDATED_COP_NAME);
        return copAccountDetails;
    }

    @BeforeEach
    public void initTest() {
        copAccountDetails = createEntity(em);
    }

    @Test
    @Transactional
    public void createCopAccountDetails() throws Exception {
        int databaseSizeBeforeCreate = copAccountDetailsRepository.findAll().size();

        // Create the CopAccountDetails
        restCopAccountDetailsMockMvc.perform(post("/api/cop-account-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(copAccountDetails)))
            .andExpect(status().isCreated());

        // Validate the CopAccountDetails in the database
        List<CopAccountDetails> copAccountDetailsList = copAccountDetailsRepository.findAll();
        assertThat(copAccountDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        CopAccountDetails testCopAccountDetails = copAccountDetailsList.get(copAccountDetailsList.size() - 1);
        assertThat(testCopAccountDetails.getCopUser()).isEqualTo(DEFAULT_COP_USER);
        assertThat(testCopAccountDetails.getCopPassword()).isEqualTo(DEFAULT_COP_PASSWORD);
        assertThat(testCopAccountDetails.getCopName()).isEqualTo(DEFAULT_COP_NAME);
    }

    @Test
    @Transactional
    public void createCopAccountDetailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = copAccountDetailsRepository.findAll().size();

        // Create the CopAccountDetails with an existing ID
        copAccountDetails.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCopAccountDetailsMockMvc.perform(post("/api/cop-account-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(copAccountDetails)))
            .andExpect(status().isBadRequest());

        // Validate the CopAccountDetails in the database
        List<CopAccountDetails> copAccountDetailsList = copAccountDetailsRepository.findAll();
        assertThat(copAccountDetailsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCopAccountDetails() throws Exception {
        // Initialize the database
        copAccountDetailsRepository.saveAndFlush(copAccountDetails);

        // Get all the copAccountDetailsList
        restCopAccountDetailsMockMvc.perform(get("/api/cop-account-details?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(copAccountDetails.getId().intValue())))
            .andExpect(jsonPath("$.[*].copUser").value(hasItem(DEFAULT_COP_USER)))
            .andExpect(jsonPath("$.[*].copPassword").value(hasItem(DEFAULT_COP_PASSWORD)))
            .andExpect(jsonPath("$.[*].copName").value(hasItem(DEFAULT_COP_NAME)));
    }
    
    @Test
    @Transactional
    public void getCopAccountDetails() throws Exception {
        // Initialize the database
        copAccountDetailsRepository.saveAndFlush(copAccountDetails);

        // Get the copAccountDetails
        restCopAccountDetailsMockMvc.perform(get("/api/cop-account-details/{id}", copAccountDetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(copAccountDetails.getId().intValue()))
            .andExpect(jsonPath("$.copUser").value(DEFAULT_COP_USER))
            .andExpect(jsonPath("$.copPassword").value(DEFAULT_COP_PASSWORD))
            .andExpect(jsonPath("$.copName").value(DEFAULT_COP_NAME));
    }

    @Test
    @Transactional
    public void getNonExistingCopAccountDetails() throws Exception {
        // Get the copAccountDetails
        restCopAccountDetailsMockMvc.perform(get("/api/cop-account-details/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCopAccountDetails() throws Exception {
        // Initialize the database
        copAccountDetailsService.save(copAccountDetails);

        int databaseSizeBeforeUpdate = copAccountDetailsRepository.findAll().size();

        // Update the copAccountDetails
        CopAccountDetails updatedCopAccountDetails = copAccountDetailsRepository.findById(copAccountDetails.getId()).get();
        // Disconnect from session so that the updates on updatedCopAccountDetails are not directly saved in db
        em.detach(updatedCopAccountDetails);
        updatedCopAccountDetails
            .copUser(UPDATED_COP_USER)
            .copPassword(UPDATED_COP_PASSWORD)
            .copName(UPDATED_COP_NAME);

        restCopAccountDetailsMockMvc.perform(put("/api/cop-account-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCopAccountDetails)))
            .andExpect(status().isOk());

        // Validate the CopAccountDetails in the database
        List<CopAccountDetails> copAccountDetailsList = copAccountDetailsRepository.findAll();
        assertThat(copAccountDetailsList).hasSize(databaseSizeBeforeUpdate);
        CopAccountDetails testCopAccountDetails = copAccountDetailsList.get(copAccountDetailsList.size() - 1);
        assertThat(testCopAccountDetails.getCopUser()).isEqualTo(UPDATED_COP_USER);
        assertThat(testCopAccountDetails.getCopPassword()).isEqualTo(UPDATED_COP_PASSWORD);
        assertThat(testCopAccountDetails.getCopName()).isEqualTo(UPDATED_COP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingCopAccountDetails() throws Exception {
        int databaseSizeBeforeUpdate = copAccountDetailsRepository.findAll().size();

        // Create the CopAccountDetails

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCopAccountDetailsMockMvc.perform(put("/api/cop-account-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(copAccountDetails)))
            .andExpect(status().isBadRequest());

        // Validate the CopAccountDetails in the database
        List<CopAccountDetails> copAccountDetailsList = copAccountDetailsRepository.findAll();
        assertThat(copAccountDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCopAccountDetails() throws Exception {
        // Initialize the database
        copAccountDetailsService.save(copAccountDetails);

        int databaseSizeBeforeDelete = copAccountDetailsRepository.findAll().size();

        // Delete the copAccountDetails
        restCopAccountDetailsMockMvc.perform(delete("/api/cop-account-details/{id}", copAccountDetails.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CopAccountDetails> copAccountDetailsList = copAccountDetailsRepository.findAll();
        assertThat(copAccountDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

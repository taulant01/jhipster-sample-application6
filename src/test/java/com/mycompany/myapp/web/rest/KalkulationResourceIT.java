package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleApplication55App;
import com.mycompany.myapp.domain.Kalkulation;
import com.mycompany.myapp.repository.KalkulationRepository;
import com.mycompany.myapp.service.KalkulationService;
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

import com.mycompany.myapp.domain.enumeration.Status;
/**
 * Integration tests for the {@link KalkulationResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication55App.class)
public class KalkulationResourceIT {

    private static final Integer DEFAULT_KALK_ID = 1;
    private static final Integer UPDATED_KALK_ID = 2;

    private static final Double DEFAULT_VERSION = 1D;
    private static final Double UPDATED_VERSION = 2D;

    private static final Status DEFAULT_STATUS = Status.IN_PROGRESS;
    private static final Status UPDATED_STATUS = Status.CANCELLED;

    private static final Boolean DEFAULT_EDITING = false;
    private static final Boolean UPDATED_EDITING = true;

    @Autowired
    private KalkulationRepository kalkulationRepository;

    @Autowired
    private KalkulationService kalkulationService;

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

    private MockMvc restKalkulationMockMvc;

    private Kalkulation kalkulation;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final KalkulationResource kalkulationResource = new KalkulationResource(kalkulationService);
        this.restKalkulationMockMvc = MockMvcBuilders.standaloneSetup(kalkulationResource)
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
    public static Kalkulation createEntity(EntityManager em) {
        Kalkulation kalkulation = new Kalkulation()
            .kalkId(DEFAULT_KALK_ID)
            .version(DEFAULT_VERSION)
            .status(DEFAULT_STATUS)
            .editing(DEFAULT_EDITING);
        return kalkulation;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Kalkulation createUpdatedEntity(EntityManager em) {
        Kalkulation kalkulation = new Kalkulation()
            .kalkId(UPDATED_KALK_ID)
            .version(UPDATED_VERSION)
            .status(UPDATED_STATUS)
            .editing(UPDATED_EDITING);
        return kalkulation;
    }

    @BeforeEach
    public void initTest() {
        kalkulation = createEntity(em);
    }

    @Test
    @Transactional
    public void createKalkulation() throws Exception {
        int databaseSizeBeforeCreate = kalkulationRepository.findAll().size();

        // Create the Kalkulation
        restKalkulationMockMvc.perform(post("/api/kalkulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kalkulation)))
            .andExpect(status().isCreated());

        // Validate the Kalkulation in the database
        List<Kalkulation> kalkulationList = kalkulationRepository.findAll();
        assertThat(kalkulationList).hasSize(databaseSizeBeforeCreate + 1);
        Kalkulation testKalkulation = kalkulationList.get(kalkulationList.size() - 1);
        assertThat(testKalkulation.getKalkId()).isEqualTo(DEFAULT_KALK_ID);
        assertThat(testKalkulation.getVersion()).isEqualTo(DEFAULT_VERSION);
        assertThat(testKalkulation.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testKalkulation.isEditing()).isEqualTo(DEFAULT_EDITING);
    }

    @Test
    @Transactional
    public void createKalkulationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = kalkulationRepository.findAll().size();

        // Create the Kalkulation with an existing ID
        kalkulation.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restKalkulationMockMvc.perform(post("/api/kalkulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kalkulation)))
            .andExpect(status().isBadRequest());

        // Validate the Kalkulation in the database
        List<Kalkulation> kalkulationList = kalkulationRepository.findAll();
        assertThat(kalkulationList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllKalkulations() throws Exception {
        // Initialize the database
        kalkulationRepository.saveAndFlush(kalkulation);

        // Get all the kalkulationList
        restKalkulationMockMvc.perform(get("/api/kalkulations?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(kalkulation.getId().intValue())))
            .andExpect(jsonPath("$.[*].kalkId").value(hasItem(DEFAULT_KALK_ID)))
            .andExpect(jsonPath("$.[*].version").value(hasItem(DEFAULT_VERSION.doubleValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].editing").value(hasItem(DEFAULT_EDITING.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getKalkulation() throws Exception {
        // Initialize the database
        kalkulationRepository.saveAndFlush(kalkulation);

        // Get the kalkulation
        restKalkulationMockMvc.perform(get("/api/kalkulations/{id}", kalkulation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(kalkulation.getId().intValue()))
            .andExpect(jsonPath("$.kalkId").value(DEFAULT_KALK_ID))
            .andExpect(jsonPath("$.version").value(DEFAULT_VERSION.doubleValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.editing").value(DEFAULT_EDITING.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingKalkulation() throws Exception {
        // Get the kalkulation
        restKalkulationMockMvc.perform(get("/api/kalkulations/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateKalkulation() throws Exception {
        // Initialize the database
        kalkulationService.save(kalkulation);

        int databaseSizeBeforeUpdate = kalkulationRepository.findAll().size();

        // Update the kalkulation
        Kalkulation updatedKalkulation = kalkulationRepository.findById(kalkulation.getId()).get();
        // Disconnect from session so that the updates on updatedKalkulation are not directly saved in db
        em.detach(updatedKalkulation);
        updatedKalkulation
            .kalkId(UPDATED_KALK_ID)
            .version(UPDATED_VERSION)
            .status(UPDATED_STATUS)
            .editing(UPDATED_EDITING);

        restKalkulationMockMvc.perform(put("/api/kalkulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedKalkulation)))
            .andExpect(status().isOk());

        // Validate the Kalkulation in the database
        List<Kalkulation> kalkulationList = kalkulationRepository.findAll();
        assertThat(kalkulationList).hasSize(databaseSizeBeforeUpdate);
        Kalkulation testKalkulation = kalkulationList.get(kalkulationList.size() - 1);
        assertThat(testKalkulation.getKalkId()).isEqualTo(UPDATED_KALK_ID);
        assertThat(testKalkulation.getVersion()).isEqualTo(UPDATED_VERSION);
        assertThat(testKalkulation.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testKalkulation.isEditing()).isEqualTo(UPDATED_EDITING);
    }

    @Test
    @Transactional
    public void updateNonExistingKalkulation() throws Exception {
        int databaseSizeBeforeUpdate = kalkulationRepository.findAll().size();

        // Create the Kalkulation

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restKalkulationMockMvc.perform(put("/api/kalkulations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kalkulation)))
            .andExpect(status().isBadRequest());

        // Validate the Kalkulation in the database
        List<Kalkulation> kalkulationList = kalkulationRepository.findAll();
        assertThat(kalkulationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteKalkulation() throws Exception {
        // Initialize the database
        kalkulationService.save(kalkulation);

        int databaseSizeBeforeDelete = kalkulationRepository.findAll().size();

        // Delete the kalkulation
        restKalkulationMockMvc.perform(delete("/api/kalkulations/{id}", kalkulation.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Kalkulation> kalkulationList = kalkulationRepository.findAll();
        assertThat(kalkulationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

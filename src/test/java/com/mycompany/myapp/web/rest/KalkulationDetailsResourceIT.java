package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleApplication55App;
import com.mycompany.myapp.domain.KalkulationDetails;
import com.mycompany.myapp.repository.KalkulationDetailsRepository;
import com.mycompany.myapp.service.KalkulationDetailsService;
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
 * Integration tests for the {@link KalkulationDetailsResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication55App.class)
public class KalkulationDetailsResourceIT {

    private static final String DEFAULT_A = "AAAAAAAAAA";
    private static final String UPDATED_A = "BBBBBBBBBB";

    private static final String DEFAULT_B = "AAAAAAAAAA";
    private static final String UPDATED_B = "BBBBBBBBBB";

    private static final String DEFAULT_C = "AAAAAAAAAA";
    private static final String UPDATED_C = "BBBBBBBBBB";

    private static final String DEFAULT_D = "AAAAAAAAAA";
    private static final String UPDATED_D = "BBBBBBBBBB";

    private static final String DEFAULT_E = "AAAAAAAAAA";
    private static final String UPDATED_E = "BBBBBBBBBB";

    private static final String DEFAULT_F = "AAAAAAAAAA";
    private static final String UPDATED_F = "BBBBBBBBBB";

    private static final String DEFAULT_G = "AAAAAAAAAA";
    private static final String UPDATED_G = "BBBBBBBBBB";

    private static final String DEFAULT_H = "AAAAAAAAAA";
    private static final String UPDATED_H = "BBBBBBBBBB";

    private static final String DEFAULT_I = "AAAAAAAAAA";
    private static final String UPDATED_I = "BBBBBBBBBB";

    private static final String DEFAULT_J = "AAAAAAAAAA";
    private static final String UPDATED_J = "BBBBBBBBBB";

    private static final String DEFAULT_K = "AAAAAAAAAA";
    private static final String UPDATED_K = "BBBBBBBBBB";

    private static final String DEFAULT_L = "AAAAAAAAAA";
    private static final String UPDATED_L = "BBBBBBBBBB";

    private static final String DEFAULT_M = "AAAAAAAAAA";
    private static final String UPDATED_M = "BBBBBBBBBB";

    private static final String DEFAULT_N = "AAAAAAAAAA";
    private static final String UPDATED_N = "BBBBBBBBBB";

    private static final String DEFAULT_O = "AAAAAAAAAA";
    private static final String UPDATED_O = "BBBBBBBBBB";

    private static final String DEFAULT_P = "AAAAAAAAAA";
    private static final String UPDATED_P = "BBBBBBBBBB";

    private static final String DEFAULT_Q = "AAAAAAAAAA";
    private static final String UPDATED_Q = "BBBBBBBBBB";

    private static final String DEFAULT_R = "AAAAAAAAAA";
    private static final String UPDATED_R = "BBBBBBBBBB";

    private static final String DEFAULT_S = "AAAAAAAAAA";
    private static final String UPDATED_S = "BBBBBBBBBB";

    private static final String DEFAULT_T = "AAAAAAAAAA";
    private static final String UPDATED_T = "BBBBBBBBBB";

    private static final String DEFAULT_U = "AAAAAAAAAA";
    private static final String UPDATED_U = "BBBBBBBBBB";

    private static final String DEFAULT_V = "AAAAAAAAAA";
    private static final String UPDATED_V = "BBBBBBBBBB";

    private static final String DEFAULT_W = "AAAAAAAAAA";
    private static final String UPDATED_W = "BBBBBBBBBB";

    private static final String DEFAULT_X = "AAAAAAAAAA";
    private static final String UPDATED_X = "BBBBBBBBBB";

    private static final String DEFAULT_Y = "AAAAAAAAAA";
    private static final String UPDATED_Y = "BBBBBBBBBB";

    private static final String DEFAULT_Z = "AAAAAAAAAA";
    private static final String UPDATED_Z = "BBBBBBBBBB";

    private static final String DEFAULT_AA = "AAAAAAAAAA";
    private static final String UPDATED_AA = "BBBBBBBBBB";

    private static final String DEFAULT_AB = "AAAAAAAAAA";
    private static final String UPDATED_AB = "BBBBBBBBBB";

    private static final String DEFAULT_AC = "AAAAAAAAAA";
    private static final String UPDATED_AC = "BBBBBBBBBB";

    private static final String DEFAULT_AD = "AAAAAAAAAA";
    private static final String UPDATED_AD = "BBBBBBBBBB";

    private static final String DEFAULT_AE = "AAAAAAAAAA";
    private static final String UPDATED_AE = "BBBBBBBBBB";

    private static final String DEFAULT_AF = "AAAAAAAAAA";
    private static final String UPDATED_AF = "BBBBBBBBBB";

    private static final String DEFAULT_AG = "AAAAAAAAAA";
    private static final String UPDATED_AG = "BBBBBBBBBB";

    @Autowired
    private KalkulationDetailsRepository kalkulationDetailsRepository;

    @Autowired
    private KalkulationDetailsService kalkulationDetailsService;

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

    private MockMvc restKalkulationDetailsMockMvc;

    private KalkulationDetails kalkulationDetails;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final KalkulationDetailsResource kalkulationDetailsResource = new KalkulationDetailsResource(kalkulationDetailsService);
        this.restKalkulationDetailsMockMvc = MockMvcBuilders.standaloneSetup(kalkulationDetailsResource)
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
    public static KalkulationDetails createEntity(EntityManager em) {
        KalkulationDetails kalkulationDetails = new KalkulationDetails()
            .a(DEFAULT_A)
            .b(DEFAULT_B)
            .c(DEFAULT_C)
            .d(DEFAULT_D)
            .e(DEFAULT_E)
            .f(DEFAULT_F)
            .g(DEFAULT_G)
            .h(DEFAULT_H)
            .i(DEFAULT_I)
            .j(DEFAULT_J)
            .k(DEFAULT_K)
            .l(DEFAULT_L)
            .m(DEFAULT_M)
            .n(DEFAULT_N)
            .o(DEFAULT_O)
            .p(DEFAULT_P)
            .q(DEFAULT_Q)
            .r(DEFAULT_R)
            .s(DEFAULT_S)
            .t(DEFAULT_T)
            .u(DEFAULT_U)
            .v(DEFAULT_V)
            .w(DEFAULT_W)
            .x(DEFAULT_X)
            .y(DEFAULT_Y)
            .z(DEFAULT_Z)
            .aa(DEFAULT_AA)
            .ab(DEFAULT_AB)
            .ac(DEFAULT_AC)
            .ad(DEFAULT_AD)
            .ae(DEFAULT_AE)
            .af(DEFAULT_AF)
            .ag(DEFAULT_AG);
        return kalkulationDetails;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static KalkulationDetails createUpdatedEntity(EntityManager em) {
        KalkulationDetails kalkulationDetails = new KalkulationDetails()
            .a(UPDATED_A)
            .b(UPDATED_B)
            .c(UPDATED_C)
            .d(UPDATED_D)
            .e(UPDATED_E)
            .f(UPDATED_F)
            .g(UPDATED_G)
            .h(UPDATED_H)
            .i(UPDATED_I)
            .j(UPDATED_J)
            .k(UPDATED_K)
            .l(UPDATED_L)
            .m(UPDATED_M)
            .n(UPDATED_N)
            .o(UPDATED_O)
            .p(UPDATED_P)
            .q(UPDATED_Q)
            .r(UPDATED_R)
            .s(UPDATED_S)
            .t(UPDATED_T)
            .u(UPDATED_U)
            .v(UPDATED_V)
            .w(UPDATED_W)
            .x(UPDATED_X)
            .y(UPDATED_Y)
            .z(UPDATED_Z)
            .aa(UPDATED_AA)
            .ab(UPDATED_AB)
            .ac(UPDATED_AC)
            .ad(UPDATED_AD)
            .ae(UPDATED_AE)
            .af(UPDATED_AF)
            .ag(UPDATED_AG);
        return kalkulationDetails;
    }

    @BeforeEach
    public void initTest() {
        kalkulationDetails = createEntity(em);
    }

    @Test
    @Transactional
    public void createKalkulationDetails() throws Exception {
        int databaseSizeBeforeCreate = kalkulationDetailsRepository.findAll().size();

        // Create the KalkulationDetails
        restKalkulationDetailsMockMvc.perform(post("/api/kalkulation-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kalkulationDetails)))
            .andExpect(status().isCreated());

        // Validate the KalkulationDetails in the database
        List<KalkulationDetails> kalkulationDetailsList = kalkulationDetailsRepository.findAll();
        assertThat(kalkulationDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        KalkulationDetails testKalkulationDetails = kalkulationDetailsList.get(kalkulationDetailsList.size() - 1);
        assertThat(testKalkulationDetails.getA()).isEqualTo(DEFAULT_A);
        assertThat(testKalkulationDetails.getB()).isEqualTo(DEFAULT_B);
        assertThat(testKalkulationDetails.getC()).isEqualTo(DEFAULT_C);
        assertThat(testKalkulationDetails.getD()).isEqualTo(DEFAULT_D);
        assertThat(testKalkulationDetails.getE()).isEqualTo(DEFAULT_E);
        assertThat(testKalkulationDetails.getF()).isEqualTo(DEFAULT_F);
        assertThat(testKalkulationDetails.getG()).isEqualTo(DEFAULT_G);
        assertThat(testKalkulationDetails.getH()).isEqualTo(DEFAULT_H);
        assertThat(testKalkulationDetails.getI()).isEqualTo(DEFAULT_I);
        assertThat(testKalkulationDetails.getJ()).isEqualTo(DEFAULT_J);
        assertThat(testKalkulationDetails.getK()).isEqualTo(DEFAULT_K);
        assertThat(testKalkulationDetails.getL()).isEqualTo(DEFAULT_L);
        assertThat(testKalkulationDetails.getM()).isEqualTo(DEFAULT_M);
        assertThat(testKalkulationDetails.getN()).isEqualTo(DEFAULT_N);
        assertThat(testKalkulationDetails.getO()).isEqualTo(DEFAULT_O);
        assertThat(testKalkulationDetails.getP()).isEqualTo(DEFAULT_P);
        assertThat(testKalkulationDetails.getQ()).isEqualTo(DEFAULT_Q);
        assertThat(testKalkulationDetails.getR()).isEqualTo(DEFAULT_R);
        assertThat(testKalkulationDetails.getS()).isEqualTo(DEFAULT_S);
        assertThat(testKalkulationDetails.getT()).isEqualTo(DEFAULT_T);
        assertThat(testKalkulationDetails.getU()).isEqualTo(DEFAULT_U);
        assertThat(testKalkulationDetails.getV()).isEqualTo(DEFAULT_V);
        assertThat(testKalkulationDetails.getW()).isEqualTo(DEFAULT_W);
        assertThat(testKalkulationDetails.getX()).isEqualTo(DEFAULT_X);
        assertThat(testKalkulationDetails.getY()).isEqualTo(DEFAULT_Y);
        assertThat(testKalkulationDetails.getZ()).isEqualTo(DEFAULT_Z);
        assertThat(testKalkulationDetails.getAa()).isEqualTo(DEFAULT_AA);
        assertThat(testKalkulationDetails.getAb()).isEqualTo(DEFAULT_AB);
        assertThat(testKalkulationDetails.getAc()).isEqualTo(DEFAULT_AC);
        assertThat(testKalkulationDetails.getAd()).isEqualTo(DEFAULT_AD);
        assertThat(testKalkulationDetails.getAe()).isEqualTo(DEFAULT_AE);
        assertThat(testKalkulationDetails.getAf()).isEqualTo(DEFAULT_AF);
        assertThat(testKalkulationDetails.getAg()).isEqualTo(DEFAULT_AG);
    }

    @Test
    @Transactional
    public void createKalkulationDetailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = kalkulationDetailsRepository.findAll().size();

        // Create the KalkulationDetails with an existing ID
        kalkulationDetails.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restKalkulationDetailsMockMvc.perform(post("/api/kalkulation-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kalkulationDetails)))
            .andExpect(status().isBadRequest());

        // Validate the KalkulationDetails in the database
        List<KalkulationDetails> kalkulationDetailsList = kalkulationDetailsRepository.findAll();
        assertThat(kalkulationDetailsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllKalkulationDetails() throws Exception {
        // Initialize the database
        kalkulationDetailsRepository.saveAndFlush(kalkulationDetails);

        // Get all the kalkulationDetailsList
        restKalkulationDetailsMockMvc.perform(get("/api/kalkulation-details?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(kalkulationDetails.getId().intValue())))
            .andExpect(jsonPath("$.[*].a").value(hasItem(DEFAULT_A)))
            .andExpect(jsonPath("$.[*].b").value(hasItem(DEFAULT_B)))
            .andExpect(jsonPath("$.[*].c").value(hasItem(DEFAULT_C)))
            .andExpect(jsonPath("$.[*].d").value(hasItem(DEFAULT_D)))
            .andExpect(jsonPath("$.[*].e").value(hasItem(DEFAULT_E)))
            .andExpect(jsonPath("$.[*].f").value(hasItem(DEFAULT_F)))
            .andExpect(jsonPath("$.[*].g").value(hasItem(DEFAULT_G)))
            .andExpect(jsonPath("$.[*].h").value(hasItem(DEFAULT_H)))
            .andExpect(jsonPath("$.[*].i").value(hasItem(DEFAULT_I)))
            .andExpect(jsonPath("$.[*].j").value(hasItem(DEFAULT_J)))
            .andExpect(jsonPath("$.[*].k").value(hasItem(DEFAULT_K)))
            .andExpect(jsonPath("$.[*].l").value(hasItem(DEFAULT_L)))
            .andExpect(jsonPath("$.[*].m").value(hasItem(DEFAULT_M)))
            .andExpect(jsonPath("$.[*].n").value(hasItem(DEFAULT_N)))
            .andExpect(jsonPath("$.[*].o").value(hasItem(DEFAULT_O)))
            .andExpect(jsonPath("$.[*].p").value(hasItem(DEFAULT_P)))
            .andExpect(jsonPath("$.[*].q").value(hasItem(DEFAULT_Q)))
            .andExpect(jsonPath("$.[*].r").value(hasItem(DEFAULT_R)))
            .andExpect(jsonPath("$.[*].s").value(hasItem(DEFAULT_S)))
            .andExpect(jsonPath("$.[*].t").value(hasItem(DEFAULT_T)))
            .andExpect(jsonPath("$.[*].u").value(hasItem(DEFAULT_U)))
            .andExpect(jsonPath("$.[*].v").value(hasItem(DEFAULT_V)))
            .andExpect(jsonPath("$.[*].w").value(hasItem(DEFAULT_W)))
            .andExpect(jsonPath("$.[*].x").value(hasItem(DEFAULT_X)))
            .andExpect(jsonPath("$.[*].y").value(hasItem(DEFAULT_Y)))
            .andExpect(jsonPath("$.[*].z").value(hasItem(DEFAULT_Z)))
            .andExpect(jsonPath("$.[*].aa").value(hasItem(DEFAULT_AA)))
            .andExpect(jsonPath("$.[*].ab").value(hasItem(DEFAULT_AB)))
            .andExpect(jsonPath("$.[*].ac").value(hasItem(DEFAULT_AC)))
            .andExpect(jsonPath("$.[*].ad").value(hasItem(DEFAULT_AD)))
            .andExpect(jsonPath("$.[*].ae").value(hasItem(DEFAULT_AE)))
            .andExpect(jsonPath("$.[*].af").value(hasItem(DEFAULT_AF)))
            .andExpect(jsonPath("$.[*].ag").value(hasItem(DEFAULT_AG)));
    }
    
    @Test
    @Transactional
    public void getKalkulationDetails() throws Exception {
        // Initialize the database
        kalkulationDetailsRepository.saveAndFlush(kalkulationDetails);

        // Get the kalkulationDetails
        restKalkulationDetailsMockMvc.perform(get("/api/kalkulation-details/{id}", kalkulationDetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(kalkulationDetails.getId().intValue()))
            .andExpect(jsonPath("$.a").value(DEFAULT_A))
            .andExpect(jsonPath("$.b").value(DEFAULT_B))
            .andExpect(jsonPath("$.c").value(DEFAULT_C))
            .andExpect(jsonPath("$.d").value(DEFAULT_D))
            .andExpect(jsonPath("$.e").value(DEFAULT_E))
            .andExpect(jsonPath("$.f").value(DEFAULT_F))
            .andExpect(jsonPath("$.g").value(DEFAULT_G))
            .andExpect(jsonPath("$.h").value(DEFAULT_H))
            .andExpect(jsonPath("$.i").value(DEFAULT_I))
            .andExpect(jsonPath("$.j").value(DEFAULT_J))
            .andExpect(jsonPath("$.k").value(DEFAULT_K))
            .andExpect(jsonPath("$.l").value(DEFAULT_L))
            .andExpect(jsonPath("$.m").value(DEFAULT_M))
            .andExpect(jsonPath("$.n").value(DEFAULT_N))
            .andExpect(jsonPath("$.o").value(DEFAULT_O))
            .andExpect(jsonPath("$.p").value(DEFAULT_P))
            .andExpect(jsonPath("$.q").value(DEFAULT_Q))
            .andExpect(jsonPath("$.r").value(DEFAULT_R))
            .andExpect(jsonPath("$.s").value(DEFAULT_S))
            .andExpect(jsonPath("$.t").value(DEFAULT_T))
            .andExpect(jsonPath("$.u").value(DEFAULT_U))
            .andExpect(jsonPath("$.v").value(DEFAULT_V))
            .andExpect(jsonPath("$.w").value(DEFAULT_W))
            .andExpect(jsonPath("$.x").value(DEFAULT_X))
            .andExpect(jsonPath("$.y").value(DEFAULT_Y))
            .andExpect(jsonPath("$.z").value(DEFAULT_Z))
            .andExpect(jsonPath("$.aa").value(DEFAULT_AA))
            .andExpect(jsonPath("$.ab").value(DEFAULT_AB))
            .andExpect(jsonPath("$.ac").value(DEFAULT_AC))
            .andExpect(jsonPath("$.ad").value(DEFAULT_AD))
            .andExpect(jsonPath("$.ae").value(DEFAULT_AE))
            .andExpect(jsonPath("$.af").value(DEFAULT_AF))
            .andExpect(jsonPath("$.ag").value(DEFAULT_AG));
    }

    @Test
    @Transactional
    public void getNonExistingKalkulationDetails() throws Exception {
        // Get the kalkulationDetails
        restKalkulationDetailsMockMvc.perform(get("/api/kalkulation-details/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateKalkulationDetails() throws Exception {
        // Initialize the database
        kalkulationDetailsService.save(kalkulationDetails);

        int databaseSizeBeforeUpdate = kalkulationDetailsRepository.findAll().size();

        // Update the kalkulationDetails
        KalkulationDetails updatedKalkulationDetails = kalkulationDetailsRepository.findById(kalkulationDetails.getId()).get();
        // Disconnect from session so that the updates on updatedKalkulationDetails are not directly saved in db
        em.detach(updatedKalkulationDetails);
        updatedKalkulationDetails
            .a(UPDATED_A)
            .b(UPDATED_B)
            .c(UPDATED_C)
            .d(UPDATED_D)
            .e(UPDATED_E)
            .f(UPDATED_F)
            .g(UPDATED_G)
            .h(UPDATED_H)
            .i(UPDATED_I)
            .j(UPDATED_J)
            .k(UPDATED_K)
            .l(UPDATED_L)
            .m(UPDATED_M)
            .n(UPDATED_N)
            .o(UPDATED_O)
            .p(UPDATED_P)
            .q(UPDATED_Q)
            .r(UPDATED_R)
            .s(UPDATED_S)
            .t(UPDATED_T)
            .u(UPDATED_U)
            .v(UPDATED_V)
            .w(UPDATED_W)
            .x(UPDATED_X)
            .y(UPDATED_Y)
            .z(UPDATED_Z)
            .aa(UPDATED_AA)
            .ab(UPDATED_AB)
            .ac(UPDATED_AC)
            .ad(UPDATED_AD)
            .ae(UPDATED_AE)
            .af(UPDATED_AF)
            .ag(UPDATED_AG);

        restKalkulationDetailsMockMvc.perform(put("/api/kalkulation-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedKalkulationDetails)))
            .andExpect(status().isOk());

        // Validate the KalkulationDetails in the database
        List<KalkulationDetails> kalkulationDetailsList = kalkulationDetailsRepository.findAll();
        assertThat(kalkulationDetailsList).hasSize(databaseSizeBeforeUpdate);
        KalkulationDetails testKalkulationDetails = kalkulationDetailsList.get(kalkulationDetailsList.size() - 1);
        assertThat(testKalkulationDetails.getA()).isEqualTo(UPDATED_A);
        assertThat(testKalkulationDetails.getB()).isEqualTo(UPDATED_B);
        assertThat(testKalkulationDetails.getC()).isEqualTo(UPDATED_C);
        assertThat(testKalkulationDetails.getD()).isEqualTo(UPDATED_D);
        assertThat(testKalkulationDetails.getE()).isEqualTo(UPDATED_E);
        assertThat(testKalkulationDetails.getF()).isEqualTo(UPDATED_F);
        assertThat(testKalkulationDetails.getG()).isEqualTo(UPDATED_G);
        assertThat(testKalkulationDetails.getH()).isEqualTo(UPDATED_H);
        assertThat(testKalkulationDetails.getI()).isEqualTo(UPDATED_I);
        assertThat(testKalkulationDetails.getJ()).isEqualTo(UPDATED_J);
        assertThat(testKalkulationDetails.getK()).isEqualTo(UPDATED_K);
        assertThat(testKalkulationDetails.getL()).isEqualTo(UPDATED_L);
        assertThat(testKalkulationDetails.getM()).isEqualTo(UPDATED_M);
        assertThat(testKalkulationDetails.getN()).isEqualTo(UPDATED_N);
        assertThat(testKalkulationDetails.getO()).isEqualTo(UPDATED_O);
        assertThat(testKalkulationDetails.getP()).isEqualTo(UPDATED_P);
        assertThat(testKalkulationDetails.getQ()).isEqualTo(UPDATED_Q);
        assertThat(testKalkulationDetails.getR()).isEqualTo(UPDATED_R);
        assertThat(testKalkulationDetails.getS()).isEqualTo(UPDATED_S);
        assertThat(testKalkulationDetails.getT()).isEqualTo(UPDATED_T);
        assertThat(testKalkulationDetails.getU()).isEqualTo(UPDATED_U);
        assertThat(testKalkulationDetails.getV()).isEqualTo(UPDATED_V);
        assertThat(testKalkulationDetails.getW()).isEqualTo(UPDATED_W);
        assertThat(testKalkulationDetails.getX()).isEqualTo(UPDATED_X);
        assertThat(testKalkulationDetails.getY()).isEqualTo(UPDATED_Y);
        assertThat(testKalkulationDetails.getZ()).isEqualTo(UPDATED_Z);
        assertThat(testKalkulationDetails.getAa()).isEqualTo(UPDATED_AA);
        assertThat(testKalkulationDetails.getAb()).isEqualTo(UPDATED_AB);
        assertThat(testKalkulationDetails.getAc()).isEqualTo(UPDATED_AC);
        assertThat(testKalkulationDetails.getAd()).isEqualTo(UPDATED_AD);
        assertThat(testKalkulationDetails.getAe()).isEqualTo(UPDATED_AE);
        assertThat(testKalkulationDetails.getAf()).isEqualTo(UPDATED_AF);
        assertThat(testKalkulationDetails.getAg()).isEqualTo(UPDATED_AG);
    }

    @Test
    @Transactional
    public void updateNonExistingKalkulationDetails() throws Exception {
        int databaseSizeBeforeUpdate = kalkulationDetailsRepository.findAll().size();

        // Create the KalkulationDetails

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restKalkulationDetailsMockMvc.perform(put("/api/kalkulation-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kalkulationDetails)))
            .andExpect(status().isBadRequest());

        // Validate the KalkulationDetails in the database
        List<KalkulationDetails> kalkulationDetailsList = kalkulationDetailsRepository.findAll();
        assertThat(kalkulationDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteKalkulationDetails() throws Exception {
        // Initialize the database
        kalkulationDetailsService.save(kalkulationDetails);

        int databaseSizeBeforeDelete = kalkulationDetailsRepository.findAll().size();

        // Delete the kalkulationDetails
        restKalkulationDetailsMockMvc.perform(delete("/api/kalkulation-details/{id}", kalkulationDetails.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<KalkulationDetails> kalkulationDetailsList = kalkulationDetailsRepository.findAll();
        assertThat(kalkulationDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

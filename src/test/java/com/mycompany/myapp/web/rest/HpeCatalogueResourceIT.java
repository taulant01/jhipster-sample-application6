package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleApplication55App;
import com.mycompany.myapp.domain.HpeCatalogue;
import com.mycompany.myapp.repository.HpeCatalogueRepository;
import com.mycompany.myapp.service.HpeCatalogueService;
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
 * Integration tests for the {@link HpeCatalogueResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplication55App.class)
public class HpeCatalogueResourceIT {

    private static final String DEFAULT_PRODUKT_NUMMER = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_NUMMER = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKT_BESCHREIBUNG = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_BESCHREIBUNG = "BBBBBBBBBB";

    private static final String DEFAULT_KURZE_PRODUKT_BESCHREIBUNG = "AAAAAAAAAA";
    private static final String UPDATED_KURZE_PRODUKT_BESCHREIBUNG = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PL_BESCHREIBUNG = "AAAAAAAAAA";
    private static final String UPDATED_PL_BESCHREIBUNG = "BBBBBBBBBB";

    private static final String DEFAULT_PL = "AAAAAAAAAA";
    private static final String UPDATED_PL = "BBBBBBBBBB";

    private static final String DEFAULT_LAND = "AAAAAAAAAA";
    private static final String UPDATED_LAND = "BBBBBBBBBB";

    private static final String DEFAULT_WAHRUNG = "AAAAAAAAAA";
    private static final String UPDATED_WAHRUNG = "BBBBBBBBBB";

    private static final String DEFAULT_INCOTERM = "AAAAAAAAAA";
    private static final String UPDATED_INCOTERM = "BBBBBBBBBB";

    private static final String DEFAULT_PREIS_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PREIS_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_DATUM_PREISANDERUNG = "AAAAAAAAAA";
    private static final String UPDATED_DATUM_PREISANDERUNG = "BBBBBBBBBB";

    private static final String DEFAULT_AKTUELLER_LISTEN_PREIS = "AAAAAAAAAA";
    private static final String UPDATED_AKTUELLER_LISTEN_PREIS = "BBBBBBBBBB";

    private static final String DEFAULT_AKTUELLER_LISTENPREIS_GULTIG = "AAAAAAAAAA";
    private static final String UPDATED_AKTUELLER_LISTENPREIS_GULTIG = "BBBBBBBBBB";

    private static final String DEFAULT_VORHERIGER_LISTENPREIS = "AAAAAAAAAA";
    private static final String UPDATED_VORHERIGER_LISTENPREIS = "BBBBBBBBBB";

    private static final String DEFAULT_NETTO_PREIS = "AAAAAAAAAA";
    private static final String UPDATED_NETTO_PREIS = "BBBBBBBBBB";

    private static final String DEFAULT_GULTIGKEITS_DATUM_NETTOPREIS = "AAAAAAAAAA";
    private static final String UPDATED_GULTIGKEITS_DATUM_NETTOPREIS = "BBBBBBBBBB";

    private static final String DEFAULT_VORHERIGER_NETTO_PREIS = "AAAAAAAAAA";
    private static final String UPDATED_VORHERIGER_NETTO_PREIS = "BBBBBBBBBB";

    private static final String DEFAULT_PA_NACHLASS = "AAAAAAAAAA";
    private static final String UPDATED_PA_NACHLASS = "BBBBBBBBBB";

    private static final String DEFAULT_EXHIBIT = "AAAAAAAAAA";
    private static final String UPDATED_EXHIBIT = "BBBBBBBBBB";

    private static final String DEFAULT_UOM = "AAAAAAAAAA";
    private static final String UPDATED_UOM = "BBBBBBBBBB";

    private static final String DEFAULT_PREISSTAFFEL_VON = "AAAAAAAAAA";
    private static final String UPDATED_PREISSTAFFEL_VON = "BBBBBBBBBB";

    private static final String DEFAULT_PREISSTAFFEL_BIS = "AAAAAAAAAA";
    private static final String UPDATED_PREISSTAFFEL_BIS = "BBBBBBBBBB";

    private static final String DEFAULT_EOQ = "AAAAAAAAAA";
    private static final String UPDATED_EOQ = "BBBBBBBBBB";

    private static final String DEFAULT_PLC_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PLC_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PLC_GULTIGKEITSDATUM = "AAAAAAAAAA";
    private static final String UPDATED_PLC_GULTIGKEITSDATUM = "BBBBBBBBBB";

    private static final String DEFAULT_ERSATZ_PRODUKT = "AAAAAAAAAA";
    private static final String UPDATED_ERSATZ_PRODUKT = "BBBBBBBBBB";

    private static final String DEFAULT_MARKETING_PROGRAMM = "AAAAAAAAAA";
    private static final String UPDATED_MARKETING_PROGRAMM = "BBBBBBBBBB";

    private static final String DEFAULT_GEWAHRLEISTUNG = "AAAAAAAAAA";
    private static final String UPDATED_GEWAHRLEISTUNG = "BBBBBBBBBB";

    private static final String DEFAULT_CLASS_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_CLASS_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_CLASS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CLASS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKT_FAMILIEN_BESCHREIBUNG = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_FAMILIEN_BESCHREIBUNG = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKT_FAMILIE = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_FAMILIE = "BBBBBBBBBB";

    private static final String DEFAULT_SERIEN_BESCHREIBUNG = "AAAAAAAAAA";
    private static final String UPDATED_SERIEN_BESCHREIBUNG = "BBBBBBBBBB";

    private static final String DEFAULT_SERIES_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SERIES_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MODELL_BESCHREIBUNG = "AAAAAAAAAA";
    private static final String UPDATED_MODELL_BESCHREIBUNG = "BBBBBBBBBB";

    private static final String DEFAULT_MODELL = "AAAAAAAAAA";
    private static final String UPDATED_MODELL = "BBBBBBBBBB";

    private static final String DEFAULT_STANDARD_LIEFERZEIT_DISTRIBUTOREN = "AAAAAAAAAA";
    private static final String UPDATED_STANDARD_LIEFERZEIT_DISTRIBUTOREN = "BBBBBBBBBB";

    private static final String DEFAULT_VOLUMEN = "AAAAAAAAAA";
    private static final String UPDATED_VOLUMEN = "BBBBBBBBBB";

    private static final String DEFAULT_VOLUMEN_EINHEIT = "AAAAAAAAAA";
    private static final String UPDATED_VOLUMEN_EINHEIT = "BBBBBBBBBB";

    private static final String DEFAULT_BRUTTOGEWICHT_PRODUKTS = "AAAAAAAAAA";
    private static final String UPDATED_BRUTTOGEWICHT_PRODUKTS = "BBBBBBBBBB";

    private static final String DEFAULT_GEWICHTSEINHEIT = "AAAAAAAAAA";
    private static final String UPDATED_GEWICHTSEINHEIT = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKTABMESSUNGEN = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKTABMESSUNGEN = "BBBBBBBBBB";

    private static final String DEFAULT_MA_SEINHEIT = "AAAAAAAAAA";
    private static final String UPDATED_MA_SEINHEIT = "BBBBBBBBBB";

    private static final String DEFAULT_EAN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_EAN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SERIALISIERUNGS_KENNUNG = "AAAAAAAAAA";
    private static final String UPDATED_SERIALISIERUNGS_KENNUNG = "BBBBBBBBBB";

    private static final String DEFAULT_PA_NUMMER = "AAAAAAAAAA";
    private static final String UPDATED_PA_NUMMER = "BBBBBBBBBB";

    private static final String DEFAULT_PARTNER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PARTNER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PARTNER_PRO = "AAAAAAAAAA";
    private static final String UPDATED_PARTNER_PRO = "BBBBBBBBBB";

    private static final String DEFAULT_DATUMS_UHRZEITSTEMPEL = "AAAAAAAAAA";
    private static final String UPDATED_DATUMS_UHRZEITSTEMPEL = "BBBBBBBBBB";

    @Autowired
    private HpeCatalogueRepository hpeCatalogueRepository;

    @Autowired
    private HpeCatalogueService hpeCatalogueService;

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

    private MockMvc restHpeCatalogueMockMvc;

    private HpeCatalogue hpeCatalogue;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final HpeCatalogueResource hpeCatalogueResource = new HpeCatalogueResource(hpeCatalogueService);
        this.restHpeCatalogueMockMvc = MockMvcBuilders.standaloneSetup(hpeCatalogueResource)
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
    public static HpeCatalogue createEntity(EntityManager em) {
        HpeCatalogue hpeCatalogue = new HpeCatalogue()
            .produktNummer(DEFAULT_PRODUKT_NUMMER)
            .produktBeschreibung(DEFAULT_PRODUKT_BESCHREIBUNG)
            .kurzeProduktBeschreibung(DEFAULT_KURZE_PRODUKT_BESCHREIBUNG)
            .produktName(DEFAULT_PRODUKT_NAME)
            .plBeschreibung(DEFAULT_PL_BESCHREIBUNG)
            .pl(DEFAULT_PL)
            .land(DEFAULT_LAND)
            .wahrung(DEFAULT_WAHRUNG)
            .incoterm(DEFAULT_INCOTERM)
            .preisStatus(DEFAULT_PREIS_STATUS)
            .datumPreisanderung(DEFAULT_DATUM_PREISANDERUNG)
            .aktuellerListenPreis(DEFAULT_AKTUELLER_LISTEN_PREIS)
            .aktuellerListenpreisGultig(DEFAULT_AKTUELLER_LISTENPREIS_GULTIG)
            .vorherigerListenpreis(DEFAULT_VORHERIGER_LISTENPREIS)
            .nettoPreis(DEFAULT_NETTO_PREIS)
            .gultigkeitsDatumNettopreis(DEFAULT_GULTIGKEITS_DATUM_NETTOPREIS)
            .vorherigerNettoPreis(DEFAULT_VORHERIGER_NETTO_PREIS)
            .paNachlass(DEFAULT_PA_NACHLASS)
            .exhibit(DEFAULT_EXHIBIT)
            .uom(DEFAULT_UOM)
            .preisstaffelVon(DEFAULT_PREISSTAFFEL_VON)
            .preisstaffelBis(DEFAULT_PREISSTAFFEL_BIS)
            .eoq(DEFAULT_EOQ)
            .plcStatus(DEFAULT_PLC_STATUS)
            .plcGultigkeitsdatum(DEFAULT_PLC_GULTIGKEITSDATUM)
            .ersatzProdukt(DEFAULT_ERSATZ_PRODUKT)
            .marketingProgramm(DEFAULT_MARKETING_PROGRAMM)
            .gewahrleistung(DEFAULT_GEWAHRLEISTUNG)
            .classDescription(DEFAULT_CLASS_DESCRIPTION)
            .classCode(DEFAULT_CLASS_CODE)
            .produktFamilienBeschreibung(DEFAULT_PRODUKT_FAMILIEN_BESCHREIBUNG)
            .produktFamilie(DEFAULT_PRODUKT_FAMILIE)
            .serienBeschreibung(DEFAULT_SERIEN_BESCHREIBUNG)
            .seriesCode(DEFAULT_SERIES_CODE)
            .modellBeschreibung(DEFAULT_MODELL_BESCHREIBUNG)
            .modell(DEFAULT_MODELL)
            .standardLieferzeitDistributoren(DEFAULT_STANDARD_LIEFERZEIT_DISTRIBUTOREN)
            .volumen(DEFAULT_VOLUMEN)
            .volumenEinheit(DEFAULT_VOLUMEN_EINHEIT)
            .bruttogewichtProdukts(DEFAULT_BRUTTOGEWICHT_PRODUKTS)
            .gewichtseinheit(DEFAULT_GEWICHTSEINHEIT)
            .produktabmessungen(DEFAULT_PRODUKTABMESSUNGEN)
            .maSeinheit(DEFAULT_MA_SEINHEIT)
            .eanCode(DEFAULT_EAN_CODE)
            .serialisierungsKennung(DEFAULT_SERIALISIERUNGS_KENNUNG)
            .paNummer(DEFAULT_PA_NUMMER)
            .partnerName(DEFAULT_PARTNER_NAME)
            .partnerPro(DEFAULT_PARTNER_PRO)
            .datumsUhrzeitstempel(DEFAULT_DATUMS_UHRZEITSTEMPEL);
        return hpeCatalogue;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static HpeCatalogue createUpdatedEntity(EntityManager em) {
        HpeCatalogue hpeCatalogue = new HpeCatalogue()
            .produktNummer(UPDATED_PRODUKT_NUMMER)
            .produktBeschreibung(UPDATED_PRODUKT_BESCHREIBUNG)
            .kurzeProduktBeschreibung(UPDATED_KURZE_PRODUKT_BESCHREIBUNG)
            .produktName(UPDATED_PRODUKT_NAME)
            .plBeschreibung(UPDATED_PL_BESCHREIBUNG)
            .pl(UPDATED_PL)
            .land(UPDATED_LAND)
            .wahrung(UPDATED_WAHRUNG)
            .incoterm(UPDATED_INCOTERM)
            .preisStatus(UPDATED_PREIS_STATUS)
            .datumPreisanderung(UPDATED_DATUM_PREISANDERUNG)
            .aktuellerListenPreis(UPDATED_AKTUELLER_LISTEN_PREIS)
            .aktuellerListenpreisGultig(UPDATED_AKTUELLER_LISTENPREIS_GULTIG)
            .vorherigerListenpreis(UPDATED_VORHERIGER_LISTENPREIS)
            .nettoPreis(UPDATED_NETTO_PREIS)
            .gultigkeitsDatumNettopreis(UPDATED_GULTIGKEITS_DATUM_NETTOPREIS)
            .vorherigerNettoPreis(UPDATED_VORHERIGER_NETTO_PREIS)
            .paNachlass(UPDATED_PA_NACHLASS)
            .exhibit(UPDATED_EXHIBIT)
            .uom(UPDATED_UOM)
            .preisstaffelVon(UPDATED_PREISSTAFFEL_VON)
            .preisstaffelBis(UPDATED_PREISSTAFFEL_BIS)
            .eoq(UPDATED_EOQ)
            .plcStatus(UPDATED_PLC_STATUS)
            .plcGultigkeitsdatum(UPDATED_PLC_GULTIGKEITSDATUM)
            .ersatzProdukt(UPDATED_ERSATZ_PRODUKT)
            .marketingProgramm(UPDATED_MARKETING_PROGRAMM)
            .gewahrleistung(UPDATED_GEWAHRLEISTUNG)
            .classDescription(UPDATED_CLASS_DESCRIPTION)
            .classCode(UPDATED_CLASS_CODE)
            .produktFamilienBeschreibung(UPDATED_PRODUKT_FAMILIEN_BESCHREIBUNG)
            .produktFamilie(UPDATED_PRODUKT_FAMILIE)
            .serienBeschreibung(UPDATED_SERIEN_BESCHREIBUNG)
            .seriesCode(UPDATED_SERIES_CODE)
            .modellBeschreibung(UPDATED_MODELL_BESCHREIBUNG)
            .modell(UPDATED_MODELL)
            .standardLieferzeitDistributoren(UPDATED_STANDARD_LIEFERZEIT_DISTRIBUTOREN)
            .volumen(UPDATED_VOLUMEN)
            .volumenEinheit(UPDATED_VOLUMEN_EINHEIT)
            .bruttogewichtProdukts(UPDATED_BRUTTOGEWICHT_PRODUKTS)
            .gewichtseinheit(UPDATED_GEWICHTSEINHEIT)
            .produktabmessungen(UPDATED_PRODUKTABMESSUNGEN)
            .maSeinheit(UPDATED_MA_SEINHEIT)
            .eanCode(UPDATED_EAN_CODE)
            .serialisierungsKennung(UPDATED_SERIALISIERUNGS_KENNUNG)
            .paNummer(UPDATED_PA_NUMMER)
            .partnerName(UPDATED_PARTNER_NAME)
            .partnerPro(UPDATED_PARTNER_PRO)
            .datumsUhrzeitstempel(UPDATED_DATUMS_UHRZEITSTEMPEL);
        return hpeCatalogue;
    }

    @BeforeEach
    public void initTest() {
        hpeCatalogue = createEntity(em);
    }

    @Test
    @Transactional
    public void createHpeCatalogue() throws Exception {
        int databaseSizeBeforeCreate = hpeCatalogueRepository.findAll().size();

        // Create the HpeCatalogue
        restHpeCatalogueMockMvc.perform(post("/api/hpe-catalogues")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(hpeCatalogue)))
            .andExpect(status().isCreated());

        // Validate the HpeCatalogue in the database
        List<HpeCatalogue> hpeCatalogueList = hpeCatalogueRepository.findAll();
        assertThat(hpeCatalogueList).hasSize(databaseSizeBeforeCreate + 1);
        HpeCatalogue testHpeCatalogue = hpeCatalogueList.get(hpeCatalogueList.size() - 1);
        assertThat(testHpeCatalogue.getProduktNummer()).isEqualTo(DEFAULT_PRODUKT_NUMMER);
        assertThat(testHpeCatalogue.getProduktBeschreibung()).isEqualTo(DEFAULT_PRODUKT_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getKurzeProduktBeschreibung()).isEqualTo(DEFAULT_KURZE_PRODUKT_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getProduktName()).isEqualTo(DEFAULT_PRODUKT_NAME);
        assertThat(testHpeCatalogue.getPlBeschreibung()).isEqualTo(DEFAULT_PL_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getPl()).isEqualTo(DEFAULT_PL);
        assertThat(testHpeCatalogue.getLand()).isEqualTo(DEFAULT_LAND);
        assertThat(testHpeCatalogue.getWahrung()).isEqualTo(DEFAULT_WAHRUNG);
        assertThat(testHpeCatalogue.getIncoterm()).isEqualTo(DEFAULT_INCOTERM);
        assertThat(testHpeCatalogue.getPreisStatus()).isEqualTo(DEFAULT_PREIS_STATUS);
        assertThat(testHpeCatalogue.getDatumPreisanderung()).isEqualTo(DEFAULT_DATUM_PREISANDERUNG);
        assertThat(testHpeCatalogue.getAktuellerListenPreis()).isEqualTo(DEFAULT_AKTUELLER_LISTEN_PREIS);
        assertThat(testHpeCatalogue.getAktuellerListenpreisGultig()).isEqualTo(DEFAULT_AKTUELLER_LISTENPREIS_GULTIG);
        assertThat(testHpeCatalogue.getVorherigerListenpreis()).isEqualTo(DEFAULT_VORHERIGER_LISTENPREIS);
        assertThat(testHpeCatalogue.getNettoPreis()).isEqualTo(DEFAULT_NETTO_PREIS);
        assertThat(testHpeCatalogue.getGultigkeitsDatumNettopreis()).isEqualTo(DEFAULT_GULTIGKEITS_DATUM_NETTOPREIS);
        assertThat(testHpeCatalogue.getVorherigerNettoPreis()).isEqualTo(DEFAULT_VORHERIGER_NETTO_PREIS);
        assertThat(testHpeCatalogue.getPaNachlass()).isEqualTo(DEFAULT_PA_NACHLASS);
        assertThat(testHpeCatalogue.getExhibit()).isEqualTo(DEFAULT_EXHIBIT);
        assertThat(testHpeCatalogue.getUom()).isEqualTo(DEFAULT_UOM);
        assertThat(testHpeCatalogue.getPreisstaffelVon()).isEqualTo(DEFAULT_PREISSTAFFEL_VON);
        assertThat(testHpeCatalogue.getPreisstaffelBis()).isEqualTo(DEFAULT_PREISSTAFFEL_BIS);
        assertThat(testHpeCatalogue.getEoq()).isEqualTo(DEFAULT_EOQ);
        assertThat(testHpeCatalogue.getPlcStatus()).isEqualTo(DEFAULT_PLC_STATUS);
        assertThat(testHpeCatalogue.getPlcGultigkeitsdatum()).isEqualTo(DEFAULT_PLC_GULTIGKEITSDATUM);
        assertThat(testHpeCatalogue.getErsatzProdukt()).isEqualTo(DEFAULT_ERSATZ_PRODUKT);
        assertThat(testHpeCatalogue.getMarketingProgramm()).isEqualTo(DEFAULT_MARKETING_PROGRAMM);
        assertThat(testHpeCatalogue.getGewahrleistung()).isEqualTo(DEFAULT_GEWAHRLEISTUNG);
        assertThat(testHpeCatalogue.getClassDescription()).isEqualTo(DEFAULT_CLASS_DESCRIPTION);
        assertThat(testHpeCatalogue.getClassCode()).isEqualTo(DEFAULT_CLASS_CODE);
        assertThat(testHpeCatalogue.getProduktFamilienBeschreibung()).isEqualTo(DEFAULT_PRODUKT_FAMILIEN_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getProduktFamilie()).isEqualTo(DEFAULT_PRODUKT_FAMILIE);
        assertThat(testHpeCatalogue.getSerienBeschreibung()).isEqualTo(DEFAULT_SERIEN_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getSeriesCode()).isEqualTo(DEFAULT_SERIES_CODE);
        assertThat(testHpeCatalogue.getModellBeschreibung()).isEqualTo(DEFAULT_MODELL_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getModell()).isEqualTo(DEFAULT_MODELL);
        assertThat(testHpeCatalogue.getStandardLieferzeitDistributoren()).isEqualTo(DEFAULT_STANDARD_LIEFERZEIT_DISTRIBUTOREN);
        assertThat(testHpeCatalogue.getVolumen()).isEqualTo(DEFAULT_VOLUMEN);
        assertThat(testHpeCatalogue.getVolumenEinheit()).isEqualTo(DEFAULT_VOLUMEN_EINHEIT);
        assertThat(testHpeCatalogue.getBruttogewichtProdukts()).isEqualTo(DEFAULT_BRUTTOGEWICHT_PRODUKTS);
        assertThat(testHpeCatalogue.getGewichtseinheit()).isEqualTo(DEFAULT_GEWICHTSEINHEIT);
        assertThat(testHpeCatalogue.getProduktabmessungen()).isEqualTo(DEFAULT_PRODUKTABMESSUNGEN);
        assertThat(testHpeCatalogue.getMaSeinheit()).isEqualTo(DEFAULT_MA_SEINHEIT);
        assertThat(testHpeCatalogue.getEanCode()).isEqualTo(DEFAULT_EAN_CODE);
        assertThat(testHpeCatalogue.getSerialisierungsKennung()).isEqualTo(DEFAULT_SERIALISIERUNGS_KENNUNG);
        assertThat(testHpeCatalogue.getPaNummer()).isEqualTo(DEFAULT_PA_NUMMER);
        assertThat(testHpeCatalogue.getPartnerName()).isEqualTo(DEFAULT_PARTNER_NAME);
        assertThat(testHpeCatalogue.getPartnerPro()).isEqualTo(DEFAULT_PARTNER_PRO);
        assertThat(testHpeCatalogue.getDatumsUhrzeitstempel()).isEqualTo(DEFAULT_DATUMS_UHRZEITSTEMPEL);
    }

    @Test
    @Transactional
    public void createHpeCatalogueWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = hpeCatalogueRepository.findAll().size();

        // Create the HpeCatalogue with an existing ID
        hpeCatalogue.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restHpeCatalogueMockMvc.perform(post("/api/hpe-catalogues")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(hpeCatalogue)))
            .andExpect(status().isBadRequest());

        // Validate the HpeCatalogue in the database
        List<HpeCatalogue> hpeCatalogueList = hpeCatalogueRepository.findAll();
        assertThat(hpeCatalogueList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllHpeCatalogues() throws Exception {
        // Initialize the database
        hpeCatalogueRepository.saveAndFlush(hpeCatalogue);

        // Get all the hpeCatalogueList
        restHpeCatalogueMockMvc.perform(get("/api/hpe-catalogues?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(hpeCatalogue.getId().intValue())))
            .andExpect(jsonPath("$.[*].produktNummer").value(hasItem(DEFAULT_PRODUKT_NUMMER)))
            .andExpect(jsonPath("$.[*].produktBeschreibung").value(hasItem(DEFAULT_PRODUKT_BESCHREIBUNG)))
            .andExpect(jsonPath("$.[*].kurzeProduktBeschreibung").value(hasItem(DEFAULT_KURZE_PRODUKT_BESCHREIBUNG)))
            .andExpect(jsonPath("$.[*].produktName").value(hasItem(DEFAULT_PRODUKT_NAME)))
            .andExpect(jsonPath("$.[*].plBeschreibung").value(hasItem(DEFAULT_PL_BESCHREIBUNG)))
            .andExpect(jsonPath("$.[*].pl").value(hasItem(DEFAULT_PL)))
            .andExpect(jsonPath("$.[*].land").value(hasItem(DEFAULT_LAND)))
            .andExpect(jsonPath("$.[*].wahrung").value(hasItem(DEFAULT_WAHRUNG)))
            .andExpect(jsonPath("$.[*].incoterm").value(hasItem(DEFAULT_INCOTERM)))
            .andExpect(jsonPath("$.[*].preisStatus").value(hasItem(DEFAULT_PREIS_STATUS)))
            .andExpect(jsonPath("$.[*].datumPreisanderung").value(hasItem(DEFAULT_DATUM_PREISANDERUNG)))
            .andExpect(jsonPath("$.[*].aktuellerListenPreis").value(hasItem(DEFAULT_AKTUELLER_LISTEN_PREIS)))
            .andExpect(jsonPath("$.[*].aktuellerListenpreisGultig").value(hasItem(DEFAULT_AKTUELLER_LISTENPREIS_GULTIG)))
            .andExpect(jsonPath("$.[*].vorherigerListenpreis").value(hasItem(DEFAULT_VORHERIGER_LISTENPREIS)))
            .andExpect(jsonPath("$.[*].nettoPreis").value(hasItem(DEFAULT_NETTO_PREIS)))
            .andExpect(jsonPath("$.[*].gultigkeitsDatumNettopreis").value(hasItem(DEFAULT_GULTIGKEITS_DATUM_NETTOPREIS)))
            .andExpect(jsonPath("$.[*].vorherigerNettoPreis").value(hasItem(DEFAULT_VORHERIGER_NETTO_PREIS)))
            .andExpect(jsonPath("$.[*].paNachlass").value(hasItem(DEFAULT_PA_NACHLASS)))
            .andExpect(jsonPath("$.[*].exhibit").value(hasItem(DEFAULT_EXHIBIT)))
            .andExpect(jsonPath("$.[*].uom").value(hasItem(DEFAULT_UOM)))
            .andExpect(jsonPath("$.[*].preisstaffelVon").value(hasItem(DEFAULT_PREISSTAFFEL_VON)))
            .andExpect(jsonPath("$.[*].preisstaffelBis").value(hasItem(DEFAULT_PREISSTAFFEL_BIS)))
            .andExpect(jsonPath("$.[*].eoq").value(hasItem(DEFAULT_EOQ)))
            .andExpect(jsonPath("$.[*].plcStatus").value(hasItem(DEFAULT_PLC_STATUS)))
            .andExpect(jsonPath("$.[*].plcGultigkeitsdatum").value(hasItem(DEFAULT_PLC_GULTIGKEITSDATUM)))
            .andExpect(jsonPath("$.[*].ersatzProdukt").value(hasItem(DEFAULT_ERSATZ_PRODUKT)))
            .andExpect(jsonPath("$.[*].marketingProgramm").value(hasItem(DEFAULT_MARKETING_PROGRAMM)))
            .andExpect(jsonPath("$.[*].gewahrleistung").value(hasItem(DEFAULT_GEWAHRLEISTUNG)))
            .andExpect(jsonPath("$.[*].classDescription").value(hasItem(DEFAULT_CLASS_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].classCode").value(hasItem(DEFAULT_CLASS_CODE)))
            .andExpect(jsonPath("$.[*].produktFamilienBeschreibung").value(hasItem(DEFAULT_PRODUKT_FAMILIEN_BESCHREIBUNG)))
            .andExpect(jsonPath("$.[*].produktFamilie").value(hasItem(DEFAULT_PRODUKT_FAMILIE)))
            .andExpect(jsonPath("$.[*].serienBeschreibung").value(hasItem(DEFAULT_SERIEN_BESCHREIBUNG)))
            .andExpect(jsonPath("$.[*].seriesCode").value(hasItem(DEFAULT_SERIES_CODE)))
            .andExpect(jsonPath("$.[*].modellBeschreibung").value(hasItem(DEFAULT_MODELL_BESCHREIBUNG)))
            .andExpect(jsonPath("$.[*].modell").value(hasItem(DEFAULT_MODELL)))
            .andExpect(jsonPath("$.[*].standardLieferzeitDistributoren").value(hasItem(DEFAULT_STANDARD_LIEFERZEIT_DISTRIBUTOREN)))
            .andExpect(jsonPath("$.[*].volumen").value(hasItem(DEFAULT_VOLUMEN)))
            .andExpect(jsonPath("$.[*].volumenEinheit").value(hasItem(DEFAULT_VOLUMEN_EINHEIT)))
            .andExpect(jsonPath("$.[*].bruttogewichtProdukts").value(hasItem(DEFAULT_BRUTTOGEWICHT_PRODUKTS)))
            .andExpect(jsonPath("$.[*].gewichtseinheit").value(hasItem(DEFAULT_GEWICHTSEINHEIT)))
            .andExpect(jsonPath("$.[*].produktabmessungen").value(hasItem(DEFAULT_PRODUKTABMESSUNGEN)))
            .andExpect(jsonPath("$.[*].maSeinheit").value(hasItem(DEFAULT_MA_SEINHEIT)))
            .andExpect(jsonPath("$.[*].eanCode").value(hasItem(DEFAULT_EAN_CODE)))
            .andExpect(jsonPath("$.[*].serialisierungsKennung").value(hasItem(DEFAULT_SERIALISIERUNGS_KENNUNG)))
            .andExpect(jsonPath("$.[*].paNummer").value(hasItem(DEFAULT_PA_NUMMER)))
            .andExpect(jsonPath("$.[*].partnerName").value(hasItem(DEFAULT_PARTNER_NAME)))
            .andExpect(jsonPath("$.[*].partnerPro").value(hasItem(DEFAULT_PARTNER_PRO)))
            .andExpect(jsonPath("$.[*].datumsUhrzeitstempel").value(hasItem(DEFAULT_DATUMS_UHRZEITSTEMPEL)));
    }
    
    @Test
    @Transactional
    public void getHpeCatalogue() throws Exception {
        // Initialize the database
        hpeCatalogueRepository.saveAndFlush(hpeCatalogue);

        // Get the hpeCatalogue
        restHpeCatalogueMockMvc.perform(get("/api/hpe-catalogues/{id}", hpeCatalogue.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(hpeCatalogue.getId().intValue()))
            .andExpect(jsonPath("$.produktNummer").value(DEFAULT_PRODUKT_NUMMER))
            .andExpect(jsonPath("$.produktBeschreibung").value(DEFAULT_PRODUKT_BESCHREIBUNG))
            .andExpect(jsonPath("$.kurzeProduktBeschreibung").value(DEFAULT_KURZE_PRODUKT_BESCHREIBUNG))
            .andExpect(jsonPath("$.produktName").value(DEFAULT_PRODUKT_NAME))
            .andExpect(jsonPath("$.plBeschreibung").value(DEFAULT_PL_BESCHREIBUNG))
            .andExpect(jsonPath("$.pl").value(DEFAULT_PL))
            .andExpect(jsonPath("$.land").value(DEFAULT_LAND))
            .andExpect(jsonPath("$.wahrung").value(DEFAULT_WAHRUNG))
            .andExpect(jsonPath("$.incoterm").value(DEFAULT_INCOTERM))
            .andExpect(jsonPath("$.preisStatus").value(DEFAULT_PREIS_STATUS))
            .andExpect(jsonPath("$.datumPreisanderung").value(DEFAULT_DATUM_PREISANDERUNG))
            .andExpect(jsonPath("$.aktuellerListenPreis").value(DEFAULT_AKTUELLER_LISTEN_PREIS))
            .andExpect(jsonPath("$.aktuellerListenpreisGultig").value(DEFAULT_AKTUELLER_LISTENPREIS_GULTIG))
            .andExpect(jsonPath("$.vorherigerListenpreis").value(DEFAULT_VORHERIGER_LISTENPREIS))
            .andExpect(jsonPath("$.nettoPreis").value(DEFAULT_NETTO_PREIS))
            .andExpect(jsonPath("$.gultigkeitsDatumNettopreis").value(DEFAULT_GULTIGKEITS_DATUM_NETTOPREIS))
            .andExpect(jsonPath("$.vorherigerNettoPreis").value(DEFAULT_VORHERIGER_NETTO_PREIS))
            .andExpect(jsonPath("$.paNachlass").value(DEFAULT_PA_NACHLASS))
            .andExpect(jsonPath("$.exhibit").value(DEFAULT_EXHIBIT))
            .andExpect(jsonPath("$.uom").value(DEFAULT_UOM))
            .andExpect(jsonPath("$.preisstaffelVon").value(DEFAULT_PREISSTAFFEL_VON))
            .andExpect(jsonPath("$.preisstaffelBis").value(DEFAULT_PREISSTAFFEL_BIS))
            .andExpect(jsonPath("$.eoq").value(DEFAULT_EOQ))
            .andExpect(jsonPath("$.plcStatus").value(DEFAULT_PLC_STATUS))
            .andExpect(jsonPath("$.plcGultigkeitsdatum").value(DEFAULT_PLC_GULTIGKEITSDATUM))
            .andExpect(jsonPath("$.ersatzProdukt").value(DEFAULT_ERSATZ_PRODUKT))
            .andExpect(jsonPath("$.marketingProgramm").value(DEFAULT_MARKETING_PROGRAMM))
            .andExpect(jsonPath("$.gewahrleistung").value(DEFAULT_GEWAHRLEISTUNG))
            .andExpect(jsonPath("$.classDescription").value(DEFAULT_CLASS_DESCRIPTION))
            .andExpect(jsonPath("$.classCode").value(DEFAULT_CLASS_CODE))
            .andExpect(jsonPath("$.produktFamilienBeschreibung").value(DEFAULT_PRODUKT_FAMILIEN_BESCHREIBUNG))
            .andExpect(jsonPath("$.produktFamilie").value(DEFAULT_PRODUKT_FAMILIE))
            .andExpect(jsonPath("$.serienBeschreibung").value(DEFAULT_SERIEN_BESCHREIBUNG))
            .andExpect(jsonPath("$.seriesCode").value(DEFAULT_SERIES_CODE))
            .andExpect(jsonPath("$.modellBeschreibung").value(DEFAULT_MODELL_BESCHREIBUNG))
            .andExpect(jsonPath("$.modell").value(DEFAULT_MODELL))
            .andExpect(jsonPath("$.standardLieferzeitDistributoren").value(DEFAULT_STANDARD_LIEFERZEIT_DISTRIBUTOREN))
            .andExpect(jsonPath("$.volumen").value(DEFAULT_VOLUMEN))
            .andExpect(jsonPath("$.volumenEinheit").value(DEFAULT_VOLUMEN_EINHEIT))
            .andExpect(jsonPath("$.bruttogewichtProdukts").value(DEFAULT_BRUTTOGEWICHT_PRODUKTS))
            .andExpect(jsonPath("$.gewichtseinheit").value(DEFAULT_GEWICHTSEINHEIT))
            .andExpect(jsonPath("$.produktabmessungen").value(DEFAULT_PRODUKTABMESSUNGEN))
            .andExpect(jsonPath("$.maSeinheit").value(DEFAULT_MA_SEINHEIT))
            .andExpect(jsonPath("$.eanCode").value(DEFAULT_EAN_CODE))
            .andExpect(jsonPath("$.serialisierungsKennung").value(DEFAULT_SERIALISIERUNGS_KENNUNG))
            .andExpect(jsonPath("$.paNummer").value(DEFAULT_PA_NUMMER))
            .andExpect(jsonPath("$.partnerName").value(DEFAULT_PARTNER_NAME))
            .andExpect(jsonPath("$.partnerPro").value(DEFAULT_PARTNER_PRO))
            .andExpect(jsonPath("$.datumsUhrzeitstempel").value(DEFAULT_DATUMS_UHRZEITSTEMPEL));
    }

    @Test
    @Transactional
    public void getNonExistingHpeCatalogue() throws Exception {
        // Get the hpeCatalogue
        restHpeCatalogueMockMvc.perform(get("/api/hpe-catalogues/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateHpeCatalogue() throws Exception {
        // Initialize the database
        hpeCatalogueService.save(hpeCatalogue);

        int databaseSizeBeforeUpdate = hpeCatalogueRepository.findAll().size();

        // Update the hpeCatalogue
        HpeCatalogue updatedHpeCatalogue = hpeCatalogueRepository.findById(hpeCatalogue.getId()).get();
        // Disconnect from session so that the updates on updatedHpeCatalogue are not directly saved in db
        em.detach(updatedHpeCatalogue);
        updatedHpeCatalogue
            .produktNummer(UPDATED_PRODUKT_NUMMER)
            .produktBeschreibung(UPDATED_PRODUKT_BESCHREIBUNG)
            .kurzeProduktBeschreibung(UPDATED_KURZE_PRODUKT_BESCHREIBUNG)
            .produktName(UPDATED_PRODUKT_NAME)
            .plBeschreibung(UPDATED_PL_BESCHREIBUNG)
            .pl(UPDATED_PL)
            .land(UPDATED_LAND)
            .wahrung(UPDATED_WAHRUNG)
            .incoterm(UPDATED_INCOTERM)
            .preisStatus(UPDATED_PREIS_STATUS)
            .datumPreisanderung(UPDATED_DATUM_PREISANDERUNG)
            .aktuellerListenPreis(UPDATED_AKTUELLER_LISTEN_PREIS)
            .aktuellerListenpreisGultig(UPDATED_AKTUELLER_LISTENPREIS_GULTIG)
            .vorherigerListenpreis(UPDATED_VORHERIGER_LISTENPREIS)
            .nettoPreis(UPDATED_NETTO_PREIS)
            .gultigkeitsDatumNettopreis(UPDATED_GULTIGKEITS_DATUM_NETTOPREIS)
            .vorherigerNettoPreis(UPDATED_VORHERIGER_NETTO_PREIS)
            .paNachlass(UPDATED_PA_NACHLASS)
            .exhibit(UPDATED_EXHIBIT)
            .uom(UPDATED_UOM)
            .preisstaffelVon(UPDATED_PREISSTAFFEL_VON)
            .preisstaffelBis(UPDATED_PREISSTAFFEL_BIS)
            .eoq(UPDATED_EOQ)
            .plcStatus(UPDATED_PLC_STATUS)
            .plcGultigkeitsdatum(UPDATED_PLC_GULTIGKEITSDATUM)
            .ersatzProdukt(UPDATED_ERSATZ_PRODUKT)
            .marketingProgramm(UPDATED_MARKETING_PROGRAMM)
            .gewahrleistung(UPDATED_GEWAHRLEISTUNG)
            .classDescription(UPDATED_CLASS_DESCRIPTION)
            .classCode(UPDATED_CLASS_CODE)
            .produktFamilienBeschreibung(UPDATED_PRODUKT_FAMILIEN_BESCHREIBUNG)
            .produktFamilie(UPDATED_PRODUKT_FAMILIE)
            .serienBeschreibung(UPDATED_SERIEN_BESCHREIBUNG)
            .seriesCode(UPDATED_SERIES_CODE)
            .modellBeschreibung(UPDATED_MODELL_BESCHREIBUNG)
            .modell(UPDATED_MODELL)
            .standardLieferzeitDistributoren(UPDATED_STANDARD_LIEFERZEIT_DISTRIBUTOREN)
            .volumen(UPDATED_VOLUMEN)
            .volumenEinheit(UPDATED_VOLUMEN_EINHEIT)
            .bruttogewichtProdukts(UPDATED_BRUTTOGEWICHT_PRODUKTS)
            .gewichtseinheit(UPDATED_GEWICHTSEINHEIT)
            .produktabmessungen(UPDATED_PRODUKTABMESSUNGEN)
            .maSeinheit(UPDATED_MA_SEINHEIT)
            .eanCode(UPDATED_EAN_CODE)
            .serialisierungsKennung(UPDATED_SERIALISIERUNGS_KENNUNG)
            .paNummer(UPDATED_PA_NUMMER)
            .partnerName(UPDATED_PARTNER_NAME)
            .partnerPro(UPDATED_PARTNER_PRO)
            .datumsUhrzeitstempel(UPDATED_DATUMS_UHRZEITSTEMPEL);

        restHpeCatalogueMockMvc.perform(put("/api/hpe-catalogues")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedHpeCatalogue)))
            .andExpect(status().isOk());

        // Validate the HpeCatalogue in the database
        List<HpeCatalogue> hpeCatalogueList = hpeCatalogueRepository.findAll();
        assertThat(hpeCatalogueList).hasSize(databaseSizeBeforeUpdate);
        HpeCatalogue testHpeCatalogue = hpeCatalogueList.get(hpeCatalogueList.size() - 1);
        assertThat(testHpeCatalogue.getProduktNummer()).isEqualTo(UPDATED_PRODUKT_NUMMER);
        assertThat(testHpeCatalogue.getProduktBeschreibung()).isEqualTo(UPDATED_PRODUKT_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getKurzeProduktBeschreibung()).isEqualTo(UPDATED_KURZE_PRODUKT_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getProduktName()).isEqualTo(UPDATED_PRODUKT_NAME);
        assertThat(testHpeCatalogue.getPlBeschreibung()).isEqualTo(UPDATED_PL_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getPl()).isEqualTo(UPDATED_PL);
        assertThat(testHpeCatalogue.getLand()).isEqualTo(UPDATED_LAND);
        assertThat(testHpeCatalogue.getWahrung()).isEqualTo(UPDATED_WAHRUNG);
        assertThat(testHpeCatalogue.getIncoterm()).isEqualTo(UPDATED_INCOTERM);
        assertThat(testHpeCatalogue.getPreisStatus()).isEqualTo(UPDATED_PREIS_STATUS);
        assertThat(testHpeCatalogue.getDatumPreisanderung()).isEqualTo(UPDATED_DATUM_PREISANDERUNG);
        assertThat(testHpeCatalogue.getAktuellerListenPreis()).isEqualTo(UPDATED_AKTUELLER_LISTEN_PREIS);
        assertThat(testHpeCatalogue.getAktuellerListenpreisGultig()).isEqualTo(UPDATED_AKTUELLER_LISTENPREIS_GULTIG);
        assertThat(testHpeCatalogue.getVorherigerListenpreis()).isEqualTo(UPDATED_VORHERIGER_LISTENPREIS);
        assertThat(testHpeCatalogue.getNettoPreis()).isEqualTo(UPDATED_NETTO_PREIS);
        assertThat(testHpeCatalogue.getGultigkeitsDatumNettopreis()).isEqualTo(UPDATED_GULTIGKEITS_DATUM_NETTOPREIS);
        assertThat(testHpeCatalogue.getVorherigerNettoPreis()).isEqualTo(UPDATED_VORHERIGER_NETTO_PREIS);
        assertThat(testHpeCatalogue.getPaNachlass()).isEqualTo(UPDATED_PA_NACHLASS);
        assertThat(testHpeCatalogue.getExhibit()).isEqualTo(UPDATED_EXHIBIT);
        assertThat(testHpeCatalogue.getUom()).isEqualTo(UPDATED_UOM);
        assertThat(testHpeCatalogue.getPreisstaffelVon()).isEqualTo(UPDATED_PREISSTAFFEL_VON);
        assertThat(testHpeCatalogue.getPreisstaffelBis()).isEqualTo(UPDATED_PREISSTAFFEL_BIS);
        assertThat(testHpeCatalogue.getEoq()).isEqualTo(UPDATED_EOQ);
        assertThat(testHpeCatalogue.getPlcStatus()).isEqualTo(UPDATED_PLC_STATUS);
        assertThat(testHpeCatalogue.getPlcGultigkeitsdatum()).isEqualTo(UPDATED_PLC_GULTIGKEITSDATUM);
        assertThat(testHpeCatalogue.getErsatzProdukt()).isEqualTo(UPDATED_ERSATZ_PRODUKT);
        assertThat(testHpeCatalogue.getMarketingProgramm()).isEqualTo(UPDATED_MARKETING_PROGRAMM);
        assertThat(testHpeCatalogue.getGewahrleistung()).isEqualTo(UPDATED_GEWAHRLEISTUNG);
        assertThat(testHpeCatalogue.getClassDescription()).isEqualTo(UPDATED_CLASS_DESCRIPTION);
        assertThat(testHpeCatalogue.getClassCode()).isEqualTo(UPDATED_CLASS_CODE);
        assertThat(testHpeCatalogue.getProduktFamilienBeschreibung()).isEqualTo(UPDATED_PRODUKT_FAMILIEN_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getProduktFamilie()).isEqualTo(UPDATED_PRODUKT_FAMILIE);
        assertThat(testHpeCatalogue.getSerienBeschreibung()).isEqualTo(UPDATED_SERIEN_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getSeriesCode()).isEqualTo(UPDATED_SERIES_CODE);
        assertThat(testHpeCatalogue.getModellBeschreibung()).isEqualTo(UPDATED_MODELL_BESCHREIBUNG);
        assertThat(testHpeCatalogue.getModell()).isEqualTo(UPDATED_MODELL);
        assertThat(testHpeCatalogue.getStandardLieferzeitDistributoren()).isEqualTo(UPDATED_STANDARD_LIEFERZEIT_DISTRIBUTOREN);
        assertThat(testHpeCatalogue.getVolumen()).isEqualTo(UPDATED_VOLUMEN);
        assertThat(testHpeCatalogue.getVolumenEinheit()).isEqualTo(UPDATED_VOLUMEN_EINHEIT);
        assertThat(testHpeCatalogue.getBruttogewichtProdukts()).isEqualTo(UPDATED_BRUTTOGEWICHT_PRODUKTS);
        assertThat(testHpeCatalogue.getGewichtseinheit()).isEqualTo(UPDATED_GEWICHTSEINHEIT);
        assertThat(testHpeCatalogue.getProduktabmessungen()).isEqualTo(UPDATED_PRODUKTABMESSUNGEN);
        assertThat(testHpeCatalogue.getMaSeinheit()).isEqualTo(UPDATED_MA_SEINHEIT);
        assertThat(testHpeCatalogue.getEanCode()).isEqualTo(UPDATED_EAN_CODE);
        assertThat(testHpeCatalogue.getSerialisierungsKennung()).isEqualTo(UPDATED_SERIALISIERUNGS_KENNUNG);
        assertThat(testHpeCatalogue.getPaNummer()).isEqualTo(UPDATED_PA_NUMMER);
        assertThat(testHpeCatalogue.getPartnerName()).isEqualTo(UPDATED_PARTNER_NAME);
        assertThat(testHpeCatalogue.getPartnerPro()).isEqualTo(UPDATED_PARTNER_PRO);
        assertThat(testHpeCatalogue.getDatumsUhrzeitstempel()).isEqualTo(UPDATED_DATUMS_UHRZEITSTEMPEL);
    }

    @Test
    @Transactional
    public void updateNonExistingHpeCatalogue() throws Exception {
        int databaseSizeBeforeUpdate = hpeCatalogueRepository.findAll().size();

        // Create the HpeCatalogue

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restHpeCatalogueMockMvc.perform(put("/api/hpe-catalogues")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(hpeCatalogue)))
            .andExpect(status().isBadRequest());

        // Validate the HpeCatalogue in the database
        List<HpeCatalogue> hpeCatalogueList = hpeCatalogueRepository.findAll();
        assertThat(hpeCatalogueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteHpeCatalogue() throws Exception {
        // Initialize the database
        hpeCatalogueService.save(hpeCatalogue);

        int databaseSizeBeforeDelete = hpeCatalogueRepository.findAll().size();

        // Delete the hpeCatalogue
        restHpeCatalogueMockMvc.perform(delete("/api/hpe-catalogues/{id}", hpeCatalogue.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<HpeCatalogue> hpeCatalogueList = hpeCatalogueRepository.findAll();
        assertThat(hpeCatalogueList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

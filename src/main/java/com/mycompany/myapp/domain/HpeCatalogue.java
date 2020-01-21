package com.mycompany.myapp.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A HpeCatalogue.
 */
@Entity
@Table(name = "hpe_catalogue")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class HpeCatalogue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "produkt_nummer")
    private String produktNummer;

    @Column(name = "produkt_beschreibung")
    private String produktBeschreibung;

    @Column(name = "kurze_produkt_beschreibung")
    private String kurzeProduktBeschreibung;

    @Column(name = "produkt_name")
    private String produktName;

    @Column(name = "pl_beschreibung")
    private String plBeschreibung;

    @Column(name = "pl")
    private String pl;

    @Column(name = "land")
    private String land;

    @Column(name = "wahrung")
    private String wahrung;

    @Column(name = "incoterm")
    private String incoterm;

    @Column(name = "preis_status")
    private String preisStatus;

    @Column(name = "datum_preisanderung")
    private String datumPreisanderung;

    @Column(name = "aktueller_listen_preis")
    private String aktuellerListenPreis;

    @Column(name = "aktueller_listenpreis_gultig")
    private String aktuellerListenpreisGultig;

    @Column(name = "vorheriger_listenpreis")
    private String vorherigerListenpreis;

    @Column(name = "netto_preis")
    private String nettoPreis;

    @Column(name = "gultigkeits_datum_nettopreis")
    private String gultigkeitsDatumNettopreis;

    @Column(name = "vorheriger_netto_preis")
    private String vorherigerNettoPreis;

    @Column(name = "pa_nachlass")
    private String paNachlass;

    @Column(name = "exhibit")
    private String exhibit;

    @Column(name = "uom")
    private String uom;

    @Column(name = "preisstaffel_von")
    private String preisstaffelVon;

    @Column(name = "preisstaffel_bis")
    private String preisstaffelBis;

    @Column(name = "eoq")
    private String eoq;

    @Column(name = "plc_status")
    private String plcStatus;

    @Column(name = "plc_gultigkeitsdatum")
    private String plcGultigkeitsdatum;

    @Column(name = "ersatz_produkt")
    private String ersatzProdukt;

    @Column(name = "marketing_programm")
    private String marketingProgramm;

    @Column(name = "gewahrleistung")
    private String gewahrleistung;

    @Column(name = "class_description")
    private String classDescription;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "produkt_familien_beschreibung")
    private String produktFamilienBeschreibung;

    @Column(name = "produkt_familie")
    private String produktFamilie;

    @Column(name = "serien_beschreibung")
    private String serienBeschreibung;

    @Column(name = "series_code")
    private String seriesCode;

    @Column(name = "modell_beschreibung")
    private String modellBeschreibung;

    @Column(name = "modell")
    private String modell;

    @Column(name = "standard_lieferzeit_distributoren")
    private String standardLieferzeitDistributoren;

    @Column(name = "volumen")
    private String volumen;

    @Column(name = "volumen_einheit")
    private String volumenEinheit;

    @Column(name = "bruttogewicht_produkts")
    private String bruttogewichtProdukts;

    @Column(name = "gewichtseinheit")
    private String gewichtseinheit;

    @Column(name = "produktabmessungen")
    private String produktabmessungen;

    @Column(name = "ma_seinheit")
    private String maSeinheit;

    @Column(name = "ean_code")
    private String eanCode;

    @Column(name = "serialisierungs_kennung")
    private String serialisierungsKennung;

    @Column(name = "pa_nummer")
    private String paNummer;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "partner_pro")
    private String partnerPro;

    @Column(name = "datums_uhrzeitstempel")
    private String datumsUhrzeitstempel;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduktNummer() {
        return produktNummer;
    }

    public HpeCatalogue produktNummer(String produktNummer) {
        this.produktNummer = produktNummer;
        return this;
    }

    public void setProduktNummer(String produktNummer) {
        this.produktNummer = produktNummer;
    }

    public String getProduktBeschreibung() {
        return produktBeschreibung;
    }

    public HpeCatalogue produktBeschreibung(String produktBeschreibung) {
        this.produktBeschreibung = produktBeschreibung;
        return this;
    }

    public void setProduktBeschreibung(String produktBeschreibung) {
        this.produktBeschreibung = produktBeschreibung;
    }

    public String getKurzeProduktBeschreibung() {
        return kurzeProduktBeschreibung;
    }

    public HpeCatalogue kurzeProduktBeschreibung(String kurzeProduktBeschreibung) {
        this.kurzeProduktBeschreibung = kurzeProduktBeschreibung;
        return this;
    }

    public void setKurzeProduktBeschreibung(String kurzeProduktBeschreibung) {
        this.kurzeProduktBeschreibung = kurzeProduktBeschreibung;
    }

    public String getProduktName() {
        return produktName;
    }

    public HpeCatalogue produktName(String produktName) {
        this.produktName = produktName;
        return this;
    }

    public void setProduktName(String produktName) {
        this.produktName = produktName;
    }

    public String getPlBeschreibung() {
        return plBeschreibung;
    }

    public HpeCatalogue plBeschreibung(String plBeschreibung) {
        this.plBeschreibung = plBeschreibung;
        return this;
    }

    public void setPlBeschreibung(String plBeschreibung) {
        this.plBeschreibung = plBeschreibung;
    }

    public String getPl() {
        return pl;
    }

    public HpeCatalogue pl(String pl) {
        this.pl = pl;
        return this;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getLand() {
        return land;
    }

    public HpeCatalogue land(String land) {
        this.land = land;
        return this;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getWahrung() {
        return wahrung;
    }

    public HpeCatalogue wahrung(String wahrung) {
        this.wahrung = wahrung;
        return this;
    }

    public void setWahrung(String wahrung) {
        this.wahrung = wahrung;
    }

    public String getIncoterm() {
        return incoterm;
    }

    public HpeCatalogue incoterm(String incoterm) {
        this.incoterm = incoterm;
        return this;
    }

    public void setIncoterm(String incoterm) {
        this.incoterm = incoterm;
    }

    public String getPreisStatus() {
        return preisStatus;
    }

    public HpeCatalogue preisStatus(String preisStatus) {
        this.preisStatus = preisStatus;
        return this;
    }

    public void setPreisStatus(String preisStatus) {
        this.preisStatus = preisStatus;
    }

    public String getDatumPreisanderung() {
        return datumPreisanderung;
    }

    public HpeCatalogue datumPreisanderung(String datumPreisanderung) {
        this.datumPreisanderung = datumPreisanderung;
        return this;
    }

    public void setDatumPreisanderung(String datumPreisanderung) {
        this.datumPreisanderung = datumPreisanderung;
    }

    public String getAktuellerListenPreis() {
        return aktuellerListenPreis;
    }

    public HpeCatalogue aktuellerListenPreis(String aktuellerListenPreis) {
        this.aktuellerListenPreis = aktuellerListenPreis;
        return this;
    }

    public void setAktuellerListenPreis(String aktuellerListenPreis) {
        this.aktuellerListenPreis = aktuellerListenPreis;
    }

    public String getAktuellerListenpreisGultig() {
        return aktuellerListenpreisGultig;
    }

    public HpeCatalogue aktuellerListenpreisGultig(String aktuellerListenpreisGultig) {
        this.aktuellerListenpreisGultig = aktuellerListenpreisGultig;
        return this;
    }

    public void setAktuellerListenpreisGultig(String aktuellerListenpreisGultig) {
        this.aktuellerListenpreisGultig = aktuellerListenpreisGultig;
    }

    public String getVorherigerListenpreis() {
        return vorherigerListenpreis;
    }

    public HpeCatalogue vorherigerListenpreis(String vorherigerListenpreis) {
        this.vorherigerListenpreis = vorherigerListenpreis;
        return this;
    }

    public void setVorherigerListenpreis(String vorherigerListenpreis) {
        this.vorherigerListenpreis = vorherigerListenpreis;
    }

    public String getNettoPreis() {
        return nettoPreis;
    }

    public HpeCatalogue nettoPreis(String nettoPreis) {
        this.nettoPreis = nettoPreis;
        return this;
    }

    public void setNettoPreis(String nettoPreis) {
        this.nettoPreis = nettoPreis;
    }

    public String getGultigkeitsDatumNettopreis() {
        return gultigkeitsDatumNettopreis;
    }

    public HpeCatalogue gultigkeitsDatumNettopreis(String gultigkeitsDatumNettopreis) {
        this.gultigkeitsDatumNettopreis = gultigkeitsDatumNettopreis;
        return this;
    }

    public void setGultigkeitsDatumNettopreis(String gultigkeitsDatumNettopreis) {
        this.gultigkeitsDatumNettopreis = gultigkeitsDatumNettopreis;
    }

    public String getVorherigerNettoPreis() {
        return vorherigerNettoPreis;
    }

    public HpeCatalogue vorherigerNettoPreis(String vorherigerNettoPreis) {
        this.vorherigerNettoPreis = vorherigerNettoPreis;
        return this;
    }

    public void setVorherigerNettoPreis(String vorherigerNettoPreis) {
        this.vorherigerNettoPreis = vorherigerNettoPreis;
    }

    public String getPaNachlass() {
        return paNachlass;
    }

    public HpeCatalogue paNachlass(String paNachlass) {
        this.paNachlass = paNachlass;
        return this;
    }

    public void setPaNachlass(String paNachlass) {
        this.paNachlass = paNachlass;
    }

    public String getExhibit() {
        return exhibit;
    }

    public HpeCatalogue exhibit(String exhibit) {
        this.exhibit = exhibit;
        return this;
    }

    public void setExhibit(String exhibit) {
        this.exhibit = exhibit;
    }

    public String getUom() {
        return uom;
    }

    public HpeCatalogue uom(String uom) {
        this.uom = uom;
        return this;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getPreisstaffelVon() {
        return preisstaffelVon;
    }

    public HpeCatalogue preisstaffelVon(String preisstaffelVon) {
        this.preisstaffelVon = preisstaffelVon;
        return this;
    }

    public void setPreisstaffelVon(String preisstaffelVon) {
        this.preisstaffelVon = preisstaffelVon;
    }

    public String getPreisstaffelBis() {
        return preisstaffelBis;
    }

    public HpeCatalogue preisstaffelBis(String preisstaffelBis) {
        this.preisstaffelBis = preisstaffelBis;
        return this;
    }

    public void setPreisstaffelBis(String preisstaffelBis) {
        this.preisstaffelBis = preisstaffelBis;
    }

    public String getEoq() {
        return eoq;
    }

    public HpeCatalogue eoq(String eoq) {
        this.eoq = eoq;
        return this;
    }

    public void setEoq(String eoq) {
        this.eoq = eoq;
    }

    public String getPlcStatus() {
        return plcStatus;
    }

    public HpeCatalogue plcStatus(String plcStatus) {
        this.plcStatus = plcStatus;
        return this;
    }

    public void setPlcStatus(String plcStatus) {
        this.plcStatus = plcStatus;
    }

    public String getPlcGultigkeitsdatum() {
        return plcGultigkeitsdatum;
    }

    public HpeCatalogue plcGultigkeitsdatum(String plcGultigkeitsdatum) {
        this.plcGultigkeitsdatum = plcGultigkeitsdatum;
        return this;
    }

    public void setPlcGultigkeitsdatum(String plcGultigkeitsdatum) {
        this.plcGultigkeitsdatum = plcGultigkeitsdatum;
    }

    public String getErsatzProdukt() {
        return ersatzProdukt;
    }

    public HpeCatalogue ersatzProdukt(String ersatzProdukt) {
        this.ersatzProdukt = ersatzProdukt;
        return this;
    }

    public void setErsatzProdukt(String ersatzProdukt) {
        this.ersatzProdukt = ersatzProdukt;
    }

    public String getMarketingProgramm() {
        return marketingProgramm;
    }

    public HpeCatalogue marketingProgramm(String marketingProgramm) {
        this.marketingProgramm = marketingProgramm;
        return this;
    }

    public void setMarketingProgramm(String marketingProgramm) {
        this.marketingProgramm = marketingProgramm;
    }

    public String getGewahrleistung() {
        return gewahrleistung;
    }

    public HpeCatalogue gewahrleistung(String gewahrleistung) {
        this.gewahrleistung = gewahrleistung;
        return this;
    }

    public void setGewahrleistung(String gewahrleistung) {
        this.gewahrleistung = gewahrleistung;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public HpeCatalogue classDescription(String classDescription) {
        this.classDescription = classDescription;
        return this;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public String getClassCode() {
        return classCode;
    }

    public HpeCatalogue classCode(String classCode) {
        this.classCode = classCode;
        return this;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getProduktFamilienBeschreibung() {
        return produktFamilienBeschreibung;
    }

    public HpeCatalogue produktFamilienBeschreibung(String produktFamilienBeschreibung) {
        this.produktFamilienBeschreibung = produktFamilienBeschreibung;
        return this;
    }

    public void setProduktFamilienBeschreibung(String produktFamilienBeschreibung) {
        this.produktFamilienBeschreibung = produktFamilienBeschreibung;
    }

    public String getProduktFamilie() {
        return produktFamilie;
    }

    public HpeCatalogue produktFamilie(String produktFamilie) {
        this.produktFamilie = produktFamilie;
        return this;
    }

    public void setProduktFamilie(String produktFamilie) {
        this.produktFamilie = produktFamilie;
    }

    public String getSerienBeschreibung() {
        return serienBeschreibung;
    }

    public HpeCatalogue serienBeschreibung(String serienBeschreibung) {
        this.serienBeschreibung = serienBeschreibung;
        return this;
    }

    public void setSerienBeschreibung(String serienBeschreibung) {
        this.serienBeschreibung = serienBeschreibung;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public HpeCatalogue seriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
        return this;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getModellBeschreibung() {
        return modellBeschreibung;
    }

    public HpeCatalogue modellBeschreibung(String modellBeschreibung) {
        this.modellBeschreibung = modellBeschreibung;
        return this;
    }

    public void setModellBeschreibung(String modellBeschreibung) {
        this.modellBeschreibung = modellBeschreibung;
    }

    public String getModell() {
        return modell;
    }

    public HpeCatalogue modell(String modell) {
        this.modell = modell;
        return this;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getStandardLieferzeitDistributoren() {
        return standardLieferzeitDistributoren;
    }

    public HpeCatalogue standardLieferzeitDistributoren(String standardLieferzeitDistributoren) {
        this.standardLieferzeitDistributoren = standardLieferzeitDistributoren;
        return this;
    }

    public void setStandardLieferzeitDistributoren(String standardLieferzeitDistributoren) {
        this.standardLieferzeitDistributoren = standardLieferzeitDistributoren;
    }

    public String getVolumen() {
        return volumen;
    }

    public HpeCatalogue volumen(String volumen) {
        this.volumen = volumen;
        return this;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getVolumenEinheit() {
        return volumenEinheit;
    }

    public HpeCatalogue volumenEinheit(String volumenEinheit) {
        this.volumenEinheit = volumenEinheit;
        return this;
    }

    public void setVolumenEinheit(String volumenEinheit) {
        this.volumenEinheit = volumenEinheit;
    }

    public String getBruttogewichtProdukts() {
        return bruttogewichtProdukts;
    }

    public HpeCatalogue bruttogewichtProdukts(String bruttogewichtProdukts) {
        this.bruttogewichtProdukts = bruttogewichtProdukts;
        return this;
    }

    public void setBruttogewichtProdukts(String bruttogewichtProdukts) {
        this.bruttogewichtProdukts = bruttogewichtProdukts;
    }

    public String getGewichtseinheit() {
        return gewichtseinheit;
    }

    public HpeCatalogue gewichtseinheit(String gewichtseinheit) {
        this.gewichtseinheit = gewichtseinheit;
        return this;
    }

    public void setGewichtseinheit(String gewichtseinheit) {
        this.gewichtseinheit = gewichtseinheit;
    }

    public String getProduktabmessungen() {
        return produktabmessungen;
    }

    public HpeCatalogue produktabmessungen(String produktabmessungen) {
        this.produktabmessungen = produktabmessungen;
        return this;
    }

    public void setProduktabmessungen(String produktabmessungen) {
        this.produktabmessungen = produktabmessungen;
    }

    public String getMaSeinheit() {
        return maSeinheit;
    }

    public HpeCatalogue maSeinheit(String maSeinheit) {
        this.maSeinheit = maSeinheit;
        return this;
    }

    public void setMaSeinheit(String maSeinheit) {
        this.maSeinheit = maSeinheit;
    }

    public String getEanCode() {
        return eanCode;
    }

    public HpeCatalogue eanCode(String eanCode) {
        this.eanCode = eanCode;
        return this;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public String getSerialisierungsKennung() {
        return serialisierungsKennung;
    }

    public HpeCatalogue serialisierungsKennung(String serialisierungsKennung) {
        this.serialisierungsKennung = serialisierungsKennung;
        return this;
    }

    public void setSerialisierungsKennung(String serialisierungsKennung) {
        this.serialisierungsKennung = serialisierungsKennung;
    }

    public String getPaNummer() {
        return paNummer;
    }

    public HpeCatalogue paNummer(String paNummer) {
        this.paNummer = paNummer;
        return this;
    }

    public void setPaNummer(String paNummer) {
        this.paNummer = paNummer;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public HpeCatalogue partnerName(String partnerName) {
        this.partnerName = partnerName;
        return this;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerPro() {
        return partnerPro;
    }

    public HpeCatalogue partnerPro(String partnerPro) {
        this.partnerPro = partnerPro;
        return this;
    }

    public void setPartnerPro(String partnerPro) {
        this.partnerPro = partnerPro;
    }

    public String getDatumsUhrzeitstempel() {
        return datumsUhrzeitstempel;
    }

    public HpeCatalogue datumsUhrzeitstempel(String datumsUhrzeitstempel) {
        this.datumsUhrzeitstempel = datumsUhrzeitstempel;
        return this;
    }

    public void setDatumsUhrzeitstempel(String datumsUhrzeitstempel) {
        this.datumsUhrzeitstempel = datumsUhrzeitstempel;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HpeCatalogue)) {
            return false;
        }
        return id != null && id.equals(((HpeCatalogue) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "HpeCatalogue{" +
            "id=" + getId() +
            ", produktNummer='" + getProduktNummer() + "'" +
            ", produktBeschreibung='" + getProduktBeschreibung() + "'" +
            ", kurzeProduktBeschreibung='" + getKurzeProduktBeschreibung() + "'" +
            ", produktName='" + getProduktName() + "'" +
            ", plBeschreibung='" + getPlBeschreibung() + "'" +
            ", pl='" + getPl() + "'" +
            ", land='" + getLand() + "'" +
            ", wahrung='" + getWahrung() + "'" +
            ", incoterm='" + getIncoterm() + "'" +
            ", preisStatus='" + getPreisStatus() + "'" +
            ", datumPreisanderung='" + getDatumPreisanderung() + "'" +
            ", aktuellerListenPreis='" + getAktuellerListenPreis() + "'" +
            ", aktuellerListenpreisGultig='" + getAktuellerListenpreisGultig() + "'" +
            ", vorherigerListenpreis='" + getVorherigerListenpreis() + "'" +
            ", nettoPreis='" + getNettoPreis() + "'" +
            ", gultigkeitsDatumNettopreis='" + getGultigkeitsDatumNettopreis() + "'" +
            ", vorherigerNettoPreis='" + getVorherigerNettoPreis() + "'" +
            ", paNachlass='" + getPaNachlass() + "'" +
            ", exhibit='" + getExhibit() + "'" +
            ", uom='" + getUom() + "'" +
            ", preisstaffelVon='" + getPreisstaffelVon() + "'" +
            ", preisstaffelBis='" + getPreisstaffelBis() + "'" +
            ", eoq='" + getEoq() + "'" +
            ", plcStatus='" + getPlcStatus() + "'" +
            ", plcGultigkeitsdatum='" + getPlcGultigkeitsdatum() + "'" +
            ", ersatzProdukt='" + getErsatzProdukt() + "'" +
            ", marketingProgramm='" + getMarketingProgramm() + "'" +
            ", gewahrleistung='" + getGewahrleistung() + "'" +
            ", classDescription='" + getClassDescription() + "'" +
            ", classCode='" + getClassCode() + "'" +
            ", produktFamilienBeschreibung='" + getProduktFamilienBeschreibung() + "'" +
            ", produktFamilie='" + getProduktFamilie() + "'" +
            ", serienBeschreibung='" + getSerienBeschreibung() + "'" +
            ", seriesCode='" + getSeriesCode() + "'" +
            ", modellBeschreibung='" + getModellBeschreibung() + "'" +
            ", modell='" + getModell() + "'" +
            ", standardLieferzeitDistributoren='" + getStandardLieferzeitDistributoren() + "'" +
            ", volumen='" + getVolumen() + "'" +
            ", volumenEinheit='" + getVolumenEinheit() + "'" +
            ", bruttogewichtProdukts='" + getBruttogewichtProdukts() + "'" +
            ", gewichtseinheit='" + getGewichtseinheit() + "'" +
            ", produktabmessungen='" + getProduktabmessungen() + "'" +
            ", maSeinheit='" + getMaSeinheit() + "'" +
            ", eanCode='" + getEanCode() + "'" +
            ", serialisierungsKennung='" + getSerialisierungsKennung() + "'" +
            ", paNummer='" + getPaNummer() + "'" +
            ", partnerName='" + getPartnerName() + "'" +
            ", partnerPro='" + getPartnerPro() + "'" +
            ", datumsUhrzeitstempel='" + getDatumsUhrzeitstempel() + "'" +
            "}";
    }
}

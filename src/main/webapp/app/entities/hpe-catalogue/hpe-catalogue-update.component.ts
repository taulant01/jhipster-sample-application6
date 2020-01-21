import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IHpeCatalogue, HpeCatalogue } from 'app/shared/model/hpe-catalogue.model';
import { HpeCatalogueService } from './hpe-catalogue.service';

@Component({
  selector: 'jhi-hpe-catalogue-update',
  templateUrl: './hpe-catalogue-update.component.html'
})
export class HpeCatalogueUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    produktNummer: [],
    produktBeschreibung: [],
    kurzeProduktBeschreibung: [],
    produktName: [],
    plBeschreibung: [],
    pl: [],
    land: [],
    wahrung: [],
    incoterm: [],
    preisStatus: [],
    datumPreisanderung: [],
    aktuellerListenPreis: [],
    aktuellerListenpreisGultig: [],
    vorherigerListenpreis: [],
    nettoPreis: [],
    gultigkeitsDatumNettopreis: [],
    vorherigerNettoPreis: [],
    paNachlass: [],
    exhibit: [],
    uom: [],
    preisstaffelVon: [],
    preisstaffelBis: [],
    eoq: [],
    plcStatus: [],
    plcGultigkeitsdatum: [],
    ersatzProdukt: [],
    marketingProgramm: [],
    gewahrleistung: [],
    classDescription: [],
    classCode: [],
    produktFamilienBeschreibung: [],
    produktFamilie: [],
    serienBeschreibung: [],
    seriesCode: [],
    modellBeschreibung: [],
    modell: [],
    standardLieferzeitDistributoren: [],
    volumen: [],
    volumenEinheit: [],
    bruttogewichtProdukts: [],
    gewichtseinheit: [],
    produktabmessungen: [],
    maSeinheit: [],
    eanCode: [],
    serialisierungsKennung: [],
    paNummer: [],
    partnerName: [],
    partnerPro: [],
    datumsUhrzeitstempel: []
  });

  constructor(protected hpeCatalogueService: HpeCatalogueService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ hpeCatalogue }) => {
      this.updateForm(hpeCatalogue);
    });
  }

  updateForm(hpeCatalogue: IHpeCatalogue): void {
    this.editForm.patchValue({
      id: hpeCatalogue.id,
      produktNummer: hpeCatalogue.produktNummer,
      produktBeschreibung: hpeCatalogue.produktBeschreibung,
      kurzeProduktBeschreibung: hpeCatalogue.kurzeProduktBeschreibung,
      produktName: hpeCatalogue.produktName,
      plBeschreibung: hpeCatalogue.plBeschreibung,
      pl: hpeCatalogue.pl,
      land: hpeCatalogue.land,
      wahrung: hpeCatalogue.wahrung,
      incoterm: hpeCatalogue.incoterm,
      preisStatus: hpeCatalogue.preisStatus,
      datumPreisanderung: hpeCatalogue.datumPreisanderung,
      aktuellerListenPreis: hpeCatalogue.aktuellerListenPreis,
      aktuellerListenpreisGultig: hpeCatalogue.aktuellerListenpreisGultig,
      vorherigerListenpreis: hpeCatalogue.vorherigerListenpreis,
      nettoPreis: hpeCatalogue.nettoPreis,
      gultigkeitsDatumNettopreis: hpeCatalogue.gultigkeitsDatumNettopreis,
      vorherigerNettoPreis: hpeCatalogue.vorherigerNettoPreis,
      paNachlass: hpeCatalogue.paNachlass,
      exhibit: hpeCatalogue.exhibit,
      uom: hpeCatalogue.uom,
      preisstaffelVon: hpeCatalogue.preisstaffelVon,
      preisstaffelBis: hpeCatalogue.preisstaffelBis,
      eoq: hpeCatalogue.eoq,
      plcStatus: hpeCatalogue.plcStatus,
      plcGultigkeitsdatum: hpeCatalogue.plcGultigkeitsdatum,
      ersatzProdukt: hpeCatalogue.ersatzProdukt,
      marketingProgramm: hpeCatalogue.marketingProgramm,
      gewahrleistung: hpeCatalogue.gewahrleistung,
      classDescription: hpeCatalogue.classDescription,
      classCode: hpeCatalogue.classCode,
      produktFamilienBeschreibung: hpeCatalogue.produktFamilienBeschreibung,
      produktFamilie: hpeCatalogue.produktFamilie,
      serienBeschreibung: hpeCatalogue.serienBeschreibung,
      seriesCode: hpeCatalogue.seriesCode,
      modellBeschreibung: hpeCatalogue.modellBeschreibung,
      modell: hpeCatalogue.modell,
      standardLieferzeitDistributoren: hpeCatalogue.standardLieferzeitDistributoren,
      volumen: hpeCatalogue.volumen,
      volumenEinheit: hpeCatalogue.volumenEinheit,
      bruttogewichtProdukts: hpeCatalogue.bruttogewichtProdukts,
      gewichtseinheit: hpeCatalogue.gewichtseinheit,
      produktabmessungen: hpeCatalogue.produktabmessungen,
      maSeinheit: hpeCatalogue.maSeinheit,
      eanCode: hpeCatalogue.eanCode,
      serialisierungsKennung: hpeCatalogue.serialisierungsKennung,
      paNummer: hpeCatalogue.paNummer,
      partnerName: hpeCatalogue.partnerName,
      partnerPro: hpeCatalogue.partnerPro,
      datumsUhrzeitstempel: hpeCatalogue.datumsUhrzeitstempel
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const hpeCatalogue = this.createFromForm();
    if (hpeCatalogue.id !== undefined) {
      this.subscribeToSaveResponse(this.hpeCatalogueService.update(hpeCatalogue));
    } else {
      this.subscribeToSaveResponse(this.hpeCatalogueService.create(hpeCatalogue));
    }
  }

  private createFromForm(): IHpeCatalogue {
    return {
      ...new HpeCatalogue(),
      id: this.editForm.get(['id'])!.value,
      produktNummer: this.editForm.get(['produktNummer'])!.value,
      produktBeschreibung: this.editForm.get(['produktBeschreibung'])!.value,
      kurzeProduktBeschreibung: this.editForm.get(['kurzeProduktBeschreibung'])!.value,
      produktName: this.editForm.get(['produktName'])!.value,
      plBeschreibung: this.editForm.get(['plBeschreibung'])!.value,
      pl: this.editForm.get(['pl'])!.value,
      land: this.editForm.get(['land'])!.value,
      wahrung: this.editForm.get(['wahrung'])!.value,
      incoterm: this.editForm.get(['incoterm'])!.value,
      preisStatus: this.editForm.get(['preisStatus'])!.value,
      datumPreisanderung: this.editForm.get(['datumPreisanderung'])!.value,
      aktuellerListenPreis: this.editForm.get(['aktuellerListenPreis'])!.value,
      aktuellerListenpreisGultig: this.editForm.get(['aktuellerListenpreisGultig'])!.value,
      vorherigerListenpreis: this.editForm.get(['vorherigerListenpreis'])!.value,
      nettoPreis: this.editForm.get(['nettoPreis'])!.value,
      gultigkeitsDatumNettopreis: this.editForm.get(['gultigkeitsDatumNettopreis'])!.value,
      vorherigerNettoPreis: this.editForm.get(['vorherigerNettoPreis'])!.value,
      paNachlass: this.editForm.get(['paNachlass'])!.value,
      exhibit: this.editForm.get(['exhibit'])!.value,
      uom: this.editForm.get(['uom'])!.value,
      preisstaffelVon: this.editForm.get(['preisstaffelVon'])!.value,
      preisstaffelBis: this.editForm.get(['preisstaffelBis'])!.value,
      eoq: this.editForm.get(['eoq'])!.value,
      plcStatus: this.editForm.get(['plcStatus'])!.value,
      plcGultigkeitsdatum: this.editForm.get(['plcGultigkeitsdatum'])!.value,
      ersatzProdukt: this.editForm.get(['ersatzProdukt'])!.value,
      marketingProgramm: this.editForm.get(['marketingProgramm'])!.value,
      gewahrleistung: this.editForm.get(['gewahrleistung'])!.value,
      classDescription: this.editForm.get(['classDescription'])!.value,
      classCode: this.editForm.get(['classCode'])!.value,
      produktFamilienBeschreibung: this.editForm.get(['produktFamilienBeschreibung'])!.value,
      produktFamilie: this.editForm.get(['produktFamilie'])!.value,
      serienBeschreibung: this.editForm.get(['serienBeschreibung'])!.value,
      seriesCode: this.editForm.get(['seriesCode'])!.value,
      modellBeschreibung: this.editForm.get(['modellBeschreibung'])!.value,
      modell: this.editForm.get(['modell'])!.value,
      standardLieferzeitDistributoren: this.editForm.get(['standardLieferzeitDistributoren'])!.value,
      volumen: this.editForm.get(['volumen'])!.value,
      volumenEinheit: this.editForm.get(['volumenEinheit'])!.value,
      bruttogewichtProdukts: this.editForm.get(['bruttogewichtProdukts'])!.value,
      gewichtseinheit: this.editForm.get(['gewichtseinheit'])!.value,
      produktabmessungen: this.editForm.get(['produktabmessungen'])!.value,
      maSeinheit: this.editForm.get(['maSeinheit'])!.value,
      eanCode: this.editForm.get(['eanCode'])!.value,
      serialisierungsKennung: this.editForm.get(['serialisierungsKennung'])!.value,
      paNummer: this.editForm.get(['paNummer'])!.value,
      partnerName: this.editForm.get(['partnerName'])!.value,
      partnerPro: this.editForm.get(['partnerPro'])!.value,
      datumsUhrzeitstempel: this.editForm.get(['datumsUhrzeitstempel'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IHpeCatalogue>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}

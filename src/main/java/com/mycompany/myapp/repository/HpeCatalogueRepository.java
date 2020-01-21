package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.HpeCatalogue;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the HpeCatalogue entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HpeCatalogueRepository extends JpaRepository<HpeCatalogue, Long> {

}

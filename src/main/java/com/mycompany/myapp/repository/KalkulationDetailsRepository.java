package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.KalkulationDetails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the KalkulationDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KalkulationDetailsRepository extends JpaRepository<KalkulationDetails, Long> {

}

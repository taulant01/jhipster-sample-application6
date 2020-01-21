package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.CopAccountDetails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CopAccountDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CopAccountDetailsRepository extends JpaRepository<CopAccountDetails, Long> {

}

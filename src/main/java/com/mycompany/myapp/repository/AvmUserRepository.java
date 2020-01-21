package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.AvmUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AvmUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AvmUserRepository extends JpaRepository<AvmUser, Long> {

}

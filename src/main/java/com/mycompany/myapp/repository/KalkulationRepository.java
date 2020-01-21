package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Kalkulation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Kalkulation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KalkulationRepository extends JpaRepository<Kalkulation, Long> {

    @Query("select kalkulation from Kalkulation kalkulation where kalkulation.user.login = ?#{principal.username}")
    List<Kalkulation> findByUserIsCurrentUser();

}

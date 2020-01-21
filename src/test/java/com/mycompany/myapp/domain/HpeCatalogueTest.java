package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class HpeCatalogueTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(HpeCatalogue.class);
        HpeCatalogue hpeCatalogue1 = new HpeCatalogue();
        hpeCatalogue1.setId(1L);
        HpeCatalogue hpeCatalogue2 = new HpeCatalogue();
        hpeCatalogue2.setId(hpeCatalogue1.getId());
        assertThat(hpeCatalogue1).isEqualTo(hpeCatalogue2);
        hpeCatalogue2.setId(2L);
        assertThat(hpeCatalogue1).isNotEqualTo(hpeCatalogue2);
        hpeCatalogue1.setId(null);
        assertThat(hpeCatalogue1).isNotEqualTo(hpeCatalogue2);
    }
}

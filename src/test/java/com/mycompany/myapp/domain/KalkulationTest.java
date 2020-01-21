package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class KalkulationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Kalkulation.class);
        Kalkulation kalkulation1 = new Kalkulation();
        kalkulation1.setId(1L);
        Kalkulation kalkulation2 = new Kalkulation();
        kalkulation2.setId(kalkulation1.getId());
        assertThat(kalkulation1).isEqualTo(kalkulation2);
        kalkulation2.setId(2L);
        assertThat(kalkulation1).isNotEqualTo(kalkulation2);
        kalkulation1.setId(null);
        assertThat(kalkulation1).isNotEqualTo(kalkulation2);
    }
}

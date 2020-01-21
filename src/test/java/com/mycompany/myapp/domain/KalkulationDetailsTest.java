package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class KalkulationDetailsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(KalkulationDetails.class);
        KalkulationDetails kalkulationDetails1 = new KalkulationDetails();
        kalkulationDetails1.setId(1L);
        KalkulationDetails kalkulationDetails2 = new KalkulationDetails();
        kalkulationDetails2.setId(kalkulationDetails1.getId());
        assertThat(kalkulationDetails1).isEqualTo(kalkulationDetails2);
        kalkulationDetails2.setId(2L);
        assertThat(kalkulationDetails1).isNotEqualTo(kalkulationDetails2);
        kalkulationDetails1.setId(null);
        assertThat(kalkulationDetails1).isNotEqualTo(kalkulationDetails2);
    }
}

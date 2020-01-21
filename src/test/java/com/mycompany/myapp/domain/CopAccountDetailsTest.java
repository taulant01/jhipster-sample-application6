package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class CopAccountDetailsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CopAccountDetails.class);
        CopAccountDetails copAccountDetails1 = new CopAccountDetails();
        copAccountDetails1.setId(1L);
        CopAccountDetails copAccountDetails2 = new CopAccountDetails();
        copAccountDetails2.setId(copAccountDetails1.getId());
        assertThat(copAccountDetails1).isEqualTo(copAccountDetails2);
        copAccountDetails2.setId(2L);
        assertThat(copAccountDetails1).isNotEqualTo(copAccountDetails2);
        copAccountDetails1.setId(null);
        assertThat(copAccountDetails1).isNotEqualTo(copAccountDetails2);
    }
}

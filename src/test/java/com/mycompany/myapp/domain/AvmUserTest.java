package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class AvmUserTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AvmUser.class);
        AvmUser avmUser1 = new AvmUser();
        avmUser1.setId(1L);
        AvmUser avmUser2 = new AvmUser();
        avmUser2.setId(avmUser1.getId());
        assertThat(avmUser1).isEqualTo(avmUser2);
        avmUser2.setId(2L);
        assertThat(avmUser1).isNotEqualTo(avmUser2);
        avmUser1.setId(null);
        assertThat(avmUser1).isNotEqualTo(avmUser2);
    }
}

package org.github.alanaafsc;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProdutoTest {

    @Test
    @DataSet("produtos1.yml")
    public void testUm() {
        assertEquals(1, Produto.count());
    }
}
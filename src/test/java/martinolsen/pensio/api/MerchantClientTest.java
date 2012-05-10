package martinolsen.pensio.api;

import java.io.InputStream;
import java.net.URL;
import martinolsen.pensio.api.jaxb.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MerchantClientTest {
    MerchantClient client;

    @Before public void setupTests() {
        this.client = new MerchantClient("testgateway", null, null);
        this.client.setHttpClient(new MockHttpClient());
    }

    @Test public void testMerchantClient() throws Exception {
        this.client.index();
    }
}

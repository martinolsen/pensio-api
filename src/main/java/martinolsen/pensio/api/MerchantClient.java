package martinolsen.pensio.api;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import martinolsen.pensio.api.jaxb.*;

public class MerchantClient {
    private String baseUrl;
    private HttpClient httpClient = new DefaultHttpClient();

    public MerchantClient(String name, String username, String password) {
        this.baseUrl = "https://" + name + ".pensio.com/merchant/API/";
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void index() {
        try {
            invokeMethod("index", null);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private ApiResponse invokeMethod(String method, OutputStream payload) {
        InputStream content = getUrl(this.baseUrl + method);
        return readResponse(content);
    }

    private InputStream getUrl(String url) {
        InputStream content;

        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            content = httpEntity.getContent();
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }

        return content;
    }

    private ApiResponse readResponse(InputStream content) {
        ApiResponse apiResponse;

        try {
            apiResponse = ApiResponse.unmarshal(content);
        } catch(UnmarshalException ex) {
            throw new RuntimeException(ex);
        }

        return apiResponse;
    }
}

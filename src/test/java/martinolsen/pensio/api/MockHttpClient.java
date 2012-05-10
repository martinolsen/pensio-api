package martinolsen.pensio.api;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.FileEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class MockHttpClient implements HttpClient {
    private static final ProtocolVersion PROTOCOL_VERSION =
        new ProtocolVersion("HTTP", 1, 1);

    public HttpResponse execute(HttpUriRequest request) {
        if(!"GET".equals(request.getMethod()))
            throw new RuntimeException("can only handle GET, not " + request.getMethod());

        HttpResponse httpResponse = new BasicHttpResponse(
            new BasicStatusLine(PROTOCOL_VERSION, 300, "OK"));

        File file = new File(requestCachePath(request));

        httpResponse.setEntity(new FileEntity(file, "text/plain"));

        return httpResponse;
    }

    public HttpResponse execute(HttpUriRequest request, HttpContext context) {
        throw new RuntimeException("not yet implemented!");
    }

    public HttpResponse execute(HttpHost host, HttpRequest request) {
        throw new RuntimeException("not yet implemented!");
    }

    public HttpResponse execute(HttpHost host, HttpRequest request,
                                HttpContext context ) {

        throw new RuntimeException("not yet implemented!");
    }

    public <T> T execute(HttpUriRequest request,
                         ResponseHandler<? extends T> handler) {

        throw new RuntimeException("not yet implemented!");
    }

    public <T> T execute(HttpUriRequest request,
                         ResponseHandler<? extends T> handler,
                         HttpContext context) {

        throw new RuntimeException("not yet implemented!");
    }

    public <T> T execute(HttpHost host, HttpRequest request,
                         ResponseHandler<? extends T> handler) {

        throw new RuntimeException("not yet implemented!");
    }

    public <T> T execute(HttpHost host, HttpRequest request,
                         ResponseHandler<? extends T> handler,
                         HttpContext httpContext) {

        throw new RuntimeException("not yet implemented!");
    }

    @Override
    public ClientConnectionManager getConnectionManager() {
        return null;
    }

    @Override
    public HttpParams getParams() {
        return null;
    }

    private String requestCachePath(HttpUriRequest request) {
        return "src/test/resources/cache/" + request.getURI().getPath();
    }
}

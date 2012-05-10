package martinolsen.pensio.api.jaxb;

import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
<APIResponse version="20110831">
    <Header/>
    <Body/>
</APIResponse>
*/

@XmlRootElement(name = "APIResponse")
public class ApiResponse {
    private Integer version;

    private Header header;
    private Body body;

    @XmlElement(name = "Header")
    public Header getHeader() {
        return this.header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @XmlElement(name = "Body")
    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "APIResponse["
            + "header = " + (header != null ? header.toString() : "null")
            + ", body = " + (body != null ? body.toString() : "null")
            + "]";
    }

    public static ApiResponse unmarshal(URL url) throws UnmarshalException {
        Object object;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ApiResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = unmarshaller.unmarshal(url);
        } catch(JAXBException ex) {
            throw new UnmarshalException(ex);
        }

        return (ApiResponse) object;
    }

    public static ApiResponse unmarshal(InputStream inputStream)
        throws UnmarshalException {

        Object object;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ApiResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = unmarshaller.unmarshal(inputStream);
        } catch(JAXBException ex) {
            throw new UnmarshalException(ex);
        }

        return (ApiResponse) object;
    }
}

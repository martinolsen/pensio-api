package martinolsen.pensio.api.jaxb;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Body")
public class Body {
    private Integer result;
    private String status;

    private List<Terminal> terminals;

    @XmlElement(name = "Result")
    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "Terminals")
    public List<Terminal> getTerminals() {
        return this.terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }
}

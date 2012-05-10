package martinolsen.pensio.api.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Terminal")
public class Terminal {
    private String title;
    private String country;
    private List<String> natures;
    private List<String> currencies;

    @XmlElement(name = "Title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElementWrapper(name = "Natures")
    @XmlElement(name = "Nature")
    public List<String> getNatures() {
        return this.natures;
    }

    public void setNatures(List<String> natures) {
        this.natures = natures;
    }

    @XmlElementWrapper(name = "Currencies")
    @XmlElement(name = "Currency")
    public List<String> getCurrencies() {
        return this.currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }
}

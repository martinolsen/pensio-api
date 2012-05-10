package martinolsen.pensio.api.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
<Header>
    <Date>2012-05-10T19:56:17+02:00</Date>
    <Path>API/index</Path>
    <ErrorCode>0</ErrorCode>
    <ErrorMessage/>
</Header>
*/

@XmlRootElement(name = "Header")
public class Header {
    private Date date;
    private String path;
    private Integer errorCode;
    private String errorMessage;

    @XmlElement(name = "Date")
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlElement(name = "Path")
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @XmlElement(name = "ErrorMessage")
    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElement(name = "ErrorMessage")
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Header["
            + "date = " + (date != null ? date.toString() : "null")
            + ", path = " + (path != null ? path : "null" )
            + ", errorCode = " + (errorCode != null ? errorCode : "null")
            + ", errorMessage = " + (errorMessage != null ? errorMessage : "null")
            + "]";
    }
}

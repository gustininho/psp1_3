package Lab2.impl.helpers;

public class TldData {
    private String domain;
    private String generic;
    private String organization;

    public TldData(String domain, String generic, String organization) {
        this.domain = domain;
        this.generic = generic;
        this.organization = organization;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}

package org.design_patterns;

public class Request {

    private String type;
    private boolean isAuthenticated;
    private boolean isAuthorized;
    private boolean isSecurityPassedChecks;

    public Request(String type, boolean isAuthenticated, boolean isAuthorized, boolean isSecurityPassedChecks) {
        this.type = type;
        this.isAuthenticated = isAuthenticated;
        this.isAuthorized = isAuthorized;
        this.isSecurityPassedChecks = isSecurityPassedChecks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public boolean isSecurityPassedChecks() {
        return isSecurityPassedChecks;
    }

    public void setSecurityPassedChecks(boolean securityPassedChecks) {
        isSecurityPassedChecks = securityPassedChecks;
    }
}

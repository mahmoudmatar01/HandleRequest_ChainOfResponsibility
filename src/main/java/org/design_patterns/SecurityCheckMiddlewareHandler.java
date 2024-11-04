package org.design_patterns;

public class SecurityCheckMiddlewareHandler extends AbstractMiddlewareHandler{

    @Override
    public boolean handleRequest(Request request) {
        System.out.println("checking request is security check ........ ");
        if(!request.isSecurityPassedChecks()){
            System.out.println("request is not security check ...... ");
            return false;
        }
        return super.handleRequest(request);
    }
}

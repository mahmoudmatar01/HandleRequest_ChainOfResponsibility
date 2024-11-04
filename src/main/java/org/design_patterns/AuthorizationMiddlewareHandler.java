package org.design_patterns;

public class AuthorizationMiddlewareHandler extends AbstractMiddlewareHandler {

    @Override
    public boolean handleRequest(Request request) {
        System.out.println("checking request is authorized ........ ");
        if(!request.isAuthorized()){
            System.out.println("request is not authorized ......!");
            return false;
        }
        return super.handleRequest(request);
    }
}

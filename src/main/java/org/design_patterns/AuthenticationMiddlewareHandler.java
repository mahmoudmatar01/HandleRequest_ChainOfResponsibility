package org.design_patterns;

public class AuthenticationMiddlewareHandler extends AbstractMiddlewareHandler {

    @Override
    public boolean handleRequest(Request request) {
        System.out.println("checking request is authenticated ........ ");
        if(!request.isAuthenticated()){
            System.out.println("request is not authenticated ......! ");
            return false;
        }
        return super.handleRequest(request);
    }
}

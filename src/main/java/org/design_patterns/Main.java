package org.design_patterns;


public class Main {
    public static void main(String[] args) {

        MiddlewareHandler authenticationMiddleware = new AuthenticationMiddlewareHandler();
        MiddlewareHandler authorizationMiddleware = new AuthorizationMiddlewareHandler();
        MiddlewareHandler securityCheckMiddleware = new SecurityCheckMiddlewareHandler();

        authenticationMiddleware.setNext(authorizationMiddleware);
        authorizationMiddleware.setNext(securityCheckMiddleware);

        RequestProcessor requestProcessor = new RequestProcessor(authenticationMiddleware);
        Request request = new Request("GET",true,false,true);
        Request request2 = new Request("POST",true,true,true);

        Response response = requestProcessor.processRequest(request);
        Response response2 = requestProcessor.processRequest(request2);
        System.out.println("process request result : "+response.isSuccess()+" because -> "+response.getMessage());
        System.out.println("process request 2 result : "+response2.isSuccess()+" because -> "+response2.getMessage());

    }
}
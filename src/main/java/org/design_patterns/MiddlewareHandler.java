package org.design_patterns;

public interface MiddlewareHandler {

    MiddlewareHandler setNext(MiddlewareHandler middlewareHandler);
    boolean handleRequest(Request request);
}

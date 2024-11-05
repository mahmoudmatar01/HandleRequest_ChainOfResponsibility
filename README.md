# HandleRequest_ChainOfResponsibility

This project demonstrates the **Chain of Responsibility Design Pattern** by implementing a sequence of middleware handlers to process requests. Each handler performs a specific check on a request (authentication, authorization, and security) and then passes it along the chain if it meets the requirements. This design pattern allows for flexible and modular handling of requests with multiple, sequential checks.

## Project Structure

The project is structured as follows:

1. **MiddlewareHandler (Interface)**
   - Defines the structure for middleware handlers in the chain.
   - `setNext(MiddlewareHandler middlewareHandler)`: Sets the next handler in the chain.
   - `handleRequest(Request request)`: Processes the request and, if applicable, passes it to the next handler.

2. **AbstractMiddlewareHandler (Abstract Class)**
   - Implements the `MiddlewareHandler` interface and provides a basic implementation of `setNext` and `handleRequest`.
   - Handles chaining by calling `handleRequest` on the next handler if present.
   - Allows for other middleware handlers to inherit basic chain functionality.

3. **Concrete Middleware Handlers**
   - Each of these classes extends `AbstractMiddlewareHandler` and performs specific checks:
     - `AuthenticationMiddlewareHandler`: Checks if the request is authenticated.
     - `AuthorizationMiddlewareHandler`: Checks if the request is authorized.
     - `SecurityCheckMiddlewareHandler`: Checks if the request passes security checks.
   - If a check fails, the request is rejected, and the process ends without continuing to the next handler.

4. **RequestProcessor (Class)**
   - Takes the initial `MiddlewareHandler` in the chain as an argument.
   - Calls the `handleRequest` method on the starting handler.
   - Returns a `Response` object based on whether the request passed all checks.

5. **Request (Class)**
   - Represents a request, containing fields like `type`, `isAuthenticated`, `isAuthorized`, and `isSecurityPassedChecks`.
   - Provides getter and setter methods for these fields, enabling checks by the middleware handlers.

6. **Response (Class)**
   - Represents the outcome of processing a request, containing fields for `message` and `isSuccess`.
   - Used by the `RequestProcessor` to return results.

7. **Main (Driver Class)**
   - Sets up the chain of responsibility by linking handlers in the desired order.
   - Creates instances of `RequestProcessor` and `Request` to simulate processing different request scenarios.
   - Displays the outcome of each processed request.

## How It Works

1. **Chain of Responsibility Pattern**:
   - Each middleware handler represents a single step in the chain.
   - Handlers perform checks (authentication, authorization, security) and pass the request to the next handler if the check passes.
   - If any handler fails, the request is rejected without further processing.

2. **Request Processing**:
   - `RequestProcessor` initiates request processing by calling `handleRequest` on the first handler.
   - Each handler processes the request in turn, passing it along the chain if successful.
   - A `Response` object with the success status and message is returned based on whether the request passed all checks.

## Sample Output

Running the `Main` class produces output similar to:

```plaintext
checking request is authenticated ........ 
checking request is authorized ........ 
request is not authorized ......! 
process request result : false because -> Request Failed

checking request is authenticated ........ 
checking request is authorized ........ 
checking request is security check ........ 
process request 2 result : true because -> Request Successfully process
```
This output shows the step-by-step processing for each request, indicating the points where the chain is stopped if a check fails.


## Key Takeaways

- Chain of Responsibility Pattern: Enables flexible and modular request processing, with each handler performing a single check.
- Error Isolation: Each handler in the chain is responsible for a single aspect of request validation, isolating potential failures and enhancing readability.
- Scalability: Additional middleware handlers can be added without modifying existing code, making the design scalable for complex processing needs.


## Usage

1. Clone the repository and navigate to the project directory.
2. Compile the project files.
3. Run the `Main` class to see the Chain of Responsibility pattern in action, simulating different request processing scenarios.

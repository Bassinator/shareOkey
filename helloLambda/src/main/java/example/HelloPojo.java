package ch.bassinator.shareokey.javalampdablueprint.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloPojo implements RequestHandler<Request, Response>{

    public Response handleRequest(Request request, Context context){
        String greetingString = String.format("Hello %s, %s.", request.firstName, request.lastName);
        return new Response(greetingString);
    }
}

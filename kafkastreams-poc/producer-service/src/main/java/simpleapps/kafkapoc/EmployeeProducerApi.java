package simpleapps.kafkapoc;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/emp/{topicName}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeProducerApi {

    private final MessageProducer messageProducer;

    public EmployeeProducerApi(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @POST
    public Response send(@PathParam("topicName") String topicName, @NotNull Map<String, Employee> message) {
        String key = message.get("employee").getId();
        Employee value = message.get("employee");
        messageProducer.send(topicName, key, value);
        return Response.ok().build();
    }
}

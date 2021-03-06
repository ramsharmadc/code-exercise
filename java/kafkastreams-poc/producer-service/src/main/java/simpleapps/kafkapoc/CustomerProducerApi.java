package simpleapps.kafkapoc;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/cust/{topicName}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerProducerApi {

    private final MessageProducer messageProducer;

    public CustomerProducerApi(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @POST
    public Response send(@PathParam("topicName") String topicName, @NotNull Map<String, Customer> message) {
        String key = message.get("customer").getId();
        Customer value = message.get("customer");
        messageProducer.send(topicName, key, value);
        return Response.ok().build();
    }
}

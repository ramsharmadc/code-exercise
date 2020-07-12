package zeromq.poc.ex1_6;

import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;
import zeromq.poc.commons.ZConstants;

import java.security.SecureRandom;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static org.zeromq.ZMQ.PUB;
import static org.zeromq.ZMQ.context;

/**
 * Weather update server in Java
 * Binds PUB socket to tcp://*:5556
 * Publishes random weather updates
 *
 * @since 1.0
 */

public class WuServer {

    public static void main(String[] args) {
        //  Prepare our context and publisher
        Context context = context(1);
        Socket publisher = context.socket(PUB);
        publisher.bind(ZConstants.URL.TCP_5556);
        publisher.bind(ZConstants.URL.IPC_WEATHER);
        SecureRandom random = new SecureRandom();
        while (!currentThread().isInterrupted())
            publisher.send(prepareWeatherUpdate(random), 0);
        publisher.close();
        context.term();
    }

    private static String prepareWeatherUpdate(SecureRandom random) {
        //  Get values that will fool the boss
        int zipCode, temperature, relHumidity;
        zipCode = 10000 + random.nextInt(10000);
        temperature = random.nextInt(215) - 80 + 1;
        relHumidity = random.nextInt(50) + 10 + 1;
        //  Send message to all subscribers
        return format("%05d %d %d", zipCode, temperature, relHumidity);
    }
}

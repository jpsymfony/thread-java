package question2;

import question1.HTTPSensor;
import question1.CyclicAcquisition;

/**
 * Decrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */
public class Main
{

    public static void main(String[] args) throws Exception
    {
        //HTTPSensor.setHttpProxy("cache.cnam.fr",3128);
        HTTPSensor ds2438 = null;
        if (args.length == 0) {
            ds2438 = new HTTPSensor();
        } else {
            ds2438 = new HTTPSensor(args[0]);
        }

        //a completer

        Handler<Float> maxHandler = new MaxHandler(null);
        Handler<Float> minHandler = new MinHandler(maxHandler);
        Handler<Float> fileHandler = new FileHandler("mesures",minHandler);
        Handler<Float> chain = new TraceHandler(fileHandler);

        CyclicAcquisition acquisition = new CyclicAcquisition(ds2438, 1000, new ChainCommand<>(chain));
        acquisition.start();

        Thread.sleep(1000 * 10);

        acquisition.stop();

    }
}

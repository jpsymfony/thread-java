package question1;

/**
 * Decrivez votre classe Main ici.
 *
 * @author SAULNIER
 * @version 12 -03-2017
 */
public class Main2
{

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception
    {
//    HTTPSensor.setHttpProxy("cache.cnam.fr",3128);
        HTTPSensor ds2438 = null;
        if (args.length == 0) {
            ds2438 = new HTTPSensor();
        } else {
            ds2438 = new HTTPSensor(args[0]);
        }

        CyclicAcquisition acquisition = new CyclicAcquisition(ds2438, ds2438.minimalPeriod(), new ConsoleCommand<>()); // a completer

        acquisition.start();  // ne pas modifier ces 3 lignes
        Thread.sleep(30 * 1000); // au total 30 secondes d'acquisition, preferez le simulateur pour vos tests ...
        acquisition.stop();
    }
}

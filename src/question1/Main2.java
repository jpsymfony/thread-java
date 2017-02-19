package question1;


/**
 * Decrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */
public class Main2
{

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

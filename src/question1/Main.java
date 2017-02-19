package question1;


/**
 * Decrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */
public class Main
{

    public static void main(String[] args)
    {
        //HTTPSensor.setHttpProxy("cache.cnam.fr",3128); // si vous etes en wifi et au Cnam

        HTTPSensor ds2438;
        if (args.length == 0) {
            ds2438 = new HTTPSensor();
        } else {
            ds2438 = new HTTPSensor(args[0]);
        }

        try {
            String request1 = ds2438.request();
            String request2 = ds2438.request();
            System.out.println("requete aupres du ds2438 : " + request1);
            System.out.println("requete aupres du ds2438 : " + request2);

            System.out.println("ds2438.value() request1 : " + ds2438.value(request1));
            System.out.println("ds2438.value() request2 : " + ds2438.value(request2));

            System.out.println("ds2438.value() new request : " + ds2438.value());
            System.out.println("ds2438.value() new request : " + ds2438.value());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

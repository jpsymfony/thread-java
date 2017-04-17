// ce qui est a completer  est en ligne 50
// ----------------------------------------
package question1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * Classe de lecture d'un capteur sur le Web
 *
 * @author jm Douin
 * @version de test
 */
public class HTTPSensor extends HumiditySensor
{
    /**
     * The constant ONE_MINUTE.
     */
    public static final long ONE_MINUTE = 60L * 1000L;

    // public final static String DEFAULT_HTTP_SENSOR = "http://lmi92.cnam.fr:8999/ds2438/";

    /**
     * The constant DEFAULT_HTTP_SENSOR.
     */
    public final static String DEFAULT_HTTP_SENSOR = "http://localhost:8999/ds2438/";
    /**
     * l'URL associee au capteur
     */
    private String urlSensor;

    /**
     * Constructeur d'une connexion avec un Capteur, valeur par defaut
     */
    public HTTPSensor()
    {
        this(DEFAULT_HTTP_SENSOR);
    }

    /**
     * Constructeur d'une connexion avec un Capteur, syntaxe habituelle
     * http://site:port/
     *
     * @param urlSensor l'URL du capteur sur le Web en protocole HTTP
     */
    public HTTPSensor(String urlSensor)
    {
        this.urlSensor = urlSensor;
    }


    /**
     * Lecture de la valeur de humidite relative
     **/
    public float value() throws Exception
    {
        StringTokenizer st = new StringTokenizer(request(), "=");
        st.nextToken();

        float f = Float.parseFloat(st.nextToken()) * 10F;
        return ((int) f) / 10F;
    }

    public long minimalPeriod()
    {
        if (urlSensor.startsWith("http://localhost")) {
            return 500L; // a valider
        } else {
            return ONE_MINUTE;
        }
    }

    /**
     * lecture de l'URL
     *
     * @return l 'url associee a ce capteur
     */
    public String getUrl()
    {
        return this.urlSensor;
    }

    /**
     * Lecture des informations issues de ce capteur
     *
     * @param params les parametres
     * @return la totalite de la page lue
     * @throws Exception en cas d'erreur
     */
    public String request(Properties params) throws Exception
    {
        String parametres = new String("");
        for (Enumeration e = params.keys(); e.hasMoreElements(); ) {
            String key = (String) e.nextElement();
            String value = (String) params.get(key);
            parametres += key + "=" + value;
            if (e.hasMoreElements()) parametres += "&";
        }
        if (!parametres.equals("")) {
            urlSensor = urlSensor + "?" + parametres;
        }

        URL url = new URL(urlSensor);
        URLConnection connection = url.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String result = new String("");
        String inputLine = in.readLine();
        while (inputLine != null) {
            result = result + inputLine;
            inputLine = in.readLine();
        }
        in.close();
        return result;
    }

    /**
     * Lecture des informations issues de ce capteur
     *
     * @return la totalite de la page lue
     * @throws Exception en cas d'erreur
     */
    public String request() throws Exception
    {
        return request(new Properties());
    }


    /**
     * Mise en place du proxy si necessaire
     * rappel en wifi au Cnam : proxyHost=cache.cnam.fr proxyPort=3128
     * attention, aucune verification de la validite de l'URL transmise n'est effectuee
     *
     * @param proxyHost adresse du proxy
     * @param proxyPort le port du proxy
     */
    public static void setHttpProxy(String proxyHost, int proxyPort)
    {
        Properties prop = System.getProperties();
        prop.put("proxySet", "true");
        prop.put("http.proxyHost", proxyHost);
        prop.put("http.proxyPort", Integer.toString(proxyPort));
    }


    // bloc d'initialisation statique eventuel
    private static final boolean PROXY = false;

    static {
        if (PROXY) {
            setHttpProxy("cache.cnam.fr", 3128);
        }
    }
}

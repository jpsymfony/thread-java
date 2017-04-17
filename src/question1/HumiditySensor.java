package question1;

/**
 * Decrivez votre classe Humidity ici.
 *
 * @author SAULNIER
 * @version 12 -03-2017
 */
public abstract class HumiditySensor
{
    /**
     * valeur du capteur, precision de 0.1
     *
     * @return the float
     * @throws Exception the exception
     */
    public abstract float value() throws Exception;

    /**
     * Minimal period long.
     *
     * @return the long
     */
/* periode minimale entre deux lectures */
    public abstract long minimalPeriod();
}

package question2;

/**
 * Decrivez votre classe MaxHandler ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */

/**
 * Decrivez votre classe MinHandler ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */


public class MaxHandler extends Handler<Float>
{

    public MaxHandler(Handler<Float> successor)
    {
        super(successor);
    }

    public boolean handleRequest(Float value)
    {
        // a completer
        if (value >= 35.0F && value < 100.0F) {
            System.out.println("maximum...... ds2438.value : " + value);
            return true;
        }

        return super.handleRequest(value);
    }
}
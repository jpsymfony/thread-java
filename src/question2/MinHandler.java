package question2;

/**
 * Decrivez votre classe MinHandler ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */


public class MinHandler extends Handler<Float>
{

    public MinHandler(Handler<Float> successor)
    {
        super(successor);
    }

    public boolean handleRequest(Float value)
    {
        // a completer
        if (value < 35.0F) {
            System.out.println("minimum......ds2438.value : " + value);
            return true;
        }

        return super.handleRequest(value);
    }
}

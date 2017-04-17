package question2;

/**
 * Decrivez votre classe MinHandler ici.
 *
 * @author SAULNIER
 * @version 12 -03-2017
 */
public class MinHandler extends Handler<Float>
{
    /**
     * Instantiates a new Min handler.
     *
     * @param successor the successor
     */
    public MinHandler(Handler<Float> successor)
    {
        super(successor);
    }

    public boolean handleRequest(Float value)
    {
        if (value < 35.0F) {
            System.out.println("minimum......ds2438.value : " + value);
            return true;
        }

        return super.handleRequest(value);
    }
}

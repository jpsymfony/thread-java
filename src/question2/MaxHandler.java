package question2;

/**
 * Decrivez votre classe MaxHandler ici.
 *
 * @author SAULNIER
 * @version 12 -03-2017
 */
public class MaxHandler extends Handler<Float>
{
    /**
     * Instantiates a new Max handler.
     *
     * @param successor the successor
     */
    public MaxHandler(Handler<Float> successor)
    {
        super(successor);
    }

    public boolean handleRequest(Float value)
    {
        if (value >= 35.0F && value < 100.0F) {
            System.out.println("maximum...... ds2438.value : " + value);
            return true;
        }

        return super.handleRequest(value);
    }
}
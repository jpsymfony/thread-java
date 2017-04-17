package question1;

import java.util.Calendar;
import java.text.DateFormat;

/**
 * Decrivez votre classe ConsoleCommand ici.
 *
 * @param <T> the type parameter
 * @author SAULNIER
 * @version 12 -03-2017
 */
public class ConsoleCommand<T> implements Command<T>
{
    public void make(T f)
    {
        String date = DateFormat.getTimeInstance().format(Calendar.getInstance().getTime());
        System.out.println("[" + date + "] ds2438.value : " + f);
    }

}

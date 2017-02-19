package question1;

import java.util.Calendar;
import java.text.DateFormat;

/**
 * Decrivez votre classe ConsoleCommand ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */
public class ConsoleCommand<T> implements Command<T>
{

    public void make(T f)
    {
        String date = DateFormat.getTimeInstance().format(Calendar.getInstance().getTime());
        System.out.println("[" + date + "] ds2438.value : " + f);
    }

}

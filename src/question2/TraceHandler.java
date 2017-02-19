package question2;

import java.util.Calendar;
import java.text.DateFormat;
import java.util.Locale;

public class TraceHandler extends Handler<Float>
{

    public TraceHandler(Handler<Float> successor)
    {
        super(successor);
    }

    public boolean handleRequest(Float value)
    {
        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        DateFormat dt = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE);
        String date = df.format(c.getTime()) + "-" + dt.format(c.getTime());
        System.out.println("[" + date + "] ds2438.value : " + value);

        return super.handleRequest(value);
    }
}
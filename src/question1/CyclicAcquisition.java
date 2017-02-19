package question1;


public class CyclicAcquisition implements Runnable
{

    private Thread local;
    private Command<Float> command;

    private HumiditySensor sensor;
    private long period;

    public CyclicAcquisition(HumiditySensor sensor, long period, Command<Float> command) throws Exception
    {
        if (period < sensor.minimalPeriod()) {
            throw new Exception(" respectez la periode minimale ( >= " + sensor.minimalPeriod() + ") !!");
        }
        this.sensor = sensor;
        this.period = period;
        this.command = command;
        local = new Thread(this);
    }

    public void start()
    {
    /* demarrer le thread */
        // a completer
        local.start();
    }

    public void stop()
    {
    /* interrompre le thread */
        // a completer
        local.interrupt();
    }

    public synchronized void setPeriod(long period) throws Exception
    {
        if (period < sensor.minimalPeriod()) {
            throw new Exception(" respectez la periode minimale ( >= " + sensor.minimalPeriod() + ") !!");
        }
        this.period = period;
    }

    public void run()
    {
        try {
            while (!local.isInterrupted()) {
                synchronized (this) {
                    Long startMs = 0L;
                    Long endMs = 0L;
                    try {
       /* lecture du capteur et transmission de la valeur par make() */
                        startMs = System.currentTimeMillis();
                        // a completer
                        command.make(sensor.value());
                        endMs = System.currentTimeMillis();
                    } catch (Exception e) {
       /* transmission de -1 par make() */
                        // a completer
                        command.make(-1F);
                    }

                    Thread.sleep(period - (endMs - startMs));
                } // synchronized
            } // while
        } catch (InterruptedException ie) {
        } // catch
    } // run()
}
package question1;

/**
 * The type Cyclic acquisition.
 */
public class CyclicAcquisition implements Runnable
{
    private Thread local;
    private Command<Float> command;

    private HumiditySensor sensor;
    private long period;

    /**
     * Instantiates a new Cyclic acquisition.
     *
     * @param sensor  the sensor
     * @param period  the period
     * @param command the command
     * @throws Exception the exception
     */
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

    /**
     * Start.
     */
    public void start()
    {
    /* demarrer le thread */
        local.start();
    }

    /**
     * Stop.
     */
    public void stop()
    {
    /* interrompre le thread */
        local.interrupt();
    }

    /**
     * Sets period.
     *
     * @param period the period
     * @throws Exception the exception
     */
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
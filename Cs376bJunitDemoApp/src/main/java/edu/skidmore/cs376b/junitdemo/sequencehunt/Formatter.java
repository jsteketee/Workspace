package edu.skidmore.cs376b.junitdemo.sequencehunt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

/**
 * Provide formatting services.
 * @author David Read
 */
public final class Formatter
{
    /**
     * Logger
     */
    private final static Logger LOG = Logger.getLogger(Formatter.class);

    /**
     * Singleton instance.
     */
    private static Formatter formatter;

    /**
     * A formatter for time.
     */
    private SimpleDateFormat timerFormat;

    /**
     * Create a formatter - private since Singleton.
     */
    private Formatter()
    {
        timerFormat = new SimpleDateFormat("HH:mm:ss");
        timerFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /**
     * Get an instance of the formatter.
     * @return The formatter instance
     */
    public static synchronized Formatter getInstance()
    {
        if (formatter == null)
        {
            formatter = new Formatter();
        }
        return formatter;
    }

    /**
     * Obtain MS in hour:minute:second format.
     * @param milliseconds
     *            The number of milliseconds
     * @return The converted value
     */
    public String formatTimer(final long milliseconds)
    {
        Date tempDate;

        tempDate = new Date(milliseconds);

        LOG.debug("milliseconds [" + milliseconds + "] tempDate [" + tempDate + "] result["
        + timerFormat.format(tempDate) + "]");

        return timerFormat.format(tempDate);
    }
}
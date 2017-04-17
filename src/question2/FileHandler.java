package question2;

import java.io.*;
// import des classes de gestion des fichiers en ecriture
// import des classes de gestion des fichiers en lecture
// exceptions susceptibles d'etre engendrees lors d'une operation de lecture ou d'ecriture
// exception liee a la serialisation
import java.lang.ClassCastException;

/* a completer */
import java.util.*;
/* a completer */


import java.text.DateFormat;

// emploi de getResource (voir java.lang.Class)
import java.net.URL;

/**
 * The type File handler.
 */
public class FileHandler extends Handler<Float>
{
    private final static int MAX = 5;
    private String fileName;
    private int counter;

    private SortedMap<Date, Float> table;

    /**
     * Instantiates a new File handler.
     *
     * @param fileName  the file name
     * @param successor the successor
     */
    public FileHandler(String fileName, Handler<Float> successor)
    {
        super(successor);
        this.fileName = fileName;
        this.counter = 0;
        table = new TreeMap<>();
    }

    public boolean handleRequest(Float value)
    {
        Calendar c = Calendar.getInstance();
        counter = (counter + 1) % MAX;
        table.put(c.getTime(), value);

        if (counter == 0) {
            try {
                writeHTML();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.handleRequest(value);
    }

    /**
     * Cette methode genere un fichier HTML .
     */
    private void writeHTML() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter(fileName + ".html")));
        bw.write("<html><head><title>mesures du taux d'humidite relative</title>");
        bw.write("<meta http-equiv=\"refresh\" content=\"30\">");
        bw.write("</head><body><br>\r\n<table border=\"2\" bgcolor=\"#CBFEEA\">");
        bw.write("<tbody>");

        for (Map.Entry<Date, Float> entry : table.entrySet()) {
            bw.write("<tr>");

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
            DateFormat dt = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE);
            Date date = entry.getKey();

            bw.write("<td>");
            bw.write(df.format(date) + "-" + dt.format(date));
            bw.write("</td>\r\n");
            bw.write("<td>");
            bw.write(Float.toString(entry.getValue()));
            bw.write("</td>");
            bw.write("</tr>\r\n");
        }

        bw.write("</table>\r\n</body></html>");
        bw.close();
        bw.close();
    }
}

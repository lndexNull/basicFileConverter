import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CSVReader {
    public CSVReader() {
    }
private final String filename = "mitarbeiter.csv";
    public String[][] reader() throws IOException {

        InputStream stream = new BufferedInputStream(new FileInputStream(filename));

        try {

            int rowCount = countLinesNew();

            if (rowCount < 2){
                throw new Exception("File did not Contain minimum row count for it to be considered relevant");
            }

            String data = new BufferedReader(
                    new InputStreamReader(stream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            String[] dataSplit = data.split("\n");

            String[][] inhalt = new String[rowCount][];
            for(int i = 0; i < rowCount; i++){
                inhalt[i] = dataSplit[i].split(";");
            }

            System.out.println(rowCount+" rows have been read");
            return inhalt;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            stream.close();
        }
    }


    // credit: https://stackoverflow.com/a/453067
    private int countLinesNew() throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];

            int readChars = is.read(c);
            if (readChars == -1) {
                // bail out if nothing to read
                return 0;
            }

            // make it easy for the optimizer to tune this loop
            int count = 1;
            while (readChars == 1024) {
                for (int i=0; i<1024;) {
                    if (c[i++] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }

            // count remaining characters
            while (readChars != -1) {
                //System.out.println(readChars);
                for (int i=0; i<readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }

            return count == 0 ? 1 : count;
        }
        finally {
            is.close();
        }
    }
}

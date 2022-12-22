import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try{
            CSVReader csv = new CSVReader();
            JSONWriter json = new JSONWriter();

            System.out.println("the Program will now read the csv and convert it to a JSON.");
            json.writer(csv.reader());
            System.out.println("The Conversion Process should be finished.");
        }
        finally {
            System.out.println("This window will close in ~5 seconds");
            Thread.sleep(5000);
        }
    }
}

/*
    Vereinfachtes beispiel von einem Betrieb der eine Mitarbeiterliste in Form einer CSV
    in eine JSON umwandeln muss um diese z.B. an einen Importer, oder eine API zu senden.
    ^ Nur bezogen auf die Beispieldaten. Der Code an sich ist generisch und funktioniert mit allen möglichen csv Daten,
    solange diese immer die gleiche Spaltenanzahl haben und die erste Zeile die Spaltennamen beinhaltet.

    Da die input CSV alle möglichen Datentypen beinhalten kann,
    wird zur Vereinfachung im JSON immer ein <String, String> Key-Value-Pair stehen.

    Zu beachten ist, dass der CSV input mit Semikolon (;) die Spalten trennt,
    und dass in jeder Zeile die gleiche Anzahl an Spalten stehen.

    Die Reihenfolge der Objekte wird leider immer vom JSONArray im JSONWriter bestimmt.
    Selbst mit einer LinkedHashMap.
*/
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        try{
            CSVReader csv = new CSVReader();
            JSONWriter json = new JSONWriter();
            Editor editor = new Editor();

            System.out.println("the Program will now read the csv and convert it to a JSON.");
            String[][] data = csv.reader();

            if(data == null){
                throw new Exception("data was null");
            }

            System.out.println("Do you wish to alter the data? Y/N");
            String confirmation = sc.nextLine();

            if (confirmation.equals("y") || confirmation.equals("Y"))
            {
                data = editor.editSelector(data);
            }

            json.writer(data);
            System.out.println("\n\nThe Conversion Process should be finished.");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
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
    ^ Nur bezogen auf die Beispieldaten. Der Code an sich ist generisch genug um 2-Dimensionale 
    Datenstrukturen aus CSVs in JSON umzuwandeln,
    solange diese in jeder Zeile die gleiche Spaltenanzahl haben und die erste Zeile die Spaltennamen beinhaltet.

    Da die input CSV alle möglichen Datentypen beinhalten kann,
    wird zur Vereinfachung im JSON immer ein <String, String> Key-Value-Pair stehen.

    Zu beachten ist, dass der CSV input mit Semikolon (;) die Spalten trennt,
    und dass in jeder Zeile die gleiche Anzahl an Spalten stehen.


    !!! getestet unter linux !!!
    evtl. muss die mitarbeiter.csv ausserhalb vom src ordner liegen.
*/
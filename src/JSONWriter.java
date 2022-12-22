import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;

public class JSONWriter {
    public JSONWriter() {
    }

    public void writer(String[][] content){
        try{
            String jsonString = "[";
            for (int i = 1; i < content.length; i++){

                if(i > 1){
                    jsonString += ",";
                }
                jsonString += "{";
                
                for (int j = 0; j < content[0].length; j++){

                    if(j > 0){
                        jsonString += ",";
                    }
                    jsonString += MessageFormat.format("\"{0}\":\"{1}\"", content[0][j], content[i][j]);
                }
                jsonString += "}";
            }
            jsonString += "]";

            byte[] writeContent = jsonString.getBytes();
            Files.write(Paths.get("mitarbeiter.json"), writeContent);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
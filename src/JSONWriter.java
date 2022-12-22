import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JSONWriter {
    public JSONWriter() {
    }

    public void writer(String[][] content){
        try{
            JSONArray jsonArray = new JSONArray();
            for (int i = 1; i < content.length; i++){
                Map<String, String> map = new HashMap<>();
                for (int j = 0; j < content[0].length; j++){
                    map.put(content[0][j], content[i][j]);
                }
                jsonArray.put(map);
                map.clear();
            }
            byte[] writeContent = jsonArray.toString().getBytes();
            Files.write(Paths.get("mitarbeiter.json"), writeContent);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
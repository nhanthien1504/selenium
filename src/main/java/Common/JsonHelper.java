package Common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class JsonHelper {
//    private static JsonReader getJsonReader(String url){
//        try{
//            JsonReader data = new JsonReader(new FileReader(Utilities.jsonProjectPath()));
//            return data;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }
//
//    public static JsonObject getJsonObject(String jsonFilePath){
//        try {
//            JsonObject obj = new JsonObject();
//            Gson gson = new Gson();
//            JsonReader reader = getJsonReader(jsonFilePath);
//            obj = gson.fromJson(reader, JsonObject.class);
//            return obj;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    }

    public static JsonObject getJsonObject(String jsonProjectPath) {
        try {
            JsonObject obj;
            Gson gson = new Gson();
            JsonReader reader = getJsonReader(jsonProjectPath);
            obj = gson.fromJson(reader, JsonObject.class);
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private static JsonReader getJsonReader(String jsonProjectPath) {
        try {
            JsonReader reader;
            reader = new JsonReader(new FileReader(jsonProjectPath));
            return reader;
        } catch (FileNotFoundException e) {
            return null;
        }
    }


}

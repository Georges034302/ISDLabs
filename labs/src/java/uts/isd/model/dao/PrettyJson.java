package uts.isd.model.dao;

/**
 *
 * @author George
 */
import org.bson.Document;
import org.json.*;

public class PrettyJson {
    public static void printJSON(Document obj) {
        JSONObject jsonObject = new JSONObject(obj);
        String prettyJson = jsonObject.toString(4);
        System.out.println(prettyJson);
    }
}

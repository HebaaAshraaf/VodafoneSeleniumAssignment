package readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    private JSONParser parser;
    private JSONArray jarray;
    private String[][] arrayJSONData;
    private Integer i;

    public JSONReader() {
        parser = new JSONParser();
    }

    public Object[][] registerDataReader() {
        File srcFile = new File("src/main/resources/testdata/registerdata.json");
        jarray = null;
        i = 0;
        try {
            jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        } catch (org.json.simple.parser.ParseException e) {
            exceptions.ExceptionsMessages.JSONParseMsg(e);
        } catch (FileNotFoundException e) {
            exceptions.ExceptionsMessages.FileNotFoundMsg(e);
        } catch (IOException e) {
            exceptions.ExceptionsMessages.IOMsg(e);
        }
        arrayJSONData = new String[jarray.size()][10];
        for (Object jsonObj : jarray) {
            JSONObject searchData = (JSONObject) jsonObj;
            arrayJSONData[i][0] = (String) searchData.get("firstName");
            arrayJSONData[i][1] = (String) searchData.get("lastName");
            arrayJSONData[i][2] = (String) searchData.get("email");
            arrayJSONData[i][3] = (String) searchData.get("passwd");
            arrayJSONData[i][4] = (String) searchData.get("firstAddress");
            arrayJSONData[i][5] = (String) searchData.get("city");
            arrayJSONData[i][6] = (String) searchData.get("postcode");
            arrayJSONData[i][7] = (String) searchData.get("country");
            arrayJSONData[i][8] = (String) searchData.get("state");
            arrayJSONData[i][9] = (String) searchData.get("phone_mobile");
            i++;
        }
        return arrayJSONData;
    }

    public Object[][] signInDataReader() {
        File srcFile = new File("src/main/resources/testdata/signindata.json");
        jarray = null;
        i = 0;
        try {
            jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        } catch (org.json.simple.parser.ParseException e) {
            exceptions.ExceptionsMessages.JSONParseMsg(e);
        } catch (FileNotFoundException e) {
            exceptions.ExceptionsMessages.FileNotFoundMsg(e);
        } catch (IOException e) {
            exceptions.ExceptionsMessages.IOMsg(e);
        }
        arrayJSONData = new String[jarray.size()][2];
        for (Object jsonObj : jarray) {
            JSONObject searchData = (JSONObject) jsonObj;
            arrayJSONData[i][0] = (String) searchData.get("email");
            arrayJSONData[i][1] = (String) searchData.get("passwd");
            i++;
        }
        return arrayJSONData;
    }
}

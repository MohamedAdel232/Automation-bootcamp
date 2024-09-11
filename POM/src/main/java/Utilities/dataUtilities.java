package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class dataUtilities
{
    private static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    //TODO: Read from json file
    public static String readDataFromJsonFile (String fileName, String field) throws FileNotFoundException
    {
        FileReader fileReader = new FileReader(TEST_DATA_PATH + fileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }

    //TODO: Read from properties file
    public static String readDataFromProperties (String fileName, String key) throws IOException
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH + fileName + ".properties"));
        return properties.getProperty(key);
    }


}

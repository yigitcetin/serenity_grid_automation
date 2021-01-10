package utils.testdata;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LoadTestData {
    public static TestData testData = new TestData();

    static {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            InputStream dataFile = LoadTestData.class.getClassLoader()
                    .getResourceAsStream("testdata/TestData.yaml");
            testData = mapper.readValue(dataFile, TestData.class);
        } catch (FileNotFoundException | JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

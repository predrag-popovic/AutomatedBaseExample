package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    // Properties file
    private Properties prop = new Properties();

    /**
     * ctor
     */
    public PropertiesFile(){

        try {
            String executionPath = System.getProperty("user.dir");
            System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
            InputStream input = new FileInputStream(executionPath + "/src/test/java/config/config.properties");
            prop.load(input);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * Get property value by key
     * @param key
     * @return
     */
    public String getPropertyValue(PropertyKey key){

        return prop.getProperty(key.toString());
    }

    /***
     * Defining PropertyKey
     */
    public enum PropertyKey {

        TEST_ENV_URL("test.env.url"),
        TEST_ENV_OS("test.env.os"),
        TEST_ENV_BROWSER("test.env.browser"),
        ENVIRONMENT("test.environment"),
        USERNAME("credentials.username"),
        PASSWORD("credentials.password"),
        EMAIL_ADDRESS_SET_FROM("mail.address.set.from"),
        EMAIL_ADDRESS_SET_TO("mail.address.set.to"),
        EMAIL_USERNAME("credentials.mail.username"),
        EMAIL_PASSWORD("credentials.mail.password");

        String value;

        PropertyKey(String value){
            this.value = value;
        }

        public String toString(){
            return value;
        }
    }
}

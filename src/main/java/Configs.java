import java.io.InputStream;
import java.util.Properties;

    public class Configs {
        private Properties props;
        private InputStream file;

        public Configs() {
            try {
                file = getClass().getClassLoader().getResourceAsStream("config.properties");
                props = new Properties();
                props.load(file);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public String getBaseURI() {
            return props.getProperty("BaseURI");
        }

        public void close() {
            try {
                file.close();
            } catch (Exception e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }


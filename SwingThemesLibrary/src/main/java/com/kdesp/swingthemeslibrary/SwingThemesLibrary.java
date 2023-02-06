package com.kdesp.swingthemeslibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

public class SwingThemesLibrary {

        public static void main(String[] args) throws IOException {
                System.out.println(getValue("button").toString());
        }

        public static Map<String, Object> getYamlData(String fileDirectory) {
                InputStream inputStream = null;
                try {
                        inputStream = new FileInputStream(new File(fileDirectory));
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(SwingThemesLibrary.class.getName()).log(Level.SEVERE, null, ex);
                }

                Yaml yaml = new Yaml();
                Map<String, Object> data = yaml.load(inputStream);
                return data;
        }
        
        public static Object getValue(String key) throws IOException{
                Map<String, Object> data = getYamlData(new java.io.File(".").getCanonicalPath() + "\\src\\main\\java\\com\\kdesp\\swingthemeslibrary\\" + "theme.yml");
                return data.get(key);
        }
}

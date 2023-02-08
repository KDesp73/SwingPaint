/*
*
* MIT License
*
* Copyright (c) 2023 Konstantinos Despoinidis
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
* 
*/

package kdesp73.themeLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author KDesp73
 */
public class YamlFile {
        private String directory;
        private Map<String, Object> contents;
        
        /**
         * @param directory Directory where the YAML file is located
         */
        public YamlFile(String directory) {
                this.directory = directory;
                this.contents = getYamlData(directory);
        }

        private static Map<String, Object> getYamlData(String fileDirectory) {
                InputStream inputStream = null;
                try {
                        inputStream = new FileInputStream(new File(fileDirectory));
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(YamlFile.class.getName()).log(Level.SEVERE, null, ex);
                }

                Yaml yaml = new Yaml();
                Map<String, Object> data = yaml.load(inputStream);
                return data;
        }
        
        /**
         * Get a specific value from the YAML file using a key
         * 
         * @param key Key to search for matching value
         * @return Value that matches the input key
         * @throws IOException
         * @throws KeyNotFoundException 
         */
        public Object getValue(String key) throws IOException, KeyNotFoundException{
                if(contents.get(key) == null) throw new KeyNotFoundException("Key Not Found");
                return contents.get(key);
        }

        public String getDirectory() {
                return directory;
        }

        public Map<String, Object> getContents() {
                return contents;
        }

        @Override
        public String toString() {
                return "YamlFile{" + "directory=" + directory + ", contents=" + contents + '}';
        }

        
}

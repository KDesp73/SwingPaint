package com.kdesp.swingthemeslibrary;

import java.io.IOException;

public class SwingThemesLibrary {

        public static void main(String[] args) throws IOException {
                String dir = new java.io.File(".").getCanonicalPath() + "\\src\\main\\java\\com\\kdesp\\swingthemeslibrary\\" + "sample_theme.yml";
                YamlFile yf = new YamlFile(dir);
                Theme t = new Theme();
                
                
                
                System.out.println(t);
                
                
                

        }

}

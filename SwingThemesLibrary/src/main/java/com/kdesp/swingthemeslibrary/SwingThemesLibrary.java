package com.kdesp.swingthemeslibrary;

import java.io.IOException;

public class SwingThemesLibrary {

        public static void main(String[] args) throws IOException {
                String dir = new java.io.File(".").getCanonicalPath() + "\\src\\main\\java\\com\\kdesp\\swingthemeslibrary\\" + "theme.yml";
                YamlFile yf = new YamlFile(dir);
                
                Theme t = new Theme("Default", yf);
                
                System.out.println(t);
                
                t.generateJson();
                System.out.println(t.getJson());
                
                Theme t1 = new Theme("New Theme", t.getJson());
                System.out.println(t1);
        }
        
        
}

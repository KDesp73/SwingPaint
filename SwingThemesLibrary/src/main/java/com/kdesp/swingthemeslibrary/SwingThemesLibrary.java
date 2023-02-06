package com.kdesp.swingthemeslibrary;

import java.io.IOException;

public class SwingThemesLibrary {

        public static void main(String[] args) throws IOException {
                String dir = new java.io.File(".").getCanonicalPath() + "\\src\\main\\java\\com\\kdesp\\swingthemeslibrary\\" + "sample_theme.yml";
                YamlFile yf = new YamlFile(dir);

                Theme t = new Theme();

                t.parseJson("{\"fg\":\"000000\",\"scrollbar\":\"000000\",\"textbox\":\"000000\",\"bg\":\"000000\",\"progress_bar\":\"000000\",\"list\":\"000000\",\"extra_1\":\"000001\",\"extra_2\":\"000002\",\"extra_0\":\"000000\",\"textbox_fg\":\"000000\",\"extra_5\":\"000005\",\"btn_fg\":\"000000\",\"extra_6\":\"000006\",\"bg_2\":\"000000\",\"extra_3\":\"000003\",\"extra_4\":\"000004\",\"name\":\"Sample Theme\",\"extra_9\":\"000009\",\"list_fg\":\"000000\",\"extra_7\":\"000007\",\"fg_2\":\"000000\",\"extra_8\":\"000008\",\"btn\":\"000000\"}");
                
                System.out.println(t);
                
                t.setYaml(t.generateYaml(yf));
                
                System.out.println(t);
                
                
                

        }

}

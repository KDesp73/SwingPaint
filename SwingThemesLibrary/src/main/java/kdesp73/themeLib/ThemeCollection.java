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

import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JList;

/**
 *
 * @author KDesp73
 */
public class ThemeCollection {

        private ArrayList<Theme> themes = new ArrayList<>();

        public ThemeCollection() {

        }

        public static void implementTheme(Component component, Theme theme) {
                String name = component.getName();

                try {
                        switch (name) {
                                case "null.glassPane":
                                        break;
                                case "null.layeredPane":
                                        break;
                                case "null.contentPane":
                                        break;
                                case "bg":
                                        component.setBackground(theme.getBg());
                                        break;
                                case "bg_2":
                                        component.setBackground(theme.getBg_2());
                                        break;
                                case "fg":
                                        component.setForeground(theme.getFg());
                                        break;
                                case "fg_2":
                                        component.setForeground(theme.getFg_2());
                                        break;
                                case "btn":
                                        component.setBackground(theme.getBtn());
                                        component.setForeground(theme.getBtn_fg());
                                        break;
                                case "textbox":
                                        component.setBackground(theme.getTextbox());
                                        component.setForeground(theme.getTextbox_fg());
                                        break;
                                case "list":
                                        if (component instanceof JList jList) {
                                                jList.setBackground(theme.getList());
                                                jList.setForeground(theme.getList_fg());
                                                jList.setSelectionBackground(theme.getList_focus());
                                        }
                                        break;
                                case "scrollbar":
                                        component.setBackground(theme.getBg());
                                case "progress_bar":
                                        component.setBackground(theme.getProgress_bar());
                                        break;
                                case "extra_0":
                                        component.setBackground(theme.getExtras()[0]);
                                        break;
                                case "extra_1":
                                        component.setBackground(theme.getExtras()[1]);
                                        break;
                                case "extra_2":
                                        component.setBackground(theme.getExtras()[2]);
                                        break;
                                case "extra_3":
                                        component.setBackground(theme.getExtras()[3]);
                                        break;
                                case "extra_4":
                                        component.setBackground(theme.getExtras()[4]);
                                        break;
                                case "extra_5":
                                        component.setBackground(theme.getExtras()[5]);
                                        break;
                                case "extra_6":
                                        component.setBackground(theme.getExtras()[6]);
                                        break;
                                case "extra_7":
                                        component.setBackground(theme.getExtras()[7]);
                                        break;
                                case "extra_8":
                                        component.setBackground(theme.getExtras()[8]);
                                        break;
                                case "extra_9":
                                        component.setBackground(theme.getExtras()[9]);
                                        break;
                                default:
                                        break;
                        }
                } catch (NullPointerException e) {
                        //System.out.println("Null name");
                }

                //Recurse through every component
                if (component instanceof Container container) {
                        for (Component child : container.getComponents()) {
                                implementTheme(child, theme);
                        }
                }
        }

        public void addTheme(Theme theme) {
                themes.add(theme);
        }

        public void loadThemes(File folder_dir) {
                themes.clear();
                ArrayList<String> yamlFiles = Utils.listFiles(folder_dir);

                for (int i = 0; i < yamlFiles.size(); i++) {
                        System.out.println(folder_dir.getPath() + yamlFiles.get(i));
                        Theme newTheme = new Theme(new YamlFile(folder_dir.getPath() + "\\" + yamlFiles.get(i)));
                        themes.add(newTheme);
                }
        }

        public void loadThemes(String[] jsons) {
                themes.clear();
                for (String json : jsons) {
                        Theme newTheme = new Theme(new JsonString(json));
                        themes.add(newTheme);
                }
        }

        public void clear() {
                themes.clear();
        }

        private class Utils {

                private static ArrayList<String> listFiles(final File folder) {
                        ArrayList<String> arr = new ArrayList<>();
                        for (final File fileEntry : folder.listFiles()) {
                                if (fileEntry.isDirectory()) {
                                        listFiles(fileEntry);
                                } else {
                                        arr.add(fileEntry.getName());
                                }
                        }
                        return arr;
                }
        }

        public ArrayList<Theme> getThemes() {
                return themes;
        }

        public void setThemes(ArrayList<Theme> themes) {
                this.themes = themes;
        }

        @Override
        public String toString() {
                String s = "";
                
                s = s + "Themes{";
                for (int i = 0; i < themes.size(); i++) {
                        s = s + themes.get(i);
                        s = s + "\n";
                }
                s = s + "}";
                
                return s;
        }

}

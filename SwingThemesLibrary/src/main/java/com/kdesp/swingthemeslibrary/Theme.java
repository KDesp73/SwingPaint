/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kdesp.swingthemeslibrary;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Konstantinos
 */
public class Theme {

        private String name;
        private String json;
        private YamlFile yaml;

        private Color bg;
        private Color bg_2;
        private Color fg;
        private Color fg_2;
        private Color btn;
        private Color btn_fg;
        private Color textbox;
        private Color textbox_fg;
        private Color list;
        private Color list_fg;
        private Color scrollbar;
        private Color progress_bar;
        private Color extra_0;
        private Color extra_1;
        private Color extra_2;
        private Color extra_3;
        private Color extra_4;
        private Color extra_5;
        private Color extra_6;
        private Color extra_7;
        private Color extra_8;
        private Color extra_9;
        private Color[] extras;

        public Theme(String name, String json) {
                this.name = name;
                this.json = json;

                //Parse json into theme
                parseJson(json);
        }

        public Theme(String name, YamlFile yaml) {
                this.name = name;
                this.yaml = yaml;

                try {
                        //Parse yaml into theme
                        parseYaml(yaml);
                } catch (KeyNotFoundException | IOException ex) {
                        Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public Theme(String name) {
                this.name = name;
        }

        public Theme() {
        }

        private void parseYaml(YamlFile yaml) throws KeyNotFoundException, IOException {
                bg = Utils.hexToColor(yaml.getValue("bg").toString());
                bg_2 = Utils.hexToColor(yaml.getValue("bg_2").toString());
                fg = Utils.hexToColor(yaml.getValue("fg").toString());
                fg_2 = Utils.hexToColor(yaml.getValue("fg_2").toString());
                btn = Utils.hexToColor(yaml.getValue("btn").toString());
                btn_fg = Utils.hexToColor(yaml.getValue("btn_fg").toString());
                textbox = Utils.hexToColor(yaml.getValue("textbox").toString());
                textbox_fg = Utils.hexToColor(yaml.getValue("textbox_fg").toString());
                list = Utils.hexToColor(yaml.getValue("list").toString());
                list_fg = Utils.hexToColor(yaml.getValue("list_fg").toString());
                scrollbar = Utils.hexToColor(yaml.getValue("scrollbar").toString());
                progress_bar = Utils.hexToColor(yaml.getValue("progress_bar").toString());
                extra_0 = Utils.hexToColor(yaml.getValue("extra_0").toString());
                extra_1 = Utils.hexToColor(yaml.getValue("extra_1").toString());
                extra_2 = Utils.hexToColor(yaml.getValue("extra_2").toString());
                extra_3 = Utils.hexToColor(yaml.getValue("extra_3").toString());
                extra_4 = Utils.hexToColor(yaml.getValue("extra_4").toString());
                extra_5 = Utils.hexToColor(yaml.getValue("extra_5").toString());
                extra_6 = Utils.hexToColor(yaml.getValue("extra_6").toString());
                extra_7 = Utils.hexToColor(yaml.getValue("extra_7").toString());
                extra_8 = Utils.hexToColor(yaml.getValue("extra_8").toString());
                extra_9 = Utils.hexToColor(yaml.getValue("extra_9").toString());

                extras = new Color[]{extra_0, extra_1, extra_2, extra_3, extra_4, extra_5, extra_6, extra_7, extra_8, extra_9};
        }

        private void parseJson(String json) {
                json = json.replaceAll(",", ", ");

                bg = Utils.hexToColor(Utils.getJsonValue(json, "bg").replaceAll("\"", ""));
                fg = Utils.hexToColor(Utils.getJsonValue(json, "fg").replaceAll("\"", ""));
                bg_2 = Utils.hexToColor(Utils.getJsonValue(json, "bg_2").replaceAll("\"", ""));
                fg_2 = Utils.hexToColor(Utils.getJsonValue(json, "fg_2").replaceAll("\"", ""));
                btn = Utils.hexToColor(Utils.getJsonValue(json, "btn").replaceAll("\"", ""));
                btn_fg = Utils.hexToColor(Utils.getJsonValue(json, "btn_fg").replaceAll("\"", ""));
                textbox = Utils.hexToColor(Utils.getJsonValue(json, "textbox").replaceAll("\"", ""));
                textbox_fg = Utils.hexToColor(Utils.getJsonValue(json, "textbox_fg").replaceAll("\"", ""));
                list = Utils.hexToColor(Utils.getJsonValue(json, "list").replaceAll("\"", ""));
                list_fg = Utils.hexToColor(Utils.getJsonValue(json, "list_fg").replaceAll("\"", ""));
                scrollbar = Utils.hexToColor(Utils.getJsonValue(json, "scrollbar").replaceAll("\"", ""));
                progress_bar = Utils.hexToColor(Utils.getJsonValue(json, "progress_bar").replaceAll("\"", ""));
                extra_0 = Utils.hexToColor(Utils.getJsonValue(json, "extra_0").replaceAll("\"", ""));
                extra_1 = Utils.hexToColor(Utils.getJsonValue(json, "extra_1").replaceAll("\"", ""));
                extra_2 = Utils.hexToColor(Utils.getJsonValue(json, "extra_2").replaceAll("\"", ""));
                extra_3 = Utils.hexToColor(Utils.getJsonValue(json, "extra_3").replaceAll("\"", ""));
                extra_4 = Utils.hexToColor(Utils.getJsonValue(json, "extra_4").replaceAll("\"", ""));
                extra_5 = Utils.hexToColor(Utils.getJsonValue(json, "extra_5").replaceAll("\"", ""));
                extra_6 = Utils.hexToColor(Utils.getJsonValue(json, "extra_6").replaceAll("\"", ""));
                extra_7 = Utils.hexToColor(Utils.getJsonValue(json, "extra_7").replaceAll("\"", ""));
                extra_8 = Utils.hexToColor(Utils.getJsonValue(json, "extra_8").replaceAll("\"", ""));
                extra_9 = Utils.hexToColor(Utils.getJsonValue(json, "extra_9").replaceAll("\"", ""));

                extras = new Color[]{extra_0, extra_1, extra_2, extra_3, extra_4, extra_5, extra_6, extra_7, extra_8, extra_9};

                this.json = json;
        }

        public String generateJson() {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("bg", Utils.ColorToHex(bg));
                jsonObject.put("fg", Utils.ColorToHex(fg));
                jsonObject.put("bg_2", Utils.ColorToHex(bg_2));
                jsonObject.put("fg_2", Utils.ColorToHex(fg_2));
                jsonObject.put("btn", Utils.ColorToHex(btn));
                jsonObject.put("btn_fg", Utils.ColorToHex(btn_fg));
                jsonObject.put("textbox", Utils.ColorToHex(textbox));
                jsonObject.put("textbox_fg", Utils.ColorToHex(textbox_fg));
                jsonObject.put("list", Utils.ColorToHex(list));
                jsonObject.put("list_fg", Utils.ColorToHex(list_fg));
                jsonObject.put("scrollbar", Utils.ColorToHex(scrollbar));
                jsonObject.put("progress_bar", Utils.ColorToHex(progress_bar));
                jsonObject.put("extra_0", Utils.ColorToHex(extra_0));
                jsonObject.put("extra_1", Utils.ColorToHex(extra_1));
                jsonObject.put("extra_2", Utils.ColorToHex(extra_2));
                jsonObject.put("extra_3", Utils.ColorToHex(extra_3));
                jsonObject.put("extra_4", Utils.ColorToHex(extra_4));
                jsonObject.put("extra_5", Utils.ColorToHex(extra_5));
                jsonObject.put("extra_6", Utils.ColorToHex(extra_6));
                jsonObject.put("extra_7", Utils.ColorToHex(extra_7));
                jsonObject.put("extra_8", Utils.ColorToHex(extra_8));
                jsonObject.put("extra_9", Utils.ColorToHex(extra_9));

                json =  jsonObject.toString();
                return json;
        }

        private class Utils {

                static Color hexToColor(String hex) {
                        hex = "#" + hex;
                        return Color.decode(hex);
                }

                static String ColorToHex(Color c) {
                        return String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
                }

                static String getJsonValue(String JsonString, String tag) {
                        tag = "\"" + tag + "\"";
                        int tagIndex = JsonString.indexOf(tag);
//                System.out.println("Tag index: " + tagIndex);
                        if (tagIndex == -1) {
                                return null;
                        }

                        int begin = tagIndex + tag.length() + 2; // "+2" For space and comma
                        int end = JsonString.indexOf(',', begin);

                        if (end == -1) {
                                end = JsonString.indexOf('}', begin);
                        }

                        String value = JsonString.substring(begin, end);
                        return value.replaceAll("\\]", "").replaceAll("\\[", "").replaceAll("\\}", "").replaceAll("\n", "").strip();
                }

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getJson() {
                return json;
        }

        public void setJson(String json) {
                this.json = json;
        }

        public YamlFile getYaml() {
                return yaml;
        }

        public void setYaml(YamlFile yaml) {
                this.yaml = yaml;
        }

        public Color getBg() {
                return bg;
        }

        public void setBg(Color bg) {
                this.bg = bg;
        }

        public Color getBg_2() {
                return bg_2;
        }

        public void setBg_2(Color bg_2) {
                this.bg_2 = bg_2;
        }

        public Color getFg() {
                return fg;
        }

        public void setFg(Color fg) {
                this.fg = fg;
        }

        public Color getFg_2() {
                return fg_2;
        }

        public void setFg_2(Color fg_2) {
                this.fg_2 = fg_2;
        }

        public Color getBtn() {
                return btn;
        }

        public void setBtn(Color btn) {
                this.btn = btn;
        }

        public Color getBtn_fg() {
                return btn_fg;
        }

        public void setBtn_fg(Color btn_fg) {
                this.btn_fg = btn_fg;
        }

        public Color getTextbox() {
                return textbox;
        }

        public void setTextbox(Color textbox) {
                this.textbox = textbox;
        }

        public Color getTextbox_fg() {
                return textbox_fg;
        }

        public void setTextbox_fg(Color textbox_fg) {
                this.textbox_fg = textbox_fg;
        }

        public Color getList() {
                return list;
        }

        public void setList(Color list) {
                this.list = list;
        }

        public Color getList_fg() {
                return list_fg;
        }

        public void setList_fg(Color list_fg) {
                this.list_fg = list_fg;
        }

        public Color getScrollbar() {
                return scrollbar;
        }

        public void setScrollbar(Color scrollbar) {
                this.scrollbar = scrollbar;
        }

        public Color getProgress_bar() {
                return progress_bar;
        }

        public void setProgress_bar(Color progress_bar) {
                this.progress_bar = progress_bar;
        }

        public Color getExtra_0() {
                return extra_0;
        }

        public void setExtra_0(Color extra_0) {
                this.extra_0 = extra_0;
        }

        public Color getExtra_1() {
                return extra_1;
        }

        public void setExtra_1(Color extra_1) {
                this.extra_1 = extra_1;
        }

        public Color getExtra_2() {
                return extra_2;
        }

        public void setExtra_2(Color extra_2) {
                this.extra_2 = extra_2;
        }

        public Color getExtra_3() {
                return extra_3;
        }

        public void setExtra_3(Color extra_3) {
                this.extra_3 = extra_3;
        }

        public Color getExtra_4() {
                return extra_4;
        }

        public void setExtra_4(Color extra_4) {
                this.extra_4 = extra_4;
        }

        public Color getExtra_5() {
                return extra_5;
        }

        public void setExtra_5(Color extra_5) {
                this.extra_5 = extra_5;
        }

        public Color getExtra_6() {
                return extra_6;
        }

        public void setExtra_6(Color extra_6) {
                this.extra_6 = extra_6;
        }

        public Color getExtra_7() {
                return extra_7;
        }

        public void setExtra_7(Color extra_7) {
                this.extra_7 = extra_7;
        }

        public Color getExtra_8() {
                return extra_8;
        }

        public void setExtra_8(Color extra_8) {
                this.extra_8 = extra_8;
        }

        public Color getExtra_9() {
                return extra_9;
        }

        public void setExtra_9(Color extra_9) {
                this.extra_9 = extra_9;
        }

        public Color[] getExtras() {
                return extras;
        }

        public void setExtras(Color[] extras) {
                this.extras = extras;
        }

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Theme{");
                sb.append("name=").append(name);
                sb.append(", bg=").append(Utils.ColorToHex(bg));
                sb.append(", bg_2=").append(Utils.ColorToHex(bg_2));
                sb.append(", fg=").append(Utils.ColorToHex(fg));
                sb.append(", fg_2=").append(Utils.ColorToHex(fg_2));
                sb.append(", btn=").append(Utils.ColorToHex(btn));
                sb.append(", btn_fg=").append(Utils.ColorToHex(btn_fg));
                sb.append(", textbox=").append(Utils.ColorToHex(textbox));
                sb.append(", textbox_fg=").append(Utils.ColorToHex(textbox_fg));
                sb.append(", list=").append(Utils.ColorToHex(list));
                sb.append(", list_fg=").append(Utils.ColorToHex(list_fg));
                sb.append(", scrollbar=").append(Utils.ColorToHex(scrollbar));
                sb.append(", progress_bar=").append(Utils.ColorToHex(progress_bar));
                sb.append(", extra_0=").append(Utils.ColorToHex(extra_0));
                sb.append(", extra_1=").append(Utils.ColorToHex(extra_1));
                sb.append(", extra_2=").append(Utils.ColorToHex(extra_2));
                sb.append(", extra_3=").append(Utils.ColorToHex(extra_3));
                sb.append(", extra_4=").append(Utils.ColorToHex(extra_4));
                sb.append(", extra_5=").append(Utils.ColorToHex(extra_5));
                sb.append(", extra_6=").append(Utils.ColorToHex(extra_6));
                sb.append(", extra_7=").append(Utils.ColorToHex(extra_7));
                sb.append(", extra_8=").append(Utils.ColorToHex(extra_8));
                sb.append(", extra_9=").append(Utils.ColorToHex(extra_9));
                sb.append('}');
                return sb.toString();
        }

}

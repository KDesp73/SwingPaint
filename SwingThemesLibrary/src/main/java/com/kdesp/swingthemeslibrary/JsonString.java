/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kdesp.swingthemeslibrary;

/**
 *
 * @author Konstantinos
 */
public class JsonString {
        private String json;
        
        public JsonString(){
        }
        
        public JsonString(String json){
                this.json = json;
        }

        public String getJson() {
                return json;
        }

        public void setJson(String json) {
                this.json = json;
        }

        @Override
        public String toString() {
                return "JsonString{" + "json=" + json + '}';
        }
        
        
}

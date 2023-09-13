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

/**
 *
 * @author KDesp73
 */
public class JsonString {
	private String json;

	public JsonString() {
	}

	public JsonString(String json) {
		this.json = json;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getJsonValue(String tag) {
		String JsonString = this.json;

		tag = "\"" + tag + "\"";
		int tagIndex = JsonString.indexOf(tag);

		if (tagIndex == -1) {
			return null;
		}

		int begin = tagIndex + tag.length() + 2; // "+2" For space and comma
		int end = JsonString.indexOf(',', begin);

		if (end == -1) {
			end = JsonString.indexOf('}', begin);
		}

		String value = JsonString.substring(begin, end);
		return value.replaceAll("\\]", "").replaceAll("\\[", "").replaceAll("\\}", "")
				.replaceAll("\n", "").strip();
	}

	@Override
	public String toString() {
		return "JsonString{" + "json=" + json + '}';
	}

}

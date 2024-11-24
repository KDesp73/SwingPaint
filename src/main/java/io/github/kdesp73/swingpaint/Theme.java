package io.github.kdesp73.swingpaint;

import io.github.kdesp73.swingpaint.painters.GlobalPainter;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Theme {

	private final Properties properties;

	public enum ColorProperty {
		HEADER_BG("header.bg"),
		HEADER_FG("header.fg"),
		BG("bg"),
		BORDER_COLOR("border.color"),
		BORDER_THICKNESS("border.thickness"),
		CARET_COLOR("caret.color"),
		DISABLED("disabled"),
		DIVIDER_COLOR("divider.color"),
		FG("fg"),
		FONT_COLOR("font.color"),
		HIGHLIGHT("highlight"),
		ICON_COLOR("icon.color"),
		POPUP_BG("popup.bg"),
		POPUP_FG("popup.fg"),
		TEXTFIELD_BG("textfield.bg"),
		TEXTFIELD_FG("textfield.fg"),
		BUTTON_BG("button.bg"),
		HORIZONTAL_THUMB("horizontal.thumb"),
		HORIZONTAL_TRACK("horizontal.track"),
		VERTICAL_THUMB("vertical.thumb"),
		VERTICAL_TRACK("vertical.track"),
		THUMB("thumb"),
		TRACK("track"),
		TICK("tick"),
		SELECTED("selected"),
		SELECTED_BG("selection.bg"),
		SELECTED_FG("selection.fg"),
		TAB_BG("tab.bg"),
		TAB_FG("tab.fg"),
		TITLE_BG("title.bg"),
		TITLE_FG("title.fg"),
		PLACEHOLDER_COLOR("placeholder.color"),
		UNSELECTED("unselected");

		private final String name;

		ColorProperty(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return name;
		}

		/**
		 * A helper method to check if a given property name exists within the enum.
		 *
		 * @param name The property name to check.
		 * @return True if the name is a valid color property, false otherwise.
		 */
		public static boolean isValidProperty(String name) {
			for (ColorProperty property : ColorProperty.values()) {
				if (property.name.equalsIgnoreCase(name)) {
					return true;
				}
			}
			return false;
		}
	}

	public Theme() {
		this.properties = new Properties();
	}

	// Set a color property for a specific component and property (e.g., "button.bg")
	public void setColor(String component, ColorProperty property, Color color) {
		String key = component + "." + property.toString();
		properties.setProperty(key, colorToHex(color));
	}

	public void setInt(String component, ColorProperty property, int number) {
		String key = component + "." + property.toString();
		properties.setProperty(key, String.valueOf(number));
	}

	// Get a color property for a specific component and property
	public Color getColor(String component, ColorProperty property) {
		String key = component + "." + property;
		String colorHex = properties.getProperty(key, null);
		return hexToColor(colorHex);
	}
	public int getInt(String component, ColorProperty property) {
		String key = component + "." + property;
		String i = properties.getProperty(key, "1");
		return Integer.parseInt(i);
	}

	public void printComponentProperties(String component) {
		Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
		for (Map.Entry<Object, Object> entry : entrySet) {
			String key = (String) entry.getKey();
			if (key.startsWith(component + ".")) {
				System.out.println(key + " = " + entry.getValue());
			}
		}
	}

	private String colorToHex(Color color) {
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	private Color hexToColor(String hex) {
		if(hex == null) return null;
		return Color.decode(hex);
	}

	public void load(String themeName) throws IOException {
		try (InputStream input = new FileInputStream(Objects.requireNonNull(getClass().getResource(String.format("/themes/%s.properties", themeName))).getPath())) {
			properties.load(input);
		}
	}

	public void save(String themeName) throws IOException {
		try (OutputStream output = new FileOutputStream(Objects.requireNonNull(getClass().getResource(String.format("/themes/%s.properties", themeName))).getPath())) {
			properties.store(output, "Theme Properties");
		}
	}

	// Print all properties
	public void printAllProperties() {
		properties.forEach((key, value) -> System.out.println(key + " = " + value));
	}

	public void apply(JFrame target) {
		for (Field field : target.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Paint.class)) {
				Paint paintAnnotation = field.getAnnotation(Paint.class);
				String componentName = paintAnnotation.name();

				field.setAccessible(true);
				try {
					Object component = field.get(target);
					if(!(component instanceof Component)) continue;

					GlobalPainter.paint(this, (Component) component, componentName);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

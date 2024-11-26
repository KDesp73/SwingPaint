package io.github.kdesp73.swingpaint;

import io.github.kdesp73.swingpaint.annotations.Paint;
import io.github.kdesp73.swingpaint.annotations.PaintAll;
import io.github.kdesp73.swingpaint.painters.GlobalPainter;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Theme {

	private final Properties properties;

	public enum ColorProperty {
		BG("bg"),
		BORDER_COLOR("border.color"),
		BORDER_THICKNESS("border.thickness"),
		BUTTON_BG("button.bg"),
		CARET_COLOR("caret.color"),
		DISABLED("disabled"),
		DIVIDER_COLOR("divider.color"),
		FG("fg"),
		FONT_COLOR("font.color"),
		HEADER_BG("header.bg"),
		HEADER_FG("header.fg"),
		HIGHLIGHT("highlight"),
		HORIZONTAL_THUMB("horizontal.thumb"),
		HORIZONTAL_TRACK("horizontal.track"),
		ICON_COLOR("icon.color"),
		MENUITEM_BG("menuitem.bg"),
		MENUITEM_FG("menuitem.fg"),
		PLACEHOLDER_COLOR("placeholder.color"),
		POPUP_BG("popup.bg"),
		POPUP_FG("popup.fg"),
		SELECTED("selected"),
		SELECTED_BG("selection.bg"),
		SELECTED_FG("selection.fg"),
		TAB_BG("tab.bg"),
		TAB_FG("tab.fg"),
		TEXTFIELD_BG("textfield.bg"),
		TEXTFIELD_FG("textfield.fg"),
		THUMB("thumb"),
		TICK("tick"),
		TITLE_BG("title.bg"),
		TITLE_FG("title.fg"),
		TRACK("track"),
		UNSELECTED("unselected"),
		VERTICAL_THUMB("vertical.thumb"),
		VERTICAL_TRACK("vertical.track");

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

		private static void printProperties(ColorProperty... properties){
			for(ColorProperty p : properties){
				System.out.println(p);
			}
		}

		private static Map<Class<? extends JComponent>, ColorProperty[]> propertiesMap = new HashMap<>();
		static {
			propertiesMap.put(JMenu.class, new ColorProperty[]{MENUITEM_BG, MENUITEM_FG});
			propertiesMap.put(JTree.class, new ColorProperty[]{SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JTextPane.class, new ColorProperty[]{CARET_COLOR, SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JTextField.class, new ColorProperty[]{PLACEHOLDER_COLOR, DISABLED, CARET_COLOR});
			propertiesMap.put(JTextArea.class, new ColorProperty[]{CARET_COLOR, DISABLED, SELECTED_BG, SELECTED_FG, PLACEHOLDER_COLOR});
			propertiesMap.put(JTable.class, new ColorProperty[]{HEADER_BG, HEADER_FG, SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JSpinner.class, new ColorProperty[]{BUTTON_BG, TEXTFIELD_BG, TEXTFIELD_FG});
			propertiesMap.put(JSlider.class, new ColorProperty[]{THUMB, TRACK, TICK});
			propertiesMap.put(JScrollBar.class, new ColorProperty[]{THUMB, TRACK});
			propertiesMap.put(JProgressBar.class, new ColorProperty[]{TRACK});
			propertiesMap.put(JFormattedTextField.class, new ColorProperty[]{CARET_COLOR, SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JPasswordField.class, new ColorProperty[]{CARET_COLOR, SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JEditorPane.class, new ColorProperty[]{CARET_COLOR, SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JCheckBox.class, new ColorProperty[]{SELECTED, UNSELECTED});
			propertiesMap.put(JComboBox.class, new ColorProperty[]{POPUP_BG, POPUP_FG});
			propertiesMap.put(JInternalFrame.class, new ColorProperty[]{TITLE_BG, TITLE_FG});
			propertiesMap.put(JList.class, new ColorProperty[]{SELECTED_BG, SELECTED_FG});
			propertiesMap.put(JToggleButton.class, new ColorProperty[]{SELECTED, UNSELECTED});
			propertiesMap.put(JScrollPane.class, new ColorProperty[]{HORIZONTAL_THUMB, HORIZONTAL_TRACK, VERTICAL_THUMB, VERTICAL_TRACK});
			propertiesMap.put(JSplitPane.class, new ColorProperty[]{DIVIDER_COLOR});
			propertiesMap.put(JTabbedPane.class, new ColorProperty[]{TAB_BG, TAB_FG});
		}

		public static void printMatchingProperties(Class<? extends JComponent> clazz) {
			printProperties(BG, FG, BORDER_COLOR, BORDER_THICKNESS);
			ColorProperty[] additionalProperties = propertiesMap.get(clazz);
			if(additionalProperties == null) return;
			printProperties(additionalProperties);
		}
	}

	public Theme() {
		this.properties = new Properties();
	}

	public Theme(String name) {
		this.properties = new Properties();
        try {
            this.load(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	public Theme(String name, JFrame target) {
		this.properties = new Properties();
		try {
			this.load(name);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		this.apply(target);
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
		if (target == null) {
			throw new IllegalArgumentException("Target JFrame cannot be null.");
		}

		Class<?> targetClass = target.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		PaintAll[] paintAllAnnotations = targetClass.getAnnotationsByType(PaintAll.class);

		// Handle PaintAll annotations
		for (PaintAll a : paintAllAnnotations) {
			for (Field field : fields) {
				processField(target, field, a.type(), a.name());
			}
		}

		// Handle Paint annotations
		for (Field field : fields) {
			if (field.isAnnotationPresent(io.github.kdesp73.swingpaint.annotations.Paint.class)) {
				io.github.kdesp73.swingpaint.annotations.Paint paintAnnotation =
					field.getAnnotation(io.github.kdesp73.swingpaint.annotations.Paint.class);
				processField(target, field, null, paintAnnotation.name());
			}
		}
	}

	private void processField(JFrame target, Field field, Class<?> expectedType, String componentName) {
		field.setAccessible(true);
		try {
			Object component = field.get(target);

			if (!(component instanceof Component)) {
				return;
			}

			if (expectedType != null && !expectedType.isAssignableFrom(component.getClass())) {
				return;
			}

			GlobalPainter.paint(this, (Component) component, componentName);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

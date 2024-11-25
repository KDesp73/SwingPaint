package io.github.kdesp73.swingpaint.painters;

import io.github.kdesp73.swingpaint.Theme;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GlobalPainter {
	private static final Map<Class<? extends Component>, Class<? extends Painter>> paintersMap = new HashMap<>();

	static {
		paintersMap.put(JButton.class, ButtonPainter.class);
		paintersMap.put(JCheckBox.class, CheckboxPainter.class);
		paintersMap.put(JComboBox.class, ComboBoxPainter.class);
		paintersMap.put(JDesktopPane.class, DesktopPanePainter.class);
		paintersMap.put(JEditorPane.class, EditorPanePainter.class);
		paintersMap.put(JFormattedTextField.class, FormattedTextFieldPainter.class);
		paintersMap.put(JInternalFrame.class, InternalFramePainter.class);
		paintersMap.put(JLabel.class, LabelPainter.class);
		paintersMap.put(JLayeredPane.class, LayeredPanePainter.class);
		paintersMap.put(JList.class, ListPainter.class);
		paintersMap.put(JMenuBar.class, MenuBarPainter.class);
		paintersMap.put(JPanel.class, PanelPainter.class);
		paintersMap.put(JPasswordField.class, PasswordFieldPainter.class);
		paintersMap.put(JPopupMenu.class, PopupMenuPainter.class);
		paintersMap.put(JProgressBar.class, ProgressBarPainter.class);
		paintersMap.put(JScrollBar.class, ScrollBarPainter.class);
		paintersMap.put(JScrollPane.class, ScrollPanePainter.class);
		paintersMap.put(JSlider.class, SliderPainter.class);
		paintersMap.put(JSplitPane.class, SplitPanePainter.class);
		paintersMap.put(JTabbedPane.class, TabbedPanePainter.class);
		paintersMap.put(JTable.class, TablePainter.class);
		paintersMap.put(JTextArea.class, TextAreaPainter.class);
		paintersMap.put(JTextField.class, TextFieldPainter.class);
		paintersMap.put(JTextPane.class, TextPanePainter.class);
		paintersMap.put(JToggleButton.class, ToggleButtonPainter.class);
		paintersMap.put(JToolBar.class, ToolBarPainter.class);
		paintersMap.put(JTree.class, TreePainter.class);
	}

	public static void paint(Theme theme, Component component, String name) {
		Painter painter = createPainter(component);
		if (painter == null) {
			System.err.println("No painter found for component: " + component.getClass().getName());
			return;
		}

		painter.setBackgroundColor(theme.getColor(name, Theme.ColorProperty.BG));
		painter.setForegroundColor(theme.getColor(name, Theme.ColorProperty.FG));

		Border border = ((JComponent) component).getBorder();
		Insets insets = border.getBorderInsets(component);
		if(
			border instanceof LineBorder &&
			(insets.top > 0 || insets.left > 0 || insets.bottom > 0 || insets.right > 0)
		) {
			painter.setBorderColor(
				theme.getColor(name, Theme.ColorProperty.BORDER_COLOR),
				theme.getInt(name, Theme.ColorProperty.BORDER_THICKNESS)
			);
		}

		switch (painter) {
			case MenuBarPainter menuBarPainter -> {
				menuBarPainter.setMenuItemBackgroundColor(theme.getColor(name, Theme.ColorProperty.MENUITEM_BG));
				menuBarPainter.setMenuItemForegroundColor(theme.getColor(name, Theme.ColorProperty.MENUITEM_FG));
			}
			case TreePainter treePainter -> {
				treePainter.setSelectionColors(
					theme.getColor(name, Theme.ColorProperty.SELECTED_BG),
					theme.getColor(name, Theme.ColorProperty.SELECTED_FG)
				);
			}
			case TextPanePainter textPanePainter -> {
				textPanePainter.setCaretColor(theme.getColor(name, Theme.ColorProperty.CARET_COLOR));
				textPanePainter.setSelectedTextBackgroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_BG));
				textPanePainter.setSelectedTextForegroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_FG));
			}
			case TextFieldPainter textFieldPainter -> {
				textFieldPainter.setPlaceholderColor(theme.getColor(name, Theme.ColorProperty.PLACEHOLDER_COLOR));
				textFieldPainter.setDisabledColor(theme.getColor(name, Theme.ColorProperty.DISABLED));
				textFieldPainter.setCaretColor(theme.getColor(name, Theme.ColorProperty.CARET_COLOR));
			}
			case TextAreaPainter textAreaPainter -> {
				textAreaPainter.setCaretColor(theme.getColor(name, Theme.ColorProperty.CARET_COLOR));
				textAreaPainter.setDisabledColor(theme.getColor(name, Theme.ColorProperty.DISABLED));
				textAreaPainter.setSelectionBackgroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_BG));
				textAreaPainter.setSelectionForegroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_FG));
				textAreaPainter.setPlaceholderColor(theme.getColor(name, Theme.ColorProperty.PLACEHOLDER_COLOR));
			}
			case TablePainter tablePainter -> {
				tablePainter.setHeaderBackgroundColor(theme.getColor(name, Theme.ColorProperty.HEADER_BG));
				tablePainter.setHeaderForegroundColor(theme.getColor(name, Theme.ColorProperty.HEADER_FG));
				tablePainter.setSelectionColors(
					theme.getColor(name, Theme.ColorProperty.SELECTED_BG),
					theme.getColor(name, Theme.ColorProperty.SELECTED_FG),
					theme.getColor(name, Theme.ColorProperty.BG),
					theme.getColor(name, Theme.ColorProperty.FG)
				);
			}
			case SpinnerPainter spinnerPainter -> {
				spinnerPainter.setButtonBackgroundColor(theme.getColor(name, Theme.ColorProperty.BUTTON_BG));
				spinnerPainter.setTextFieldBackgroundColor(theme.getColor(name, Theme.ColorProperty.TEXTFIELD_BG));
				spinnerPainter.setTextFieldForegroundColor(theme.getColor(name, Theme.ColorProperty.TEXTFIELD_FG));
			}
			case SliderPainter sliderPainter -> {
				sliderPainter.setThumbColor(theme.getColor(name, Theme.ColorProperty.THUMB));
				sliderPainter.setTrackColor(theme.getColor(name, Theme.ColorProperty.TRACK));
				sliderPainter.setTickColor(theme.getColor(name, Theme.ColorProperty.TICK));
			}
			case ScrollBarPainter scrollBarPainter -> {
				scrollBarPainter.setThumbColor(theme.getColor(name, Theme.ColorProperty.THUMB));
				scrollBarPainter.setTrackColor(theme.getColor(name, Theme.ColorProperty.TRACK));
			}
			case ProgressBarPainter progressBarPainter -> {
				progressBarPainter.setTrackColor(theme.getColor(name, Theme.ColorProperty.TRACK));
			}
			case FormattedTextFieldPainter formattedTextFieldPainter -> {
				formattedTextFieldPainter.setCaretColor(theme.getColor(name, Theme.ColorProperty.CARET_COLOR));
				formattedTextFieldPainter.setSelectionColors(
					theme.getColor(name, Theme.ColorProperty.SELECTED_BG),
					theme.getColor(name, Theme.ColorProperty.SELECTED_FG)
				);
			}
			case PasswordFieldPainter passwordFieldPainter -> {
				passwordFieldPainter.setCaretColor(theme.getColor(name, Theme.ColorProperty.CARET_COLOR));
				passwordFieldPainter.setSelectionColors(
					theme.getColor(name, Theme.ColorProperty.SELECTED_BG),
					theme.getColor(name, Theme.ColorProperty.SELECTED_FG)
				);
			}
			case EditorPanePainter editorPanePainter -> {
				editorPanePainter.setCaretColor(theme.getColor(name, Theme.ColorProperty.CARET_COLOR));
				editorPanePainter.setSelectedTextBackgroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_BG));
				editorPanePainter.setSelectedTextForegroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_FG));
			}
			case CheckboxPainter checkboxPainter -> {
				checkboxPainter.setSelectedColor(theme.getColor(name, Theme.ColorProperty.SELECTED));
				checkboxPainter.setUnselectedColor(theme.getColor(name, Theme.ColorProperty.UNSELECTED));
			}
			case ComboBoxPainter comboBoxPainter -> {
				comboBoxPainter.setPopupBackgroundColor(theme.getColor(name, Theme.ColorProperty.POPUP_BG));
				comboBoxPainter.setPopupForegroundColor(theme.getColor(name, Theme.ColorProperty.POPUP_FG));
			}
			case InternalFramePainter internalFramePainter -> internalFramePainter.setTitleBarColor(
				theme.getColor(name, Theme.ColorProperty.TITLE_BG),
				theme.getColor(name, Theme.ColorProperty.TITLE_FG)
			);
			case ListPainter listPainter -> {
				listPainter.setSelectedBackgroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_BG));
				listPainter.setSelectedForegroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED_FG));
			}
			case ToggleButtonPainter toggleButtonPainter -> {
				toggleButtonPainter.setSelectedBackgroundColor(theme.getColor(name, Theme.ColorProperty.SELECTED));
				toggleButtonPainter.setUnselectedBackgroundColor(theme.getColor(name, Theme.ColorProperty.UNSELECTED));
			}
			case ScrollPanePainter scrollPanePainter -> {
				scrollPanePainter.setHorizontalScrollBarColor(
					theme.getColor(name, Theme.ColorProperty.HORIZONTAL_THUMB),
					theme.getColor(name, Theme.ColorProperty.HORIZONTAL_TRACK)
				);
				scrollPanePainter.setVerticalScrollBarColor(
					theme.getColor(name, Theme.ColorProperty.VERTICAL_THUMB),
					theme.getColor(name, Theme.ColorProperty.VERTICAL_TRACK)
				);
			}
			case SplitPanePainter splitPanePainter -> {
				splitPanePainter.setDividerColor(theme.getColor(name, Theme.ColorProperty.DIVIDER_COLOR));
			}
			case TabbedPanePainter tabbedPanePainter -> {
				tabbedPanePainter.setTabBackgroundColor(theme.getColor(name, Theme.ColorProperty.TAB_BG));
				tabbedPanePainter.setTabForegroundColor(theme.getColor(name, Theme.ColorProperty.TAB_FG));
			}
			default -> {
			}
		}
	}

	private static Painter createPainter(Component component) {
		Class<? extends Painter> painterClass = findPainterClass(component.getClass());
		if (painterClass == null) return null;

		try {
			return painterClass.getDeclaredConstructor(component.getClass()).newInstance(component);
		} catch (ReflectiveOperationException e) {
			throw new IllegalStateException("Failed to create painter for " + component.getClass().getName(), e);
		}
	}

	private static Class<? extends Painter> findPainterClass(Class<?> componentClass) {
		Class<?> currentClass = componentClass;
		while (currentClass != null) {
			if (paintersMap.containsKey(currentClass)) {
				return paintersMap.get(currentClass);
			}
			currentClass = currentClass.getSuperclass();
		}
		return null;
	}
}

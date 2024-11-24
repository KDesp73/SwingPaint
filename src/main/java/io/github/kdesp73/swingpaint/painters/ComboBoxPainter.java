package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ComboBoxPainter implements Painter {
	private final JComboBox comboBox;

	public ComboBoxPainter(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	@Override
	public void setBackgroundColor(Color color) {
		comboBox.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		comboBox.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		comboBox.setBorder(new LineBorder(color, thickness));
	}

	public void setPopupBackgroundColor(Color color) {
		UIManager.put("ComboBox.background", color);
		SwingUtilities.updateComponentTreeUI(comboBox);
	}

	public void setPopupForegroundColor(Color color) {
		UIManager.put("ComboBox.foreground", color);
		SwingUtilities.updateComponentTreeUI(comboBox);
	}
}

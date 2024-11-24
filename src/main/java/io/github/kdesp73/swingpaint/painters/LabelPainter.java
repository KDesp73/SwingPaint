package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LabelPainter implements Painter {
	private final JLabel label;

	public LabelPainter(JLabel label) {
		this.label = label;
	}

	@Override
	public void setBackgroundColor(Color color) {
		label.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		label.setForeground(color);
	}

	public void setFontColor(Color color) {
		label.setForeground(color);  // Font color is the same as foreground
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		label.setBorder(new LineBorder(color, thickness));
	}
}

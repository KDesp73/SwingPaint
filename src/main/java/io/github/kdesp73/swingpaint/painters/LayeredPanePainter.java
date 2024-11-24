package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LayeredPanePainter implements Painter{
	private final JLayeredPane layeredPane;

	public LayeredPanePainter(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	@Override
	public void setBackgroundColor(Color color) {
		layeredPane.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		layeredPane.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		layeredPane.setBorder(new LineBorder(color, thickness));
	}
}

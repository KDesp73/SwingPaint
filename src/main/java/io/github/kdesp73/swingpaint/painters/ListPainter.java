package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ListPainter implements Painter {
	private final JList<?> list;

	public ListPainter(JList<?> list) {
		this.list = list;
	}

	@Override
	public void setBackgroundColor(Color color) {
		list.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		list.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		list.setBorder(new LineBorder(color, thickness));
	}

	public void setSelectedBackgroundColor(Color color) {
		list.setSelectionBackground(color);
	}

	public void setSelectedForegroundColor(Color color) {
		list.setSelectionForeground(color);
	}
}

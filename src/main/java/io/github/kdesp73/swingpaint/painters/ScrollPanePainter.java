package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ScrollPanePainter implements Painter {
	private final JScrollPane scrollPane;

	public ScrollPanePainter(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	@Override
	public void setBackgroundColor(Color color) {
		scrollPane.getViewport().setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		scrollPane.getViewport().setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = scrollPane.getBorder();
		if (currentBorder instanceof LineBorder lineBorder) {
			scrollPane.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			scrollPane.setBorder(new LineBorder(color, thickness));
		}
	}

	public void setVerticalScrollBarColor(Color thumbColor, Color trackColor) {
		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		customizeScrollBar(verticalScrollBar, thumbColor, trackColor);
	}

	public void setHorizontalScrollBarColor(Color thumbColor, Color trackColor) {
		JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
		customizeScrollBar(horizontalScrollBar, thumbColor, trackColor);
	}

	private void customizeScrollBar(JScrollBar scrollBar, Color thumbColor, Color trackColor) {
		scrollBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = thumbColor;
				this.trackColor = trackColor;
			}
		});
	}
}

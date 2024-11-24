package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InternalFramePainter implements Painter{
	private final JInternalFrame internalFrame;

	public InternalFramePainter(JInternalFrame internalFrame) {
		this.internalFrame = internalFrame;
	}

	@Override
	public void setBackgroundColor(Color color) {
		internalFrame.getContentPane().setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		internalFrame.getContentPane().setForeground(color);
		internalFrame.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		internalFrame.setBorder(new LineBorder(color, thickness));
	}

	public void setTitleBarColor(Color backgroundColor, Color textColor) {
		if (internalFrame.getUI() instanceof javax.swing.plaf.basic.BasicInternalFrameUI basicUI) {
			JComponent titlePane = basicUI.getNorthPane();
			if (titlePane != null) {
				titlePane.setBackground(backgroundColor);
				for (Component comp : titlePane.getComponents()) {
					if (comp instanceof JLabel label) {
						label.setForeground(textColor);
					}
				}
			}
		}
	}
}

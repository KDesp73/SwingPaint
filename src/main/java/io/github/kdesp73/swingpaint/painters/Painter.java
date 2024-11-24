package io.github.kdesp73.swingpaint.painters;

import java.awt.*;

public interface Painter {
	void setBackgroundColor(Color color);

	void setForegroundColor(Color color);

	void setBorderColor(Color color, int thickness);

}


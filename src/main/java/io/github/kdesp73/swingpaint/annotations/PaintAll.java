package io.github.kdesp73.swingpaint.annotations;

import javax.swing.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = MultiplePaintAll.class)
public @interface PaintAll {
	String label();
	Class<? extends JComponent> type();
}


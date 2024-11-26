package io.github.kdesp73.swingpaint.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MultiplePaintAll {
	PaintAll[] value();
}

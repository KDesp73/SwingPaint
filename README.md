# SwingPaint

A user-friendly library that simplifies coloring and theming,
making it easy to integrate into existing desktop applications.

## Dependency

[Maven Central](https://central.sonatype.com/artifact/io.github.kdesp73/SwingPaint)

### Maven

```xml
<dependency>
    <groupId>io.github.kdesp73</groupId>
    <artifactId>SwingPaint</artifactId>
    <version>1.1.0</version>
</dependency>
```

### Gradle

```text
implementation 'io.github.kdesp73:SwingPaint:1.1.0'
```

## Usage

```java
import io.github.kdesp73.swingpaint.Theme;

import javax.swing.*;

public class MainFrame extends JFrame {

	@Paint(name = "button")
	private JButton button1;

	@Paint(name = "button")
	private JButton button2;

	@Paint(name = "myspinner")
	private JSpinner spinner1;

	MainFrame() {
		initComponents();

		Theme theme = new Theme();
		theme.load("light");
		theme.apply(this);
	}
}

```

### Theme file

File path: `src/main/resources/themes/light.properties`

```properties
button.bg = #282828
button.fg = #FFFFFF

myspinner.bg = #282828
myspinner.fg = #FFFFFF
myspinner.border = #000000
myspinner.button.bg = #FF00FF
myspinner.textfield.bg = #92AB01
myspinner.textfield.fg = #FFEEFF
```

## Contributing

Contributions are always welcome!

See [Contributing.md](https://github.com/KDesp73/Swing-Themes-Library/blob/main/CONTRIBUTING.md) for ways to get started.

Please adhere to this project's [Code of Conduct](https://github.com/KDesp73/Swing-Themes-Library/blob/main/CODE_OF_CONDUCT.md).

## License

[MIT](https://choosealicense.com/licenses/mit/)

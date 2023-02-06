# Swing Themes Library

## Tutorial

* Import SwingThemesLibrary in your project as a dependency (see [Releases](https://github.com/KDesp73/Swing-Themes-Library/releases) for .jar file)

### Themes

* Create a theme

  ```java
  Theme theme = new Theme(); //And insert each color by hand

  //or

  Theme theme_json = new Theme(new JsonString([Your json string]);

  //or

  Theme theme_yaml = new Theme(new YamlFile([Full file directory]);
  ```

* Parse Yaml file
  ```java
  Theme theme = new Theme();
  
  theme.parseYaml(new YamlFile([Full file directory]);
  ```

* Parse Json
  ```java
  Theme theme = new Theme();
  
  theme.parseJson(new JsonString([Your json string]);
  ```
  
* Generate Yaml from Theme
  ```java
  YamlFile yaml = existing_theme.generateYaml([target directory]); //Creates .yml file in [targer directory]
  ```
  
* Generate Json from Theme
  ```java
  JsonString json = existing_theme.generateJson();
  ```
  
### ThemeCollection

* Create a ThemeCollection
  ```java
  ThemeCollection themes = new ThemeCollection(); // No other constructor exists
  ```
  
* Add a theme
  ```java
  themes.add(new Theme());
  ```
  
* Load themes
  ```java
  themes.load(new File([folder path*])); //* Folder containing .yml files with wanted themes
  
  //or
  
  themes.load(new String[]{[strings with theme information]});
  ```
  
* Implement Theme on a container
  ```java
  JFrame frame = new JFrame();
  Theme theme = new Theme(); //non empty theme
  ThemeCollection.implementTheme(frame, theme);
  ```

> Set your JComponent's name according to the [sample_theme.yml](https://github.com/KDesp73/Swing-Themes-Library/blob/main/Samples/sample_theme.yml). This will determine the color of each component.

## Dependencies

```xml
<dependency>
    <groupId>kdesp73.lib</groupId>
    <artifactId>SwingThemesLibrary</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```


## Clone

```bash
git clone https://github.com/KDesp73/Swing-Themes-Library
```

## TODO
* Make dependency fully public on the Maven repository

## Contributing

Contributions are always welcome!

See [Contributing.md](https://github.com/KDesp73/Swing-Themes-Library/blob/main/Contributing.md) for ways to get started.

Please adhere to this project's [Code of Conduct](https://github.com/KDesp73/Swing-Themes-Library/blob/main/CODE_OF_CONDUCT.md).

## Authors

- [@KDesp73](https://github.com/KDesp73)


## License

[MIT](https://choosealicense.com/licenses/mit/)

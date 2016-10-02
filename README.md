> A helper library to set custom fonts to your android view
### Please visit the website to know the [how to](http://anwarshahriar.github.io/projects/calligrapher/calligrapher.html).
> Website: http://anwarshahriar.github.io/projects/calligrapher/calligrapher.html

> This is a simple library for setting specific font to all of your view with a single line.
Feel free to fork it or fix any issues and make a pull request.

### Add to gradle dependencies
```groovy
dependencies {
  compile 'me.anwarshahriar:calligrapher:1.0'
}
```
> ### Place your font under assets directory or sub directories under assets.

### Example use
```java
Calligrapher calligrapher = new Calligrapher(this);
calligrapher.setFont(this, "alexbrush/AlexBrush-Regular.ttf", true);
```

![demo 1](./screenshots/demo_one.png)
![demo 2](./screenshots/demo_two.png)

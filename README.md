# BanHammer API
Ban hammer API is an API for punishment plugin devs to implement. Other plugins that depend on Punishment use BanHammer instead of using all punishment plugin API.

#How to use

First, you need to create a new class that implements BanPlugin. implement all methods and finally registering them into the plugin.

**NOTE: MUST REGISTER BEFORE BanHammer is Enabled**

**How to register:**
Simply get an instance of main class of plugin **BanHammer** and use the following:
```java
public class YourMainClass extends JavaPlugin{
  public void onEnable() {
    //other code
    banhammerInstance.setBanPlugin(BanHammerImplementation, this); //"this" is your main class
 }
}
```

# Add dependency
Insert the following into your pom.xml

```xml
	<repositories>
        <!-- Other repositories -->
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

  <dependencies>
        <!-- Other dependencies -->
	<dependency>
	    <groupId>com.github.BlueTree242</groupId>
	    <artifactId>BanHammer</artifactId>
	    <version>master-SNAPSHOT</version>
	</dependency>
 </dependencies>
```


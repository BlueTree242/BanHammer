# BanHammer API
Ban hammer API is an API for punishment plugin devs to implement. Other plugins that depend on Punishment use BanHammer instead of using all punishment plugin API.

# How to Implement

First, you need to create a new class that implements BanPlugin. implement all methods and finally registering them into the plugin.

**NOTE: MUST REGISTER BEFORE BanHammer is Enabled**

**How to register:**
Simply get an instance of main class of plugin **BanHammer** and use the following:
```java
public class YourMainClass extends JavaPlugin{
  public void onLoad() /*onLoad because it won't register if BanHammer is enabled (sometimes when server finishes starting but onLoad is recommended)*/{
    //other code
    banhammerInstance.setPunishmentsPlugin(BanHammerImplementation, this); //"this" is your main class
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

for gradle:
```gradle
repositories {
	//other repositories
	maven { url 'https://jitpack.io' }
}
dependencies {
    //other dependencies
	implementation 'com.github.BlueTree242:BanHammer:master-SNAPSHOT'
}
```


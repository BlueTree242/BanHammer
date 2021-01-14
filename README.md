# BanHammer API
Ban hammer API is an API for punishment plugin devs to implement. Other plugins that depend on Punishment use BanHammer instead of using all punishment plugin API.

#How to use

First, you need to create a new class that implements BanPlugin. implement all methods and finally registering them into the plugin
**NOTE: MUST REGISTER BEFORE BanHammer is Enabled**

**How to register:**
Simply get an instance of main class of plugin **BanHammer** and use the following:
```java
public class YourMainClass extends JavaPlugin{
  public void onEnable() {
    //other code
    banhammerInstance.setBanPlugin(BanPluginImplementation, BanHammerImplementation, this); //"this" is your main class
 }
}
```


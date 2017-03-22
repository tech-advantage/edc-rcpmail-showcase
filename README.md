# edc-rcpmail-showcase
Eclipse RCP application for edc integration

This example is based on Eclipse RCP. The goal is to explain how can you integrate edc in your Eclipse RCP application.

## The application

This application contains 2 plugins:

* _fr.techad.edc.showcase.mailreader_: the rcp application
* _fr.techad.edc.showcases.mailreader.help_: the edc publishing 
 
Import the project in Eclipse and create a launcher to start the application.

With **F1**, you will display the **Contextual Help View**. When you click on widget, the contextual help will be updated.

## How does it work ?

You need to register the key with its components in the help engine of Eclipse.

For example, see View.java at line 30
```java
public void createPartControl(Composite parent) {
  Composite top = new Composite(parent, SWT.NONE);
  // Register the edc keys.
  PlatformUI.getWorkbench().getHelpSystem().setHelp(top, "fr.techad.edc.showcase.mailreader.leftmenu.account");

``` 
That's all.

## Best practise

We recommend you to declare keys as constant in a class.

See HelpKey.java
```java
public interface HelpKey {
  static final String PLUGIN_ID = "fr.techad.edc.showcase.mailreader.";
	
  static final public String VIEW = PLUGIN_ID+"leftmenu.account";
  static final public String NAVIGATION_VIEW = PLUGIN_ID+"email.tab";
}
```
ans use it directly

```java
public void createPartControl(Composite parent) {
  Composite top = new Composite(parent, SWT.NONE);
  // Register the edc keys.
  PlatformUI.getWorkbench().getHelpSystem().setHelp(top, HelpKey.VIEW);
}
``` 

## License

MIT 



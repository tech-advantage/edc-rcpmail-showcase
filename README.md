# edc-rcpmail-showcase
Eclipse RCP application for edc integration

This example is based on Eclipse RCP. The goal is to explain how can you integrate edc in your Eclipse RCP application.

## edc Version

Current release is compatible with edc v2.1+

## The application

This application contains 2 plugins:

* _fr.techad.edc.showcase.mailreader_: the rcp application
* _fr.techad.edc.showcases.mailreader.help_: the edc publishing 
 
Import the project in Eclipse, select the target platform and select it as default.
Use the defined laucnher to start the application.

With **F1**, you will display the **Contextual Help View**. When you click on widget, the contextual help will be updated.
To display the content helps, click in the menu bar on **Help** > **Help Contents**

The target platform download the packaged mathjax library to render the mathematic formula.

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



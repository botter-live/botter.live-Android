<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/ic_botter.png" alt="Botter">

## Onboard, retain and support mobile users at scale
Engage customers with in‑app messages and support them with an integrated knowledge base and help desk.

## The Botter Messenger
The [Botter Messenger](https://botter.ai/) enables you to use it like a Messenger in your app, have conversations with your customers, send rich outbound messages, and track events.
The Botter SDK is the home for the conversations your customers have with you, and the place where they can self-serve for support or to learn more about your product.
You can open Botter from a persistent button that sits over your app’s UI, From there, your customer can  start a conversation, replies in both directions happen in real time.

## Sceenshots
<p float="left">
<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/sample_black.jpg" width="200" alt="sample1">
<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/sample_blue.jpg" width="200" alt="sample2">
<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/sample_orange.jpg" width="200" alt="sample3">
<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/sample_green.jpg" width="200" alt="sample4">
</p>

## Contents
- [Installation](#Installation)
- [Integration](#Integration)
- [Supported integration languages](#Supported-integration-languages)
- [Current supported bot languages](#Supported-bot-languages)
- [Customer support](#Customer-support)
- [Customizations](#Customizations)
- [Push Notifications (FCM)](#Push-Notifications-FCM)
- [Customization parameters table](#Customizations-guidance-table)
- [Licence](#Licence)





## Installation
Install Botter to see and talk to users of your Android app, Botter for Android supports API 23 and above.

<li>Add the below lines under <strong>all projects -> repositories</strong> in build.gradle <strong>(project level)</strong>.</li>

```
maven {
  url "from our support team"
     credentials {
       username = "*ask for your username*" //from our support team
       password = "*ask for your password*" //from our support team
    }
}
```
<li> Make sure that you suppoty java 8 by adding the below lines under <strong>android { </strong> in build.gradle <strong>(App level)</strong>
  
```
 compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    } 
```
<li> add Botter dependency under <strong>dependencies { </strong> section  
 
```
implementation "com.bluecrunch:botter:1.3.8"
```

## Integration

<p>First, you'll need to get your Botter Android API key. To find this, just contact our support team to get you one.
  Then, initialize Botter by calling the following in the <strong>onCreate()</strong> method of your application class</p>
  
```
Botter.initialize(this,"Your API Key",
new BotterCustomization.Builder().build());
```

<strong>Note:</strong> If you don't currently implement a custom application, you’ll need to create one. A custom application looks like this:

```
public class CustomApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        Botter.initialize(this,"Your API Key",
new BotterCustomization.Builder().build());
   }
}
```

You’ll need to update your manifest to use your application:

```
<application
    android:name=".CustomApplication">
</application>
```

## Supported integration languages
<li> Java. </li>
<li> Kotlin. </li>


## Current supported bot languages
<li> English </li>
<li> Arabic </li>


## Customer support

👋 Contact us with any integration/issues at [Botter - Contact us page](https://botter.ai/contact/). If you bump into any problems or need more support, just start a conversation with our support team.

## Push Notifications (FCM)
Below, we’ll show you how to send push notifications to your customers, with Firebase Cloud Messaging (FCM) in Botter.

 #### Step :one:. Enable Google services for your app



## Customizations
if you want anytime at any screen hide the Botter chat icon, just write the below line inside <strong>onResume()</strong> method : 

```
Botter.client().setLauncherVisibility(Botter.Visibility.GONE);
```

and you can show it anytime using the below line at <strong>onResume()</strong> also :

```
Botter.client().setLauncherVisibility(Botter.Visibility.VISIBLE);
```

You can also change margins around the launcher button using : 

```
Botter.client().setLauncherMargin(left,top,right,bottom);
```

If you have your custom button , and want to show chat screen directly then you can use the below line:

```
Botter.client().openChatActivity();
```

You can customize Botter with your preferred settings, when you initialize Botter instance inside <strong>onCreate</strong> method of your Application class like below : 

```
Botter.initialize(this,
"Your API Key"
new BotterCustomization.Builder() 
.setLauncherGravity(BotterCustomization.LauncherGravity.LEFT) // set the launcher icon to the left/right of your screen. (default right).
.setDefaultLocal(BotterCustomization.Local.AR) // set default bot language either AR/EN. (default EN).
.setLauncherIcon(R.drawable.) //set the launcher icon.
.setBotterLogo(R.drawable.) //set the chat logo & seen icon logo.
.setWelcomeBrandLogo(R.drawable.) //set the welcome screen brand logo.
.setBotterAccentColor(R.color.) //set the chat accent color.
.setBotterHeadlineText("") // set welcome screen headline text.
.setBotterHeadlineTextColor(R.color.) // set welcome screen headline text color.
.seBtotterWelcomeText("") // set welcome screen headline welcome message.
.setBotterWelcomeTextColor(R.color.) // set welcome screen headline welcome message color.
.setBotterChatHeaderTitle("") //set chat screen header title.              
.setBotterChatHeaderTitleColor(R.color.) // set chat screen header title color.
.setBotterChatBubbleColor(R.color.) // set botter bubble color.
.setBotterChatBubbleTextColor(R.color.) // set botter bubble text color.
.setSenderChatBubbleColor(R.color.) // set sender bubble color.
.setSenderChatBubbleTextColor(R.color.) // set sender bubble text color.
.setBotterRegularFontFamily(R.font.) // set chat primary font.
.setBotterSemiBoldFontFamily(R.font.) // set chat secondry font.
.setHasFAQs(true) // Determine if chat has FAQs or not.
.setAgentDefaultIcon(R.drawable.) // set the default icon for agent.
.build());
```

[back to top](#readme)


## Customization parameters table:
| Name  | Description | Screenshot |
| ------------- | ------------- | ------------- |
| setLauncherGravity | To set the launcher to the right/left of the screen. | 
| setDefaultLocal | To set the default bot language either AR/EN. | 
| setLauncherIcon | To change the launcher icon. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/1.jpg" alt="1">|
| setBotterLogo | To set the chat main logo. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/2.jpg" alt="2">|
| setBotterAccentColor | This is the main color used all over the chat like launcher bg color, welcome screen top area bg color, chat header, ect… I.e. in the image accent color is purple. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/main_color.jpg" alt="main_color">|
| setBotterHeadlineText , setBotterHeadlineTextColor | Used to set the welcome screen header title text and color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/4.jpg" alt="4">|
| seBotterWelcomeText , setBotterWelcomeTextColor | Used to set the welcome screen header subtitle text and color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/3.jpg" alt="3">|
|setBotterChatHeaderTitle , setBotterChatHeaderTitleColor | Used to set the main chat header title text and color | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/6.jpg" alt="6">|
| setBotterChatBubbleColor , setBotterChatBubbleTextColor | Used to set the botter message bubble bg color and it’s text color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/7.jpg" alt="7">|
| setSenderChatBubbleColor , setSenderChatBubbleTextColor | Used to set the sender/user message bubble bg color and it’s text color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/8.jpg" alt="8">|
| setWelcomeBrandLogo | Used to set the welcome screen brand logo. |
| setAgentDefaultIcon | Used to set the default agent chant icon. |
| setBotterRegularFontFamily | Used to set the primary font all over the chat. |
| setBotterSemiBoldFontFamily | Used to set the secondary font all over the chat. |

[back to top](#readme)


# Licence 
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of at:
<a href='https://opensource.org/licenses/apache2.0.php'>https://opensource.org/licenses/apache2.0.php</a>

[back to top](#readme)

### Thank you 

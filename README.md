<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/ic_botter.png" alt="Botter">

## Onboard, retain and support mobile users at scale
Engage customers with in‑app messages and support them with an integrated knowledge base and help desk.

## The BOTTER Messenger
The [BOTTER Messenger](https://botter.ai/) enables you to use it like a Messenger in your app, have conversations with your customers, send rich outbound messages, and track events.
The BOTTER SDK is the home for the conversations your customers have with you, and the place where they can self-serve for support or to learn more about your product.
You can open BOTTER from a persistent button that sits over your app’s UI, From there, your customer can  start a conversation, replies in both directions happen in real time.

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
- [Push Notifications (FCM)](#Push-Notifications-FCM)
- [Customizations](#Customizations)
- [On-premise extra customizations](#On-Premise-extra-customizations)
- [Share Location (Optional)](#Share-location)
- [Customizations parameters table](#Customizations-parameters-table)
- [Licence](#Licence)





## Installation
Install BOTTER to see and talk to users of your Android app, BOTTER for Android supports <strong>API 23</strong> and above.

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
<li> add BOTTER dependency under <strong>dependencies { </strong> section  
 
```
implementation "com.bluecrunch:botter:1.4.3"
```

## Integration

<p>First, you'll need to get your BOTTER Android API key. To find this, just contact our support team to get you one.
  Then, initialize BOTTER by calling the following in the <strong>onCreate()</strong> method of your application class</p>
  
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

👋 Contact us with any integration/issues at [BOTTER - Contact us page](https://botter.ai/contact/). If you bump into any problems or need more support, just start a conversation with our support team.

## Push Notifications (FCM)
Below, we’ll show you how to send push notifications to your customers, with Firebase Cloud Messaging (FCM) in BOTTER.

### Step :one:: Enable Google services for your app
If you already have a Firebase project with notifications enabled you can skip to the next step. Otherwise go to the [FCM Console page](https://console.firebase.google.com/u/0/) and create a new project following these steps:

Give the project a name and click <strong>‘Create Project’</strong>.

<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_create_project.png" alt="fcm_create">

Once your project is set up, scroll down and select the <strong>‘Cloud Messaging’</strong> card.

<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_cloud_messaging.png" alt="fcm_cloud_messaging">

Click on the Android icon to continue setup.

<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_setup_android.png" alt="fcm_android">

Enter your app’s package name and click <strong>‘Register App’</strong>.

<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_register_app.png" alt="fcm_register_app">

### Step :two:: Setup client to receive notifications

Click the button <strong>"Download google-services.json"</strong> to download the config file. You’ll need to move that file into the same directory as your application level `build.gradle`.

<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_json_file.png" alt="fcm_json_file">

Click <strong>"next"</strong> and then in your app `build.gradle` you will need to add the following lines to your dependencies:

```
dependencies {
    implementation 'com.google.firebase:firebase-messaging:20.2+'
}
```

At the bottom of your `build.gradle` you must add:

```
apply plugin: 'com.google.gms.google-services'
```

It is important that this is at the very end of the file.

Click the <strong>Next</strong> button and then skip the verification step.

### Step :three:: Add your Server key to BOTTER for Android settings

Finally, click the settings icon on top left and select <strong>‘Project settings’</strong>, then <strong>‘Cloud Messaging tab’</strong> and copy your Server key.


<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_server_key.png" alt="fcm_server_key">


Open your BOTTER app’s dashboard and select <strong>‘Settings -> Configure Notifications’</strong>. Then find the <strong>‘Server Key’</strong> field. Here you'll be able to paste and save your Server API key.


<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/fcm_dashboard_settings.png" alt="fcm_settings">



### Step :four:: Setting your FCM icon (optional)
If you want to add a custom icon for your notifications, just add an image named ic_botter_push_icon.png to each of your supported densities. Please note that vector drawables cannot be used here. For example:

```
/res/drawable-xxxhdpi/ic_botter_push_icon.png 
/res/drawable-xxhdpi/ic_botter_push_icon.png 
/res/drawable-xhdpi/ic_botter_push_icon.png 
/res/drawable-hdpi/ic_botter_push_icon.png 
/res/drawable-mdpi/ic_botter_push_icon.png
```

We recommend following these [material design guidelines](https://material.io/design) for producing this icon or you can directly use [this link](http://romannurik.github.io/AndroidAssetStudio/icons-notification.html#source.type=image&source.space.trim=1&source.space.pad=0&name=ic_botter_push_icon
) to generate your notification icon (recommended white icon 72x72 px.).

### Step :five:: Create FirebaseMessagingService class

You should have a class that extends `FirebaseMessagingService`. That service is where you get the device token to send to your backend to register for push notifications. To register for BOTTER push set it up like this:

```
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private final BotterPushClient botterPushClient = new BotterPushClient();

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        botterPushClient.sendTokenToBotter(getApplication(), s);
        // do other host logic
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (botterPushClient.isBotterPush(remoteMessage.getData())) {
            botterPushClient.handlePush(getApplication(), remoteMessage.getData());
        }
        else{
            // do other host logic
        }
    }
}
```

Don't forget to register this service in the `AndroidManifest.xml` like this:

```
  <service android:name=".MyFirebaseMessagingService">
      <intent-filter>
          <action android:name="com.google.firebase.MESSAGING_EVENT" />
      </intent-filter>
 </service>
```

[back to top](#readme)



## Customizations
if you want anytime at any screen hide the BOTTER chat icon, just write the below line inside <strong>onResume()</strong> method : 

```
Botter.client().setLauncherVisibility(Botter.Visibility.GONE);
```

and you can show it anytime using the below line at <strong>onResume()</strong> also :

```
Botter.client().setLauncherVisibility(Botter.Visibility.VISIBLE);
```

Note that you can specify a list of activities to hide BOTTER into them like below : 

```
Botter.client().hideLauncherInActivities(activitiesToHide); // activitiesToHide is an ArrayList holds the activities to hide BOTTER (i.e. MainActivity.class)

```

You can also change margins around the launcher button using : 

```
Botter.client().setLauncherMargin(left,top,right,bottom);
```

If you have your custom button , and want to show chat screen directly then you can use the below line:

```
Botter.client().openChatActivity();
```

You can customize BOTTER with your preferred settings, when you initialize BOTTER instance inside <strong>onCreate</strong> method of your Application class like below : 

```
Botter.initialize(this,
"Your API Key"
new BotterCustomization.Builder() 
.setLauncherGravity(BotterCustomization.LauncherGravity.LEFT) // set the launcher icon to the left/right of your screen. (default right).
.setDefaultLocal(BotterCustomization.Local.AR) // set default bot language either AR/EN. (default EN).
.setLauncherIcon(R.drawable.) //set the launcher icon.
.setBotterLogo(R.drawable.) //set the seen icon logo.
.setBotterHeaderLogo(R.drawable.) //set the chat header logo.
.setWelcomeBrandLogo(R.drawable.) //set the welcome screen brand logo.
.setBotterAccentColor(R.color.) //set the chat accent color.
.setBotterHeaderAccentColor(R.color.) // set the chat header accent color.
.setBotterLauncherAccentColor(R.color.) // set the launcher accent color.
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

<strong>Note</strong>

You can edit the initial customizations parameters at runtime using `Botter.client()`
(i.e. when changing your app language and want to change BOTTER accordingly) like below : 

```
 Botter.client().updateCustomizations(Botter.client().getOldCustomizations()
                .setDefaultLocal(BotterCustomization.Local.AR)
                .setBotterHeadlineText("Arabic Text")
                .build());
``` 

[back to top](#readme)

## On-premise extra customizations

for on-premise servers you can easily set (socket, API and upload) URLs using same builder method in Application class: 
```
Botter.initialize(this,
"Your API Key"
new BotterCustomization.Builder() 
......
.setSocketURL("wss://...") // set the socket url for the bot (must start with wss:// or ws://)
.setApiURL("https://...") // set the base API url for the bot (must start with https:// or http://)
.setUploadApiURL("https://...") // set the upload-attachments API for the bot (must start with https:// or http://)
.build());
```

[back to top](#readme)

## Share location feature (Optional)


### Step :one:: Get Google static map key for your app

If you want to enable share current location feature you have to provide google static maps API key, 
you need to open [Google cloud console](https://console.cloud.google.com/apis/credentials?) and make sure you choose the desired project,
from the left menu you need to choose Credentials tab then press on (+ CREATE CREDENTIALS) and create your static map key (it's recommended to restrict your key to be used with static maps only) - please refer to image below :


<img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/static_map.png" alt="static_map">


### Step :two:: Provide the static map key to BOTTER

You need to pass the key from step 1 to BOTTER initialize method in the app class to activate the share location feature like below : 


```
Botter.initialize(this,
"Your API Key"
new BotterCustomization.Builder() 
.enableShareLocationWithGoogleStaticMapKey("You google static map key here") // To enable share location feature.
.build());
```

[back to top](#readme)

## Customizations parameters table
| Name  | Description | Screenshot |
| ------------- | ------------- | ------------- |
| setLauncherGravity | To set the launcher to the right/left of the screen. | 
| setDefaultLocal | To set the default bot language either AR/EN. | 
| setLauncherIcon | To change the launcher icon. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/1.jpg" alt="1">|
| setBotterLogo | To set the chat main logo. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/2.jpg" alt="2">|
| setBotterAccentColor | This is the main color used all over the chat like welcome screen top area bg color, ect… I.e. in the image accent color is purple. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/main_color.jpg" alt="main_color">|
| setBotterHeadlineText , setBotterHeadlineTextColor | Used to set the welcome screen header title text and color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/4.jpg" alt="4">|
| seBotterWelcomeText , setBotterWelcomeTextColor | Used to set the welcome screen header subtitle text and color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/3.jpg" alt="3">|
|setBotterChatHeaderTitle , setBotterChatHeaderTitleColor | Used to set the main chat header title text and color | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/6.jpg" alt="6">|
| setBotterChatBubbleColor , setBotterChatBubbleTextColor | Used to set the BOTTER message bubble bg color and it’s text color. | <img src="https://raw.githubusercontent.com/botter-live/botter.live-Android/master/.github/images/7.jpg" alt="7">|
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

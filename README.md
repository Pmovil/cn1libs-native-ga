## Shortcut
This project only works with `ScreenView` hit type **manually** sent. It goes really native **only** for Android. It fallback to Codename One's AnalyticsServices (appsMode) on all other OSs

If it meet you needs, congrats, you are really lucky.

If not, and you have some time, contribute =)

## Using
Clone the project and open on Netbeans with Codename One plugin installed

Compile it

Copy `dist/CN1NativeGA.cn1lib` to your project's lib folder. Use Codename One's `Refresh libs` from your IDE

Enable Google Play Services on Build Hints (`android.includeGPlayServices=true`)

Update android.xapplication at your will. Reference: https://developers.google.com/analytics/devguides/collection/android/v4/#manifest. Here is a working sample:
```xml
<meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version" /><receiver android:name="com.google.android.gms.analytics.AnalyticsReceiver" android:enabled="true"><intent-filter><action android:name="com.google.android.gms.analytics.ANALYTICS_DISPATCH" /></intent-filter></receiver><service android:name="com.google.android.gms.analytics.AnalyticsService" android:enabled="true" android:exported="false"/><receiver android:name="com.google.android.gms.analytics.CampaignTrackingReceiver" android:exported="true"><intent-filter><action android:name="com.android.vending.INSTALL_REFERRER" /></intent-filter></receiver>
```

Start using it:
```java

import com.pmovil.nativega.GANative;
import com.pmovil.nativega.HitBuilders;
import com.pmovil.nativega.Tracker;

...
        
    GANative ga = GANative.getInstance();
    ga.setLocalDispatchPeriod(1800);
    tracker = ga.newTracker("UA-XXXXXXXX-Y");
    tracker.setAppName("My APP");
    tracker.setAppVersion("1.0");
    tracker.setScreenName("My Screen");
    tracker.send(new HitBuilders.ScreenViewBuilder().build());

```

## Roadmap
* cover [iOS](https://developers.google.com/analytics/devguides/collection/ios/v3/)
* focus on Google Analytics support to measure campaigns and traffic sources

## Premises
* library's interface reflects [Android original SDK] (https://developers.google.com/android/reference/com/google/android/gms/analytics/package-summary) as close as possible
* in the case of a no-supported platform, library will fallback to an implementation of [Measurement Protocol](https://developers.google.com/analytics/devguides/collection/protocol/v1/?hl=pt-br) automatically.

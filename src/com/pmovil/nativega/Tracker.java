/*
 * The MIT License
 *
 * Copyright 2015 Pmovil LTDA.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.pmovil.nativega;

import com.pmovil.nativega.impl.TrackerNativeInterface;
import com.codename1.system.NativeLookup;
import com.pmovil.nativega.fallback.TrackerImpl;
import java.net.URI;
import java.util.Map;


/**
 *
 * @author ivan
 */
public class Tracker {
    
    private TrackerNativeInterface impl;
    
    protected Tracker(String trackingId){
        impl = (TrackerNativeInterface)NativeLookup.create(TrackerNativeInterface.class);
        if(impl == null || !impl.isSupported()){
            impl = new TrackerImpl();
        }
        impl.initialize(trackingId);
    }

    public void enableAdvertisingIdCollection(boolean enabled){
        impl.enableAdvertisingIdCollection(enabled);
    }

    public void enableAutoActivityTracking(boolean enabled){
        impl.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enable){
        impl.enableExceptionReporting(enable);
    }

    public String get(String key){
        return impl.get(key);
    }

    public void set(String key, String value){
        impl.set(key, value);
    }

    public void setAnonymizeIp(boolean anonymize){
        impl.setAnonymizeIp(anonymize);
    }

    public void setAppId(String appId){
        impl.setAppId(appId);
    }

    public void setAppInstallerId(String appInstallerId){
        impl.setAppInstallerId(appInstallerId);
    }

    public void setAppName(String appName){
        impl.setAppName(appName);
    }

    public void setAppVersion(String appVersion){
        impl.setAppVersion(appVersion);
    }

    public void setClientId(String clientId){
        impl.setClientId(clientId);
    }

    public void setEncoding(String encoding){
        impl.setEncoding(encoding);
    }

    public void setHostname(String hostname){
        impl.setHostname(hostname);
    }

    public void setLanguage(String language){
        impl.setLanguage(language);
    }

    public void setLocation(String location){
        impl.setLocation(location);
    }

    public void setPage(String page){
        impl.setPage(page);
    }

    public void setReferrer(String referrer){
        impl.setReferrer(referrer);
    }

    public void setSampleRate(double sampleRate){
        impl.setSampleRate(sampleRate);
    }

    public void setScreenColors(String screenColors){
        impl.setScreenColors(screenColors);
    }

    public void setScreenName(String screenName){
        impl.setScreenName(screenName);
    }

    public void setScreenResolution(int width, int height){
        impl.setScreenResolution(width, height);
    }

    public void setSessionTimeout(long sessionTimeout){
        impl.setSessionTimeout(sessionTimeout);
    }

    public void setTitle(String title){
        impl.setTitle(title);
    }

    public void setUseSecure(boolean useSecure){
        impl.setUseSecure(useSecure);
    }

    public void setViewportSize(String viewportSize){
        impl.setViewportSize(viewportSize);
    }

    public void send(Map<String, String> values){
        impl.send(JSONUtils.encode(values));
    }
    
    public void setCampaignParamsOnNextHit(URI uri){
        impl.setCampaignParamsOnNextHit(uri.toString());
    } 

        
    
}

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
package com.pmovil.nativega.impl;

import com.codename1.system.NativeInterface;

/**
 *
 * @author ivan
 */
public interface TrackerNativeInterface extends NativeInterface{
    
    public void initialize(String trackingId);
    
    public void enableAdvertisingIdCollection(boolean enabled);

    public void enableAutoActivityTracking(boolean enabled);

    public void enableExceptionReporting(boolean enable);

    public String get(String key);

    public void set(String key, String value);

    public void setAnonymizeIp(boolean anonymize);

    public void setAppId(String appId);

    public void setAppInstallerId(String appInstallerId);

    public void setAppName(String appName);

    public void setAppVersion(String appVersion);

    public void setClientId(String clientId);

    public void setEncoding(String encoding);

    public void setHostname(String hostname);

    public void setLanguage(String language);

    public void setLocation(String location);

    public void setPage(String page);

    public void setReferrer(String referrer);

    public void setSampleRate(double sampleRate);

    public void setScreenColors(String screenColors);

    public void setScreenName(String screenName);

    public void setScreenResolution(int width, int height);

    public void setSessionTimeout(long sessionTimeout);

    public void setTitle(String title);

    public void setUseSecure(boolean useSecure);

    public void setViewportSize(String viewportSize);

    public void setCampaignParamsOnNextHit(String uri);
    
    public void send(String values);
    
    
}

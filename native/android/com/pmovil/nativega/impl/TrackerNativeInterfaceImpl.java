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

import com.codename1.impl.android.AndroidNativeUtil;


import android.net.Uri;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import android.util.Log;



import org.json.JSONObject;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TrackerNativeInterfaceImpl {
    
    private Tracker peer;
    private final Map<String, String> vars = new HashMap<String, String>();
    
    
    public void initialize(String trackingId) {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(AndroidNativeUtil.getActivity());
        peer = analytics.newTracker(trackingId);
    }
    
    
    public String get(String param) {
        return peer.get(param);
    }

    public void set(String key, String value) {
        peer.set(key, value);
    }

    public void send() {
        peer.send(vars);
        vars.clear();
    }

    public void setLanguage(String param) {
        peer.setLanguage(param);
    }

    public void setPage(String param) {
        peer.setPage(param);
    }

    public void setTitle(String param) {
        peer.setTitle(param);        
    }

    public void setLocation(String param) {
        peer.setLocation(param);        
    }

    public void setEncoding(String param) {
        peer.setEncoding(param);        
    }

    public void setAnonymizeIp(boolean param) {
        peer.setAnonymizeIp(param);        
    }

    public void enableExceptionReporting(boolean param) {
        peer.enableExceptionReporting(param);
    }

    public void setAppId(String param) {
        peer.setAppId(param);
    }

    public void enableAdvertisingIdCollection(boolean param) {
        peer.enableAdvertisingIdCollection(param);
    }

    public void enableAutoActivityTracking(boolean param) {
        peer.enableAutoActivityTracking(param);
    }

    public void setScreenName(String param) {
        peer.setScreenName(param);
    }

    public void setScreenResolution(int width, int height) {
        peer.setScreenResolution(width, height);
    }

    public void setSessionTimeout(long param) {
        peer.setSessionTimeout(param);
    }

    public void setUseSecure(boolean param) {
        peer.setUseSecure(param);
    }

    public void setAppInstallerId(String param) {
        peer.setAppInstallerId(param);
    }

    public void setAppName(String param) {
        peer.setAppName(param);
    }

    public void setAppVersion(String param) {
        peer.setAppVersion(param);
    }

    public void setClientId(String param) {
        peer.setClientId(param);
    }

    public void setViewportSize(String param) {
        peer.setViewportSize(param);
    }

    /*
    TODO: reimplement setCampaignParamsOnNextHit for GoogleAnalytics v3.0 and bellow
    Not compilig for Codename One 3.0
    
    /*
    public void setCampaignParamsOnNextHit(String param) {
        
        peer.setCampaignParamsOnNextHit(Uri.parse(param));
    }
    */

    public void setCampaignParamsOnNextHit(String param) {
    }
    
    
    public void setHostname(String param) {
        peer.setHostname(param);
    }

    public void setReferrer(String param) {
        peer.setReferrer(param);
    }

    public void setSampleRate(double param) {
        peer.setSampleRate(param);
    }

    public void setScreenColors(String param) {
        peer.setScreenColors(param);
    }

    public void setOnNextHit(String key, String value) {
        vars.put(key, value);
    }

    public void send(String json) {
        Log.d("TrackerNativeInterfaceImpl", json);
        final Map<String, String> params = new HashMap<String, String>();
        final JSONObject jsonObj;
        try {
            jsonObj = new JSONObject(json);
            Iterator<String> keysItr = jsonObj.keys();
            while(keysItr.hasNext()) {
                String key = keysItr.next();
                params.put(key, jsonObj.getString(key));
            }
            peer.send(params);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }    
    
    public boolean isSupported() {
        return true;
    }

}

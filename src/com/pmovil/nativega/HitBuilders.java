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

import com.codename1.system.NativeLookup;
import com.pmovil.nativega.impl.ScreenViewBuilderInterface;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.system.NativeInterface;
import com.pmovil.nativega.fallback.ScreenViewBuilderImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class HitBuilders {
    
    
    
    public interface HitBuilderInterface  {
        public void set(String paramName, String paramValue);
        public void setCampaignParamsFromUrl(String utmParams);
        public void setCustomDimension(int index, String dimension);
        public void setCustomMetric(int index, float metric);
        public void setNewSession();
        public void setNonInteraction(boolean nonInteraction);
        public String build();

    }    
    
    protected static class HitBuilder<T>{
        
        protected HitBuilderInterface impl;
        
        public <T> T set(String paramName, String paramValue){
            impl.set(paramName, paramValue);
            return (T)this;
        }
        public <T> T setCampaignParamsFromUrl(String utmParams){
            impl.setCampaignParamsFromUrl(utmParams);
            return (T)this;

        }
        public <T> T setCustomDimension(int index, String dimension){
            impl.setCustomDimension(index, dimension);
            return (T)this;

        }
        public <T> T setCustomMetric(int index, float metric){
            impl.setCustomMetric(index, metric);
            return (T)this;

        }
        public <T> T setNewSession(){
            impl.setNewSession();
            return (T)this;

        }
        public void setNonInteraction(boolean nonInteraction){
            impl.setNonInteraction(nonInteraction);
        }
        public Map<String, String> build(){
            final String json = impl.build();
            final JSONParser jp = new JSONParser();
            final Map<String, String> params = new HashMap<String, String>();
            
            try {
                Map<String, Object> decoded = jp.parseJSON(new InputStreamReader(new ByteArrayInputStream(json.getBytes("UTF-8"))));
                for (Map.Entry<String, Object> entrySet : decoded.entrySet()) {
                    params.put(entrySet.getKey(), (String)entrySet.getValue());
                }
            } catch (UnsupportedEncodingException ex) {
                Log.e(ex);
            } catch (IOException ex) {
                Log.e(ex);
            }
            return params;
        }
    }
    
    
    public static class ScreenViewBuilder extends HitBuilder{

        public ScreenViewBuilder(){
            impl = (ScreenViewBuilderInterface)NativeLookup.create(ScreenViewBuilderInterface.class);
            if( impl == null || !((NativeInterface)impl).isSupported()){
                impl = new ScreenViewBuilderImpl();
            }
        }
        
    }    
}

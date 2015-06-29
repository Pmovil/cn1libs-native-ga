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
package com.pmovil.nativega.fallback;

import com.pmovil.nativega.impl.GANativeInterface;

/**
 *
 * @author ivan
 */
public class GANativeImpl implements GANativeInterface{

    private static GANativeImpl instance;
    
    private GANativeImpl(){
    }

    public static GANativeImpl getInstance(){
        if(instance == null){
            instance = new GANativeImpl();
        }
       return instance;
    }
    
    public boolean getAppOptOut() {
        return false;
    }

    public boolean isDryRunEnabled() {
        return false;
    }

    public void setAppOptOut(boolean optOut) {
    }

    public void setDryRun(boolean dryRun) {
    }

    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
    }

    public void dispatchLocalHits() {
    }

    public boolean isSupported() {
        return false;
    }
    
}

/*
 The MIT License (MIT)

 Copyright (c) 2015 Massimo Caliman

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package io.github.mcaliman.patterns.singletion;

/**
 * Singleton che realizza una forma di pre-elaborazione ( utile ad esempio per
 * il controllo degli errori).
 *
 * @author mcaliman
 */
public class StaticBlockInitializationSingleton {

    private final static StaticBlockInitializationSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockInitializationSingleton();
        } catch (Exception e) {
            throw new RuntimeException("error occurred.", e);
        }
    }

    private String property = "StaticBlockInitializationSingleton property value.";

    private StaticBlockInitializationSingleton() {
        //dovrebbe contiene qualcosa che potrebbe lanciare un eccezione...
        System.out.println("Istanza di StaticBlockInitializationSingleton creata! Questo messaggio non dovrà apparire più di una volta.");
    }

    public static StaticBlockInitializationSingleton getInstance() {
        return INSTANCE;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}

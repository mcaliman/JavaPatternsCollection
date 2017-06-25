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
 * Un altro tipo di singleton sicuro rispetto al multi-thread.
 *
 * @author Massimo Caliman
 */
public class ThreadSafeSingleton {

    /**
     * volatile garantisce che i cambiamenti siano visti immediatamente da tutti
     * gli altri thread
     */
    private static volatile ThreadSafeSingleton instance = null;
    private String property = "ThreadSafeSingleton property value.";

    /**
     * Il costruttore private impedisce l'istanza di oggetti da parte di classi
     * esterne
     */
    private ThreadSafeSingleton() {
        System.out.println("Istanza di ThreadSafeSingleton creata! Questo messaggio non dovrà apparire più di una volta.");
    }

    /**
     * Per accedere al singleton (vedi le altre classi di esempio e relativi
     * commenti).
     *
     * @return il singleton
     */
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            /*
             * E' possibile rendere synchronized solo questa parte del metodo perché l'istanza
             * è di tipo volatile. Meno parte di un blocco di codice si riesce a rendere
             * synchronized meglio è...
             */
            synchronized (ThreadSafeSingleton.class) {
                //non sono sicuro di essere ancora il primo thread ad accedere al metodo,
                //quindi ricontrollo
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}

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
 * Un singleton "pigro" (lazy). Inizializza (con tutti i relativi vantaggi)
 * la sua istanza solo quando necessario.
 *
 * @author Massimo Caliman
 */
public class LazyInitializationSingleton {

    private static LazyInitializationSingleton instance = null;
    /**
     * La proprietà (anche se è un dummy!) che giustifica il singleton (qualcosa
     * dovrà pur fare o comunicare.
     */
    private String property = "LazyInitializationSingleton property value.";

    /**
     * Il costruttore privato impedisce l'istanza di oggetti da parte di classi esterne.
     */
    private LazyInitializationSingleton() {
        System.out.println("Istanza di LazyInitializationSingleton creata! Questo messaggio non dovrà apparire più di una volta.");
    }

    /**
     * Metodo della classe impiegato per accedere al singleton. E'per ovvi motivi
     * sincronizzato (con due thread tentano di accedere si rischia la doppia istanza).
     *
     * @return il singleton.
     */
    public static synchronized LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
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

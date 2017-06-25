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
 * Se l'applicazione ha sempre necessità di una istanza, o se il costo di
 * creazione della stessa non è troppo grande in termini di tempo e risorse, si
 * può utilizzare questa modalità che crea sempre un istanza.
 * <p>
 * L'Eager (impaziente!) Initialization Singleton è un singleton impaziente di inizializzare
 * la sua unica istanza possibile.
 *
 * @author Massimo Caliman
 */
public class EagerInitializationSingleton {

    /**
     * Istanza creata all'atto di caricamento della classe in memoria
     * quindi è thread-safe! Le convenzioni sono importanti
     * INSTANCE è scritto in maiscolo in quanto final e static.
     */
    private final static EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();
    /**
     * Il singleton è utile se contiene o fa qualcosa, ecco quindi
     * un unica proprietà (dummy) accessive solo tramite setter e getter
     * appositi.
     */
    private String property = "EagerInitializationSingleton property value.";

    /**
     * Il costruttore è privato, in quanto la creazione dell'istanza deve essere
     * controllata. Può avvenire solo all'interno della classe Singleton.
     */
    private EagerInitializationSingleton() {
        System.out.println("Istanza di EagerInitializationSingleton creata! Questo messaggio non dovrà apparire più di una volta.");
    }

    /**
     * Unico punto di accesso al Singleton tramite metodo pubblico e statico.
     *
     * @return il Singleton
     */
    public static EagerInitializationSingleton getInstance() {
        return INSTANCE;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}

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
package io.github.mcaliman.patterns.chain.of.responsibility.example2;

/**
 * Se un handler giusto viene trovato non si ferma nella catena ma prosegue
 * comunque per vedere se ci sono altri handler che possono trattare l'oggetto.
 * L'ordine seguito è quello di aggiuta degli Handler
 * <p>
 * Chain seq. do not stop if match property.
 * <p>
 * TODO FIX: problems if properties A,B,C (more than 2)
 *
 * @author Massimo Caliman
 */
public class Client {

    private EntryProcessor proc;

    public Client() {
        proc = new EntryProcessor();
        proc.addHandler(new AHandler());
        proc.addHandler(new BHandler());
    }

    public static void main(String[] args) {

        Entry e = new Entry();
        e.setName("Object with property B and A");
        e.setPropertyA(true);
        e.setPropertyB(true);

        Client client = new Client();
        client.handle(e);

    }

    public void handle(Entry e) {
        proc.handleRequest(e);
    }
}

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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Massimo Caliman
 */
public class AHandler implements Handler {

    private static final Logger LOG = Logger.getLogger(AHandler.class.getName());

    private Handler next;

    @Override
    public void next(Handler handler) {
        next = handler;
    }

    @Override
    public void handleRequest(Entry e) {
        if (e.isPropertyA()) {
            //Fai qualcosa con l'oggetto perchè ha la proprietà A e l'handler sa come trattarlo            
            //Stuff..
            LOG.log(Level.INFO, "> {0} : call AHandler ", e.toString());
        }
        //Prosegue nella catena
        if (next != null) {
            next.handleRequest(e);
        }
    }
}

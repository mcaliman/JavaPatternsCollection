/*
 The MIT License (MIT)

 Copyright (c) 2016 Massimo Caliman

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
package io.github.mcaliman.patterns.strategy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Massimo Caliman
 */
public class TestStrategy {

    public static void main(String[] args) {
        final int LEN = 10000;
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            list1.add(i);
        }
        Collections.shuffle(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            list2.add(i);
        }
        Collections.shuffle(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            list3.add(i);
        }
        Collections.shuffle(list3);

        //randomized
        Context context1 = new Context(list1);
        context1.sort(new CollectionsSort_Strategy());

        Context context2 = new Context(list2);
        context2.sort(new StreamSort_Strategy());

        Context context3 = new Context(list3);
        context3.sort(new CollectionLambdaSort_Strategy());

    }

}

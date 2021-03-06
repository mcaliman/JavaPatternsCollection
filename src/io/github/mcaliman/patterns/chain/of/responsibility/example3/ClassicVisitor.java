/*
 The MIT License (MIT)

 Copyright (c) 2017 Massimo Caliman

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
package io.github.mcaliman.patterns.chain.of.responsibility.example3;

/**
 * @author Massimo Caliman
 */
public class ClassicVisitor {

    public static void main(String[] args) {
        ClassicVisitor visitor = new ClassicVisitor();
        visitor.visit(new C());
    }

    public void visit(Object object) {
        if (object instanceof A) {
            visit(object);
        } else if (object instanceof B) {
            visit(object);
        } else if (object instanceof C) {
            visit(object);
        }
    }

    public void visit(A object) {
        System.out.println(object);
    }

    public void visit(B object) {
        System.out.println(object);
    }

    public void visit(C object) {
        System.out.println(object);
    }

}

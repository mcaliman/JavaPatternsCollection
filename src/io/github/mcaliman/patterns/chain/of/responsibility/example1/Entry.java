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
package io.github.mcaliman.patterns.chain.of.responsibility.example1;

import java.util.Objects;

/**
 * @author Massimo Caliman
 */
public class Entry {

    private String name;
    private boolean propertyA;
    private boolean propertyB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPropertyA() {
        return propertyA;
    }

    public void setPropertyA(boolean propertyA) {
        this.propertyA = propertyA;
    }

    public boolean isPropertyB() {
        return propertyB;
    }

    public void setPropertyB(boolean propertyB) {
        this.propertyB = propertyB;
    }

    @Override
    public String toString() {
        return "[name:" + this.name + ",A=" + this.propertyA + ",B=" + this.propertyB + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + (this.propertyA ? 1 : 0);
        hash = 23 * hash + (this.propertyB ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entry other = (Entry) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.propertyA != other.propertyA) {
            return false;
        }
        return this.propertyB == other.propertyB;
    }

}

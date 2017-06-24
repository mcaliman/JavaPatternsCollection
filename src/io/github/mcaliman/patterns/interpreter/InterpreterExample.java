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
package io.github.mcaliman.patterns.interpreter;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * @author Massimo Caliman
 */
public class InterpreterExample {

    public static void example1() {
        EvalExpr evalExpr = new EvalExpr("a b c - +");
        Map<String, Expr> variables = new HashMap<>();
        variables.put("a", new NumExpr(1));
        variables.put("b", new NumExpr(1));
        variables.put("c", new NumExpr(1));
        int result = evalExpr.interpret(variables);
        out.println(result);
    }

    public static void example2() {
        String expr2 = "a b +";
        EvalExpr evalExpr = new EvalExpr(expr2);
        Map<String, Expr> variables = new HashMap<>();
        variables.put("a", new NumExpr(3));
        variables.put("b", new NumExpr(7));
        int result = evalExpr.interpret(variables);
        out.println(result);
    }

    public static void main(String[] args) {
        example1();
        example2();
    }
}

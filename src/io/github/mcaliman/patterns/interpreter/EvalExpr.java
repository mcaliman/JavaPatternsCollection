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

import java.util.Map;
import java.util.Stack;

/**
 * @author Massimo Caliman
 */
public class EvalExpr implements Expr {

    private final Expr expr;

    /**
     * @param string
     */
    public EvalExpr(String string) {
        Stack<Expr> stack = new Stack<>();
        //attenzione non rimuove spazi multipli, da implementare.
        for (String token : string.split(" ")) {
            switch (token) {
                case "+":
                    Expr addExpr = new AddExpr(stack.pop(), stack.pop());
                    stack.push(addExpr);
                    break;
                case "-":
                    Expr right = stack.pop();
                    Expr left = stack.pop();
                    Expr subExpr = new SubExpr(left, right);
                    stack.push(subExpr);
                    break;
                default:
                    stack.push(new VarExpr(token));
                    break;
            }
        }
        this.expr = stack.pop();
    }

    @Override
    public int interpret(Map<String, Expr> context) {
        return this.expr.interpret(context);
    }
}

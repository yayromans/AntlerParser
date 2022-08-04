package org.langparser;

import antlr4.Java8Parser;
import antlr4.Java8BaseListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;


public class UppercaseMethodListener extends Java8BaseListener {
    public static final String ERROR_ONE = "Method is uppercase!";
    private final List<String> errors = new ArrayList<>();

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        String methodName = node.getText();

        if (Character.isUpperCase(methodName.charAt(0))) {
            errors.add(ERROR_ONE);
        }
    }
}

package org.langparser;

import antlr4.Java8Lexer;
import antlr4.Java8Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.goTest();
    }

    public void goTest() {
        //Now, let's do some testing. First, we construct the lexer:

        String javaClassContent = "public class SampleClass { void DoSomething(){} }";
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromString(javaClassContent));


        //Then, we instantiate the parser:
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();


        //And then, the walker and the listener:
        ParseTreeWalker walker = new ParseTreeWalker();
        UppercaseMethodListener listener = new UppercaseMethodListener();


        //Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);
       // assertThat(listener.getErrors().size(), is(1));
       // assertThat(listener.getErrors().get(0), is("Method DoSomething is uppercased!"));
    }

}


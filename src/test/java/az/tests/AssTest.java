package az.tests;

import antlr4.Java8Lexer;
import antlr4.Java8Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.langparser.UppercaseMethodListener;
import org.junit.jupiter.api.Test;

import static org.langparser.UppercaseMethodListener.ERROR_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssTest {

    @Test
    public void testAssertThatEqual() {
        assertEquals("123", "123");
    }

    @Test
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
        assertEquals(listener.getErrors().size(), 1);
        assertEquals(listener.getErrors().get(0), ERROR_ONE);
    }
}

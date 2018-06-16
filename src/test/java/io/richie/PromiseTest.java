package io.richie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PromiseTest{

    private Promise promise;

    @BeforeEach
    void setup(){
        promise = new Promise();
    }

    @Test
    void shouldGetPromise() throws ExecutionException, InterruptedException{

        CompletableFuture<String> actual = promise.helloPromise();
        assertEquals("Hello ", actual.get());
        assertNotEquals("Hello World", actual.get());
    }

    @Test
    void shouldProcessPromise() throws ExecutionException, InterruptedException{
        String addendum = "Richie";
        CompletableFuture<String> actual = promise.processPromise(addendum);
        assertNotEquals("Hello", actual.get());
        assertEquals("Hello " + addendum, actual.get());
    }

    @Test
    void shouldProcessConsumerPromise() throws ExecutionException, InterruptedException{

        // Setup Print Streams so that we can see what is outputted
        final OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When I call the promise that outputs to System.out.println
        promise.consumerPromise().get();

        // Then the output stream should have the value printed by the promise
        assertEquals("Hello World: Promise Finished\n", outputStream.toString());

        // Clean up
        System.setOut(System.out);
    }

    @Test
    void shouldCombinePromise() throws ExecutionException, InterruptedException{

        String promiseString = "Composed World";

        CompletableFuture<String> combinedPromise = promise.combinePromise(promiseString);
        assertEquals("Hello " + promiseString, combinedPromise.get());

    }

}
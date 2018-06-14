package io.richie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompletableFuturesTest{

    @Test
    void shouldGetPromise() throws ExecutionException, InterruptedException{
        CompletableFuture<String> actual = new CompletableFutures().helloPromise();
        assertEquals("Hello", actual.get());
        Assertions.assertNotEquals("Hello World", actual.get());
    }

    @Test
    void shouldProcessPromise() throws ExecutionException, InterruptedException{
        String addendum = "Richie";
        CompletableFuture<String> actual = new CompletableFutures().processPromise(addendum);
        Assertions.assertNotEquals("Hello", actual.get());
        assertEquals("Hello " + addendum, actual.get());
    }
}
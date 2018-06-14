package io.richie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CompletableFuturesTest{

    @Test
    void helloPromise() throws ExecutionException, InterruptedException{
        CompletableFuture<String> actual = new CompletableFutures().helloPromise();
        Assertions.assertEquals("Hello", actual.get());
        Assertions.assertNotEquals("Hello World", actual.get());
    }
}
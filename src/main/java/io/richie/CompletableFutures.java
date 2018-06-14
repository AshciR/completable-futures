package io.richie;

import java.util.concurrent.CompletableFuture;

public class CompletableFutures{

    public CompletableFuture<String> helloPromise(){
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

}

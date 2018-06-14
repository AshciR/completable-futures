package io.richie;

import java.util.concurrent.CompletableFuture;

class CompletableFutures{

    CompletableFuture<String> helloPromise(){
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    CompletableFuture<String> processPromise(String addendum){
        return CompletableFuture.supplyAsync(() -> "Hello ")
                                .thenApply(it -> it + addendum);
    }
}

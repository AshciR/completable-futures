package io.richie;

import java.util.concurrent.CompletableFuture;

class Promise{

    CompletableFuture<String> helloPromise(){
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    CompletableFuture<String> processPromise(String addendum){
        return CompletableFuture.supplyAsync(() -> "Hello ")
                                .thenApply(it -> it + addendum);
    }

    CompletableFuture<Void> consumerPromise(){
        return CompletableFuture.supplyAsync(() -> "Hello World")
                                .thenAccept(it -> System.out.println(it + ": Promise Finished"));
    }


}

package io.richie;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

class Promise{

    private final Supplier<String> helloMethod = () -> "Hello ";

    CompletableFuture<String> helloPromise(){
        return CompletableFuture.supplyAsync(helloMethod);
    }

    CompletableFuture<String> processPromise(String addendum){
        return CompletableFuture.supplyAsync(helloMethod)
                                .thenApply(it -> it + addendum);
    }

    CompletableFuture<Void> consumerPromise(){
        return CompletableFuture.supplyAsync(() -> "Hello World")
                                .thenAccept(it -> System.out.println(it + ": Promise Finished"));
    }

    CompletableFuture<String> combinePromise(String nextString){
        CompletableFuture<String> initialPromise = CompletableFuture.supplyAsync(helloMethod);
        // The compose method allows us to combine futures
        return initialPromise.thenCompose(it -> CompletableFuture.supplyAsync(() -> it + nextString));
    }

}

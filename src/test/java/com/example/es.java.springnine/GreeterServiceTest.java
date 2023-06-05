package com.example.es.java.springnine;

import com.example.es.java.springnine.proto.GreeterGrpc;
import com.example.es.java.springnine.proto.GreeterOuterClass;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class GreeterServiceTest {

    @Test
    public void testSayHello() {
        // Create a mock StreamObserver
        StreamObserver<GreeterOuterClass.HelloReply> responseObserver = Mockito.mock(StreamObserver.class);

        // Create a HelloRequest
        GreeterOuterClass.HelloRequest request = GreeterOuterClass.HelloRequest.newBuilder()
                .setName("John")
                .build();

        // Create a GreeterService instance and call the sayHello method
        GreeterService greeterService = new GreeterService();
        greeterService.sayHello(request, responseObserver);

        // Capture the argument passed to the onNext method of the responseObserver
        ArgumentCaptor<GreeterOuterClass.HelloReply> argumentCaptor = ArgumentCaptor.forClass(GreeterOuterClass.HelloReply.class);
        verify(responseObserver).onNext(argumentCaptor.capture());

        // Verify that the message in the HelloReply is correct
        assertEquals("Hello John", argumentCaptor.getValue().getMessage());
    }
}

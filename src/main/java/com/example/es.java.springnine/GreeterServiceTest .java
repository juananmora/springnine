import com.example.es.java.springnine.proto.GreeterOuterClass;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class GreeterServiceTest {

    @Mock
    private StreamObserver<GreeterOuterClass.HelloReply> responseObserver;

    private GreeterService greeterService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        greeterService = new GreeterService();
    }

    @Test
    public void testSayHello() {
        // Create a sample request
        GreeterOuterClass.HelloRequest request = GreeterOuterClass.HelloRequest.newBuilder()
                .setName("John")
                .build();

        // Call the method under test
        greeterService.sayHello(request, responseObserver);

        // Verify that the expected response was sent to the response observer
        verify(responseObserver, times(1)).onNext(any(GreeterOuterClass.HelloReply.class));
        verify(responseObserver, times(1)).onCompleted();
    }
}

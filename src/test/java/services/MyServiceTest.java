package services;

import external.services.BQClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MyServiceTest {
    @Mock
    BQClient bqClient;
    @InjectMocks
    MyService myService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSendMessage() {
        when(bqClient.getFormattedMessage(anyString())).thenReturn("method formatMessage was mocked");
        myService.sendMessage("testMessage");
        verify(bqClient, times(1)).putObject(anyString());
    }

    @Test
    void testSendMessageThrowException() {
        when(bqClient.getFormattedMessage(anyString())).thenReturn(null);
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> myService.sendMessage("testMessage"));
        Assertions.assertEquals("message cannot be null", e.getMessage());
        verify(bqClient, times(0)).putObject(anyString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
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
    void testSendMessageOK() {
        when(bqClient.getFormattedMessage(anyString())).thenReturn("mock Message");
        myService.sendMessage("message");
        verify(bqClient, times(1)).putObject(anyString());
    }
    @Test
    void testSendMessageFail() {
        when(bqClient.getFormattedMessage(anyString())).thenReturn(null);
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> myService.sendMessage("message"));
        Assertions.assertEquals("message cannot be null", e.getMessage());
        verify(bqClient, times(0)).putObject(anyString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
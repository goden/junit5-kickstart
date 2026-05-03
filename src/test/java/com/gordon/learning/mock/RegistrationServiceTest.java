package com.gordon.learning.mock;

import com.gordon.learning.mock.case1.EmailService;
import com.gordon.learning.mock.case1.RegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {

    @Mock
    private EmailService mockEmailService;

    @Test
    void testRegister() {
        RegistrationService service = new RegistrationService(mockEmailService);
        String userEmail = "test@example.com";

        // Step 1: Act
        service.register(userEmail);

        // Step 2: Assert
        // verify mockEmailService.sendWelcomeEmail() was invoked
        // the input parameter should be "test@example.com"
        verify(mockEmailService).sendWelcomeEmail(userEmail);

        // advance verification, assure this method invoked only 1 time.
        verify(mockEmailService, times(1)).sendWelcomeEmail(anyString());
    }

}

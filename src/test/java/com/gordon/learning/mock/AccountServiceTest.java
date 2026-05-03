package com.gordon.learning.mock;

import com.gordon.learning.mock.case2.Account;
import com.gordon.learning.mock.case2.AccountManager;
import com.gordon.learning.mock.case2.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountManager mockAccountManager;

    @Test
    void testTransferOK() {

        Account sender = new Account("1", 200);
        Account beneficiary = new Account("2", 300);

        // Step 1: Arrange
        Mockito.lenient().when(mockAccountManager.findByUserId("1")).thenReturn(sender);
        Mockito.lenient().when(mockAccountManager.findByUserId("2")).thenReturn(beneficiary);

        // Step 2: Act
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 200);

        // Step 3: Assert
        assertEquals(0, sender.getBalance());
        assertEquals(500, beneficiary.getBalance());
    }

}

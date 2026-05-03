package com.gordon.learning.mock.case2;

public interface AccountManager {
    Account findByUserId(String userId);
    void updateAccount(Account account);
}

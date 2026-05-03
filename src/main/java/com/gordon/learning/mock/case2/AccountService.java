package com.gordon.learning.mock.case2;

public class AccountService {

    private AccountManager accountManager;

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void transfer(String senderId, String beneficiaryId, long amount) {
        Account sender = accountManager.findByUserId(senderId);
        Account beneficiary = accountManager.findByUserId(beneficiaryId);
        sender.debit(amount);
        beneficiary.withdraw(amount);
        accountManager.updateAccount(sender);
        accountManager.updateAccount(beneficiary);
    }

}

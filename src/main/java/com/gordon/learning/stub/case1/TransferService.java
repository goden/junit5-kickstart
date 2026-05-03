package com.gordon.learning.stub.case1;

/**
 * <h3>轉帳服務</h3>
 * Stub測試概念的測試對象
 */
public class TransferService {

    /**
     * 外部依賴：匯率服務介面
     */
    private final ExchangeRateService rateService;

    public TransferService(ExchangeRateService rateService) {
        this.rateService = rateService;
    }

    public double convertCurrency(double amount, String from, String to) {
        double rate = rateService.getRate(from, to);
        return amount * rate;
    }
}

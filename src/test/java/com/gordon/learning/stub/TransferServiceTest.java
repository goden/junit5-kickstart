package com.gordon.learning.stub;

import com.gordon.learning.stub.case1.ExchangeRateService;
import com.gordon.learning.stub.case1.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * <p>
 *      此測試案例的3個重點：
 * </p>
 *  <ul>
 *      <li>
 *          <strong>解耦 (Decoupling):</strong>
 *          transferService 不需要知道 ExchangeRateService 背後是怎麼計算匯率（SQL、RestAPI 還是檔案）
 *      </li>
 *      <li>
 *          <strong>確定性 (Determinism):</strong>
 *          匯率每秒都在變化，但是測試要的是穩定數值，使用Stub基本就確立每次跑測試時，結果是一致的。
 *      </li>
 *      <li>
 *          <storng>Sugar:</storng>
 *          <ul>
 *              <li>when(...).thenReturn(...)：這是最標準的 Stub 寫法。</li>
 *              <li>when(...).thenThrow(...)：如果想測試「如果 API 異常時拋出 Exception，程式會不會 crash」，這個method就很好用</li>
 *          </ul>
 *      </li>
 *  </ul>
 *
 */
@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {

    @Mock
    private ExchangeRateService mockService;        // 建立一個Stub(替身)

    @Test
    void testConvertCurrency() {
        // Step 1: Arrange (設定 Stub 回傳值)
        // 如果getRate("USD", "TWD")被呼叫時，就回傳31.5
        when(mockService.getRate("USD", "TWD")).thenReturn(31.5);

        TransferService transferService = new TransferService(mockService);

        // Step 2: 執行受測方法
        double result = transferService.convertCurrency(100,  "USD", "TWD");

        // Step 3: 驗證結果
        assertEquals(3150.0, result);

    }

    @Test
    void testConvertCurrencyWithZeroRate() {
        // 模擬異常或極端情況：匯率變成 0
        when(mockService.getRate("ANY", "ANY")).thenReturn(0.0);

        TransferService service = new TransferService(mockService);
        double result = service.convertCurrency(100, "ANY", "ANY");

        assertEquals(0.0, result);
    }

}

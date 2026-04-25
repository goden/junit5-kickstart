package com.gordon.learning.junt5.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnumSourceTest {

    @DisplayName(value = "Test each element in UploadStatus.")
    @ParameterizedTest
    @EnumSource(UploadStatus.class)
    void testWithEnumSource(UploadStatus status) {
        assertEquals(4, UploadStatus.values().length);
    }

    @ParameterizedTest
    @EnumSource(value = UploadStatus.class, mode = EnumSource.Mode.EXCLUDE, names = {"UNKNOWN"})
    void testSelectedStatusInUploadStatus(UploadStatus status) {
        // only 2 execution whatever.
        assertEquals(4, UploadStatus.values().length);
    }

    enum UploadStatus {

        SUCCESS(0, "成功"),
        PARTIAL(1, "部份成功"),
        FAILURE(2, "失敗"),
        UNKNOWN(-1, "未知");

        private int code;
        private String desc;

        UploadStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static UploadStatus find(int code) {
            UploadStatus s = null;
            for(UploadStatus status: UploadStatus.values()) {
                if (status.getCode() == code) {
                    return s;
                }
            }

            return UNKNOWN;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }


    }

}

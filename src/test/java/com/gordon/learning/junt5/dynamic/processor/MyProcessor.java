package com.gordon.learning.junt5.dynamic.processor;

public class MyProcessor {

    String result;
    StringBuilder builder;

    public void initialize() {
        result = "";
        builder = new StringBuilder();
    }

    public String process(String data) {
        if (data.isEmpty())
            return data;
        return builder.append(data).toString();
    }


    public void cleanup() {
        result = null;

    }
}

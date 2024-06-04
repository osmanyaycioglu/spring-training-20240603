package org.training.spring.springtraining20240603.rest.models;

public class HelloResponse {
    private String result;
    private String note;

    public HelloResponse() {
    }

    public HelloResponse(final String resultParam,
                         final String noteParam) {
        result = resultParam;
        note   = noteParam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(final String resultParam) {
        result = resultParam;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String noteParam) {
        note = noteParam;
    }
}

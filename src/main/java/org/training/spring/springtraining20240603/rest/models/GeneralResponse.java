package org.training.spring.springtraining20240603.rest.models;

public class GeneralResponse<T> {
    private boolean error;
    private int errorCode;
    private String errorDesc;
    private int errorCategory;
    private T body;

    public static <E> GeneralResponse<E> createSuccess(E body){
        GeneralResponse<E> eGeneralResponseLoc = new GeneralResponse<>();
        eGeneralResponseLoc.setError(false);
        eGeneralResponseLoc.setBody(body);
        return eGeneralResponseLoc;
    }

    public boolean isError() {
        return error;
    }

    public void setError(final boolean errorParam) {
        error = errorParam;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final int errorCodeParam) {
        errorCode = errorCodeParam;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(final String errorDescParam) {
        errorDesc = errorDescParam;
    }

    public int getErrorCategory() {
        return errorCategory;
    }

    public void setErrorCategory(final int errorCategoryParam) {
        errorCategory = errorCategoryParam;
    }

    public T getBody() {
        return body;
    }

    public void setBody(final T bodyParam) {
        body = bodyParam;
    }
}

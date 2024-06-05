package org.training.spring.springtraining20240603.rest.error;

import java.util.List;

public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String desc;
    private int errorCode;

    public ErrorObj() {
    }

    public ErrorObj(final List<ErrorObj> subErrorsParam,
                    final String descParam,
                    final int errorCodeParam) {
        subErrors = subErrorsParam;
        desc      = descParam;
        errorCode = errorCodeParam;
    }

    public List<ErrorObj> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(final List<ErrorObj> subErrorsParam) {
        subErrors = subErrorsParam;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String descParam) {
        desc = descParam;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final int errorCodeParam) {
        errorCode = errorCodeParam;
    }
}

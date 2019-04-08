package com.example.taxii.rest.impl.objects;

import com.example.taxii.rest.api.datatypes.ErrorMessage;
import lombok.Data;

import java.util.Map;

@Data
public class ErrorMessageImpl implements ErrorMessage {

    private String title;

    private String description;

    private String errorId;

    private String errorCode;

    private String httpStatus;

    private String externalDetails;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getErrorId() {
        return errorId;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getExternalDetails() {
        return externalDetails;
    }

    @Override
    public Map<String, String> details() {
        return null;
    }
}

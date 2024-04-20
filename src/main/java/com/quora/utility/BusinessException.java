package com.quora.utility;

import com.quora.utility.models.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BusinessException extends WebApplicationException {
    public BusinessException(Response.Status status, String errorMessage){
        super(Response.status(status)
                .entity(new ErrorResponse(status.getStatusCode(), errorMessage)).type(MediaType.APPLICATION_JSON).build());
    }
}

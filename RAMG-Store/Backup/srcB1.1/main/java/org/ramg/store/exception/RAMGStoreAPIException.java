package org.ramg.store.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RAMGStoreAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}

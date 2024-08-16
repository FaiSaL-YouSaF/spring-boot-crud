package com.faisalyousaf777.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BlankNoteException extends RuntimeException {
    public BlankNoteException(String message) {
        super(message);
    }
}

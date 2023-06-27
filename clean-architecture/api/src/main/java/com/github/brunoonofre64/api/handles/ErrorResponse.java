package com.github.brunoonofre64.api.handles;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String title;
    private int codeStatus;
    private LocalDateTime timestamp;
    private String cause;

    public ErrorResponse(String title, int codeStatus, LocalDateTime timestamp, String cause) {
        this.title = title;
        this.codeStatus = codeStatus;
        this.timestamp = timestamp;
        this.cause = cause;
    }

    public String getTitle() {
        return title;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getCause() {
        return cause;
    }
}

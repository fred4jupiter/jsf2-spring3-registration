package com.itcuties.registration;

import java.util.ArrayList;
import java.util.List;


public class MessageFlashBean {

    private List<String> infoMessages = new ArrayList<>();

    private List<String> errorMessages = new ArrayList<>();

    public void addInfoMessage(String message) {
        infoMessages.add(message);
    }

    public void addErrorMessage(String message) {
        errorMessages.add(message);
    }

    public List<String> getInfoMessages() {
        return infoMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public boolean hasInfoMessage() {
        return !infoMessages.isEmpty();
    }

    public boolean hasErrorMessage() {
        return !errorMessages.isEmpty();
    }

    public boolean hasMessages() {
        return hasInfoMessage() || hasErrorMessage();
    }
}

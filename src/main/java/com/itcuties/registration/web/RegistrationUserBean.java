package com.itcuties.registration.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import com.itcuties.registration.MessageFlashBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itcuties.registration.service.RegistrationService;

/**
 * Registration user JSF bean.
 *
 * @author itcuties
 */
@Component
@ManagedBean
@SessionScoped
public class RegistrationUserBean {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationUserBean.class);

    // This is going to be injected by Spring framework
    @Autowired
    private RegistrationService registrationService;

    private String firstname;
    private String lastname;
    private String email;

    /**
     * Method registers user
     */
    public String register() {
        // Output some info
        LOG.debug("RegistrationUserBean:: Registering user {} {}, with email {}", firstname, lastname, email);

        // Call the business object to register the user
        registrationService.registerUser(firstname, lastname, email);

        if (firstname == null || "".equals(firstname)) {
            addErrorMsg("Firstname has not to be empty", "error");
        } else {
            addInfoMsg("Registration success. Hello " + firstname, "success");
        }

        return "index?faces-redirect=true";
    }

    private void addInfoMsg(String summary, String detail) {
        addMessage(summary, FacesMessage.SEVERITY_INFO, detail);
    }

    private void addErrorMsg(String summary, String detail) {
        addMessage(summary, FacesMessage.SEVERITY_ERROR, detail);
    }

    private void addMessage(String messageText, FacesMessage.Severity severity, String detail) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        MessageFlashBean msgBean = (MessageFlashBean) flash.get("msgBean");
        if (msgBean == null) {
            msgBean = new MessageFlashBean();
            flash.put("msgBean", msgBean);
        }

        if (FacesMessage.SEVERITY_INFO.equals(severity)) {
            msgBean.addInfoMessage(messageText);
        } else if (FacesMessage.SEVERITY_ERROR.equals(severity)) {
            msgBean.addErrorMessage(messageText);
        } else {
            msgBean.addInfoMessage(messageText);
        }

        facesContext.addMessage(null, new FacesMessage(severity, messageText, detail));
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

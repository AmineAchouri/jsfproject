/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("bean")
//@RequestScoped
@ConversationScoped
public class BackingBeanfirst implements Serializable {

    private Long value = new Long(0);
    private List<Long> values ;

    public List<Long> getValues() {
        return values;
    }
    @Inject
    private Conversation conversation;

    @PostConstruct
    public void postConstruct() {
        if (conversation != null ) {
            conversation.begin();
            conversation.setTimeout(900000);
                    }
    }

    public Conversation getConversation() {
        return conversation;
    }
public void confirm() {
    conversation.end();
    /*ry {
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.jsf?faces-redirect=true");
    } catch (IOException e) {
        e.printStackTrace();
    }*/
}
    public void add2Values() {
        if(values==null)
        {    values = new ArrayList<Long>();
        }
        values.add(value);
        
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getMessage() {
        return "The value is : " + value;
    }
}

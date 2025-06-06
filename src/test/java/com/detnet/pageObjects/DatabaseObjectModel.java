package com.detnet.pageObjects;

import com.detnet.utilities.DatabaseUtils;

import java.util.List;
import java.util.Map;

public class DatabaseObjectModel {
    private final List<Map<String,Object>> users;
    private final List<Map<String,Object>> networks;
    private final List<Map<String,Object>> groups;
    private final List<Map<String,Object>> recipients;

    public DatabaseObjectModel() {
        this.users = DatabaseUtils.getAllUsers();
        this.networks = DatabaseUtils.getAllNetworks();
        this.groups = DatabaseUtils.getAllGroups();
        this.recipients = DatabaseUtils.getAllRecipients();
    }

    public boolean hasUsers(){
        return users != null && !users.isEmpty();
    }

    public List<Map<String, Object>> getAllUsers(){
        return users;
    }

    public List<Map<String, Object>> findUserByEmail(String email){
        return DatabaseUtils.findUserByEmail(email);
    }

    public boolean hasNetworks(){
        return networks != null && !networks.isEmpty();
    }

    public List<Map<String, Object>> getAllNetworks(){
        return networks;
    }

    public List<Map<String,Object>> findNetworkByResourceName(String resourceName){
        return DatabaseUtils.findNetworkByResourceName(resourceName);
    }

    public List<Map<String,Object>> getAllGroups(){
        return groups;
    }

    public List<Map<String, Object>> findGroupByName(String name){
        return DatabaseUtils.findGroupByName(name);
    }

    public boolean hasGroups(){
        return groups != null && !groups.isEmpty();
    }

    public List<Map<String,Object>> getAllRecipients(){
        return recipients;
    }

    public boolean hasRecipients(){
        return recipients != null && !groups.isEmpty();
    }

    public List<Map<String,Object>> findRecipientByEmail(String email){
        return DatabaseUtils.findRecipientByEmail(email);
    }
}
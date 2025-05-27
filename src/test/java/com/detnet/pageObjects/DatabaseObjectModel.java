package com.detnet.pageObjects;

import com.detnet.utilities.DatabaseUtils;

import java.util.List;
import java.util.Map;

public class DatabaseObjectModel {
    private final List<Map<String,Object>> users;
    private final List<Map<String,Object>> networks;

    public DatabaseObjectModel() {
        this.users = DatabaseUtils.getAllUsers();
        this.networks = DatabaseUtils.getAllNetworks();
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
}
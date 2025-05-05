package com.detnet.pageObjects;

import com.detnet.utilities.DatabaseUtils;

import java.util.List;
import java.util.Map;

public class DatabaseObjectModel {
    private final List<Map<String,Object>> users;

    public DatabaseObjectModel() {
        this.users = DatabaseUtils.getAllUsers();
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
}
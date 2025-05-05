package com.detnet.managers;

public enum DatabaseQueryManager {
    SELECT_ALL_USERS(
            "SELECT name, password, role, surname, firstname, id, eventsmask, devicelist, modulepos, email, " +
            "notify, password_requires_reset, createdat, lastmodifiedat, createdby, lastmodifiedby, deleted\n" +
            "\tFROM public.users;"
    ),
    SELECT_USER_BY_EMAIL(
            "SELECT name, role, surname, firstname, id, email, notify, createdat, deleted " +
            "FROM public.users " +
            "WHERE email = ?;"
    );
//    TODO: Write more queries here...

    private final String query;

    DatabaseQueryManager(String query) {
        this.query = query;
    }

    public String get(){
        return query;
    }
}
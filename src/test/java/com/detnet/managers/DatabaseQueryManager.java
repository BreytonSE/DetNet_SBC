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
    ),
    SELECT_ALL_NETWORKS(
            "SELECT id, resourcename, param, netdelay, use, statistics, extendedstats, messagegap, serial_type, reportdets, " +
                    "createdat, lastmodifiedat, createdby, lastmodifiedby, deleted, messages_in, messages_out, " +
                    "expected_replies, lost_replies, bad_replies\n" +
                    "\tFROM public.networks;"
    ),
    SELECT_NETWORK_BY_NAME(
            "SELECT id, resourcename, param, netdelay, use, statistics, extendedstats, messagegap, serial_type, " +
                    "reportdets, createdat, lastmodifiedat, createdby, lastmodifiedby, deleted, messages_in, messages_out, " +
                    "expected_replies, lost_replies, bad_replies\n" +
                    "\tFROM public.networks " +
                    "WHERE resourcename = ?;"
    ),
    SELECT_GROUP_BY_NAME(
            "SELECT id, name, color, createdat, lastmodifiedat, createdby, lastmodifiedby " +
                    "FROM public.device_groups " +
                    "WHERE name = ?;"
    ),
    SELECT_ALL_GROUPS(
            "SELECT id, name, color, createdat, lastmodifiedat, createdby, lastmodifiedby " +
                    "FROM public.device_groups;"
    ),
    SELECT_ALL_RECIPIENTS(
            "SELECT email, created_date, last_modified_date, enabled, deleted, critical_errors, moderate_errors, firstname, lastname " +
                    "FROM public.error_recipients;"
    ),
    SELECT_RECIPIENT_BY_EMAIL(
            "SELECT email, created_date, last_modified_date, enabled, deleted, critical_errors, moderate_errors, firstname, lastname " +
                    "FROM public.error_recipients " +
                    "WHERE email = ?;"
    ),
    SELECT_DEVICE_BY_ID(
            "SELECT id, location, groupid " +
                    "FROM public.devices " +
                    "WHERE id = ? " +
                    "AND location = ? " +
                    "AND groupid = ?;"
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
package com.detnet.utilities;

import com.detnet.managers.DatabaseQueryManager;

import java.sql.*;
import java.util.*;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/quickshot";

    private static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                DB_URL,
                LoginConstantUtils.getDecryptedDatabaseUsername(),
                LoginConstantUtils.getDecryptedDatabasePassword()
        );
    }

    public static List<Map<String, Object>> executeQuery(DatabaseQueryManager query,Object...params){
        List<Map<String,Object>> results = new ArrayList<>();
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query.get())){

            for(int i = 0;i < params.length; i++){
                stmt.setObject(i + 1,params[i]); // Set each parameter
            }

            try(ResultSet rs = stmt.executeQuery()){
                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();

                while(rs.next()){
                    Map<String, Object> row = new HashMap<>();
                    for(int i=1;i<=columnCount;i++){
                        row.put(meta.getColumnName(i),rs.getObject(i));
                    }
                    results.add(row);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Database access failed", e);
        }catch (Exception e){
            throw new RuntimeException("Failed to decrypt database credentials",e);
        }

        return results;
    }

    public static List<Map<String,Object>> getAllUsers(){
       return executeQuery(DatabaseQueryManager.SELECT_ALL_USERS);
    }

    public static List<Map<String,Object>> findUserByEmail(String email){
        return executeQuery(DatabaseQueryManager.SELECT_USER_BY_EMAIL, email);
    }
}
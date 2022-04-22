package com.project.thrillio.dao;

import com.project.thrillio.datastore.DataStore;
import com.project.thrillio.entities.User;

public class UserDao {
    
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}

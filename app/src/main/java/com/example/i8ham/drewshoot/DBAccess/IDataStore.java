package com.example.i8ham.drewshoot.DBAccess;

/**
 * Created by i8ham on 9/21/2017.
 */

public interface IDataStore {
    void saveState(String state);
    String getState();
}

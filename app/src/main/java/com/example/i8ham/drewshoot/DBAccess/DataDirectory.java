package com.example.i8ham.drewshoot.DBAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by i8ham on 9/21/2017.
 */

public class DataDirectory implements IDataStore {
    File file;
    FileOutputStream fOut = null;
    OutputStreamWriter myOutWriter;

    public DataDirectory() throws IOException {
        file = new File("test.txt");

        try {
            fOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        myOutWriter = new OutputStreamWriter(fOut);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//reading from the file

    public String getState() {
        String state = "";
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        FileInputStream in = null;

        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        state = new String(bytes);
        //verifying that the file storage worked
        return state;
    }

    @Override
    public void saveState(String state) {
        try {
            myOutWriter.append(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myOutWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




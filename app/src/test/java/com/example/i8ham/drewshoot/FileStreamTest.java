package com.example.i8ham.drewshoot;

import com.example.i8ham.drewshoot.DBAccess.DataDirectory;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class FileStreamTest {

    @Test
    public void dbTest() throws IOException {
        DataDirectory db = new DataDirectory();
        db.saveState("testing");

        assertEquals("testing", db.getState());

    }
}

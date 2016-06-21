package com.servicetests.database.admin;


import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Anita on 2016/05/12.
 */


/*
I used intent service to delete all the values since I am not receiving values back when deleting the files.
 */
public class DeleteDBTest extends AndroidTestCase {

    public void testDeleteAll() throws Exception
    {
        Intent intent = new Intent(this.getContext(), InsertDBTest.class);
        this.getContext().startService(intent);




    }


}

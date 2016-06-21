package com.servicetests.members;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import main.services.members.MemberService;

/**
 * Created by Anita on 2016/05/12.
 */

/*

I used an intent service this will run in the background and therefor would not need to return a value

 */
public class MemberServiceTest extends AndroidTestCase {

    Context context = getContext();
    MemberService member = new MemberService();

    public void testAdultBookTitle()  throws Exception {
        Assert.assertEquals("Anita", member.getName());
    }

    public void testAdultAuthor()  throws Exception {
        Assert.assertEquals("Jonker", member.getSurname());
    }

    public void testAdultPages()  throws Exception {
        Assert.assertEquals("0N12586331", member.getCardNumber());
    }
}

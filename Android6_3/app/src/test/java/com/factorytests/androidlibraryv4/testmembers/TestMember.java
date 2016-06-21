package com.factorytests.androidlibraryv4.testmembers;


import junit.framework.Assert;

import org.junit.Test;

import main.factories.membersfactory.impl.UseMemberFactory;

/**
 * Created by Anita on 2016/04/16.
 */
public class TestMember {
    @Test
    public void testMemberName() throws Exception {
        UseMemberFactory memberFactory = new UseMemberFactory();
        Assert.assertEquals(memberFactory.getMember().getName(),"Anita");
    }

}

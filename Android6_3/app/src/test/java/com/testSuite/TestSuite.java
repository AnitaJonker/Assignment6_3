package com.testSuite;

import com.testBookSystem.TestBooks;
import com.testMembers.TestMember;
import com.testAdmin.TestWorker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


    @RunWith(Suite.class)
    @Suite.SuiteClasses({
    TestBooks.class,
            TestMember.class,
            TestWorker.class
    })


    public class TestSuite {}




package com.factorytests.androidlibraryv4.testsuite;

import com.factorytests.androidlibraryv4.testbooksystem.TestBooks;
import com.factorytests.androidlibraryv4.testmembers.TestMember;
import com.factorytests.androidlibraryv4.testadmin.TestWorker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


    @RunWith(Suite.class)
    @Suite.SuiteClasses({
    TestBooks.class,
            TestMember.class,
            TestWorker.class
    })


    public class TestSuite {}




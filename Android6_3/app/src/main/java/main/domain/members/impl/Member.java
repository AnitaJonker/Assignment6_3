package main.domain.members.impl;

import main.domain.members.MemberDetails;
import main.domain.members.RegisterMember;

/**
 * Created by Anita on 2016/04/16.
 */
public class Member implements RegisterMember
{
    public MemberDetails registerMember()
    {
        MemberDetails member = new MemberDetails.Builder()
                .name("Anita")
                .surname("Jonker")
                .address("Almeria str4")
                .address("Gotham 87")
                .libraryBranch("Durbanville")
                .cardNumber("0N12586331")
                .build();
        return member;
    }

}
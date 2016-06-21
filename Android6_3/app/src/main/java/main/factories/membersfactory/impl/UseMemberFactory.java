package main.factories.membersfactory.impl;

import main.factories.membersfactory.MemberFactory;
import main.domain.members.MemberDetails;
import main.domain.members.impl.Member;

/**
 * Created by Anita on 2016/04/16.
 */
public class UseMemberFactory implements MemberFactory {

    public MemberDetails getMember() {
        return new Member().registerMember();
    }
}


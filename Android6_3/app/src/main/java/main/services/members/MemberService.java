package main.services.members;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import main.domain.members.impl.Member;

public class MemberService extends IntentService {
    private static final String TAG = "services.booksystem";

    public MemberService() {
        super("MemberService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
                getName();
                getSurname();
                getCardNumber();
    }

    public String getName()
    {
        Member member = new Member();
        return member.registerMember().getName();
    }

    public String getSurname()
    {
        Member member = new Member();
        return member.registerMember().getSurname();

    }
    public String getCardNumber()
    {
        Member member = new Member();
        return member.registerMember().getCardNumber();
    }
}

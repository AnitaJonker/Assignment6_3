package com.repositorytests.members;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import main.domain.members.MemberDetails;
import main.repository.members.impl.MemberRepositoryImpl;

/**
 * Created by Anita on 2016/04/23.
 */
public class SettingsMemberTest  extends AndroidTestCase {
    private static final String TAG=" SETTINGS TEST ";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        MemberRepositoryImpl repo = new MemberRepositoryImpl(this.getContext());
        // CREATE
        MemberDetails createEntity = new MemberDetails.Builder()
                .name("Member")
                .surname("Details")
                .address("barbarossa")
                .libraryBranch("Bellville")
                .cardNumber("4758455142")
                .build();

        MemberDetails insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+ " CREATE ", insertedEntity);

        //READ ALL
        Set<MemberDetails> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL ", settings.size()>0);

        //READ ENTITY
        MemberDetails entity = repo.findById(id);
        Assert.assertEquals("Member",entity.getName());
        Assert.assertNotNull(TAG +" READ ENTITY ", entity);



        //UPDATE ENTITY
        MemberDetails updateEntity = new MemberDetails.Builder()
                .name("Member")
                .surname("Details")
                .address("barbarossa")
                .libraryBranch("Bellville")
                .cardNumber("4758455142")
                .build();
        repo.update(updateEntity);
        MemberDetails newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","barbarossa", newEntity.getAddress());

        // DELETE ENTITY
        repo.delete(updateEntity);
        MemberDetails deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

        repo.deleteAll();
        Set<MemberDetails> settingsDelete = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settingsDelete.size() == 0);
        // Assert.assertTrue(TAG + " test ALL", settings.size() == 0);


    }

}

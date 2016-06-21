package main.repository.members.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import main.conf.databases.DBConstants;
import main.domain.members.MemberDetails;
import main.repository.members.MemberRepository;

/**
 * Created by Anita on 2016/04/23.
 */
public class MemberRepositoryImpl extends SQLiteOpenHelper implements MemberRepository
{


    public static final String TABLE_NAME = "member";
    private SQLiteDatabase db;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_libBranch = "libraryBranch";
    public static final String COLUMN_cardNumber = "cardNumber";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_SURNAME + " TEXT NOT NULL , "
            + COLUMN_ADDRESS + " TEXT NOT NULL , "
            + COLUMN_libBranch + " TEXT NOT NULL , "
            + COLUMN_cardNumber + " TEXT NOT NULL);" ;

    public MemberRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public MemberDetails findById(long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_SURNAME,
                        COLUMN_ADDRESS,
                        COLUMN_libBranch,
                        COLUMN_cardNumber},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final MemberDetails worker = new MemberDetails.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                    .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                    .libraryBranch(cursor.getString(cursor.getColumnIndex(COLUMN_libBranch)))
                    .cardNumber(cursor.getString(cursor.getColumnIndex(COLUMN_cardNumber)))
                    .build();
            return worker;
        } else {
            return null;
        }
    }

    @Override
    public MemberDetails save(MemberDetails entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_libBranch, entity.getLibraryBranch());
        values.put(COLUMN_cardNumber, entity.getCardNumber());

        System.out.println("This excecutes");
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        MemberDetails insertedEntity = entity;
        return insertedEntity;
    }

    @Override
    public MemberDetails update(MemberDetails entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_libBranch, entity.getLibraryBranch());
        values.put(COLUMN_cardNumber, entity.getCardNumber());



        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public MemberDetails delete(MemberDetails entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<MemberDetails> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<MemberDetails> member = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final MemberDetails setting = new MemberDetails.Builder()

                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .libraryBranch(cursor.getString(cursor.getColumnIndex(COLUMN_libBranch)))
                        .cardNumber(cursor.getString(cursor.getColumnIndex(COLUMN_cardNumber)))
                        .build();
                member.add(setting);
            } while (cursor.moveToNext());
        }
        return member;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
    //    close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


}



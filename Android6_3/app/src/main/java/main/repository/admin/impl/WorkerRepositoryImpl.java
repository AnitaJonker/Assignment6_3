package main.repository.admin.impl;

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
import main.domain.admin.Worker;
import main.repository.admin.WorkerRepository;

/**
 * Created by Anita on 2016/04/22.
 */


public class WorkerRepositoryImpl extends SQLiteOpenHelper implements WorkerRepository
    {

        public static final String TABLE_NAME = "worker";
        private SQLiteDatabase db;
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_ADDRESS = "address";

        // Database creation sql statement
        private static final String DATABASE_CREATE = " CREATE TABLE "
                + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT NOT NULL , "
                + COLUMN_SURNAME + " TEXT NOT NULL , "
                + COLUMN_ADDRESS + " TEXT NOT NULL);" ;


        public WorkerRepositoryImpl(Context context) {
            super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
        }

        public void open() throws SQLException {
            db = this.getWritableDatabase();
        }

        public void close() {
            this.close();
        }

        @Override
        public Worker findById(long id) {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(
                    TABLE_NAME,
                    new String[]{
                            COLUMN_ID,
                            COLUMN_NAME,
                            COLUMN_SURNAME,
                            COLUMN_ADDRESS,},
                    COLUMN_ID + " =? ",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null,
                    null);
            if (cursor.moveToFirst()) {
                final Worker worker = new Worker.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .build();
                return worker;
            } else {
                return null;
            }
        }

        @Override
        public Worker save(Worker entity) {
            open();
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, entity.getId());
            values.put(COLUMN_NAME, entity.getName());
            values.put(COLUMN_SURNAME, entity.getSurname());
            values.put(COLUMN_ADDRESS, entity.getAddress());
            long id = db.insertOrThrow(TABLE_NAME, null, values);
            Worker insertedEntity = entity;
            return insertedEntity;
        }

        @Override
        public Worker update(Worker entity) {
            open();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, entity.getName());
            values.put(COLUMN_SURNAME, entity.getSurname());
            values.put(COLUMN_ADDRESS, entity.getAddress());

            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_ID + " =? ",
                    new String[]{String.valueOf(entity.getId())}
            );
            return entity;
        }

        @Override
        public Worker delete(Worker entity) {
            open();
            db.delete(
                    TABLE_NAME,
                    COLUMN_ID + " =? ",
                    new String[]{String.valueOf(entity.getId())});
                     Log.d("Database Operations", "Row Deleted");
            return entity;
        }


        @Override
        public Set<Worker> findAll() {
            SQLiteDatabase db = this.getReadableDatabase();
            Set<Worker> Person = new HashSet<>();
            open();
            Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
            if (cursor.moveToFirst()) {
                do {
                    final Worker setting = new Worker.Builder()
                            .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                            .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                            .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                            .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                            .build();
                    Person.add(setting);
                } while (cursor.moveToNext());
            }
            return Person;
        }

        @Override
        public int deleteAll() {
            open();
            int rowsDeleted = db.delete(TABLE_NAME,null,null);
            close();
            return rowsDeleted;
        }

        /*

    @Override
    public int deleteVehicles() {
        openConnectionWritable();
        int vehiclesDeleted = database.delete(DBContract.TABLE_NAME, null, null);
        closeConnection();
        Log.d("Database Operations", "Table Deleted");
        return vehiclesDeleted;
    }



         */


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


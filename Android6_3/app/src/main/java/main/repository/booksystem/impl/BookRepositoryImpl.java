package main.repository.booksystem.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import main.conf.databases.DBConstants;
import main.domain.booksystem.Books;
import main.repository.booksystem.BookRepository;

/**
 * Created by Anita on 2016/04/24.
 */
public class BookRepositoryImpl extends SQLiteOpenHelper implements BookRepository
{

    public static final String TABLE_NAME = "book";
    private SQLiteDatabase db;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_bookTitle = "bookTitle";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_PAGES = "pages";
    public static final String COLUMN_PUBLISHER = "publisher";
    public static final String COLUMN_ISBN = "iSBN";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_bookTitle + " TEXT NOT NULL , "
            + COLUMN_AUTHOR + " TEXT NOT NULL , "
            + COLUMN_PAGES + " TEXT NOT NULL , "
            + COLUMN_PUBLISHER + " TEXT NOT NULL , "
            + COLUMN_ISBN + " TEXT NOT NULL);" ;

    public BookRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Books findById(long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_bookTitle,
                        COLUMN_AUTHOR,
                        COLUMN_PAGES,
                        COLUMN_PUBLISHER,
                        COLUMN_ISBN},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Books book = new Books.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .bookTitle(cursor.getString(cursor.getColumnIndex(COLUMN_bookTitle)))
                    .author(cursor.getString(cursor.getColumnIndex(COLUMN_AUTHOR)))
                    .pages(cursor.getInt(cursor.getColumnIndex(COLUMN_PAGES)))
                    .publisher(cursor.getString(cursor.getColumnIndex(COLUMN_PUBLISHER)))
                    .iSBN(cursor.getString(cursor.getColumnIndex(COLUMN_ISBN)))
                    .build();
            return book;
        } else {
            return null;
        }
    }
    private long id;
    private String bookTitle;
    private String author;
    private int pages;
    private String publisher;
    private String  iSBN;
    @Override
    public Books save(Books entity) {
        open();
        ContentValues values = new ContentValues();
   //    values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_bookTitle, entity.getBookTitle());
        values.put(COLUMN_AUTHOR, entity.getAuthor());
        values.put(COLUMN_PAGES, entity.getPages());
        values.put(COLUMN_PUBLISHER, entity.getPublisher());
        values.put(COLUMN_ISBN, entity.getiSBN());

        System.out.println("This excecutes");
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Books insertedEntity = new Books.Builder()
                .copy(entity)
                .id(id)
                .build();

        return insertedEntity;
    }

    @Override
    public Books update(Books entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_bookTitle, entity.getBookTitle());
        values.put(COLUMN_AUTHOR, entity.getAuthor());
        values.put(COLUMN_PAGES, entity.getPages());
        values.put(COLUMN_PUBLISHER, entity.getPublisher());
        values.put(COLUMN_ISBN, entity.getiSBN());


        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Books delete(Books entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Books> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Books> member = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Books setting = new Books.Builder()

                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .bookTitle(cursor.getString(cursor.getColumnIndex(COLUMN_bookTitle)))
                        .author(cursor.getString(cursor.getColumnIndex(COLUMN_AUTHOR)))
                        .pages(cursor.getInt(cursor.getColumnIndex(COLUMN_PAGES)))
                        .publisher(cursor.getString(cursor.getColumnIndex(COLUMN_PUBLISHER)))
                        .iSBN(cursor.getString(cursor.getColumnIndex(COLUMN_ISBN)))
                        .build();
                member.add(setting);
            } while (cursor.moveToNext());
        }
        return member;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
        // close();
        return rowsDeleted;
    }

        public int findMaxPages() {
            SQLiteDatabase db = this.getReadableDatabase();
            int max = -5;
            Set<Books> member = new HashSet<>();
            open();
            Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
            if (cursor.moveToFirst()) {
                do {
                    final Books setting = new Books.Builder()
                            .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                            .pages(cursor.getInt(cursor.getColumnIndex(COLUMN_PAGES)))
                            .build();
                    member.add(setting);

                    if(setting.getPages()>max)
                    {
                        max = setting.getPages();
                    }


                } while (cursor.moveToNext());
            }
            return max;
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



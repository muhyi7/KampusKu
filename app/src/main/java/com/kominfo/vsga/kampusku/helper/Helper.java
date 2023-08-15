package com.kominfo.vsga.kampusku.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "crud";

    public Helper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE users (id INTEGER PRIMARY KEY autoincrement, nomor TEXT NOT NULL, nama TEXT, tanggal TEXT, kelamin TEXT, alamat TEXT)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getAll(){
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String QUERY = "SELECT * FROM users";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("nomor", cursor.getString(1));
                map.put("nama", cursor.getString(2));
                map.put("tanggal", cursor.getString(3));
                map.put("kelamin", cursor.getString(4));
                map.put("alamat", cursor.getString(5));

                list.add(map);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void insert(String nomor, String nama, String tanggal, String kelamin, String alamat){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "INSERT INTO users (nomor,nama,tanggal,kelamin,alamat) VALUES('"+nomor+"','"+nama+"','"+tanggal+"','"+kelamin+"','"+alamat+"')";
        database.execSQL(QUERY);
    }

    public void update(int id, String nomor,String nama, String tanggal, String kelamin, String alamat){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "UPDATE users SET nomor = '"+nomor+"', nama = '"+nama+"', tanggal = '"+tanggal+"', kelamin = '"+kelamin+"', alamat = '"+alamat+"' WHERE id = "+id;
        database.execSQL(QUERY);
    }

    public void delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM users WHERE id = "+id;
        database.execSQL(QUERY);
    }
}

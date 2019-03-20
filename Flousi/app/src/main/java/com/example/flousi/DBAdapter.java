package com.example.flousi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBAdapter extends SQLiteOpenHelper {

    private int id;

    public DBAdapter(Context context)
    {
        super(context,"flousi",null,1);
    }

    public void onCreate(SQLiteDatabase db) {
        String createTable="CREATE TABLE Expenses(id integer primary key,achat text ,prix float, date text)";
        db.execSQL(createTable); }

    public void onUpgrade(SQLiteDatabase db, int V, int V1) {
        String deleteTable=("DROP Table IF EXISTS Expenses");
        db.execSQL(deleteTable);
        onCreate(db); }

    public void addexpense(Expense ex){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("achat",ex.getAchat());
        contentValues.put("prix",ex.getPrix());
        contentValues.put("date",ex.getDate());
        db.insert("Expenses",null,contentValues);

    }

    public ArrayList<Expense> afficher(){
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM Expenses";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<Expense> expenses=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                Expense ex1=new Expense(cursor.getString(1),cursor.getFloat(2));
                ex1.setAchat(cursor.getString(1));
                ex1.setPrix(cursor.getFloat(2));
                ex1.setDate(cursor.getString(3));
                expenses.add(ex1); }
            while(cursor.moveToNext()); }
        return expenses;}

    public Float total()
    {   Float flousi =0f ;

        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM Expenses";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<Expense> expenses =new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                flousi = flousi + cursor.getFloat(2);
            }
            while(cursor.moveToNext());
        }

        return flousi ;}

    public void delete(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Expenses","id="+Integer.toString(id),null);}


}



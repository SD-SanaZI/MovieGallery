package com.example.testbitcoin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DbHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "Film_DB"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val FILM_TABLE_NAME = "Films"
        val ACTOR_TABLE_NAME = "Actors"
        val ACTORFILM_TABLE_NAME = "FilmActor"

        // below is the variable for id column
        val ID_COL = "id"

        // below is the variable for name column
        val NAME_COl = "name"

        // below is the variable for age column
        val AGE_COL = "age"
        val TAG_COL = "tag"
        val IMG_COL = "image"
        val REV_COL = "countReviews"
        val TIME_COL = "time"
        val LIKE_COL = "hasLike"
        val STORY_COL = "story"

        val FILM_ID_COL = "film_id"
        val ACTOR_ID_COL = "actor_id"
        val FILM_ID_FK = "film_fk"
        val ACTOR_ID_FK = "actor_fk"
    }

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        var query = ("CREATE TABLE " + FILM_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                AGE_COL + " TEXT," +
                TAG_COL + " TEXT," +
                IMG_COL + " INTEGER," +
                REV_COL + " INTEGER," +
                TIME_COL + " INTEGER," +
                LIKE_COL + " BOOLEAN," +
                STORY_COL + " TEXT" +
                ")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)

        query = ("CREATE TABLE " + ACTOR_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                IMG_COL + " INTEGER" + ")")
        db.execSQL(query)

        query = ("CREATE TABLE " + ACTORFILM_TABLE_NAME + " ("
                + FILM_ID_COL + " INTEGER, " +
                ACTOR_ID_COL + " INTEGER," +
                " PRIMARY KEY (" + FILM_ID_COL + " , " + ACTOR_ID_COL + ")," +
                " CONSTRAINT " + FILM_ID_FK + " FOREIGN KEY (" + FILM_ID_COL + ")" +
                    " REFERENCES " + FILM_TABLE_NAME + "(" + ID_COL + ")" + " ON DELETE CASCADE, " +
                " CONSTRAINT " + ACTOR_ID_FK + " FOREIGN KEY (" + ACTOR_ID_COL + ")" +
                    " REFERENCES " + ACTOR_TABLE_NAME + "(" + ID_COL + ")" + " ON DELETE CASCADE " +
                ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + FILM_TABLE_NAME)
        db.execSQL("DROP TABLE IF EXISTS " + ACTOR_TABLE_NAME)
        db.execSQL("DROP TABLE IF EXISTS " + ACTORFILM_TABLE_NAME)
        onCreate(db)
    }

    fun addFilm(id: Int, name : String, age : String, tag:String, image:Int,
                countReviews:Int, time:Int, hasLike:Boolean, story:String){
        val values = ContentValues()
        values.put(ID_COL, id)
        values.put(NAME_COl, name)
        values.put(AGE_COL, age)
        values.put(TAG_COL, tag)
        values.put(IMG_COL, image)
        values.put(REV_COL, countReviews)
        values.put(TIME_COL, time)
        values.put(LIKE_COL, hasLike)
        values.put(STORY_COL, story)

        val db = this.writableDatabase

        db.insert(FILM_TABLE_NAME, null, values)

        db.close()
    }

    fun addActor(id: Int, name : String,  image:Int){
        val values = ContentValues()
        values.put(ID_COL, id)
        values.put(NAME_COl, name)
        values.put(IMG_COL, image)

        val db = this.writableDatabase

        db.insert(ACTOR_TABLE_NAME, null, values)

        db.close()
    }

    fun addRelationship(filmId: Int, ActorId : Int){
        val values = ContentValues()
        values.put(FILM_ID_COL, filmId)
        values.put(ACTOR_ID_COL, ActorId)

        val db = this.writableDatabase

        db.insert(ACTORFILM_TABLE_NAME, null, values)

        db.close()
    }

    fun likeFilm(filmId: Int){
        val values = ContentValues()
        val db = this.writableDatabase
        Log.i("likefilm1", "+")
        val cursor = db.rawQuery("SELECT * FROM " + FILM_TABLE_NAME + " WHERE " + ID_COL + " =  " + filmId.toString(), null)
        cursor.moveToFirst()
        Log.i("likefilm2", cursor.getInt(7).toString())
        values.put(LIKE_COL, (cursor.getInt(7)+1)%2)
        db.update(FILM_TABLE_NAME, values, "id = " + filmId, null);
        db.close()
    }

    fun getDataFilmById(id: Int): FilmData {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + FILM_TABLE_NAME + " WHERE " + ID_COL + " =  " + id.toString(), null)
        val cursor2 = db.rawQuery("SELECT * FROM " + ACTORFILM_TABLE_NAME + " WHERE " + FILM_ID_COL + " =  " + id.toString(), null)
        cursor.moveToFirst()
        cursor2.moveToFirst()
        var actorList = listOf(cursor2.getInt(1))
        while (cursor2.moveToNext()){
            actorList += cursor2.getInt(1)
        }
        return FilmData(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getInt(4),cursor.getInt(5),
                        cursor.getInt(6),cursor.getInt(7) == 1,cursor.getString(8), actorList)
    }

    fun filmSize(): Int{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + FILM_TABLE_NAME, null)
        return cursor.count
    }

    fun getActorById(id: Int): ActorData {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + ACTOR_TABLE_NAME + " WHERE " + ID_COL + " =  " + id.toString(), null)
        cursor.moveToFirst()
        return ActorData(cursor.getInt(0),cursor.getString(1),cursor.getInt(2))
    }
}
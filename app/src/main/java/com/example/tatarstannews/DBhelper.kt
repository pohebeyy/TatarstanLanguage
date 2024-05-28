package com.example.tatarstannews



import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBhelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Создание таблицы пользователей
        val userTableQuery =
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, email TEXT, pass TEXT, level TEXT, points INTEGER,rait Text)"
        db?.execSQL(userTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }


    fun addUser(user: User) {
        val values = ContentValues().apply {
            put("login", user.login)
            put("email", user.email)
            put("pass", user.pass)
            put("level", "") // Устанавливаем пустой уровень при добавлении нового пользователя
            put("points", 0) // Устанавливаем начальное количество баллов
        }

        val db = this.writableDatabase
        db.insert("users", null, values)
        db.close()
    }


    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf("id")
        val selection = "login = ? AND pass = ?"
        val selectionArgs = arrayOf(login, pass)

        val cursor: Cursor = db.query("users", columns, selection, selectionArgs, null, null, null)
        val cursorCount: Int = cursor.count
        cursor.close()
        db.close()
        return cursorCount > 0
    }

    fun getCurrentUser(): User? {
        val db = this.readableDatabase
        val columns = arrayOf("login", "email", "pass", "level")
        val cursor = db.query("users", columns, null, null, null, null, null)

        var user: User? = null

        if (cursor != null && cursor.moveToFirst()) {
            val loginIndex = cursor.getColumnIndex("login")
            val emailIndex = cursor.getColumnIndex("email")
            val passIndex = cursor.getColumnIndex("pass")
            val levelIndex = cursor.getColumnIndex("level")

            if (loginIndex != -1 && emailIndex != -1 && passIndex != -1 && levelIndex != -1) {
                val login = cursor.getString(loginIndex)
                val email = cursor.getString(emailIndex)
                val pass = cursor.getString(passIndex)
                val level = cursor.getString(levelIndex)
                user = User(login, email, pass, level)
                user.level = level // Установим уровень пользователя
            }
        }

        cursor?.close()
        db.close()
        return user
    }

    fun saveUserLevel(level: String) {
        val user = getCurrentUser()
        if (user != null) {
            val db = this.writableDatabase
            val values = ContentValues().apply {
                put("level", level)
            }
            db.update("users", values, "login = ?", arrayOf(user.login))
            db.close()
        }
    }
    fun addPoints(login: String, points: Int) {
        val db = this.writableDatabase
        db.execSQL("UPDATE users SET points = points + ? WHERE login = ?", arrayOf(points, login))
        db.close()
    }


    fun getUserPoints(login: String): Int {
        val db = this.readableDatabase
        var points = 0

        val query = "SELECT points FROM users WHERE login = ?"
        val cursor = db.rawQuery(query, arrayOf(login))

        cursor.use {
            if (it.moveToFirst()) {
                val pointsIndex = it.getColumnIndex("points")
                if (pointsIndex != -1) {
                    points = it.getInt(pointsIndex)
                }
            }
        }

        db.close()

        return points
    }
    fun addReit(login: String,rait:Int){
        val db = this.writableDatabase
        db.execSQL("UPDATE users SET rait = rait + ? WHERE login = ?", arrayOf(rait,login))
        db.close()
    }
    fun getUserRait(login: String): Int {
        val db = this.readableDatabase
        var rait = 0

        val query = "SELECT rait FROM users WHERE login = ?"
        val cursor = db.rawQuery(query, arrayOf(login))

        cursor.use {
            if (it.moveToFirst()) {
                val raitIndex = it.getColumnIndex("points")
                if (raitIndex != -1) {
                    rait = it.getInt(raitIndex)
                }
            }
        }

        db.close()

        return rait
    }




}
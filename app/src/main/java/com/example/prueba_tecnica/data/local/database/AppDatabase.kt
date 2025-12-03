package com.example.prueba_tecnica.data.local.database
import androidx.room.Database
import com.example.prueba_tecnica.data.local.entities.Posts
import com.example.prueba_tecnica.data.local.entities.Comment
import com.example.prueba_tecnica.data.local.dao.CommentDao
import androidx.room.RoomDatabase
import com.example.prueba_tecnica.data.local.dao.PostDao
@Database(
    //Llamamos entidades
    entities = [Posts::class, Comment::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //Hcemos una unica instancia de la base de datos.
        fun getDatabase(context: android.content.Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }}

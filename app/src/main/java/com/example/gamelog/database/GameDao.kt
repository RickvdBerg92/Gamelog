package com.example.gamelog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamelog.model.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM Game ORDER BY releaseDate ASC")
    fun getGames(): LiveData<List<Game?>?>

    @Delete
    suspend fun delete(game: Game)

    @Query("DELETE FROM Game")
    suspend fun deleteGames()

}

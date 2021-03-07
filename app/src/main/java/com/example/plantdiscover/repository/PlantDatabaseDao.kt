package com.example.plantdiscover.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlantDatabaseDao {
    @Insert
    suspend fun insert(savedPlant: SavedPlant)

    @Update
    suspend fun update(savedPlant: SavedPlant)

    @Query("SELECT * from favourite_plant_table WHERE plantId = :key")
    suspend fun get(key: Long): SavedPlant

    @Query("DELETE FROM favourite_plant_table")
    suspend fun clear()

    @Query("SELECT * FROM favourite_plant_table ORDER BY plantId DESC")
    fun getAllPlants(): LiveData<List<SavedPlant>>

    @Query("SELECT * FROM favourite_plant_table ORDER BY plantId DESC LIMIT 1")
    suspend fun getLastPlant(): SavedPlant?

    @Query("SELECT * from favourite_plant_table WHERE plantId = :key")
    fun getPlantWithId(key: Long): LiveData<SavedPlant>

}
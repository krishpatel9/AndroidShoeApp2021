package com.learning.roboticsprogram.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learning.roboticsprogram.room.entity.Shoe;

import java.util.List;

@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShoe(Shoe note);

    @Query("SELECT * FROM shoe ORDER BY id DESC Limit :limit")
    Shoe getShoe(int limit);

    @Query("SELECT * FROM shoe ORDER BY id DESC")
    List<Shoe> getAllShoes();
}

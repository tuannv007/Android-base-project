package com.tuannv.base.truyenhh.data.local.dao;

import com.tuannv.base.truyenhh.data.model.Example2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ExampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExample(Example2... examples);
    @Query("Select * from example2 LIMIT 1")
    Example2 getExample();
}

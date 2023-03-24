package com.learning.roboticsprogram;

import com.learning.roboticsprogram.room.entity.Shoe;

public interface AppTasks {
    void onSuccess(Shoe shoe);

    void onFailure();
}

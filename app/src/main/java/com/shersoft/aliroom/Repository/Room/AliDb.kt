package com.shersoft.Sherhotel.Repository.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shersoft.Sherhotel.Repository.Room.Room.PurchaeModelR
import com.shersoft.Sherhotel.Repository.Room.Room.SaleModelR
import com.shersoft.Sherhotel.Repository.Room.Room.StockModelR

import com.shersoft.aliroom.Utility.Constants


@Database(
    entities = [SaleModelR::class, StockModelR::class, PurchaeModelR::class],
    version = 1,
    exportSchema = false
)
abstract class ALIDATABASE : RoomDatabase() {
    abstract fun saledao(): SaleDao
    abstract fun stockdao(): StockDao
    abstract fun purchasedao(): PurchaseDao
//    abstract fun dbgetdao(): mdao


    companion object {
        private var INSTANCE: ALIDATABASE? = null
        fun getDatabase(context: Context): ALIDATABASE {
            val tempinstance = INSTANCE
            if (tempinstance != null) {
                return tempinstance
            }
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        ALIDATABASE::class.java,
                        "/storage/emulated/0/Alidb/" + Constants.DATABASENAME_Ali + ".db "
                    ).build()
                INSTANCE = instance
                return instance;
            }

        }

    }

}
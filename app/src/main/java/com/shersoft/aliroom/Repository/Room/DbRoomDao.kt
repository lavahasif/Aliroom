package com.shersoft.Sherhotel.Repository.Room


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.shersoft.Sherhotel.Repository.Room.Room.PurchaeModelR
import com.shersoft.Sherhotel.Repository.Room.Room.SaleModelR
import com.shersoft.Sherhotel.Repository.Room.Room.StockModelR


interface BaseDao<T> {
    @Insert
    suspend fun insert(vararg obj: T)


    @Update()
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)
}


@Dao
interface SaleDao : BaseDao<SaleModelR> {
    @Query("Select * from tablename_saletable order by ID desc")
    abstract fun getData(): List<SaleModelR>

    @Query("Select * from tablename_saletable where CUSTOMERNAME like:search")
    abstract fun findbyto(search: String): List<SaleModelR>

}

@Dao
interface StockDao : BaseDao<StockModelR> {
    @Query("Select * from tablename_addstock order by ID desc")
    abstract fun getData(): LiveData<List<StockModelR>>

    @Query("Select * from tablename_addstock where PRODUCTNAME like:search")
    abstract fun findbyto(search: String): LiveData<List<StockModelR>>

}

@Dao
interface PurchaseDao : BaseDao<PurchaeModelR> {
    @Query("Select * from tablename_purchaselist order by ID desc")
    abstract fun getdata(): LiveData<List<PurchaeModelR>>


    @Query("Select * from tablename_purchaselist where COMPANYNAME like:search")
    abstract fun findbyto(search: String): LiveData<List<PurchaeModelR>>


}


package com.shersoft.Sherhotel.Repository;


import android.content.Context
import androidx.lifecycle.LiveData
import com.shersoft.Sherhotel.Repository.Room.ALIDATABASE
import com.shersoft.Sherhotel.Repository.Room.Room.PurchaeModelR
import com.shersoft.Sherhotel.Repository.Room.Room.SaleModelR
import com.shersoft.Sherhotel.Repository.Room.Room.StockModelR
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

class DatabaseRepository(private val mcontext: Context) : Accounts() {

    val parentJob = Job()
    val coroutineScope = CoroutineScope(Dispatchers.IO + parentJob)
    val daoSale = ALIDATABASE.getDatabase(mcontext).saledao()
    val daoStock = ALIDATABASE.getDatabase(mcontext).stockdao()
    val daoPurchase = ALIDATABASE.getDatabase(mcontext).purchasedao()


    override suspend fun getSale(): List<SaleModelR> =
        withContext(Dispatchers.IO) {
            daoSale.getData()
        }


    override suspend fun getStock(): LiveData<List<StockModelR>> =
        withContext(Dispatchers.IO) {
            daoStock.getData()
        }

    override suspend fun getPurchase(): LiveData<List<PurchaeModelR>> =
        withContext(Dispatchers.IO) {
            daoPurchase.getdata()
        }

    override suspend fun setSale(sale: SaleModelR) = withContext(Dispatchers.IO) {
        daoSale.insert(sale)
    }


    override suspend fun setPurchase(purchaeModelR: PurchaeModelR) = withContext(Dispatchers.IO) {
        daoPurchase.insert(purchaeModelR)
    }

    override suspend fun setStock(stock: StockModelR) = withContext(Dispatchers.IO) {
        daoStock.insert(stock)
    }

    override suspend fun updateSale(sale: SaleModelR) = withContext(Dispatchers.IO) {
        daoSale.update(sale)
    }

    override suspend fun updatepurchase(purchase: PurchaeModelR) = withContext(Dispatchers.IO)
    {
        daoPurchase.update(purchase)
    }

    override suspend fun updateStock(stock: StockModelR) = withContext(Dispatchers.IO) {
        daoStock.update(stock)
    }


}

abstract class Accounts {
    //read data
    abstract suspend fun getSale(): List<SaleModelR>

    abstract suspend fun getStock(): LiveData<List<StockModelR>>
    abstract suspend fun getPurchase(): LiveData<List<PurchaeModelR>>
    //insert
    abstract suspend fun setSale(sale: SaleModelR)

    abstract suspend fun setPurchase(purchase: PurchaeModelR)
    abstract suspend fun setStock(stock: StockModelR)

    //update
    abstract suspend fun updateSale(sale: SaleModelR)

    abstract suspend fun updatepurchase(purchase: PurchaeModelR)
    abstract suspend fun updateStock(stock: StockModelR)


}
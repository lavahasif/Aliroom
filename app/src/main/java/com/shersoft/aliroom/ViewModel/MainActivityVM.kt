package com.shersoft.aliroom.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersoft.Sherhotel.Repository.DatabaseRepository
import com.shersoft.Sherhotel.Repository.Room.Room.PurchaeModelR
import com.shersoft.Sherhotel.Repository.Room.Room.SaleModelR
import com.shersoft.Sherhotel.Repository.Room.Room.StockModelR
import kotlinx.coroutines.launch

class MainActivityVM(
    application: Context
) : ViewModel(), VmLiveReport, VmSetup {
    override lateinit var salerportd: LiveData<SaleModelR>

    override lateinit var stockrportd: LiveData<StockModelR>

    override lateinit var purchaserportd: LiveData<PurchaeModelR>

    override lateinit var salerportListd: MutableLiveData<List<SaleModelR>>

    override lateinit var stockrportListd: LiveData<List<StockModelR>>

    override lateinit var purchaserportListd: LiveData<List<PurchaeModelR>>
    override var salerport: LiveData<SaleModelR>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var stockrport: LiveData<StockModelR>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var purchaserport: LiveData<PurchaeModelR>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override val salerportList: LiveData<List<SaleModelR>>
            by lazy {
                var liveData: LiveData<List<SaleModelR>> = MutableLiveData()
                viewModelScope.launch {

                    liveData = MutableLiveData(repository.getSale())
                }

                liveData
            }

    fun _initSale() = { viewModelScope.launch { salerportListd.value = repository.getSale() } }
    val salerportListt: MutableLiveData<List<SaleModelR>>
            by lazy {
                var liveData: MutableLiveData<List<SaleModelR>> = MutableLiveData()
                viewModelScope.launch {

                    liveData.value = repository.getSale()
                }

                if (!::salerportListd.isInitialized)
                    salerportListd = MutableLiveData()
                salerportListd = liveData
                salerportListd
            }
    override val stockrportList: LiveData<List<StockModelR>>
            by lazy {
                var liveData: LiveData<List<StockModelR>> = MutableLiveData()
                viewModelScope.launch {

                    liveData = repository.getStock()
                }

                if (!::stockrportListd.isInitialized)
                    stockrportListd = MutableLiveData()
                stockrportListd = liveData
                stockrportListd
            }

    override val purchaserportList: LiveData<List<PurchaeModelR>> by lazy {


        var liveData: LiveData<List<PurchaeModelR>> = MutableLiveData()
        viewModelScope.launch {

            liveData = repository.getPurchase()
        }

        if (!::purchaserportListd.isInitialized)
            purchaserportListd = MutableLiveData()
        purchaserportListd = liveData
        purchaserportListd
    }


    override lateinit var repository: DatabaseRepository


    lateinit var liveData: LiveData<List<SaleModelR>>

    init {
        repository = DatabaseRepository(application)
        salerportListd = MutableLiveData()
        stockrportListd = MutableLiveData()
        purchaserportListd = MutableLiveData()
        _initSale()
    }

    override fun setSale(sale: SaleModelR) {
        viewModelScope.launch { repository.setSale(sale) }
        salerportListt.value = listOf(sale)

    }

    override fun setStock(stock: StockModelR) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPurchase(purchase: PurchaeModelR) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface VmLiveReport {
    public abstract val salerport: LiveData<SaleModelR>
    public abstract val stockrport: LiveData<StockModelR>
    abstract val purchaserport: LiveData<PurchaeModelR>
    abstract val salerportList: LiveData<List<SaleModelR>>
    abstract val stockrportList: LiveData<List<StockModelR>>
    abstract val purchaserportList: LiveData<List<PurchaeModelR>>
    public abstract val salerportd: LiveData<SaleModelR>
    public abstract val stockrportd: LiveData<StockModelR>
    abstract val purchaserportd: LiveData<PurchaeModelR>
    public abstract val salerportListd: LiveData<List<SaleModelR>>
    abstract val stockrportListd: LiveData<List<StockModelR>>
    abstract val purchaserportListd: LiveData<List<PurchaeModelR>>
    abstract val repository: DatabaseRepository


}

interface VmSetup {
    public abstract fun setSale(sale: SaleModelR)
    abstract fun setStock(stock: StockModelR)
    abstract fun setPurchase(purchase: PurchaeModelR)


}

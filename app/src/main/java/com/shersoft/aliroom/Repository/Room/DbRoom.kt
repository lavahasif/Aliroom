package com.shersoft.Sherhotel.Repository.Room.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shersoft.aliroom.Utility.Constants


@Entity(tableName = Constants.TABLENAME_SALETABLE)

data class SaleModelR(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constants.COLUMN_SALE_ID) val Id: Int,
    @ColumnInfo(name = Constants.COLUMN_SALE_DATE, defaultValue = "") val date: String,
    @ColumnInfo(
        name = Constants.COLUMN_SALE_CUSTOMERNAME,
        defaultValue = ""
    ) val customername: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_MOBILENO, defaultValue = "") val mobilno: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_PRODUCT, defaultValue = "5") val product: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_QUANTITY, defaultValue = "0") val quantity: String,
    @ColumnInfo(
        name = Constants.COLUMN_SALE_ACTUALPRICE,
        defaultValue = "0"
    ) val actualprice: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_VAT5, defaultValue = "0") val vat: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_NETAMOUNT, defaultValue = "0") val netamount: String


)


@Entity(tableName = Constants.TABLENAME_ADDSTOCK)

data class StockModelR(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constants.COLUMN_STOCK_ID) val Id: Int,
    @ColumnInfo(name = Constants.COLUMN_STOCK_PRODUCTNAME) val productname: String,
    @ColumnInfo(name = Constants.COLUMN_STOCK_STOCKQUANTITY) val stockqty: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_ACTUALPRICE) val price: String,
    @ColumnInfo(name = Constants.COLUMN_STOCK_VAT5) val vat: String,
    @ColumnInfo(name = Constants.COLUMN_STOCK_NETAMOUNT, defaultValue = "0") val netamout: String,
    @ColumnInfo(
        name = Constants.COLUMN_STOCK_SPECIFICATION,
        defaultValue = "0"
    ) val specific: String,
    @ColumnInfo(name = Constants.COLUMN_STOCK_IAMGE) val image: String


)

@Entity(tableName = Constants.TABLENAME_PURCHASELIST)

data class PurchaeModelR(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constants.COLUMN_PURCHASE_ID) val Id: Int,
    @ColumnInfo(name = Constants.COLUMN_PURCHASE_PURCHASEDATE) val date: String,
    @ColumnInfo(name = Constants.COLUMN_PURCHASE_COMPANYNAME) val companyname: String,
    @ColumnInfo(name = Constants.COLUMN_PURCHASE_NETAMOUNT) val netamount: String,
    @ColumnInfo(
        name = Constants.COLUMN_PURCHASE_ACTUALAMOUNT,
        defaultValue = "0"
    ) val actualamount: String,
    @ColumnInfo(name = Constants.COLUMN_PURCHASE_VAT5, defaultValue = "0") val vat: String,
    @ColumnInfo(name = Constants.COLUMN_SALE_BALANCETOPAY) val balancepay: String


)

//data class MinimumItem(
//    @ColumnInfo(name = Constants.COLUMN_ITEM_USERCODE) val usercode: String,
//    @ColumnInfo(name = Constants.COLUMN_ITEM_ITEMNAME) val itemname: String,
//    @ColumnInfo(name = Constants.COLUMN_ITEM_CATAGORY, defaultValue = "") val catagory: String,
//    @ColumnInfo(name = Constants.COLUMN_ITEM_ACRATE) val acrate: String,
//    @ColumnInfo(name = Constants.COLUMN_ITEM_ACDRATE) val acdrate: String,
//    @ColumnInfo(name = Constants.COLUMN_ITEM_NONACRATE) val nonacrate: String,
//    @ColumnInfo(
//        name = Constants.COLUMN_ITEM_SUBCATAGORY,
//        defaultValue = ""
//    ) val subcatagory: String,
//    @ColumnInfo(name = Constants.COLUMN_ITEM_PRATE, defaultValue = "0") val prate: String
//)
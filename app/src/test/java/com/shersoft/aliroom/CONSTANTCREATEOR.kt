package com.shersoft.aliroom

class CONSTANTCREATEOR {


    fun main(args: Array<String>) {
        val sale = arrayListOf<String>(
            "DATE",
            "CUSTOMERNAME",
            "MOBILENO",
            "PRODUCT"
            , "QUANTITY", "ACTUALPRICE",
            "VAT5%",
            "NETAMOUNT"
        )
        val stock = arrayListOf<String>(
            "PRODUCTNAME",
            "STOCKQUANTITY",
            "ACTUALPRICE",
            "SPECIFICATION"
            , "IAMGE",
            "VAT5%",
            "NETAMOUNT"
        )
        val purchase = arrayListOf<String>(
            "PURCHASEDATE",
            "COMPANYNAME",
            "ACTUALAMOUNT",
            "VAT5%",
            "NETAMOUNT"
        )
        val table = arrayListOf<String>(
            "COLUMN_SALE",
            "COLUMN_STOCK",
            "COLUMN_PURCHASE"
        )
        stock.forEach {
            println("const val ${table[0] + "_$it"} ='${it}' ")
        }
    }
}
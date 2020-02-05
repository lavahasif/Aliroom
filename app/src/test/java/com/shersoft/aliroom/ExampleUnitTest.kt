package com.shersoft.aliroom

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
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
}

//import android.content.Context
//import com.shersoft.Sherhotel.Repository.Room.Room.DbItemRoom
//import com.shersoft.Sherhotel.Repository.Room.Room.MinimumItem
//import com.shersoft.Sherhotel.Utility.Constants
//import com.shersoft.Sherhotel.Utility.SharedPreference
//import com.shersoft.Sherhotel.activity.ConnectionClass
//
//import java.util.*
//
//class DatabaseService {
//
//    companion object {
//
//        var connectionClass: ConnectionClass? = null
//        var ip: String? = null
//        var vdbs: String? = null
//        var un: String? = null
//        var pass: String? = null
//
//        fun loadsettings(context: Context?) {
//            val config_value = SharedPreference.getConfvalue(context!!)
//            ip = config_value[0]
//            vdbs = config_value[2]
//            un = config_value[3]
//            pass = config_value[4]
//        }
//
//        fun getItem(
//                context: Context?,
//                type: String
//        ): ArrayList<DbItemRoom> {
//            loadsettings(context)
//            val list_itemmodel: ArrayList<DbItemRoom> = ArrayList<DbItemRoom>()
//            val query = "exec getitemreg"
//            connectionClass = ConnectionClass()
//            try {
//                val con = connectionClass!!.CONN(ip, vdbs!!, un!!, pass!!)
//                if (con != null) {
//                    val ps = con.prepareStatement(query)
//                    val rs = ps.executeQuery()
//                    while (rs.next()) {
//                        list_itemmodel.add(
//                                DbItemRoom(
//                                        0,
//                                        MinimumItem(rs.getString(Constants.COLUMN_ITEM_USERCODE)
//                                                ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_ITEMNAME) ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_CATAGORY) ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_ACRATE) ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_ACDRATE) ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_NONACRATE) ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_SUBCATAGORY)
//                                                        ?: "",
//                                                rs.getString(Constants.COLUMN_ITEM_PARCEL) ?: ""
//                                        ),
//                                        rs.getString(Constants.COLUMN_ITEM_LESSITEM) ?: "",
//                                        rs.getString(Constants.COLUMN_ITEM_STOCKLESS) ?: "",
//                                        rs.getString(Constants.COLUMN_ITEM_UNIT) ?: "",
//                                        rs.getString(Constants.COLUMN_ITEM_TAX) ?: "",
//                                        rs.getString(Constants.COLUMN_ITEM_PRATE) ?: "",
//                                        rs.getString(Constants.COLUMN_ITEM_GSTPER) ?: "",
//                                        "N",
//                                        "N",
//                                        rs.getString(Constants.COLUMN_ITEM_SQLID) ?: ""
//
//                                )
//                        )
//                    }
//                }
//            } catch (ex: Exception) {
//                ex.message
//            }
//            return list_itemmodel
//        }
//    }
//}
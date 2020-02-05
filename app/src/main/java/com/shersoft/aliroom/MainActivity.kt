package com.shersoft.aliroom

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.shersoft.Sherhotel.Repository.Room.Room.PurchaeModelR
import com.shersoft.Sherhotel.Repository.Room.Room.SaleModelR
import com.shersoft.Sherhotel.Repository.Room.Room.StockModelR
import com.shersoft.aliroom.Utility.checkSelfPermissionCompat
import com.shersoft.aliroom.Utility.requestPermissionsCompat
import com.shersoft.aliroom.Utility.shouldShowRequestPermissionRationaleCompat
import com.shersoft.aliroom.Utility.showSnackbar
import com.shersoft.aliroom.ViewModel.MainActivityVM
import kotlinx.android.synthetic.main.activity_main.*

lateinit var mcontext: Context

class MainActivity : AppCompatActivity() {
    val READ_EXTERNAL_STORAGE = 0
    private val mclick: View.OnClickListener = View.OnClickListener {
        if (::viewModel.isInitialized) {
            viewModel.setSale(SaleModelR(0, editText.text.toString(), "", "", "", "", "", "", ""))


            // add this in purchase  activity
            viewModel.setPurchase(PurchaeModelR(0, editText.text.toString(), "", "", "", "", ""))



            // add this in stock activity
            viewModel.setStock(StockModelR(0, editText.text.toString(), "", "", "", "","",""))




            viewModel.salerportListt.value
        }


    }
    lateinit var viewModel: MainActivityVM
    lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        mcontext = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = textView.rootView
        showStoragePreview()
    }



    //permission
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            READ_EXTERNAL_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission has been granted. Start camera preview Activity.
                    layout.showSnackbar(R.string.storage_permission_granted, Snackbar.LENGTH_SHORT)
                    startDatabase()
                } else {
                    // Permission request was denied.
                    layout.showSnackbar(R.string.storage_permission_denied, Snackbar.LENGTH_SHORT)
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }


    private fun showStoragePreview() {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            textView.rootView.showSnackbar(
                R.string.Strorage_permission_available,
                Snackbar.LENGTH_SHORT
            )
            startDatabase()
        } else {
            // Permission is missing and must be requested.
            requestStoragePermission()
        }
    }

    /**
     * Requests the [android.Manifest.permission.CAMERA] permission.
     * If an additional rationale should be displayed, the user has to launch the request from
     * a SnackBar that includes additional information.
     */
    private fun requestStoragePermission() {
        // Permission has not been granted and must be requested.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                layout.showSnackbar(
                    R.string.storage_access_required,
                    Snackbar.LENGTH_INDEFINITE, R.string.ok
                ) {
                    requestPermissionsCompat(
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        READ_EXTERNAL_STORAGE
                    )
                }


            } else {
                layout.showSnackbar(
                    R.string.storage_permission_not_available,
                    Snackbar.LENGTH_SHORT
                )

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    READ_EXTERNAL_STORAGE
                )
            }

        } else {
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                layout.showSnackbar(
                    R.string.storage_access_required,
                    Snackbar.LENGTH_INDEFINITE, R.string.ok
                ) {
                    requestPermissionsCompat(
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        READ_EXTERNAL_STORAGE
                    )

                }


            } else {
                layout.showSnackbar(
                    R.string.storage_permission_not_available,
                    Snackbar.LENGTH_SHORT
                )
                requestPermissionsCompat(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    READ_EXTERNAL_STORAGE
                )
            }


        }
    }

    private fun startDatabase() {

        viewModel =
            ViewModelProvider(this, Mfactory()).get(MainActivityVM::class.java)
        findViewById<Button>(R.id.button).setOnClickListener(mclick)
        var name = ""
        viewModel.salerportListt.observe(this, Observer { it ->


            it.forEach {
                name = name + it.date + "\n"
            }
            textView.text = name

        })

    }


    //    ================================
    class Mfactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainActivityVM(mcontext) as T
        }
    }
}

package com.permissionx.fanyifu

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 *@Auther:  Fuyf
 *@Date:  2021-10-20-13:41
 *@Description:  com.permissionx.fanyifu
 *@version: 1.0
 */
typealias PermissionCallback=(Boolean,List<String>)->Unit
class InvisibleFragment:Fragment() {
    private var callback:PermissionCallback?=null
    fun requestNow(cb:PermissionCallback,vararg permissions:String){
        callback=cb
        requestPermissions(permissions,1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode==1){
            val deniedList=ArrayList<String>()
            for ((index,result) in grantResults.withIndex()){
                if (result!=PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val allGranted=deniedList.isEmpty()
            callback?.let { it (allGranted,deniedList)}
        }
    }
}
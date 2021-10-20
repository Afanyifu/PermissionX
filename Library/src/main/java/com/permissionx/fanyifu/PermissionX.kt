package com.permissionx.fanyifu

import androidx.fragment.app.FragmentActivity

/**
 *@Auther:  Fuyf
 *@Date:  2021-10-20-13:51
 *@Description:  com.permissionx.fanyifu
 *@version: 1.0
 */
object PermissionX {
    private const val TAG="InvisibleFragment"
    fun request(activity:FragmentActivity,vararg permissions:String,callback: PermissionCallback){
        val fragmentManager=activity.supportFragmentManager
        val existedFragment=fragmentManager.findFragmentByTag(TAG)
        val fragment=if (existedFragment!=null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment=InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}
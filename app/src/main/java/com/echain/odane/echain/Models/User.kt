package com.echain.odane.echain.Models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ksteere on 2/28/2018.
 */
open class User(
    @PrimaryKey var id: String = "",
    var fname: String = "",
    var lname: String = "",
    var utype: String = "",
    var phone: String = "",
    var avatar: String = "",
    var token: String = "",
    var company: Company? = null,
    var active: Boolean = false
) : RealmObject() {

}
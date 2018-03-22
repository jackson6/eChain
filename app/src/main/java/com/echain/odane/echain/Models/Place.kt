package com.echain.odane.echain.Models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ksteere on 3/15/2018.
 */
open class Place(
    @PrimaryKey var id: String = "",
    var name: String = "",
    var address: String = "",
    var type: Int = 0

): RealmObject(){

}
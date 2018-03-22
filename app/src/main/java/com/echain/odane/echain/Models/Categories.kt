package com.echain.odane.echain.Models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ksteere on 2/28/2018.
 */
open class Categories: RealmObject(){
    @PrimaryKey var id: String? = null
    var name: String? = null
    var image_url: String? = null
}
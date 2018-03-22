package com.echain.odane.echain.Models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ksteere on 2/28/2018.
 */
open class Company(
  @PrimaryKey var id: String = "",
  var name: String = "",
  var description: String = "",
  var brand_url: String = "",
  var cover_url: String = "",
  var categories: RealmList<Categories> = RealmList()
): RealmObject(){

}
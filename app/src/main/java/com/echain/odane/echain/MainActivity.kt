package com.echain.odane.echain

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var foodList = arrayListOf("Chinese", "Hamburger", "Mac Donalds", "Pizza", "Barros Pizza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedFoodText.text = "Burger King"

        decideBtn.setOnClickListener {
            var random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodText.text = foodList[randomFood]
        }

        addFoodBtn.setOnClickListener {
            if(addFoodTxt.text.isNotEmpty()) {
                foodList.add(addFoodTxt.text.toString())
                addFoodTxt.text.clear()
            }else {
                Toast.makeText(this,"Field cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

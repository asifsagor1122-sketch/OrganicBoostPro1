package com.organicboostpro.app

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(40, 60, 40, 40)
        layout.gravity = Gravity.CENTER_HORIZONTAL

        val title = TextView(this)
        title.text = "Organic Boost Pro"
        title.textSize = 26f
        title.gravity = Gravity.CENTER
        layout.addView(title)

        val balance = TextView(this)
        balance.text = "\nBalance: ৳0 (Demo)\n"
        balance.textSize = 20f
        balance.gravity = Gravity.CENTER
        layout.addView(balance)

        fun addBtn(text: String): Button {
            val b = Button(this)
            b.text = text
            b.textSize = 18f
            val p = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            p.setMargins(0, 16, 0, 16)
            b.layoutParams = p
            layout.addView(b)
            return b
        }

        val btnFollowers = addBtn("Followers")
        val btnLikes = addBtn("Likes")
        val btnViews = addBtn("Views")
        val btnTopup = addBtn("Top-up (bKash Demo)")
        val btnOrders = addBtn("My Orders")

        btnFollowers.setOnClickListener {
            Toast.makeText(this, "Followers - Demo only", Toast.LENGTH_SHORT).show()
        }
        btnLikes.setOnClickListener {
            Toast.makeText(this, "Likes - Demo only", Toast.LENGTH_SHORT).show()
        }
        btnViews.setOnClickListener {
            Toast.makeText(this, "Views - Demo only", Toast.LENGTH_SHORT).show()
        }
        btnTopup.setOnClickListener {
            Toast.makeText(this, "bKash Top-up - Demo only. PIN/OTP chaibo na.", Toast.LENGTH_LONG).show()
        }
        btnOrders.setOnClickListener {
            Toast.makeText(this, "My Orders - Kono order nai (Demo)", Toast.LENGTH_SHORT).show()
        }

        val scroll = ScrollView(this)
        scroll.addView(layout)
        setContentView(scroll)
    }
}

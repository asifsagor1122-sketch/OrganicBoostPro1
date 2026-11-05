package com.organicboostpro.app

import android.os.Bundle
import android.view.Gravity
import android.widget.*
import android.app.Activity

class MainActivity : Activity() {

    var balance = 0
    var orders = ArrayList<String>()
    lateinit var mainLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainLayout = LinearLayout(this)
        mainLayout.orientation = LinearLayout.VERTICAL
        mainLayout.setPadding(40, 50, 40, 40)
        showLogin()
        setContentView(mainLayout)
    }

    fun clear() {
        mainLayout.removeAllViews()
    }

    fun addTitle(t: String) {
        val tv = TextView(this)
        tv.text = t
        tv.textSize = 24f
        tv.gravity = Gravity.CENTER
        mainLayout.addView(tv)
    }

    fun addText(t: String, size: Float = 18f) {
        val tv = TextView(this)
        tv.text = t
        tv.textSize = size
        tv.gravity = Gravity.CENTER
        tv.setPadding(0, 16, 0, 16)
        mainLayout.addView(tv)
    }

    fun addInput(hint: String): EditText {
        val et = EditText(this)
        et.hint = hint
        val p = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        p.setMargins(0, 12, 0, 12)
        et.layoutParams = p
        mainLayout.addView(et)
        return et
    }

    fun addBtn(text: String, onClick: () -> Unit) {
        val b = Button(this)
        b.text = text
        b.textSize = 18f
        val p = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        p.setMargins(0, 14, 0, 14)
        b.layoutParams = p
        b.setOnClickListener { onClick() }
        mainLayout.addView(b)
    }

    fun showLogin() {
        clear()
        addTitle("Organic Boost Pro")
        addText("Login (Demo)", 20f)
        val phone = addInput("Phone Number - jekono number")
        val pass = addInput("Password - jekono password")
        addBtn("Login") {
            if (phone.text.toString().isEmpty()) {
                Toast.makeText(this, "Phone number dao", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Welcome! Login hoyeche (Demo)", Toast.LENGTH_SHORT).show()
                showHome()
            }
        }
        addText("Demo app - Asol account lagbe na", 14f)
    }

    fun showHome() {
        clear()
        addTitle("Organic Boost Pro")
        addText("Balance: ৳$balance (Demo)", 21f)
        addText("Ki lagbe? Service select koro:", 16f)
        addBtn("👥 Followers - ৳50 / 1K") { showOrder("Followers", 50) }
        addBtn("❤️ Likes - ৳40 / 1K") { showOrder("Likes", 40) }
        addBtn("👁️ Views - ৳20 / 1K") { showOrder("Views", 20) }
        addBtn("💬 Comments - ৳80 / 1K") { showOrder("Comments", 80) }
        addBtn("💰 Top-up (bKash Demo)") { showTopup() }
        addBtn("📦 My Orders (${orders.size})") { showOrders() }
        addBtn("🚪 Logout") { showLogin() }
    }

    fun showOrder(service: String, price: Int) {
        clear()
        addTitle(service)
        addText("Price: ৳$price / 1000 (Demo)", 18f)
        addText("Balance: ৳$balance", 18f)
        val link = addInput("Profile / Post Link dao")
        val qty = addInput("Quantity - jemon 1000")
        addBtn("Order Korun") {
            val q = qty.text.toString().toIntOrNull() ?: 0
            if (link.text.toString().isEmpty() || q <= 0) {
                Toast.makeText(this, "Link ar Quantity thik moto dao", Toast.LENGTH_SHORT).show()
            } else {
                val cost = (q * price) / 1000
                if (cost > balance) {
                    Toast.makeText(this, "Balance kom! Age Top-up koro (Demo)", Toast.LENGTH_LONG).show()
                } else {
                    balance -= cost
                    orders.add("$service - $q pcs - ৳$cost - Pending (Demo)")
                    Toast.makeText(this, "Order hoyeche! ৳$cost katlo", Toast.LENGTH_LONG).show()
                    showHome()
                }
            }
        }
        addBtn("⬅ Back") { showHome() }
    }

    fun showTopup() {
        clear()
        addTitle("bKash Top-up (Demo)")
        addText("Send Money korar dorkar NAI.\nEta sudhu Demo.", 16f)
        addText("bKash Number (Demo): 01XXXXXXXXX", 16f)
        val amount = addInput("Amount - jemon 100")
        val trx = addInput("TrxID - jekono kichu likho")
        addBtn("Top-up Submit") {
            val a = amount.text.toString().toIntOrNull() ?: 0
            if (a <= 0 || trx.text.toString().isEmpty()) {
                Toast.makeText(this, "Amount ar TrxID dao", Toast.LENGTH_SHORT).show()
            } else {
                balance += a
                Toast.makeText(this, "Demo Top-up hoyeche! ৳$a add holo", Toast.LENGTH_LONG).show()
                showHome()
            }
        }
        addText("⚠️ Kokhono PIN / OTP diba na", 14f)
        addBtn("⬅ Back") { showHome() }
    }

    fun showOrders() {
        clear()
        addTitle("My Orders")
        if (orders.isEmpty()) {
            addText("Ekhono kono order nai.\nAge ekta order koro.", 18f)
        } else {
            for (o in orders) {
                addText(o, 16f)
            }
        }
        addBtn("⬅ Back") { showHome() }
    }
}

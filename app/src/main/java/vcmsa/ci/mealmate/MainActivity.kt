/*
*
*
*
*
*
*
* */



package vcmsa.ci.mealmate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private var editTextText: EditText? = null
    private var textView: TextView? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editTextText = findViewById(R.id.editTextText)
        textView = findViewById(R.id.textView)
        answer = findViewById(R.id.TextView)

        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnEnter.setOnClickListener {
            checkMeal()
        }

        btnClear.setOnClickListener {
            answer?.text = ""
            editTextText?.text?.clear()
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

    }

    private fun isEmpty(): Boolean {
        return editTextText?.text.toString().trim().isEmpty() == true
    }

    private fun checkMeal() {
        if (isEmpty()){
            editTextText?.error = "Invalid information"
            answer?.text = "Invalid information"
            return
        }

        val TimeOfTheDay = editTextText?.text.toString().trim()

        when (TimeOfTheDay){
            "Morning" -> answer?.text = "Oatmeal, Avocado toast and Smoothie" +
                    "Toast and scrambled eggs" + "Muffin and Coffee" +
                    "Chicken and Waffles" + "Kellgg's and Orange Juice"
            "Mid Morning" -> answer?.text = "Yogurt with fruit or granola" +
                    "Hard boiled Eggs" + "Noodles with meat"
            "Afternoon" -> answer?.text = "Chicken and Rice with veges" +
                    "Stuffed Sweet Potato with Beans" + "Veggie Wrap" +
                    "Big Mac with Fries and Coke"
            "Mid Afternoon" -> answer?.text = "Grilled Cheese Sandwich" +
                    "Pizza and Coke" + "Fruit Salad" + "Italian pasta salad"
            "Dinner" -> answer?.text = "Rice with Stew" + "Lasagna" +
                    "Chicken and Pap with salads" + "Steak and Veges with mash Potatoes"
            else -> {
                answer?.text = "Invalid Time Of The Day, enter what is on the example above"
            }

        }



        }
    }

package com.example.myapplication
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var currentSquare = 0
    private val squares = arrayOfNulls<View>(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        squares[0] = findViewById(R.id.square1) // Верхний правый угол
        squares[1] = findViewById(R.id.square2) // Нижний правый угол
        squares[2] = findViewById(R.id.square3) // Нижний левый угол
        squares[3] = findViewById(R.id.square4) // Верхний левый угол

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            changeSquareColor()
        }
    }

    private fun changeSquareColor() {

        val defaultColor = Color.BLUE
        val highlightColor = Color.RED

        // Сброс цвета текущего квадрата на синий
        squares[currentSquare]?.setBackgroundColor(defaultColor)

        // Переключение на следующий квадрат и изменение его цвета на красный
        currentSquare = (currentSquare + 1) % squares.size
        squares[currentSquare]?.setBackgroundColor(highlightColor)
    }
}

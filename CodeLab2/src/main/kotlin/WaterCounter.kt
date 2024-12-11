import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun WaterCounter() {
    var counter by rememberSaveable() { mutableStateOf(0) }
    Column {
        if (counter > 0){
            val vasosTexto = if (counter == 1 ) "vaso" else "vasos"
            Text("Has bebido ${counter} ${vasosTexto} de agua")
        }
        Row {
            Button(
                onClick = {
                    counter++
                }
            ) {
                Text("Beber vaso de agua")
            }
            Button(
                onClick = {
                    counter = 0
                }
            ) {
                Text("Reiniciar contador")
            }
        }
    }
}
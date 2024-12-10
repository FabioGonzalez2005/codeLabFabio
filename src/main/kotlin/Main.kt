import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    MaterialTheme {
        Surface {
            var happypepe by remember { mutableStateOf(true) }
            if (happypepe) {
                pantalla1(mostrarPantalla = { happypepe = false })
            } else {
                pantalla2()
            }
        }
    }
}

@Composable
fun pantalla2() {
    val textos = arrayOf(
        "At vero eos et accusamus et iusto odio dignissimos",
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem",
        "Hola Fabio",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod"
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp)
    ) {
        textos.forEach { texto ->
            var expanded by remember { mutableStateOf(false) }
            val animationPadding by animateDpAsState(
                if (expanded) 48.dp else 0.dp,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            var currentPadding = animationPadding.coerceAtLeast(0.dp)
            var text by remember { mutableStateOf("Show More!") }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(10.dp)
                    .padding(bottom = currentPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(texto)
                Button(onClick = {
                    expanded = !expanded
                    text = if (expanded) "Show Less!" else "Show More!"
                }) {
                    Text(text)
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
        }
    }
}

@Composable
fun pantalla1(mostrarPantalla: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido al mundo de Fabio")
        MaterialTheme {
            Button(onClick = mostrarPantalla) {
                Text("Entrar")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

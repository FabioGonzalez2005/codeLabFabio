import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(viewModel: ViewModel1) {
    MaterialTheme {
        Surface {
            Column {
                WaterCounter()
                WellnessTaskList(
                    listaItems = viewModel.tasks,
                    onCheckedTask = { task, checked ->
                        viewModel.changeTaskChecked(task, checked)
                    },
                    onCloseTask = { task ->
                        viewModel.remove(task)
                    }
                )
            }

        }
    }
}

fun main() = application {
    val viewModel = ViewModel1()
    Window(onCloseRequest = ::exitApplication) {
        App(viewModel)
    }
}
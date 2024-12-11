import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: ViewModel1 = viewModel()
) {
    WellnessTaskList(
        listaItems = wellnessViewModel.tasks,
        onCheckedTask = { task, checked ->
            wellnessViewModel.changeTaskChecked(task, checked)
        },
        onCloseTask = { task ->
            wellnessViewModel.remove(task)
        }
    )
}
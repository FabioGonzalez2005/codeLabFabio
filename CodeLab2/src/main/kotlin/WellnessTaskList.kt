import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable


@Composable
fun WellnessTaskList(
    listaItems: List<WellnessTask>,
    onCheckedTask: (task: WellnessTask, checked: Boolean) -> Unit,
    onCloseTask: (task: WellnessTask) -> Unit
) {
    LazyColumn (state = rememberLazyListState()){
        items(listaItems) {
            WellnessTaskItem(task = it, onClose = { onCloseTask(it) })
        }
    }
}
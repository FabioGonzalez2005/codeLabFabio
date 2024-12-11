import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    onClose: (task: WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    val checkedState = rememberSaveable(){ mutableStateOf(true) }
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f).padding(start = 16.dp),
            text = task.label
        )
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {checkedState.value = it}
        )
        IconButton(onClick = { onClose(task) }) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ch.tutti.common.ui.R

@Composable
fun AppBarLogo(
    modifier: Modifier? = null
) {
    Row(
        modifier = modifier?.fillMaxHeight() ?: Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxHeight()
        )
    }
}

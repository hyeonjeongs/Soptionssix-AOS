package com.kbcs.soptionssix.exchangetab

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kbcs.soptionssix.R

@Composable
fun ExchangeItemRowFrame(
    @DrawableRes prefixIcon: Int? = null,
    prefixContent: @Composable (modifier: Modifier) -> Unit = {},
    posfixContent: @Composable () -> Unit = {}
) {
    val borderColor = colorResource(id = R.color.view_background)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = Stroke.DefaultMiter
                val y = size.height - strokeWidth / 2

                drawLine(
                    color = borderColor,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth
                )
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (prefixIcon != null) {
            Image(
                modifier = Modifier.padding(end = 8.dp),
                painter = painterResource(id = prefixIcon),
                contentDescription = ""
            )
        }
        prefixContent(Modifier.weight(1f))
        posfixContent()
    }
}

@Composable
@Preview(showBackground = true)
private fun ExchangeRowInformationPreview() {
    ExchangeItemRowFrame(
        prefixIcon = R.drawable.ic_temp_storefront,
        prefixContent = { modifier ->
            Text(
                modifier = modifier,
                text = "떡도리탕",
                style = MaterialTheme.typography.body2,
                color = colorResource(id = R.color.dark_green)
            )
        },
        posfixContent = {
            Text(
                text = "9000원",
                style = MaterialTheme.typography.body2,
                color = colorResource(id = R.color.black)
            )
        }
    )
}

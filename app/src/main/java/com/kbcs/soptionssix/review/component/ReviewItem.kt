package com.kbcs.soptionssix.review.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ReviewItem(
    title: String,
    time: String,
    address: String,
    content: String,
    storeName: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ReviewInformation(
                title = title,
                time = time,
                address = address
            )
            Spacer(Modifier.size(4.dp))
            ReviewContent(content = content)
            Spacer(Modifier.size(16.dp))
            StoreInformation(storeName = storeName)
        }
    }
}

@Composable
private fun ReviewInformation(
    title: String,
    time: String,
    address: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)
        Row {
            Text(text = time)
            Spacer(Modifier.size(4.dp))
            Text(text = "|")
            Spacer(Modifier.size(4.dp))
            Text(text = address)
        }
    }
}

@Composable
private fun ReviewContent(content: String) {
    val isClick = remember { mutableStateOf(true) }
    val contentMaxLine = if (isClick.value) 3 else Int.MAX_VALUE
    Text(
        modifier = Modifier
            .clickable { isClick.value = !isClick.value }
            .animateContentSize(),
        text = content,
        maxLines = contentMaxLine,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun StoreInformation(storeName: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = storeName)
        Text(text = ">")
    }
}

@Preview
@Composable
fun ReviewPreview() {
    ReviewItem(
        title = "맑은비",
        time = "5분 전",
        address = "백현동",
        content = "첫번째 방문에 너무 득템했는데\n" +
            "오늘 두번쨰 방문인데 후기를 안남길 수가 없어요\n" +
            "참깨, 무화과, 갈릭바게트 베이글 전부 다 존맛이고 크림치즈 서비스스스스스스\n" +
            "이거까지 보이나요???",
        storeName = "몽실 베이커리"
    )
}

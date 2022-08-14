package com.kbcs.soptionssix.review

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kbcs.soptionssix.review.component.DonationBoxes
import com.kbcs.soptionssix.review.component.DonationDescriptionBox
import com.kbcs.soptionssix.review.component.ReviewItem
import com.kbcs.soptionssix.review.component.WriteReviewBox

@Composable
fun ReviewScreen() {
    val dummyReviewList = mutableListOf(
        Review(
            title = "맑은비",
            time = "5분 전",
            address = "백현동",
            content = "첫번째 방문에 너무 득템했는데\n" +
                "오늘 두번쨰 방문인데 후기를 안남길 수가 없어요\n" +
                "참깨, 무화과, 갈릭바게트 베이글 전부 다 존맛이고 크림치즈 서비스스스스스스\n" +
                "이거까지 보이나요???",
            storeName = "몽실 베이커리"
        ),
        Review(
            title = "맑은비",
            time = "5분 전",
            address = "백현동",
            content = "첫번째 방문에 너무 득템했는데\n" +
                "오늘 두번쨰 방문인데 후기를 안남길 수가 없어요\n" +
                "참깨, 무화과, 갈릭바게트 베이글 전부 다 존맛이고 크림치즈 서비스스스스스스\n" +
                "이거까지 보이나요???",
            storeName = "몽실 베이커리"
        ),
        Review(
            title = "맑은비",
            time = "5분 전",
            address = "백현동",
            content = "첫번째 방문에 너무 득템했는데\n" +
                "오늘 두번쨰 방문인데 후기를 안남길 수가 없어요\n" +
                "참깨, 무화과, 갈릭바게트 베이글 전부 다 존맛이고 크림치즈 서비스스스스스스\n" +
                "이거까지 보이나요???",
            storeName = "몽실 베이커리"
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            DonationDescriptionBox()
            Spacer(modifier = Modifier.size(16.dp))
            DonationBoxes()
            Spacer(modifier = Modifier.size(26.dp))
            WriteReviewBox()
        }
        items(dummyReviewList) { review ->
            Spacer(modifier = Modifier.size(16.dp))
            ReviewItem(review)
        }
    }
}

data class Review(
    val title: String,
    val time: String,
    val address: String,
    val content: String,
    val storeName: String
)

@Preview(showBackground = true)
@Composable
fun ReviewScreenPreview() {
    ReviewScreen()
}

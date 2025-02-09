package com.kbsc.soptionssix.buy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.kbsc.soptionssix.R
import com.kbsc.soptionssix.util.component.InvisibleGuestButton
import com.kbsc.soptionssix.util.component.IsChallengeCheck
import com.kbsc.soptionssix.util.component.SelectBuyMethod
import com.kbsc.soptionssix.util.component.SelectPickUpTime
import com.kbsc.soptionssix.util.theme.PretendardTypography
import java.text.DecimalFormat

@Composable
fun BuyScreenBottom(
    buyViewModel: BuyViewModel,
    finish: () -> Unit
) {
    val buyUiState = buyViewModel.uiState.collectAsState()
    val totalFoodPrice = buyViewModel.totalPrice.collectAsState()
    val buyButtonState = buyViewModel.buttonState.collectAsState()
    val pickUpTime = buyViewModel.pickUpTime.collectAsState()
    val decFormatter = DecimalFormat("#,###")
    MaterialTheme(typography = PretendardTypography) {
        Column(modifier = Modifier.background(colorResource(id = R.color.view_background))) {
            Spacer(Modifier.height(8.dp))
            SelectPickUpTime(
                selectPickUpTimeIndex = buyUiState.value.pickUpTimeIndex,
                pickUpTimeList = buyUiState.value.pickUpTimeList,
                pickUpTime = pickUpTime.value,
                setPickUpTime = buyViewModel::setPickUpTime
            )
            Spacer(Modifier.height(8.dp))
            IsChallengeCheck(
                isChecked = buyUiState.value.isChallenge,
                setIsChecked = buyViewModel::setIsChallenge
            )
            Spacer(Modifier.height(8.dp))
            SelectBuyMethod(
                selectPaymentIndex = buyUiState.value.selectPaymentIndex,
                paymentList = buyUiState.value.paymentList,
                setPaymentState = buyViewModel::setPayment
            )
            InvisibleGuestButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .padding(8.dp),
                isClickable = buyButtonState.value,
                buttonText = "${decFormatter.format(totalFoodPrice.value)}원 결제하기",
                onClickEvent = buyViewModel::postReceipt,
                finish = finish
            )
        }
    }
}

package com.danielnastase.gooder.presentation.vendors.register2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.R
import com.danielnastase.gooder.presentation.vendors.register1.VendorsRegisterFirstStepEvent
import com.danielnastase.gooder.presentation.vendors.register1.areFieldsFilled
import com.danielnastase.gooder.ui.components.*
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VendorsRegisterSecondStepScreen(
    appState: GooderAppState,
    viewModel: VendorsRegisterSecondStepViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val showLoadingDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            showLoadingDialog.value = false
            TODO("Impement further navigation")
        }
    }

    GooderLoadingDialog(showLoadingDialog)

    GooderTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
            GooderTopAppBar(
                title = "Setup vendor details",
                onBackClicked = { appState.popUp() }
            )
            Spacer(Modifier.height(56.dp))
            GooderTextField(
                value = state.name,
                onValueChange = { viewModel.onEvent(VendorsRegisterSecondStepEvent.EnteredName(it)) },
                title = "Vendor name",
                placeholder = "What is your your business?")
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                GooderButton(
                    onClick = { viewModel.onEvent(VendorsRegisterSecondStepEvent.UploadLogo) },
                    label = "Upload Logo",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    width = 160.dp
                )
                GooderButton(
                    onClick = { viewModel.onEvent(VendorsRegisterSecondStepEvent.UploadBanner) },
                    label = "Upload Banner",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    width = 160.dp
                )
            }
            Spacer(Modifier.height(16.dp))
            Divider(color = MaterialTheme.colorScheme.secondary)
            Spacer(Modifier.height(16.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Vendor preview",
                    color = Color.White,
                    style = MaterialTheme.gooderTypography.semi_bold_16_24
                )
                Text(
                    text = "This is how your business will be displayed",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.gooderTypography.semi_bold_12_20
                )
            }
            Spacer(Modifier.height(20.dp))
            StoreCard(
                storeName = "Sushi King",
                storeDistance = "500 m",
                storeProducts = "10 products",
                isFavourite = true,
                storeBannerPainter = painterResource(id = R.drawable.sushi_king_banner),
                storeLogoPainter = painterResource(id = R.drawable.sushi_king_logo),
                visitOnClick = {}
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                GooderButton(
                    onClick = {
                        showLoadingDialog.value = true
                        viewModel.onEvent(VendorsRegisterSecondStepEvent.PressedProceed) },
                    label = "Proceed",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    color = if (state.name.isNotEmpty()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
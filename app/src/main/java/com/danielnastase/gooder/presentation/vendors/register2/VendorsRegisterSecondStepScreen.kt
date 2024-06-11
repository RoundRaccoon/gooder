package com.danielnastase.gooder.presentation.vendors.register2

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.components.*
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VendorsRegisterSecondStepScreen(
    appState: GooderAppState,
    viewModel: VendorsRegisterSecondStepViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val showLoadingDialog = remember { mutableStateOf(false) }

    val logoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { viewModel.onEvent(VendorsRegisterSecondStepEvent.ResultLogo(it)) }
    )

    val bannerPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { viewModel.onEvent(VendorsRegisterSecondStepEvent.ResultBanner(it)) }
    )

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
                value = state.value.name,
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
                    onClick = { logoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    ) },
                    label = "Upload Logo",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    width = 160.dp
                )
                GooderButton(
                    onClick = { bannerPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    ) },
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

            PreviewStoreCard(
                name = state.value.name,
                logo = state.value.logo,
                banner = state.value.banner)

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
                    color = if (state.value.name.isNotEmpty()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
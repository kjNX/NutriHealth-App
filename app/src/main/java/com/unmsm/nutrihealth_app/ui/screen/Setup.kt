package com.unmsm.nutrihealth_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unmsm.nutrihealth_app.ui.screen.page.EssentialData
import com.unmsm.nutrihealth_app.ui.screen.page.OverviewData
import com.unmsm.nutrihealth_app.ui.screen.page.TargetData
import com.unmsm.nutrihealth_app.ui.screen.shard.ScreenTracker
import com.unmsm.nutrihealth_app.ui.viewmodel.SetupViewModel
import kotlinx.coroutines.launch

@Composable
fun SetupScreen(
    onSetupFinish: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SetupViewModel = viewModel()
) {
    var pagerState = rememberPagerState(pageCount = { 3 })
    var coroutineScope = rememberCoroutineScope()
    var uiState = viewModel.uiState

    Column(modifier = modifier.padding(8.dp)) {
        ScreenTracker(pagerState.currentPage, 3)
        HorizontalPager(state = pagerState, userScrollEnabled = false) { i ->
            when(i) {
                0 -> {
                    EssentialData(
                        genderIndex = uiState.genderIndex,
                        intensity = uiState.intensity,
                        age = uiState.age,
                        height = uiState.height,
                        weight = uiState.weight,
                        onGenderChange = viewModel::setGender,
                        onAgeChange = viewModel::setAge,
                        onHeightChange = viewModel::setHeight,
                        onWeightChange = viewModel::setWeight,
                        onIntensityChange = viewModel::setIntensity,
                        onNext = {
//                            viewModel.submitData()
                            coroutineScope.launch { pagerState.animateScrollToPage(1) }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                1 -> {
                    TargetData(
                        targetWeight = uiState.targetWeight,
                        mainGoal = uiState.mainGoal,
                        onWeightChange = viewModel::setTargetWeight,
                        onGoalChange = viewModel::setMainGoal,
                        onNext = {
//                            viewModel.submitTarget()
                            coroutineScope.launch { pagerState.animateScrollToPage(2) }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                2 -> {
                    OverviewData(
                        tmb = uiState.tmb,
                        recommendedKcal = uiState.recommendedKcal,
                        protein = uiState.protein,
                        carbs = uiState.carbs,
                        fats = uiState.fats,
                        timeToReach = uiState.timeToReach,
                        onNext = {
//                            viewModel.confirm()
                            onSetupFinish()
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                else -> {}
            }
        }
    }
}
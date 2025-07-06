package com.unmsm.nutrihealth_app.ui.setup

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
import com.unmsm.nutrihealth_app.ui.shard.ScreenTracker
import kotlinx.coroutines.launch

@Composable
fun SetupComposite(
    onSetupFinish: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SetupViewModel = viewModel()
) {
    var uiState = viewModel.uiState
    var pagerState = rememberPagerState(pageCount = { 3 })
    var coroutineScope = rememberCoroutineScope()

    val goNext = {
        coroutineScope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
    }

    Column(modifier = modifier.padding(8.dp)) {
        ScreenTracker(pagerState.currentPage, pagerState.pageCount)
        HorizontalPager(state = pagerState, userScrollEnabled = false) { i ->
            when(i) {
                0 -> {
                    EssentialPage(
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
                            goNext()
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                1 -> {
                    TargetPage(
                        targetWeight = uiState.targetWeight,
                        mainGoal = uiState.mainGoal,
                        onWeightChange = viewModel::setTargetWeight,
                        onGoalChange = viewModel::setMainGoal,
                        onNext = {
                            goNext()
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                2 -> {
                    OverviewPage(
                        tmb = uiState.tmb,
                        recommendedKcal = uiState.recommendedKcal,
                        protein = uiState.protein,
                        carbs = uiState.carbs,
                        fats = uiState.fats,
                        timeToReach = uiState.timeToReach,
                        onNext = {
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
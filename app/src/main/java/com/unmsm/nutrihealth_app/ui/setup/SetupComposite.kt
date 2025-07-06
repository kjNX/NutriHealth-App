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
fun SetupScreen(
    genderIndex: Int,
    intensity: Float,
    age: String,
    height: String,
    weight: String,
    onGenderChange: (Int) -> Unit,
    onAgeChange: (String) -> Unit,
    onHeightChange: (String) -> Unit,
    onWeightChange: (String) -> Unit,
    onIntensityChange: (Float) -> Unit,
    onEssentialFinish: () -> Unit,
    targetWeight: String,
    mainGoal: Int,
    onTargetWeightChange: (String) -> Unit,
    onGoalChange: (Int) -> Unit,
    onTargetFinish: () -> Unit,
    tmb: Int,
    recommendedKcal: Int,
    protein: Int,
    carbs: Int,
    fats: Int,
    timeToReach: Int,
    onSetupFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    var pagerState = rememberPagerState(pageCount = { 3 })
    var coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.padding(8.dp)) {
        ScreenTracker(pagerState.currentPage, 3)
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
//                            viewModel.submitData()
                            coroutineScope.launch { pagerState.animateScrollToPage(1) }
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
                        onNext = onTargetFinish,
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
                        onNext = onSetupFinish,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                else -> {}
            }
        }
    }
}
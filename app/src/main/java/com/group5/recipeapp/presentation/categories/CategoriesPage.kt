package com.group5.recipeapp.presentation.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.group5.recipeapp.presentation.components.RoundedButton
import com.group5.recipeapp.ui.theme.Black
import com.group5.recipeapp.ui.theme.Typography
import com.group5.recipeapp.ui.theme.White

@Composable
fun CategoriesPages(
    navController: NavHostController,
    viewModel: CategoriesViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome",
                style = Typography.titleLarge,
                modifier = Modifier.padding(top = 10.dp)
            )
            RoundedButton(
                bgColor = Black,
                text = "Sign out",
                textColor = White,
                textSize = 18.sp,
                displayProgressBar = false,
                onClick = {
                    viewModel.signOut {
                        navController.navigate("login") {
                            popUpTo(0)
                        }
                    }
                }
            )
        }
    }
}
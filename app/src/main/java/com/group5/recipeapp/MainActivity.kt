package com.group5.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.group5.recipeapp.presentation.categories.CategoriesPages
import com.group5.recipeapp.presentation.login.LoginPage
import com.group5.recipeapp.presentation.register.RegisterPage
import com.group5.recipeapp.ui.theme.RecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationHandler()
                }
            }
        }
    }
}

@Composable
fun NavigationHandler() {
    val navController = rememberNavController()
    var startDestination = "login"

    if (FirebaseAuth.getInstance().currentUser?.email != null) {
        startDestination = "categories"
    }

    NavHost(navController = navController, startDestination) {
        composable("login") {
            LoginPage(navController)
        }
        composable("register") {
            RegisterPage(navController)
        }
        composable("categories") {
            CategoriesPages(navController)
        }
    }
}
package com.example.bookingmobilejetpackcompose.presentation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.example.bookingmobilejetpackcompose.presentation.screen.Layout
import com.example.bookingmobilejetpackcompose.presentation.screen.ListScreen
import com.example.bookingmobilejetpackcompose.presentation.screen.SearchScreen
import com.example.bookingmobilejetpackcompose.presentation.store.BookingViewModel
import com.example.bookingmobilejetpackcompose.presentation.utils.Routes


@Preview
@Composable
fun Application() {
    val navController = rememberNavController()

    val navGraph = navController.createGraph(startDestination = Routes[0]) {
        val viewModel:BookingViewModel = viewModel()
        composable(route = Routes[0]) {
            SearchScreen(navController,viewModel)
        }
        composable(Routes[1]) { ListScreen(navController,viewModel) }
        composable(Routes[2]) {  Text(Routes[2]) }
        composable(Routes[3]) {  Text(Routes[3]) }
    }
    Layout(navController){
        NavHost(
            navController=navController,
            graph = navGraph
        )
    }

}
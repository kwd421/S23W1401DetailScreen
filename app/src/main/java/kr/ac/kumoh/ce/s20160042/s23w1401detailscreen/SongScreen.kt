package kr.ac.kumoh.ce.s20160042.s23w1401detailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

enum class SongScreen {
    List,
    Detail
}

@Composable
fun SongApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SongScreen.List.name // == "List" or "Detail"
    ) {
        composable(SongScreen.List.name) {
            SongList(navController)
        }
        composable(
            route = "${SongScreen.Detail.name}/{songId}",
            arguments = listOf(
                navArgument("songId") { type = NavType.StringType }
                )
            ) {
            SongDetail(it.arguments?.getString("songId"))
        }
    }
}

@Composable
fun SongList(navController: NavController) {
    Column {
        Button (
            onClick = {
                navController.navigate("Detail/Song01")
            }
        ) {
            Text("노래 1")
        }
        Button (
            onClick = {
                navController.navigate(SongScreen.Detail.name)
            }
        ) {
            Text("노래 2")
        }
    }
}

@Composable
fun SongDetail(songId: String?) {
    Text("노래 내용: $songId")
}
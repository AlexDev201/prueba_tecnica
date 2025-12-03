package com.example.prueba_tecnica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.prueba_tecnica.ui.posts.PostListScreen
import com.example.prueba_tecnica.ui.theme.Prueba_tecnicaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prueba_tecnicaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PostListScreen(
                        onPostClick = { postId ->
                            // Navegar al detalle del post
                            // TODO: Implementar navegación al detalle
                        }
                    )
                }
            }
        }
    }
}
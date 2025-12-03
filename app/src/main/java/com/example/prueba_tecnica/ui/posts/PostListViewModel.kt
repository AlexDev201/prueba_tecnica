package com.example.prueba_tecnica.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba_tecnica.domain.model.Post
import com.example.prueba_tecnica.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PostListUiState())
    val uiState: StateFlow<PostListUiState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        _uiState.update { it.copy(isLoading = true, error = null) }
        
        viewModelScope.launch {
            try {
                val posts = getPostsUseCase()
                _uiState.update { 
                    it.copy(
                        posts = posts,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Error desconocido"
                    )
                }
            }
        }
    }

    fun onPostClick(post: Post) {
        // Navegar al detalle del post
        _uiState.update { it.copy(selectedPost = post) }
    }
}

data class PostListUiState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedPost: Post? = null
)

package com.bsrakdg.movies.factory

import androidx.fragment.app.FragmentFactory
import com.bsrakdg.movies.data.source.MoviesDataSource
import com.bsrakdg.movies.ui.movie.DirectorsFragment
import com.bsrakdg.movies.ui.movie.MovieDetailFragment
import com.bsrakdg.movies.ui.movie.StarActorsFragment
import com.bumptech.glide.request.RequestOptions

class MovieFragmentFactory(
    private val requestOptions: RequestOptions? = null,
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            MovieDetailFragment::class.java.name -> {
                if (requestOptions != null
                    && moviesDataSource != null
                ) {
                    MovieDetailFragment(
                        requestOptions,
                        moviesDataSource
                    )
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}


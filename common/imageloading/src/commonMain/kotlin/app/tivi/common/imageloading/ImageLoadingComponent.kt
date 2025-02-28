// Copyright 2019, Google LLC, Christopher Banes and the Tivi project contributors
// SPDX-License-Identifier: Apache-2.0

package app.tivi.common.imageloading

import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.intercept.Interceptor
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

expect interface ImageLoadingPlatformComponent

interface ImageLoadingComponent : ImageLoadingPlatformComponent {

    val imageLoader: ImageLoader

    @Provides
    @IntoSet
    fun provideShowCoilInterceptor(interceptor: ShowCoilInterceptor): Interceptor = interceptor

    @Provides
    @IntoSet
    fun provideTmdbImageEntityCoilInterceptor(interceptor: TmdbImageEntityCoilInterceptor): Interceptor = interceptor

    @Provides
    @IntoSet
    fun provideEpisodeCoilInterceptor(interceptor: EpisodeCoilInterceptor): Interceptor = interceptor
}

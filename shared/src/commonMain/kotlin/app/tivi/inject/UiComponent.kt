// Copyright 2023, Christopher Banes and the Tivi project contributors
// SPDX-License-Identifier: Apache-2.0

package app.tivi.inject

import app.tivi.account.AccountComponent
import app.tivi.common.ui.resources.Locales
import app.tivi.common.ui.resources.Strings
import app.tivi.common.ui.resources.TiviStrings
import app.tivi.episode.track.EpisodeTrackComponent
import app.tivi.episodedetails.EpisodeDetailsComponent
import app.tivi.home.discover.DiscoverComponent
import app.tivi.home.library.LibraryComponent
import app.tivi.home.popular.PopularShowsComponent
import app.tivi.home.recommended.RecommendedShowsComponent
import app.tivi.home.search.SearchComponent
import app.tivi.home.trending.TrendingShowsComponent
import app.tivi.home.upnext.UpNextComponent
import app.tivi.showdetails.details.ShowDetailsComponent
import app.tivi.showdetails.seasons.ShowSeasonsComponent
import cafe.adriel.lyricist.Lyricist
import com.slack.circuit.foundation.CircuitConfig
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import me.tatarka.inject.annotations.Provides

interface UiComponent :
    AccountComponent,
    DiscoverComponent,
    EpisodeDetailsComponent,
    EpisodeTrackComponent,
    LibraryComponent,
    PopularShowsComponent,
    RecommendedShowsComponent,
    SearchComponent,
    ShowDetailsComponent,
    ShowSeasonsComponent,
    TrendingShowsComponent,
    UpNextComponent {

    @Provides
    @ActivityScope
    fun provideLyricist(): TiviStrings {
        return Lyricist(
            defaultLanguageTag = Locales.EN,
            translations = Strings,
        ).strings
    }

    @Provides
    @ActivityScope
    fun provideCircuitConfig(
        uiFactories: Set<Ui.Factory>,
        presenterFactories: Set<Presenter.Factory>,
    ): CircuitConfig = CircuitConfig.Builder()
        .addUiFactories(uiFactories)
        .addPresenterFactories(presenterFactories)
        .build()
}

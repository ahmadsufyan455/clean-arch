package com.zerodev.diexample.view.viewmodel.story

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.zerodev.dicostories.getOrAwaitValue
import com.zerodev.diexample.data.models.Story
import com.zerodev.diexample.domain.usecase.GetStory
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var getStory: GetStory

    @Before
    fun setup() {
        mainViewModel = MainViewModel(getStory)
    }

    @Test
    fun `should get data from use case`() {
        val dummyStory = Story(
            "1",
            "Dicoding Indonesia",
            "Decode idea discover potential",
            "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/commons/homepage-hero.png",
        )
        Mockito.`when`(getStory.execute()).thenReturn(dummyStory)
        val actualStory = mainViewModel.getStory().getOrAwaitValue()
        verify(getStory).execute()
        verifyNoMoreInteractions(getStory)
        Assert.assertEquals(dummyStory.name, actualStory.name)
    }
}
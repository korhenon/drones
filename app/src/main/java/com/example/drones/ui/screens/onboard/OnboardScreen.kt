package com.example.drones.ui.screens.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drones.R
import com.example.drones.data.utils.NavDestinations
import com.example.drones.data.utils.OnboardPages
import com.example.drones.ui.components.MaxWidthButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardScreen(navController: NavHostController, viewModel: OnboardViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState(pageCount = {
        OnboardPages.size
    })
    HorizontalPager(state = pagerState) { page ->
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .paint(
                            painterResource(id = R.drawable.onboard_background),
                            contentScale = ContentScale.FillWidth
                        )
                        .padding(top = 80.dp, bottom = 32.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(SpanStyle(color = colorScheme.primary)) {
                            append("AERO")
                        }
                        append("DROP.")
                    }, fontWeight = FontWeight.Black, fontSize = 28.sp)
                    Image(
                        painter = painterResource(id = OnboardPages[page].image),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(27.dp))
                Text(
                    text = OnboardPages[page].title,
                    color = colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 42.dp)
                )
                Spacer(modifier = Modifier.height(37.dp))
                Text(
                    text = OnboardPages[page].text,
                    color = colorScheme.tertiary,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 54.dp)
                )
            }
            if (page == OnboardPages.size - 1) {
                MaxWidthButton(text = "HELP ME TO DELIVER NOW", onClick =  {
                    viewModel.skip()
                    navController.navigate(NavDestinations.Home)
                }, modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 26.dp))
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .padding(bottom = 113.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            Modifier
                .width(84.dp)
                .background(colorScheme.surface, CircleShape)
                .padding(horizontal = 4.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Box(
                Modifier
                    .height(6.dp)
                    .weight(if (pagerState.currentPage == 0) .18f else .07f)
                    .background(
                        if (pagerState.currentPage == 0) colorScheme.primary else colorScheme.tertiary,
                        CircleShape
                    )
            )
            Box(
                Modifier
                    .height(6.dp)
                    .weight(if (pagerState.currentPage == 1) .18f else .07f)
                    .background(
                        if (pagerState.currentPage == 1) colorScheme.primary else colorScheme.tertiary,
                        CircleShape
                    )
            )
            Box(
                Modifier
                    .height(6.dp)
                    .weight(if (pagerState.currentPage == 2) .18f else .07f)
                    .background(
                        if (pagerState.currentPage == 2) colorScheme.primary else colorScheme.tertiary,
                        CircleShape
                    )
            )
        }
    }
}
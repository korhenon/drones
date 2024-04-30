package com.example.drones.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.drones.R
import com.example.drones.ui.components.CustomField
import com.example.drones.ui.components.MaxWidthButton
import com.example.drones.ui.components.OpenStreetMap

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val interactionSource = remember { MutableInteractionSource() }
    OpenStreetMap(59.948830, 30.487577, 59.963062, 30.465970)
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            Modifier
                .background(
                    colorScheme.background,
                    RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                )
                .padding(start = 27.dp, end = 27.dp, top = 12.dp, bottom = 32.dp)
                .clickable(interactionSource = interactionSource, indication = null) { }
        ) {
            if (viewModel.state.formState != HomeFormState.Confirmation) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.slider),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            when (viewModel.state.formState) {
                HomeFormState.Location -> {
                    Text(
                        text = "Send Package",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.spacedBy(13.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.from_icon),
                            contentDescription = "",
                            modifier = Modifier.fillMaxHeight(),
                            contentScale = ContentScale.FillHeight
                        )
                        CustomField(
                            label = "Pickup Location",
                            value = viewModel.state.pickupLocation,
                            onChange = {
                                viewModel.state = viewModel.state.copy(pickupLocation = it)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(21.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.spacedBy(13.dp)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.to_icon),
                            contentDescription = "",
                            modifier = Modifier.fillMaxHeight(),
                            contentScale = ContentScale.FillHeight
                        )
                        CustomField(
                            label = "Delivering To",
                            value = viewModel.state.deliveringLocation,
                            onChange = {
                                viewModel.state = viewModel.state.copy(deliveringLocation = it)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(35.dp))
                    MaxWidthButton(text = "CONTINUE", onClick = {
                        viewModel.state = viewModel.state.copy(formState = HomeFormState.Service)
                    })
                }

                HomeFormState.Service -> {
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        Text(
                            text = "Change Location",
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(13.dp)
                    ) {
                        CustomField(
                            label = "Pickup Location",
                            value = viewModel.state.pickupLocation,
                            onChange = {},
                            enabled = false,
                            modifier = Modifier.weight(1f)
                        )
                        CustomField(
                            label = "Delivering To",
                            value = viewModel.state.deliveringLocation,
                            onChange = {},
                            enabled = false,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Choose servive",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ServiceCard(
                        image = R.drawable.small_size,
                        name = "Small size",
                        weight = "1-2 Kg",
                        price = "$5",
                        isBestDeal = true
                    ) {
                        viewModel.state = viewModel.state.copy(
                            service = Service.Small,
                            formState = HomeFormState.Summary
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    ServiceCard(
                        image = R.drawable.medium_size,
                        name = "Medium size",
                        weight = "3 - 5 Kg",
                        price = "$12",
                        isBestDeal = false
                    ) {
                        viewModel.state = viewModel.state.copy(
                            service = Service.Medium,
                            formState = HomeFormState.Summary
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    ServiceCard(
                        image = R.drawable.big_size,
                        name = "Big size",
                        weight = "6-10 Kg",
                        price = "$25",
                        isBestDeal = false
                    ) {
                        viewModel.state = viewModel.state.copy(
                            service = Service.Big,
                            formState = HomeFormState.Summary
                        )
                    }
                }

                HomeFormState.Summary -> {
                    Text(
                        text = "Summary",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        Text(
                            text = "Change Location",
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(13.dp)
                    ) {
                        CustomField(
                            label = "Pickup Location",
                            value = viewModel.state.pickupLocation,
                            onChange = {},
                            enabled = false,
                            modifier = Modifier.weight(1f)
                        )
                        CustomField(
                            label = "Delivering To",
                            value = viewModel.state.deliveringLocation,
                            onChange = {},
                            enabled = false,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row {
                        Text(
                            text = "Change Service",
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    when (viewModel.state.service) {
                        Service.Small ->
                            ServiceCard(
                                image = R.drawable.small_size,
                                name = "Small size",
                                weight = "1-2 Kg",
                                price = "$5",
                                isBestDeal = true
                            )

                        Service.Medium ->
                            ServiceCard(
                                image = R.drawable.medium_size,
                                name = "Medium size",
                                weight = "3 - 5 Kg",
                                price = "$12",
                                isBestDeal = false
                            )

                        Service.Big ->
                            ServiceCard(
                                image = R.drawable.big_size,
                                name = "Big size",
                                weight = "6-10 Kg",
                                price = "$25",
                                isBestDeal = false
                            )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    MaxWidthButton(text = "ORDER NOW", onClick = {
                        viewModel.state =
                            viewModel.state.copy(formState = HomeFormState.Confirmation)
                    })
                }

                HomeFormState.Confirmation -> {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(65.dp))
                        Image(
                            painter = painterResource(id = R.drawable.drone),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.height(26.dp))
                        Text(
                            text = "Finding nearby available dron",
                            color = colorScheme.tertiary,
                            fontSize = 18.sp
                        )
                        Spacer(Modifier.height(56.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(14.dp)
                                .background(colorScheme.surface, CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ServiceCard(
    image: Int,
    name: String,
    weight: String,
    price: String,
    isBestDeal: Boolean,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFE9E9E9), RoundedCornerShape(7.dp))
            .height(60.dp)
            .padding(horizontal = 12.dp, vertical = 9.dp)
            .clickable(interactionSource = interactionSource, indication = null) {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                Modifier.width(42.dp),
                contentScale = ContentScale.FillHeight
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = name, fontSize = 12.sp, color = colorScheme.tertiary)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = weight,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorScheme.secondary
                )
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            if (isBestDeal) {
                Text(
                    text = "Best Deal 🔥",
                    color = Color(0xFFFF6B31),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
            }
            Text(
                text = price,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = colorScheme.primary
            )
        }
    }
}
package com.techdetect.digisecure.app_components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techdetect.digisecure.R

@Composable
fun HeadingOne(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 120.dp),
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal
        ),
        color = Color(0xFF2C2A2A),
    )
}

@Composable
fun HeadingTwo(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 120.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 32.sp,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun HeadingThree(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal
        )
    )
}


@Composable
fun HeadingFour(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 160.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal
        )
    )
}


val raleWayFontFamily = FontFamily(
    Font(R.font.raleway_semibold, FontWeight.SemiBold),
    Font(R.font.raleway_bold, FontWeight.Bold)
)


@Composable
fun BodyExtraLargeSemiBold(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodyExtraLargeMedium(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodyExtraLargeRegular(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    )
}


@Composable
fun BodyLargeSemiBold(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodyLargeMedium(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodyLargeRegular(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    )
}


@Composable
fun BodyMediumSemiBold(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodyMediumMedium(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodyMediumRegular(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    )
}


@Composable
fun BodySmallSemiBold(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodySmallMedium(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun BodySmallRegular(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 140.dp),
        color = Color(0xFF2C2A2A),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    )
}


@Composable
fun CaptionOne(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 160.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun CaptionTwo(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 160.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 12.sp,
            fontStyle = FontStyle.Normal
        )
    )
}


@Composable
fun DisplayOne(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 120.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal
        )
    )
}

@Composable
fun DisplayTwo(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxSize()
            .heightIn(min = 120.dp),
        color = Color(0xFF2C2A2A),
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 32.sp,
            fontStyle = FontStyle.Normal
        )
    )
}



val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal)
)
package com.techdetect.digisecure.app_components

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techdetect.digisecure.R
import com.techdetect.digisecure.ui.theme.DefaultColor
import com.techdetect.digisecure.ui.theme.PrimaryGreenDark
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.ui.theme.SecondaryBlue1Dark
import com.techdetect.digisecure.ui.theme.SecondaryBlue1Normal
import com.techdetect.digisecure.ui.theme.SecondaryBlue2Dark
import com.techdetect.digisecure.ui.theme.SecondaryBlue2NormalActive
import com.techdetect.digisecure.ui.theme.SuccessColor
import com.techdetect.digisecure.ui.theme.TextColor
import com.techdetect.digisecure.ui.theme.WarningColor

@Composable
fun HeadingOne(value: String){
    Text(
        text = value,
        color = PrimaryHoverLight,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 40.sp,
        )
    )
}

@Composable
fun HeadingTwo(value: String){
    Text(
        text = value,
        color = PrimaryHoverLight,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 32.sp,
        )
    )
}

@Composable
fun HeadingThree(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 24.sp,
        )
    )
}


@Composable
fun HeadingFour(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}
@Composable
fun HeadingFourDark(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 18.sp,
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
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 24.sp,
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
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 24.sp,
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
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
        style = TextStyle(
            fontSize = 24.sp,
        )
    )
}


@Composable
fun BodyLargeSemiBold(value: String){
    Text(
        text = value,
        color = SecondaryBlue2Dark,
        textAlign = TextAlign.Center,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 20.sp,
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
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 20.sp,
        )
    )
}

@Composable
fun BodyLargeRegular(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
        style = TextStyle(
            fontSize = 20.sp,
        )
    )
}

@Composable
fun BodyLargeRegularLight(value: String){
    Text(
        text = value,
        color = PrimaryHoverLight,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
        style = TextStyle(
            fontSize = 20.sp,
        )
    )
}


@Composable
fun BodyMediumSemiBold(value: String){
    Text(
        text = value,
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}

@Composable
fun BodyMediumMedium(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        color = DefaultColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}


@Composable
fun BodyMediumMediumTextColor(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}
@Composable
fun BodyMediumMediumLight(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        color = PrimaryHoverLight,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}@Composable
fun BodyMediumMediumSuccess(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        color = SuccessColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}



@Composable
fun BodyMediumRegular(value: String){
    Text(
        text = value,
        color = PrimaryHoverLight,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
        style = TextStyle(
            fontSize = 18.sp,
        )
    )
}


@Composable
fun BodySmallSemiBold(value: String){
    Text(
        text = value,
        color = PrimaryHoverLight,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 16.sp,
        )
    )
}

@Composable
fun BodySmallMedium(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        textAlign = TextAlign.Center,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 16.sp,
        )
    )
}
@Composable
fun BodySmallMedium1(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
        style = TextStyle(
            fontSize = 16.sp,
        )
    )
}

@Composable
fun BodySmallRegular(value: String){
    Text(
        text = value,
        color = PrimaryGreenNormal,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
        style = TextStyle(
            fontSize = 16.sp,
        )
    )
}

@Composable
fun ErrorBodySmallRegular(value: String){
    Text(
        text = value,
        color = WarningColor,
        textAlign = TextAlign.Center,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
        style = TextStyle(
            fontSize = 16.sp,
        )
    )
}


@Composable
fun CaptionOne(value: String){
    Text(
        text = value,
        color = PrimaryHoverDark,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 16.sp,
        )
    )
}

@Composable
fun CaptionTwo(value: String){
    Text(
        text = value,
        color = PrimaryGreenNormal,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 12.sp,
        )
    )
}

@Composable
fun CaptionOneBlack(value: String){
    Text(
        text = value,
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 14.sp,
        )
    )
}

@Composable
fun CaptionTwoBlack(value: String){
    Text(
        text = value,
        color = TextColor,
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 12.sp,
        )
    )
}

@Composable
fun DisplayOne(value: String){
    Text(
        text = value,
        color = TextColor,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 40.sp,
        )
    )
}

@Composable
fun DisplayTwo(value: String){
    Text(
        text = value,
        color = TextColor,
        fontFamily = raleWayFontFamily, fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 32.sp,
        )
    )
}



val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal)
)
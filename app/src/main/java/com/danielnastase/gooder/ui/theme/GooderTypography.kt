package com.danielnastase.gooder.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.danielnastase.gooder.R
import org.w3c.dom.Text

val InterFontFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_black, FontWeight.Black)
)

data class GooderTypography(
    val regular_08_12: TextStyle,
    val medium_08_12: TextStyle,
    val bold_12_11: TextStyle,
    val extra_bold_12_11: TextStyle,
    val regular_12_20: TextStyle,
    val semi_bold_12_20: TextStyle,
    val regular_16_24: TextStyle,
    val semi_bold_16_24: TextStyle,
    val bold_16_24: TextStyle,
    val bold_24_24: TextStyle,
    val regular_24_32: TextStyle,
    val bold_24_32: TextStyle,
    val black_24_32: TextStyle,
    val bold_32_32: TextStyle,
)

val LocalGooderTypography = staticCompositionLocalOf {
    GooderTypography(
        regular_08_12 = TextStyle.Default,
        medium_08_12 = TextStyle.Default,
        bold_12_11 = TextStyle.Default,
        extra_bold_12_11 = TextStyle.Default,
        regular_12_20 = TextStyle.Default,
        semi_bold_12_20 = TextStyle.Default,
        regular_16_24 = TextStyle.Default,
        semi_bold_16_24 = TextStyle.Default,
        bold_16_24 = TextStyle.Default,
        bold_24_24 = TextStyle.Default,
        regular_24_32 = TextStyle.Default,
        bold_24_32 = TextStyle.Default,
        black_24_32 = TextStyle.Default,
        bold_32_32 = TextStyle.Default
    )
}

fun buildGooderTypography() = GooderTypography(
    regular_08_12 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 12.sp
    ),
    medium_08_12 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 8.sp,
        lineHeight = 12.sp
    ),
    bold_12_11 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 11.sp
    ),
    extra_bold_12_11 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 12.sp,
        lineHeight = 11.sp
    ),
    regular_12_20 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    semi_bold_12_20 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    regular_16_24 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    semi_bold_16_24 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bold_16_24 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bold_24_24 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp
    ),
    regular_24_32 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    bold_24_32 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    black_24_32 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    bold_32_32 = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 32.sp
    ),
)

val MaterialTheme.gooderTypography: GooderTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalGooderTypography.current
package com.app.fitgo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.fitgo.R

val myFontFamily = FontFamily(
    Font(R.font.dm_sans_regular, FontWeight.Normal), // Regular
    Font(R.font.dm_sans_medium, FontWeight.Medium), // Medium
    Font(R.font.dm_sans_bold, FontWeight.Bold), // Bold
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,  // Slightly smaller than bodyLarge
        lineHeight = 20.sp, // Reduced line height for medium text
        letterSpacing = 0.25.sp // Smaller letter spacing
    ),
    bodySmall = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,  // Smallest font size for body text
        lineHeight = 16.sp, // Smaller line height for compact text
        letterSpacing = 0.sp // Minimal letter spacing for small text
    ),
    titleLarge = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,  // Bold to emphasize title
        fontSize = 22.sp,              // Larger font size for titles
        lineHeight = 28.sp,            // Larger line height for better readability
        letterSpacing = 0.sp           // Minimal letter spacing
    ),
    titleMedium = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Medium,  // Medium weight for less emphasis
        fontSize = 18.sp,                // Medium title size
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Medium,  // Medium weight for small titles
        fontSize = 16.sp,                // Smaller title size
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    // Headline text styles
    headlineLarge = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,  // Strong emphasis for large headings
        fontSize = 32.sp,              // Larger size for primary headings
        lineHeight = 40.sp,            // Ample line height for readability
        letterSpacing = (-0.5).sp      // Slightly tightened spacing for large headings
    ),
    headlineMedium = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,  // Bold to make the headline stand out
        fontSize = 28.sp,              // Medium headline size
        lineHeight = 36.sp,
        letterSpacing = 0.sp           // No additional spacing
    ),
    headlineSmall = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,  // Bold for consistency across headlines
        fontSize = 24.sp,              // Slightly smaller headline
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    // Label text styles
    labelSmall = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    // Display text styles
    displayLarge = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    )
)
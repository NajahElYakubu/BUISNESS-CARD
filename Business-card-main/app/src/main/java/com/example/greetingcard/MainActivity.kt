package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 🔥 Profile Image
        // Note: Ensure ma_image exists in res/drawable. 
        // If not, you might need to add it or use a different resource.
        Image(
            painter = painterResource(id = R.drawable.andstud),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Name
        Text(
            text = "Molly Yusra",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        // Title
        Text(
            text = "Developer",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Contact Info
        ContactRow(info = "📞 +234 811 1111 111")
        ContactRow(info = "📧 moll1230986y@gmail.com")
        ContactRow(info = "🌐 www.molly.dev")
    }
}



@Composable
fun ContactRow(info: String) {
    Row(
        modifier = Modifier.padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = info,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    GreetingCardTheme {
        BusinessCard()
    }
}

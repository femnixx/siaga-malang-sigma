package com.example.login2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SignUp() {


    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var kataSandi by remember { mutableStateOf("") }
    var kataSandiVisibility by remember { mutableStateOf(false) }
    var konfirmKataSandi by remember { mutableStateOf("") }
    var konfirmKataSandiVisibility by remember { mutableStateOf(false) }

    val dark_grey = colorResource(id = R.color.dark_grey)
    val dark0_grey = colorResource(id = R.color.dark0_grey)


    val context = LocalContext.current

    val authenticationManager = remember {
        AuthenticationManager(context)
    }

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFC41532),
                        Color(0xFF431B3B)
                    )
                )
            )
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_sign_up),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(63.dp)
                    .height(80.dp),
            )
            Spacer(modifier = Modifier.height(40.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .width(347.dp)
                    .height(535.dp),
                shape = RoundedCornerShape(30.dp),
                elevation = CardDefaults.cardElevation(100.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Daftar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 20.dp).padding(bottom = 15.dp)
                    )

                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        placeholder = { Text("Nama", color = dark_grey)},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.PersonOutline,
                                contentDescription = "Nama",
                                tint = dark_grey
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .border(
                                width = 2.dp,
                                color = dark0_grey,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        shape = RoundedCornerShape(18.dp),
                        colors = outlinedTextFieldColors(
                            containerColor = dark0_grey)
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("Email", color = dark_grey) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.MailOutline,
                                contentDescription = "Email",
                                tint = dark_grey
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp)

                            .padding(bottom = 7.dp)
                            .border(
                                width = 2.dp,
                                color = dark0_grey,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        shape = RoundedCornerShape(18.dp),
                        colors = outlinedTextFieldColors(
                            containerColor = dark0_grey)
                    )

                    OutlinedTextField(
                        value = kataSandi,
                        onValueChange = { kataSandi = it },
                        placeholder = { Text("kata Sandi ", color = dark_grey) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Email",
                                tint = dark_grey
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 1.dp)
                            .border(
                                width = 2.dp,
                                color = dark0_grey,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        colors = outlinedTextFieldColors(
                            containerColor = dark0_grey),
                        shape = RoundedCornerShape(18.dp),
                        trailingIcon = {
                            IconButton(onClick = { kataSandiVisibility = !kataSandiVisibility }) {
                                Icon(
                                    imageVector = if (kataSandiVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = "Toggle Password Visibility",
                                    tint = dark_grey
                                )
                            }
                        }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.note_kata_sandi),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(25.dp)
                            .width(265.dp)
                    )

                    OutlinedTextField(
                        value = konfirmKataSandi,
                        onValueChange = { konfirmKataSandi = it },
                        placeholder = { Text("konfirmasi Kata Sandi", color = dark_grey) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Email",
                                tint = dark_grey
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .padding(top = 5.dp)
                            .border(
                                width = 2.dp,
                                color = dark0_grey,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        colors = outlinedTextFieldColors(
                            containerColor = dark0_grey),
                        shape = RoundedCornerShape(18.dp),
                        trailingIcon = {
                            IconButton(onClick = { konfirmKataSandiVisibility = !konfirmKataSandiVisibility }) {
                                Icon(
                                    imageVector = if (konfirmKataSandiVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = "Toggle Password Visibility",
                                    tint = dark_grey
                                )
                            }
                        }
                    )



                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        onClick = {
                            authenticationManager.LoginWithEmail(email, password = "")
                                .onEach { response ->
                                    if (response is AuthResponse.Success) {
                                        // dosmth
                                    }
                                }
                                .launchIn(coroutineScope)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(color = Color.Transparent),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xFFC41532),
                                            Color(0xFF431B3B)
                                        )
                                    ),
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            contentAlignment = Alignment.Center // Pusatkan teks dalam Box
                        ) {
                            Text(text = "Daftar", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sudah memiliki akun? Masuk",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            Text(
                text = "Dengan membuat akun, Anda menyetujui Ketentuan kami dan telah membaca serta mengakui Pernyataan Privasi Global.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 38.dp)
                    .padding(top = 80.dp),
                textAlign = TextAlign.Center,
                fontSize = 10.sp, color = Color.White
            )
        }
    }
}


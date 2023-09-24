package com.example.laboratorio6.ui.events.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.events.viewmodel.events

/**
 * Pantalla de detalles para evento
 * Recibe el ID del evento a buscar en la lista total de eventos
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsPage(navController: NavController, eventID: String){
    // Obtener los detalles del evento de los argumentos
    val event = events.find { it.eventID == eventID }!!
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(1){//Los elementos son mostrados en columna
        Box(modifier = Modifier.fillMaxWidth().height(410.dp)){//Muestra de imagen representativa del eventos
            AsyncImage( //Imagen
                model = event.image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Button(modifier = Modifier //Botón para retornar a pantalla de grid
                .align(Alignment.TopStart)
                .padding(5.dp),
                onClick = { navController.navigateUp() }) {
                Icon( Icons.Rounded.ArrowBack, contentDescription = "Go back")
            }
            Text(text = "Imagen ilustrativa", //Texto default
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(3.dp))
        }
        //Detalles del evento
        Text(text = event.title, fontSize = 30.sp, modifier = Modifier.padding(5.dp))
        Row( //Fecha y hora
            Modifier
                .fillMaxWidth()
                .padding(15.dp), Arrangement.SpaceBetween) {
            Row( horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Filled.DateRange, contentDescription = "Date")
                Text(text = "Día: " + event.date)
            }
            Text(text = "Hora: " + event.time)
        }
        //Descripción
        Text(text = "About", fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        Text(text = event.context,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Justify) //Texto justificado
        Row( //Botones de navegacion
            Modifier
                .fillMaxWidth()
                .padding(10.dp), Arrangement.SpaceAround) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.width(100.dp)) {
                Text(text = "Favorite") //Añadir a favorito
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.width(100.dp)) {
                Text(text = "Buy") //Comprar
            }
        }
        }
    }
}

@Preview
@Composable
fun DetailPreview(){}

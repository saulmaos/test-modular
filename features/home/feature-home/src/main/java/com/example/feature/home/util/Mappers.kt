package com.example.feature.home.util

import com.example.core.network.api.TerrainsResponse
import com.example.feature.home.models.Terrain
import java.util.Locale

fun List<TerrainsResponse>.toTerrains(): List<Terrain> =
    this.map { terrainsResponse ->
        Terrain(
            price = String.format(Locale.US, "$%.2f", terrainsResponse.price),
            id = terrainsResponse.id,
            type = terrainsResponse.type,
            imageUrl = terrainsResponse.imageUrl.replace("http", "https"),
        )
    }

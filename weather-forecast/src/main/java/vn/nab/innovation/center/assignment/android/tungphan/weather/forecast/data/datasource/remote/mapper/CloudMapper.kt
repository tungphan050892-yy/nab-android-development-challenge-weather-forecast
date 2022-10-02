package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.CloudDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Cloud

fun CloudDTO.toEntityObject() = Cloud(
    all = this.all
)
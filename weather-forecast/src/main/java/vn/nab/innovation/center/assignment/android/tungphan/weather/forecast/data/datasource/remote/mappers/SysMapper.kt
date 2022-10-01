package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.SysDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Sys

fun SysDTO.toEntityObject() = Sys(
    pod = this.pod
)

package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.SysDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Sys

fun SysDTO.toEntityObject() = Sys(
    pod = this.pod
)

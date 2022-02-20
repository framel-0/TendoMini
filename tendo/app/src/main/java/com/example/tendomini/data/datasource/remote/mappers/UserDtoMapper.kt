package com.example.tendomini.data.datasource.remote.mappers

import com.example.tendomini.data.datasource.remote.dtos.UserDto
import com.example.tendomini.domain.models.User
import com.example.tendomini.domain.utils.DomainModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDtoMapper @Inject constructor() : DomainModelMapper<UserDto, User> {
    override fun mapToDomainModel(model: UserDto): User {
        return User(
            id = model.id,
            fullName = model.fullName,
            email = model.email,
            phoneNumber = model.phoneNumber,
        )
    }

    override fun mapFromDomainModel(domainModel: User): UserDto {
        return UserDto(
            id = domainModel.id,
            fullName = domainModel.fullName,
            email = domainModel.email,
            phoneNumber = domainModel.phoneNumber,
        )
    }

    fun toDomainList(initial: List<UserDto>): List<User> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<User>): List<UserDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
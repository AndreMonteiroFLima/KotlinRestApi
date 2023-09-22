package br.com.zup.dto

import br.com.zup.entities.User
import br.com.zup.entities.Vehicle
import br.com.zup.services.validation.UserValidData
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.br.CPF
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@UserValidData
class UserDTO (
    @NotBlank
    @CPF(message = "invalid CPF")
    var cpf: String,
    @NotBlank
    var name: String,
    @Email(message = "invalid Email")
    @NotBlank
    var email: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var birthDate: Date,
    var vehicles: List<VehicleDTO>
)  {
    companion object {
        fun fromEntity(entity: User, vehicles: List<VehicleDTO>): UserDTO {
            return UserDTO(
                cpf = entity.cpf,
                name = entity.name,
                email = entity.email,
                birthDate = entity.birthDate,
                vehicles = vehicles,
            )
        }
    }
}

package br.com.zup.services.validation

import br.com.zup.controllers.exceptions.FieldMessage
import br.com.zup.dto.UserDTO
import br.com.zup.repositories.UserRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.beans.factory.annotation.Autowired

class UserValidatorData() : ConstraintValidator<UserValidData?, UserDTO> {
    override fun isValid(dto: UserDTO, context: ConstraintValidatorContext): Boolean {
        return true
    }
}

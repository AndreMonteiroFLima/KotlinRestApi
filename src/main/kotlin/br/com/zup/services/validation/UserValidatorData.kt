package br.com.zup.services.validation

import br.com.zup.controllers.exceptions.FieldMessage
import br.com.zup.dto.UserDTO
import br.com.zup.repositories.UserRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.beans.factory.annotation.Autowired
import org.slf4j.LoggerFactory


class UserValidatorData() : ConstraintValidator<UserValidData?, UserDTO> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun isValid(dto: UserDTO, context: ConstraintValidatorContext): Boolean {
        log.info("User validation mock OK")
        return true
    }
}

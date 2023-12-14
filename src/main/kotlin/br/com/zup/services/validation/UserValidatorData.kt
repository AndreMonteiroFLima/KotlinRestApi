package br.com.zup.services.validation

import br.com.zup.controllers.exceptions.FieldMessage
import br.com.zup.dto.UserDTO
import br.com.zup.repositories.UserRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.beans.factory.annotation.Autowired
import org.slf4j.LoggerFactory


class UserValidatorData(
    val userRepository: UserRepository
) : ConstraintValidator<UserValidData?, UserDTO> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun isValid(dto: UserDTO, context: ConstraintValidatorContext): Boolean {

        val cpf = dto.cpf
        if (!isCPF(cpf)) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("CPF is required")
                .addPropertyNode("cpf")
                .addConstraintViolation()
            return false
        }
        if(userRepository.findByEmail(dto.email) != null){
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Email is already being used")
                .addPropertyNode("email")
                .addConstraintViolation()
            return false
        }


        return true
    }

    private fun isCPF(document: String): Boolean {
        if (document.isEmpty()) return false

        val numbers = document.filter { it.isDigit() }.map {
            it.toString().toInt()
        }

        if (numbers.size != 11) return false

        //repeticao
        if (numbers.all { it == numbers[0] }) return false

        //digito 1
        val dv1 = ((0..8).sumOf { (it + 1) * numbers[it] }).rem(11).let {
            if (it >= 10) 0 else it
        }

        val dv2 = ((0..8).sumOf { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
            if (it >= 10) 0 else it
        }

        return numbers[9] == dv1 && numbers[10] == dv2
    }
}

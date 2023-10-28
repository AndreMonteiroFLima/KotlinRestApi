package br.com.zup.services

import br.com.zup.dto.VehicleDTO
import br.com.zup.services.exceptions.DataErrorException
import br.com.zup.services.feign.FIPEClient
import br.com.zup.services.feign.FIPEObject
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FeignService(
    val fipeClient: FIPEClient
) {

    fun getInformations(vehicle: VehicleDTO): FIPEObject {
        return jsonToFIPEObject(
            fipeClient.getFipeInformations(
                vehicle.brand,
                vehicle.model,
                vehicle.yearAndFuel
            )
        )
    }

    fun jsonToFIPEObject(json: String?): FIPEObject {
        val mapper = ObjectMapper()
        return try {
            mapper.readValue(json, FIPEObject::class.java)
        } catch (e: JsonProcessingException) {
            throw DataErrorException("Error mapping JSON to OBJECT")
        }
    }

    fun tryRotation(): Boolean {
        println("Rotation False")
        return false
    }
}

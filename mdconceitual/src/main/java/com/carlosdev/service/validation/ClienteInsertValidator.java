package com.carlosdev.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.carlosdev.controller.exception.FieldMessage;
import com.carlosdev.domain.enums.TipoCliente;
import com.carlosdev.dto.ClienteNewDTO;
import com.carlosdev.service.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
			list.add(new FieldMessage("cpfOuCnpj", "CPf invalido"));
		}
		
		
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessagem()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

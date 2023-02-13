package ws.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import ws.Repository.SubscribeTypeRepository;
import ws.controller.SubscriptionTypeController;
import ws.dto.SubscriptionTypeDto;
import ws.exception.BadRequestException;
import ws.exception.NotFoundException;
import ws.mapper.SubscriptionTypeMapper;
import ws.model.SubscriptionType;
import ws.service.SubscritionTypeService;

@Service
public class SubscriptionTypeServiceImpl implements SubscritionTypeService {

	private static final String UPDATE = "UPDATE";
	private static final String DELETE = "DELETE";
	private SubscribeTypeRepository subscribeTypeRepository;

	public SubscriptionTypeServiceImpl(SubscribeTypeRepository subscribeTypeRepository) {

		this.subscribeTypeRepository = subscribeTypeRepository;
	}

	@Override
	public List<SubscriptionType> findAll() {

		return this.subscribeTypeRepository.findAll();
	}

	@Override
	public SubscriptionType findById(Long id) {
		
		return this.getSubscriptionType(id)
				.add(WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).findById(id)).withSelfRel()
				).add(WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).update(id, new SubscriptionTypeDto())).withRel(UPDATE)
						).add(WebMvcLinkBuilder.linkTo(
								WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).delete(id)).withRel(DELETE)
								)
				;
	}


	@Override
	public SubscriptionType create(SubscriptionTypeDto dto) {
		if (Objects.nonNull(dto.getId())) {
			throw new BadRequestException("ID deve ser nulo!!!");
		}
		return subscribeTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
	}

	@Override
	public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
		getSubscriptionType(id);
		dto.setId(id);
		return subscribeTypeRepository.save(
				SubscriptionTypeMapper.fromDtoToEntity(dto));
	}

	@Override
	public void delete(Long id) {
		getSubscriptionType(id);
		subscribeTypeRepository.deleteById(id);

	}
	
	private SubscriptionType getSubscriptionType(Long id) {
		Optional<SubscriptionType> optionalSubscriptionType = this.subscribeTypeRepository.findById(id);

		if (optionalSubscriptionType.isEmpty()) {
			throw new NotFoundException("SubscriptionType não encontrado!!!");
		}
		return optionalSubscriptionType.get();
	}

}

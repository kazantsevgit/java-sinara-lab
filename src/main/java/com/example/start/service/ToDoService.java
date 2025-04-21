package com.example.start.service;

import com.example.start.dto.ToDoDTO;
import com.example.start.entities.EventEntity;
import com.example.start.entities.ToDoEntity;
import com.example.start.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    public List<ToDoDTO> getAllLists() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO).
                collect(Collectors.toList());
    }

    public void createList(ToDoDTO toDoDTO) {
        ToDoEntity toDoEntity = mapToEntity(toDoDTO);
        repository.save(toDoEntity);
    }

    private ToDoEntity mapToEntity(ToDoDTO toDoDTO) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(toDoDTO.getName());

        Set<EventEntity> events = toDoDTO.getEvents()
                .stream()
                .map(eventDescription -> new EventEntity(eventDescription, entity))
                .collect(Collectors.toSet());
        entity.setEvents(events);
        return entity;
    }

    private ToDoDTO mapToDTO(ToDoEntity entity) {
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setName(entity.getName());

        List<String> events = entity.getEvents()
                .stream()
                .map(EventEntity::getDescription)
                .collect(Collectors.toList());
        toDoDTO.setEvents(events);
        return toDoDTO;
    }
}
package com.rogomdi.template.application.model;

import lombok.Data;

import java.util.UUID;


public record Entity(UUID id, String field) {
}

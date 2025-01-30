package com.carbowitz.nova.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ManagedApiCreationDTO {
    @NotNull
    @Size(min = 2, max = 50)
    String name;
}

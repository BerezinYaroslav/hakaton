package ru.lubiteli_diksi.hakaton.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
    private String data;

    private Integer count;
}

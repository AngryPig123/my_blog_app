package com.rest.blog.myblogapp.payload.superdto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BasicDateDto {
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
}
